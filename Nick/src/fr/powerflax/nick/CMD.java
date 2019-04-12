package fr.powerflax.nick;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) { 
		if(cmd.getName().equalsIgnoreCase("nick")) {
		   Player p = (Player)sender;
			if(args.length == 0);
			   p.sendMessage("/nick set <player>)");
			   p.sendMessage("/nick reset <player>");
		} else {
			if(args[0].equalsIgnoreCase("set")){
			   if (args.length == 1){
				   Player p = (Player)sender;
				   p.sendMessage("§6Usage: /nick set <name>");
			   } else {
				   Player p = (Player)sender;
				   if (args.length == 2){
					    if(p.hasPermission("nick") || p.isOp()){
					    	 Main.nick(p, args[1]);
					    	p.sendMessage("vous l'avez changé en"+args[1]);
					    }
				   }else if(args.length == 3) {
					   if(p.hasPermission("nick.other")|| p.isOp()) {
						   Player p2 = Bukkit.getPlayer(args[2]);
						   if (p2 != null ) {
							  Main.nick(p2, args[1]);
							  p.sendMessage("Vous avez changé le pseudo de"+p2.getName()+" en "+args[1]);
						   } else {
							   p.sendMessage("le joueur est introuvable"+args[2]);
						   }
					   }
					   
				   }
				   
			   }
			}else if(args[0].equalsIgnoreCase("reset")) {
				if(args.length==1);
				Player p = (Player)sender;
				if(p.hasPermission("nick.reset"));
				Main.reset(p);
				p.sendMessage("Votre pseudo a été reset");
			} else if(args.length == 1) {
				Player p = (Player)sender;
				if(p.hasPermission("nick.reset.other")) {
					Player p2 = Bukkit.getPlayer(args[1]);
					if (p2 != null) {
						Main.reset(p2);
						p.sendMessage("Reseted"+p2.getName()+"nick");
						p.sendMessage("le joueur"+args[1]+"est introuvable");
					}
				}
			
			}
		}
			
		return true;
	}
    
}
