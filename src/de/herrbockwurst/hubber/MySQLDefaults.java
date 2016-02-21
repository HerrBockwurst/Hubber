package de.herrbockwurst.hubber;


public class MySQLDefaults {
	public static void create() {
		//Table creation
		MySQL.query("CREATE TABLE IF NOT EXISTS `globalconfig` (`conf` VARCHAR(100), value TEXT)");
		
		//Inhalt einfügen
		MySQL.query("INSERT INTO `globalconfig` (`conf`, `value`) VALUES ('servers', 'a;b')");
	}
}
