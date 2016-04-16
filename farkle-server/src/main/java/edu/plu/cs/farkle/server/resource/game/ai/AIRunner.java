package edu.plu.cs.farkle.server.resource.game.ai;

import java.util.ArrayList;
import java.util.List;

public class AIRunner {
	private List<AIPlayer> players;
	
	public AIRunner(){
		players = new ArrayList<AIPlayer>();
	}
	public void runAI(){
		while(true)
		for(int i = 0; i < players.size(); i++){
			if(players.get(i).startTurn()){
				//TODO temp
				System.out.println(players.get(i).getName() + " WINS" + players.get(i).getTotalScore());
				return;
			}
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
