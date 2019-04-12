package fr.powerflax.rush;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.powerflax.rush.team.Team;

public class RushListener implements Listener {

	private Rush main;
	public RushListener(Rush rush) { this.main = rush;}
		@EventHandler
		public void onJoin(PlayerJoinEvent e) {
			Player player = e.getPlayer();
			main.title.sendTitle(e.getPlayer(), "§2RushPlugin", "En dev", 25);
			player.getInventory().clear();
			for(Team team : main.getTeam()) {
				player.getInventory().addItem(team.getIcon());
				
			}
		}
	    @EventHandler
	    public void onQuit(PlayerQuitEvent e) {
	    	
	    }
	    @EventHandler
	    public void onLogin(AsyncPlayerPreLoginEvent e) {
	    	
	    }
	
	}
	


