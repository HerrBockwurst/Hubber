package de.herrbockwurst.hubber;

import org.bukkit.ChatColor;

public class methods {
	public static String getPluginName(Boolean form) {
		if(form == false) {
			return main.thisclass.getDescription().getName();
		} else {
			return ChatColor.DARK_GREEN + "[" + main.thisclass.getDescription().getName() + "]";
		}		
	}
	public static String getLangString(String name) {
		if(main.thisclass.lang.contains(name)) {
			return main.thisclass.lang.getString(name); 
		}
		
		return "String not found";
	}
}
