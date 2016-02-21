package de.herrbockwurst.hubber;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.herrbockwurst.hubber.Config.SimpleConfig;
import de.herrbockwurst.hubber.Config.SimpleConfigManager;
import de.herrbockwurst.hubber.Listeners.FallDamage;
import de.herrbockwurst.hubber.Listeners.VoidFall;
import de.herrbockwurst.hubber.FixConfig;
import de.herrbockwurst.hubber.Commands.Hub;

public class Main extends JavaPlugin {
	
	public static Main thisclass = null;
    public SimpleConfigManager manager;
    public SimpleConfig config;
    public SimpleConfig lang;
    public SimpleConfig lobbys;
    
    
	@Override
	public void onEnable() {
		thisclass = this;
		
		getConf();
		registerListeners();
		registerCommands();
		getBungeeCon();
		MySQL.connect();
		MySQLDefaults.create();
		
	}
	@Override
	public void onDisable() {
		MySQL.disconnect();
		System.out.println("test");
	}
	
	public void getBungeeCon() {
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}

	private void getConf() {
		manager = new SimpleConfigManager(this);
		config = manager.getNewConfig("config.yml");
		lang = manager.getNewConfig("language/de.yml");
		lobbys = manager.getNewConfig("lobbys.yml");
		
		FixConfig.fix();
	}

	public void registerListeners() {
		getServer().getPluginManager().registerEvents(new VoidFall(), this);
		getServer().getPluginManager().registerEvents(new FallDamage(), this);
	}
	
	public void registerCommands() {
		getCommand("hub").setExecutor(new Hub());
	}


	
	
	
}
