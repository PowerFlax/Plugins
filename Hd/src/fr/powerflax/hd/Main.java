package fr.powerflax.hd;


import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.filoghost.holograms.api.HolographicDisplaysAPI;



public class Main extends JavaPlugin implements Listener {
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onPlayerDeath(PlayerDeathEvent e) {
		Date date = new Date();
		HolographicDisplaysAPI.createHologram(this, e.getEntity().getLocation().add(0, 5, 0), e.getEntity().getName() + ("§2Mort ici")
		+ "§3Le temps de mort >> " + date.getMinutes() 
		);
		
	}

}
