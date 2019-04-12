package fr.powerflax.rank.bukkit.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.powerflax.rank.Rank;
import fr.powerflax.rank.bukkit.plugin.command.ListCommand;
import fr.powerflax.rank.bukkit.plugin.listener.PlayerListener;
import fr.powerflax.rank.command.RankCommand;

public class RankJavaPlugin extends JavaPlugin {
	
	private Rank rank;
	
	
	public final void onLoad() {
		rank = new Rank(this);
	}
	
	
	public final void onEnable() {
		rank.initScoreboard();
		
		Bukkit.getPluginManager().registerEvents(new PlayerListener(rank), this);
		getCommand("rank").setExecutor(new RankCommand(rank));
		getCommand("listofstaff").setExecutor(new ListCommand());
	}
	
	public final void onDisable() {
		
	}
	
}


