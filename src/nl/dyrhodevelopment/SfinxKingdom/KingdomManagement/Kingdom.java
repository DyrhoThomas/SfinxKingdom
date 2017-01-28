package nl.dyrhodevelopment.SfinxKingdom.KingdomManagement;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import nl.dyrhodevelopment.SfinxKingdom.Main;

public class Kingdom implements KingdomInterface {
	
	Main main = Main.main;
	
	protected static int id;
	
	protected static UUID king;
	protected static List<UUID> lords;
	protected static List<UUID> members;
	
	protected static String name;
	protected static String prefix;
	
	public Kingdom(int id) {
		Kingdom.id = id;
		
		File file = new File(main.getDataFolder(), File.separator + "kingdoms.yml");
		FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
		
		
		king = UUID.fromString(fileConfiguration.getString("kingdoms." + id + ".owner"));
		
		List<String> lordsStrings = fileConfiguration.getStringList("kingdoms." + id + ".lords");
		for(String s: lordsStrings) {
			lords.add(UUID.fromString(s));
		}
		
		List<String> membersStrings = fileConfiguration.getStringList("kingdoms." + id + ".members");
		for(String s: membersStrings) {
			members.add(UUID.fromString(s));
		}
		
		name = fileConfiguration.getString("kingdoms." + id + ".name");
		
		prefix = fileConfiguration.getString("kingdoms." + id + ".prefix");
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	
	@Override
	public UUID getKing() {
		return king;
	}
	
	@Override
	public List<UUID> getLords() {
		return lords;
	}
	
	@Override
	public List<UUID> getMembers() {
		return members;
	}
	
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getPrefix() {
		return prefix;
	}
	
	@Override
	public void create(String name, UUID king) {
	}

}
