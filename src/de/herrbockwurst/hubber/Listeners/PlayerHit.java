package de.herrbockwurst.hubber.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerHit implements Listener {
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerHit(EntityDamageEvent event) {
		if(event.getEntity() instanceof Player) {
			event.setCancelled(true);
		}
	}

}
