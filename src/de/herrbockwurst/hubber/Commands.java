package de.herrbockwurst.hubber;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.herrbockwurst.hubber.methods;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("hub") || label.equalsIgnoreCase("lobby")) {
			if(!(sender instanceof Player)) {
				System.out.println(methods.getPluginName(true) + " " + methods.getLangString("Errors.NotFromConsole"));
				return true;
			}
			System.out.println("Test");
			return true;
		}
		return false;
	}
}
