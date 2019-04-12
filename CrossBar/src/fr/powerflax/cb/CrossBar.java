package fr.powerflax.cb;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CrossBar extends JavaPlugin{
	
	
	public void onEnable() {
		BossBar Bar = Bukkit.createBossBar("§cBienvenue sur §2Hardium", BarColor.BLUE, BarStyle.SEGMENTED_10, new BarFlag[0]);
		for(Player players : Bukkit.getOnlinePlayers()) {
			Bar.addPlayer(players);
			Bar.setColor(BarColor.GREEN);
		}
		
	}

}
