package de.herrbockwurst.hubber;

import de.herrbockwurst.hubber.Config.SimpleConfig;

public class FixConfig {
	public static void fix() {
		fixMain(Main.thisclass.config);
		fixLang(Main.thisclass.lang);
		fixLobbys(Main.thisclass.lobbys);
	}
	
	private static void fixLobbys(SimpleConfig lobbys) {
		String[] example = null;
		if(!lobbys.contains("lobbys")) {
			lobbys.set("lobbys", example);
			lobbys.saveConfig();
		}
		
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
		if(!config.contains("MySQL.host")){
			config.set("MySQL.host", "localhost");
			config.saveConfig();
		}
		if(!config.contains("MySQL.port")){
			config.set("MySQL.port", "3306");
			config.saveConfig();
		}
		if(!config.contains("MySQL.database")){
			config.set("MySQL.database", "dbhere");
			config.saveConfig();
		}
		if(!config.contains("MySQL.user")){
			config.set("MySQL.user", "namehere");
			config.saveConfig();
		}
		if(!config.contains("MySQL.pass")){
			config.set("MySQL.pass", "passhere");
			config.saveConfig();
		}
		
	}
	
	public static void fixLang(SimpleConfig lang) {
		if(!lang.contains("Errors.NotFromConsole")) {
			lang.set("Errors.NotFromConsole", "Du kannst das nicht als Konsole ausführen!");
			lang.saveConfig();
		}
		if(!lang.contains("MySQL.conOK")) {
			lang.set("MySQL.conOK", "MySQL Verbindung erfolgreich!");
			lang.saveConfig();
		}
		if(!lang.contains("MySQL.disconnect")) {
			lang.set("MySQL.conOK", "MySQL Verbindung getrennt!");
			lang.saveConfig();
		}
	}
	
}
