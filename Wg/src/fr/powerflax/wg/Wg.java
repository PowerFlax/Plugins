package fr.powerflax.wg;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import fr.powerflax.wg.cmd.CommandExecutor;

public class Wg extends JavaPlugin {
	
	WorldGuardPlugin wg ;
	
	public static Wg instance;
	public static Wg getInstance() {
		return instance;
	}
	
	
	public void onEnable() {
		instance = this;
		getCommand("claim").setExecutor(new CommandExecutor());
		try {
		wg = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void createRegion(Player p) {
		Vector vmin = new Vector(55,0,256);
		Vector vmax = new Vector(8,256,999);
		BlockVector min = vmin.toBlockVector();
		BlockVector max = vmax.toBlockVector();
		
		RegionManager rManager = wg.getRegionManager(p.getWorld());
		ProtectedRegion region = new ProtectedCuboidRegion("my_region", min, max);
		region.getOwners().addPlayer(p.getName());
		
		
		Map<Flag<?>, Object> flags = new HashMap<>();
		
		flags.put(DefaultFlag.BUILD, StateFlag.State.DENY);
		flags.put(DefaultFlag.GREET_MESSAGE, "§2Vous venez d'entrer dans la région");
		rManager.addRegion(region);
		
		region.setFlags(flags);
		p.sendMessage("§cregion crée");
		
	}
	public void checkPermOfBuild(Player p) {
		if(wg.canBuild(p, p.getLocation())) {
			p.sendMessage("ici tu peux construire");
			
		}
		else {
			p.sendMessage("Vous n'avez pas la permssion");
		}
		
		
	}


	

}
