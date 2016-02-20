package de.herrbockwurst.hubber.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.herrbockwurst.hubber.Methods;

public class Hub implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("hub")) {
			if(!(sender instanceof Player)) {
				System.out.println(Methods.getPluginName(true) + " " + Methods.getLangString("Errors.NotFromConsole"));
				return true;
			}
			System.out.println("Test");
			return true;
		}
		return false;
	}
}
