package de.herrbockwurst.hubber.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener {
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = (Player) event.getPlayer();
		p.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
		p.getInventory().clear();
		p.getInventory().setItem(0, new ItemStack(Material.NETHER_STAR)); //Lobbywahl
		p.getInventory().setItem(1, new ItemStack(Material.WATCH)); //Spielwahl
		p.getInventory().setItem(2, new ItemStack(Material.COOKIE)); //Freunde
		
	}
}
