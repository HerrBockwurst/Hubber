package de.herrbockwurst.hubber.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import de.herrbockwurst.hubber.Main;


public class VoidFall implements Listener{
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onFallVoid (EntityDamageEvent event) {
		if(Main.thisclass.config.getBoolean("events.VoidFall") == false) {
			//VoidFall eingeschalten?
			return;
		}
		if(!(event.getEntity() instanceof Player)) {
			//Wenn nicht Spieler, dann aus!
			return;
		}
		if(event.getCause() != EntityDamageEvent.DamageCause.VOID) {
			//Ist es Void Schaden?
			return;
		}
		Player p = (Player) event.getEntity();
		p.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
		p.setFallDistance(0.0F);
		event.setCancelled(true);
	}
	 
}
