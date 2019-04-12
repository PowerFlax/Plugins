package fr.powerflax.rank;



import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.google.common.collect.Maps;

public final class Rank {

	private Scoreboard scoreboard;
	private final Plugin plugin;
	private final String prefix = "§7[§6Rank§7]";
	private FileConfiguration config;
	private File file;
	public final Map<String, RankList> playerRanks = Maps.newHashMap();
	
	public Rank(Plugin plugin){
		this.plugin = plugin;
		initConfig();
	}
	
	public final Plugin getPlugin() {
		return plugin;
	}
	public String getPrefix(){
		return prefix;
	}
	
	
	private void initConfig() {
		File f = new File("plugins/Rank");
		if (!f.exists()) f.mkdirs();
		file = new File(f,"rank.yml");
		if(!file.exists()) {
			try {
				file.createNewFile();
				
			}catch(IOException ioe) {  ioe.getStackTrace();}
		}
			
		config = YamlConfiguration.loadConfiguration(file);
	}
	public final Scoreboard getScoreboard() {
		return scoreboard;
	}
	public void initScoreboard() {
		if(scoreboard != null) throw new UnsupportedOperationException("Le scoreboard est deja mis en place");
		scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		
		for(RankList ranklist : RankList.values()) {
			Team team = scoreboard.registerNewTeam(ranklist.getName());
			team.setPrefix(ranklist.getprefix());
			team.setSuffix(ranklist.getsuffix());
		}
		
		config = YamlConfiguration.loadConfiguration(file);
	}
 
		
    public void loadPlayer(Player player) {
    	String uuid = player.getUniqueId().toString();
    	if(playerRanks.containsKey(player.getUniqueId().toString()))return;
    	playerRanks.put(uuid, getRankById(config.getInt(uuid)));
    	if(!config.contains(uuid)){
    		config.set(uuid, 1);
    		saveConfig();
    	}
    
    	scoreboard.getTeam(playerRanks.get(uuid).getName()).addEntry(player.getName());
    }
    public void deletPlayer(Player player) {
    	if(playerRanks.containsKey(player.getUniqueId().toString()))return;
    	playerRanks.remove(player.getUniqueId().toString());
    	
    }
    
    public RankList getPlayerRank(Player player) {
    	if(!playerRanks.containsKey(player.getUniqueId().toString()))loadPlayer(player);
    	return playerRanks.get(player.getUniqueId().toString());
    }
    public RankList getRankById(int id) {
    	for (RankList rankList : RankList.values()) {
    		if(rankList.getId() == id) return rankList;
    	}
    	
    	return RankList.PLAYER;
    }
    
    
    public void saveConfig() {
    	try {
    		config.save(file);
    	}catch(IOException ioe) { ioe.printStackTrace();}
    }
    
    
    public Boolean hasPower(Player player, int power) {
    	return(getPlayerRank(player).getPower() == power) ;
    	
    	
    }
    public Boolean hasPowerSup(Player player, int power) {
    	return(getPlayerRank(player).getPower() > power) ;
    	
    }
    public Boolean hasPowerInf(Player player, int power) {
    	return(getPlayerRank(player).getPower() < power) ;
    }
    public void changeRank(Player player, RankList rankList) {
    	deletPlayer(player); 
    	config.set(player.getUniqueId().toString(), rankList.getId());
    	saveConfig();
    	loadPlayer(player);
    }


	
}
