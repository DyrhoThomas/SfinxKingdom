package nl.dyrhodevelopment.SfinxKingdom.ClaimCommand;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import nl.dyrhodevelopment.SfinxKingdom.Main;
import nl.dyrhodevelopment.SfinxKingdom.ChunkManagement.Chunk;
import nl.dyrhodevelopment.SfinxKingdom.KingdomManagement.Kingdom;

public class Claim {
	
	static Main main = Main.main;
	
	public static void onClaim(Player p) {
		org.bukkit.Chunk chunk = p.getLocation().getChunk();
		
		File file = new File(main.getDataFolder(), File.separator + "chunks.yml");
		FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);
		
		//TODO check if in kingdom en has lord or king rank
		if(new nl.dyrhodevelopment.SfinxKingdom.PlayerManagement.Player(p).getId() == 0) {
			p.sendMessage("§cHelaas, maar je zit nog niet in een kingdom!");
			return;
		}
		int kingdomId = new nl.dyrhodevelopment.SfinxKingdom.PlayerManagement.Player(p).getId();
		Kingdom kd = new Kingdom(kingdomId);
		
		if(!kd.getLords().contains(p.getUniqueId()) || !kd.getKing().equals(p.getUniqueId())) {
			p.sendMessage(Main.prefix + "§cHelaas, Je hebt hier geen toestemming voor, je bent geen hertog of koning van je kingdom!");
			return;
		}
		
		if(fileConfig.contains("chunks." + chunk.getX() + "-" + chunk.getZ())) {
			p.sendMessage(Main.prefix + "§cHelaas, deze chunk is al geclaimed!");
			return;
		} else {
			Chunk.claimChunk(chunk, kingdomId);
		}
		
	}
}
