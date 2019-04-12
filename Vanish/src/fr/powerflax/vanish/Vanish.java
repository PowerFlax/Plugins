package fr.powerflax.vanish;
import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class Vanish extends JavaPlugin implements Listener {
	private final String prefix = "§7[§cVanishPlugin§7]";
	
	public String getPrefix() {
		return prefix;
	}
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	private ArrayList<Player> vanished = new ArrayList<Player>();
	
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			sender.sendMessage(getPrefix()+"§8Vous n'avez pas la permission ");
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("vanish")) {
			if(!vanished.contains(player)) {
				for(Player pl : Bukkit.getServer().getOnlinePlayers()) {
					pl.hidePlayer(player);
					pl.getNoDamageTicks();
				}
				player.sendMessage(getPrefix()+"§cVous êtes en §4vanish §c" +sender.getName());
				vanished.add(player);
				return true;
				
			}
			else {
				for(Player pl : Bukkit.getServer().getOnlinePlayers()) {
					pl.showPlayer(player);
				}
				vanished.remove(player);
				player.sendMessage(getPrefix()+"§cVotre §4Vanish §cest désactivé " +sender.getName());
			}
		}
	
	return true;
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		for(Player player : vanished) {
			e.getPlayer().hidePlayer(player);
		}
	}
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		vanished.remove(e.getPlayer());
		
	}	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.sendRawMessage("§7[§2+§7]" + player.getName() + " §2vient de rejoindre le serveur");
		player.getInventory().clear();
		player.getInventory().addItem(new ItemStack(org.bukkit.Material.BLAZE_ROD));
		ItemStack customblaze = new ItemStack(Material.BLAZE_ROD);
		ItemMeta customM = customblaze.getItemMeta();
		customM.setDisplayName("§cVanish");
		customM.setLore(Arrays.asList("§aStaff","§aPlugin"));
		customM.addEnchant(Enchantment.KNOCKBACK, 2, true);
		customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		customblaze.setItemMeta(customM);
		player.getInventory().setItemInHand(customblaze);
		player.updateInventory();
		player.setFlying(true);
		
		
		
		
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		org.bukkit.event.block.Action action = event.getAction();
		ItemStack it = event.getItem();
		if(it == null) return;
		if(it.getType()== Material.BLAZE_ROD) {
			if(action== Action.RIGHT_CLICK_AIR  ) {
				player.chat("/vanish");
				}
				
			}
		}
			
		
	}

