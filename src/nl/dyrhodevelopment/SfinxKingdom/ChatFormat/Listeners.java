package nl.dyrhodevelopment.SfinxKingdom.ChatFormat;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import nl.dyrhodevelopment.SfinxKingdom.KingdomManagement.Kingdom;
import nl.dyrhodevelopment.SfinxKingdom.PlayerManagement.Player;

public class Listeners implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		String msg = e.getMessage();
		
		
		Player p = new Player(e.getPlayer());
		int id= p.getId();
		Kingdom kingdom = new Kingdom(id);
		
		String kingdomPrefix = kingdom.getPrefix();
		
		String kingdomRankPrefix = "";
		if(kingdom.getLords() != null) {
			if(kingdom.getLords().contains(e.getPlayer().getUniqueId())) {
				kingdomRankPrefix = "§7[§6Hertog§7]";
			}
		}
		if(kingdom.getKing() != null) {
			if(kingdom.getKing().equals(e.getPlayer().getUniqueId())) {
				kingdomRankPrefix = "§7[§4King§7]";
			}	
		}
		
		if(e.getPlayer().hasPermission("kingdom.chatcolor")) {
			msg = msg.replace("&", "§");
		}
		
		String chatMessage = "§7" + kingdomRankPrefix.replace("&", "§") + kingdomPrefix.replace("&", "§") + " " +
				p.getPlayer().getDisplayName() + ": §r" + msg;

		e.setCancelled(true);
		Bukkit.broadcastMessage(chatMessage);
	}
}
