package nl.dyrhodevelopment.SfinxKingdom;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static String prefix = "§4[§6Sfinx§4] §6";
	
	public static Main main;
	
	public void onEnable() {
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(prefix + "De kingdom plugin wordt opgestart...");
		main = this;
		
		console.sendMessage(prefix + "Listeners registreren...");
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new nl.dyrhodevelopment.SfinxKingdom.ChatFormat.Listeners(), this);
		pm.registerEvents(new nl.dyrhodevelopment.SfinxKingdom.JoinAndQuit.Listeners(), this);
	}
}
