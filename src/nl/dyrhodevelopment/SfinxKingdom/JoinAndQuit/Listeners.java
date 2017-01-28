package nl.dyrhodevelopment.SfinxKingdom.JoinAndQuit;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import nl.dyrhodevelopment.SfinxKingdom.Main;

public class Listeners implements Listener {
	
	Main main = Main.main;
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		File file = new File(main.getDataFolder(), File.separator + "players.yml");
		FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);
		
		if(!fileConfig.contains("players." + e.getPlayer().getUniqueId().toString())) {
			fileConfig.set("players." + e.getPlayer().getUniqueId().toString() + ".factionId", 0);
			try {
				fileConfig.save(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
