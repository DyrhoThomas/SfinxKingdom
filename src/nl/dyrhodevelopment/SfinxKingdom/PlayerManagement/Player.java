package nl.dyrhodevelopment.SfinxKingdom.PlayerManagement;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.dyrhodevelopment.SfinxKingdom.Main;

public class Player implements PlayerInterface {
	
	Main main = Main.main;
	
	protected org.bukkit.entity.Player p;
	
	protected int id;
	
	public Player(org.bukkit.entity.Player p) {
		this.p = p;
		
		File file = new File(main.getDataFolder(), File.separator + "players.yml");
		FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);
		
		int id = fileConfig.getInt("players." + p.getUniqueId().toString() + ".factionId");
		
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public org.bukkit.entity.Player getPlayer() {
		return p;
	}
}
