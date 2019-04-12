package fr.powerflax.rush.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Team {
	private String name;
	private String tag;
	private byte woolData;
	private List<Player> players = new ArrayList<>();
	
	public Team(String name, String tag, byte woolData) {
		this.name=name;
		this.tag=tag;
		this.woolData=woolData;
	}
	public ItemStack getIcon() {
		ItemStack i = new ItemStack(Material.WOOL, 1, woolData);
		ItemMeta iM = i.getItemMeta();
		iM.setDisplayName("Rejoindre l'équipe" + tag + name);
		iM.setLore(Arrays.asList("§aStaff","§aPlugin"));
		iM.addEnchant(Enchantment.KNOCKBACK, 2, true);
		iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		return i;
		
		
	}
	public void addPlayer(Player p) {
		players.add(p);
	}
	public void removePlayer(Player p) {
		players.remove(p);
	}
	public List<Player> getPlayer(){
		return players;
	}
	public int getSize() {
		return players.size();
	}
	public String getName() {
		return name;
	}
	public String getTag() {
		return tag;
	}
	
	public byte getWoolData() {
		return woolData;
	}
	
	
}
