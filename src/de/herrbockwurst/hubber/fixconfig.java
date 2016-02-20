package de.herrbockwurst.hubber;

import de.herrbockwurst.hubber.Config.SimpleConfig;

public class fixconfig {
	public static void fix() {
		fixMain(main.thisclass.config);
		fixLang(main.thisclass.lang);
	}
	
	public static void fixMain(SimpleConfig config) {
		if(!config.contains("language")){
			config.set("language", "de");
			config.saveConfig();
		}
		if(!config.contains("events.VoidFall")){
			config.set("events.VoidFall", true);
			config.saveConfig();
		}
		if(!config.contains("events.FallDamage")){
			config.set("events.FallDamage", true);
			config.saveConfig();
		}
	}
	
	public static void fixLang(SimpleConfig lang) {
		if(!lang.contains("Errors.NotFromConsole")) {
			lang.set("Errors.NotFromConsole", "Du kannst das nicht als Konsole ausführen!");
			lang.saveConfig();
		}
	}
}
