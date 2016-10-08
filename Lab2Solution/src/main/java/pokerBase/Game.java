package pokerBase;

import java.util.UUID;
import java.util.ArrayList;

public class Game {

	private UUID GameID;
	private UUID TableID;
	ArrayList<Player> GamePlayers = new ArrayList<Player>();

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

	public void AddPlayerToGame(Table t1, Player p1) {
		ArrayList<Player> ps = t1.getPlayers();
		ps.add(p1);
		t1.setPlayers(ps);
	}

}
