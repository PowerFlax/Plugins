package fr.powerflax.rank.bukkit.plugin.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.powerflax.rank.Rank;
import fr.powerflax.rank.RankList;

public final class PlayerListener implements Listener {
	
	private final Rank rank;
	
	public PlayerListener(Rank rank) {
		this.rank = rank;
	}
	
	
	
	@EventHandler
	private void playerJoin(PlayerJoinEvent pje) {
		rank.loadPlayer(pje.getPlayer());
		pje.getPlayer().setScoreboard(rank.getScoreboard());
	}
	@EventHandler
	private void playerQuit(PlayerQuitEvent pqe) {
		rank.deletPlayer(pqe.getPlayer());
		
	}
	
	
	@EventHandler
	private void playerChat(AsyncPlayerChatEvent poe) {
		RankList ranklist = rank.getPlayerRank(poe.getPlayer());
		poe.setFormat(ranklist.getprefix()+poe.getPlayer().getName()+ranklist.getsuffix()+ranklist.getChatSeparator()+poe.getMessage());
		
	}

}
