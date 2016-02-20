package de.herrbockwurst.hubber;

import org.bukkit.plugin.java.JavaPlugin;

import de.herrbockwurst.hubber.Config.SimpleConfig;
import de.herrbockwurst.hubber.Config.SimpleConfigManager;
import de.herrbockwurst.hubber.listeners.VoidFall;
import de.herrbockwurst.hubber.listeners.FallDamage;
import de.herrbockwurst.hubber.fixconfig;

public class main extends JavaPlugin {
	
	public static main thisclass = null;
    public SimpleConfigManager manager;
    public SimpleConfig config;
    public SimpleConfig lang;
    
    
	@Override
	public void onEnable() {
		super.onEnable();
		thisclass = this;
		
		getConf();
		registerListeners();
		registerCommands();
		//test
	}
	
	private void getConf() {
		manager = new SimpleConfigManager(this);
		config = manager.getNewConfig("config.yml");
		lang = manager.getNewConfig("language/de.yml");
		
		fixconfig.fix();
	}

	public void registerListeners() {
		getServer().getPluginManager().registerEvents(new VoidFall(), this);
		getServer().getPluginManager().registerEvents(new FallDamage(), this);
	}
	
	public void registerCommands() {
		getCommand("hub").setExecutor(new Commands());
	}
	
	
	
}
