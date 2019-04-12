package fr.powerflax.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{
	
	public final String prefix = "§2Ist§aria &7>>";
	
	public String getprefix() {
		return prefix;
	}
	private List<String> messages = new ArrayList<>();
	

	public void onEnable() {
		messages.add("§2ceci est un test");
		messages.add("§3By PowerFlax");
		
		System.out.println(getprefix()+"Allumé");
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

			@Override
			public void run() {
				Random rand = new Random();
				int alea = rand.nextInt(messages.size());
				String msg = messages.get(alea);
				Bukkit.broadcastMessage("§2Ist§aria §7>>"+ msg);
				
			}
	    },100, 100);
	    
	    		
	    }
	    
		
	}
	


