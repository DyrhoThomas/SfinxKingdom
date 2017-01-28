package nl.dyrhodevelopment.SfinxKingdom.ChunkManagement;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.dyrhodevelopment.SfinxKingdom.Main;

public class Chunk implements ChunkInterface {

	static Main main = Main.main;
	
	protected static int id;
	protected static org.bukkit.Chunk chunk;
	
	
	public static Chunk claimChunk(org.bukkit.Chunk mChunk, int kingdomID) {
		chunk = mChunk;
		
		File file = new File(main.getDataFolder(), File.separator + "chunks.yml");
		FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);
		
		fileConfig.set("chunks." + mChunk.getX() + "-" + mChunk.getZ() + ".faction", kingdomID);
		
		try {
			fileConfig.save(file);
		} catch (IOException e) {
			
		}
		
		return new Chunk(chunk);
	}
	
	public Chunk(org.bukkit.Chunk chunk) {
		Chunk.chunk = chunk;
		
		File file = new File(main.getDataFolder(), File.separator + "chunks.yml");
		FileConfiguration fileConfig = YamlConfiguration.loadConfiguration(file);
		
		if(!fileConfig.contains("chunks." + chunk.getX() + "-" + chunk.getZ())) {
			Chunk.id = 0;
		} else {
			int id = fileConfig.getInt("chunks." + chunk.getX() + "-" + chunk.getZ() + ".faction");
			Chunk.id = id;
		}
	}
	
	public org.bukkit.Chunk getChunk() {
		return chunk;
	}
	
	@Override
	public int getId() {
		return id;
	}
}
