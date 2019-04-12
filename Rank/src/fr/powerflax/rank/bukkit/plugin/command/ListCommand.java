package fr.powerflax.rank.bukkit.plugin.command;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.powerflax.rank.RankList;

public class ListCommand implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String msg, String[] args) {
		Player p = (Player)s;
		if(s instanceof Player && s != null) {
			p.sendMessage("il y'a" + Bukkit.getOnlinePlayers() + "/" + Bukkit.getMaxPlayers());
			p.sendMessage("La liste du staff connecté est :" + RankList.AMINISTRATOR.getName()+ RankList.MODERATOR.getName());
		}
		else{
			return false;
		}
		
		
		return false;
	}

}
