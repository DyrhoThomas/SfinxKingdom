package nl.dyrhodevelopment.SfinxKingdom.KingdomManagement;

import java.util.List;
import java.util.UUID;

public interface KingdomInterface {
	
	public int getId();
	
	public UUID getKing();
	public List<UUID> getLords();
	public List<UUID> getMembers();
	
	public String getName();
	public String getPrefix();
	
	public void create(String name, UUID king);
	
}
