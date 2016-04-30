package edu.plu.cs.farkle.server.resource.game.ai;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.plu.cs.farkle.server.resource.game.Game;

public class AITest {
	AIRunner runner;
	
	AIPlayer player, player1,player2, test;
	Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game(1, 1);
		test = new AIPlayer(5,"AITEST", game);
		player = new AIPlayer(10,"test", game);
		player1 = new AIPlayer(5,"test1", game);
		player2 = new AIPlayer(1,"test2", game);
		runner = new AIRunner();
		runner.addPlayer(player);
		runner.addPlayer(player1);
		runner.addPlayer(player2);
		//runner.addPlayer(test);
		
	}

	@Test
	public void test() {
		test.startTurn();
	
		assertNotNull(test.getDice());
		
		System.out.println(test.getDice());
		assertNotNull(test.getStoredDice());
		System.out.println(test.getStoredDice());
		assertTrue(test.AIfarkled());
	    System.out.println(test.getTotalScore());
		
		runner.runAI();
	}

}
