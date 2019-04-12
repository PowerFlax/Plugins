package fr.powerflax.rank.command;


import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.google.common.collect.Lists;

import fr.powerflax.rank.Rank;
import fr.powerflax.rank.RankList;

public final class RankCommand implements CommandExecutor, TabCompleter {
	
	private final Rank rank;
	public RankCommand(Rank rank) {
		this.rank = rank;
	}

	public List<String> onTabComplete(CommandSender s, Command c, String l, String[] a) {
		List<String> tabComplete = Lists.newArrayList();
		if(a.length == 2) {
			for(RankList rankList : RankList.values()) {
				if(rankList.getName().toLowerCase().startsWith(a[1].toLowerCase())) tabComplete.add(rankList.getName());
			}
			return tabComplete;
		}
		return null;
		
	}

	public boolean onCommand(CommandSender s, Command c, String l, String[] a) {
		if(s instanceof Player) {
			
			if(rank.hasPowerInf((Player)s, 90)) return sendMessage(s, "§4Vous n'avez pas la permission pour executer cela"); 
		}
				
		 
		
		
		if (a.length < 2)  return sendMessage(s, "§4/rank <Player> <Rank>");
		
		Player target = Bukkit.getPlayer(a[0]);
		if(target == null) return sendMessage(s, "§cLe joueur n'a pas été trouvé");
		
		RankList rankList = null;
		try {
			rankList = rank.getRankById(Integer.parseInt(a[1]));
		}catch (NumberFormatException nbe) {
			try {
		
			rankList = RankList.valueOf(a[1].toUpperCase());
			}catch(Exception e) {
				return sendMessage(s, "§cLe rank est introuvable");
			}
		}
		
		rank.changeRank(target, rankList);
		sendMessage(target, "§9Votre grade a été modifié");
		return sendMessage(s,"§6" +target.getName()+ "§2a obtenu son grade §5"+ rankList.getName().toLowerCase());
		
	}
	public boolean sendMessage(CommandSender s, String msg) {
		s.sendMessage(rank.getPrefix()+msg);
		return true;
	}

}
