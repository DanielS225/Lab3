package pokerBase;

import java.util.UUID;
import java.util.ArrayList;

public class Game {

	private UUID GameID;

	public UUID getGameID() {
		return GameID;
	}

	public void setGameID(UUID gameID) {
		GameID = gameID;
	}

	public ArrayList<Player> getGamePlayers() {
		return GamePlayers;
	}

	public void setGamePlayers(ArrayList<Player> gamePlayers) {
		GamePlayers = gamePlayers;
	}

	private ArrayList<Player> GamePlayers = new ArrayList<Player>();

	public Game AddPlayerToGame(Table t1, Player p1) {
		
	}

}
