package de.herrbockwurst.hubber.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import de.herrbockwurst.hubber.Main;

public class FallDamage implements Listener {
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onFallDamage (EntityDamageEvent event) {
		if(Main.thisclass.config.getBoolean("events.FallDamage") == false) {
			//FallDamage eingeschalten?
			return;
		}
		if(!(event.getEntity() instanceof Player)) {
			//Wenn nicht Spieler, dann aus!
			return;
		}
		if(event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			//Nur bei Fallschaden
			return;
		}
		event.setCancelled(true);
		//event.setDamage(0.0);
		
	}

}
