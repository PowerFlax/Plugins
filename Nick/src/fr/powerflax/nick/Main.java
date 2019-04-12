package fr.powerflax.nick;


import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin  {
	@Override
	public void onEnable() {
		getCommand("nick").setExecutor(new CMD());
	}
	public static void nick(Player player, String arg0) {
	   player.setDisplayName(arg0);
	}
	public static void reset(Player player) {
		player.setDisplayName(player.getName());
	}
}



