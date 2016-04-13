package edu.plu.cs.farkle.server.resource.game.ai;

import java.util.List;

public class AIRunner {
	private List<AIPlayer> players;
	
	
	public void runAI(){
		for(int i = 0; i < players.size(); i++){
			players.get(i).startTurn();
		}
		
	}
	
	public void addPlayer(AIPlayer player){
		players.add(player);
	}

	public List<AIPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<AIPlayer> players) {
		this.players = players;
	}
	
	
}
