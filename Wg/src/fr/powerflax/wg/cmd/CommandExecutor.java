package fr.powerflax.wg.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.powerflax.wg.Wg;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {

	public boolean onCommand(CommandSender s, Command cmd, String msg, String[] args) {
		if(s instanceof Player) {
			Player p = (Player)s;
			if(cmd.getName().equalsIgnoreCase("claim")) {
				if(args.length == 0) {
					Wg.getInstance().checkPermOfBuild(p);
				}
				if (args.length == 1 ) {
					if(args[0].equalsIgnoreCase("create")) {
						Wg.getInstance().createRegion(p);
						
					}
				}
			}
			
		}
		return false;
	}

}
