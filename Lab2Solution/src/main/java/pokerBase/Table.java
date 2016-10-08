package pokerBase;

import java.util.UUID;
import java.util.ArrayList;

public class Table {
	private UUID TableID;
	private ArrayList<Player> players;

	public Table() {
		TableID = UUID.randomUUID();
		players = new ArrayList<Player>();
	}

	public Table AddPlayerToTable(Player p1) {
		players.add(p1);
		return this;
	}

	public UUID getTableID() {
		return TableID;
	}

	public void setTableID(UUID tableID) {
		TableID = tableID;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public ArrayList<Player> setPlayers(ArrayList<Player> players) {
		return this.players = players;
	}

}
