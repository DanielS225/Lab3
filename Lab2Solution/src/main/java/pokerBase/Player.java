package pokerBase;

import java.util.UUID;


public class Player {
	private UUID PlayerID;
	private String PlayerName;
	
	public Player(String name){
		
		PlayerID = UUID.randomUUID();
		this.PlayerName = name;
	}

	public UUID getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(UUID playerID) {
		PlayerID = playerID;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	
	

}
