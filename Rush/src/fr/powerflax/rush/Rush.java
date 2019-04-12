package fr.powerflax.rush;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.powerflax.rush.team.Team;

public class Rush extends JavaPlugin{	
	
	private RushGame current; 
	private List<Team> teams = new ArrayList<>();
	public RushTitles title = new RushTitles();
	
	@Override
	public void onEnable() {
		current = RushGame.WAITING;
		getServer().getPluginManager().registerEvents(new RushListener(this), this);
		System.out.println("[Rush] Open En Dev");
		saveDefaultConfig();
		ConfigurationSection section = getConfig().getConfigurationSection("teams");
		for(String team : section.getKeys(false)) {
			String name = section.getString(team+".name");
			String tag = section.getString(team+".color").replace("&", "§");
			byte data = (byte)section.getInt(team+".data");
			teams.add(new Team(name, tag, data));
		}
		
		System.out.println(teams.size() + "equipes ont ete charge ;)");
	}
	public void setState(RushGame state) {
		current = state;
	}
	public boolean isState(RushGame state) {
		return current == state; 
		
	}
	public void addPlayer(Player player, Team team) {
		
	}
	public void removePlayer(Player player) {
		
	}
	public void randomTeam(Player player) {
		
	}
	public List<Team> getTeam(){
		return teams;
	}

}
