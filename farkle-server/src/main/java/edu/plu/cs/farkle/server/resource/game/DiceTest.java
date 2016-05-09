package edu.plu.cs.farkle.server.resource.game;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import edu.plu.cs.farkle.server.resource.game.scoring.Variation;

public class DiceTest {
	Variation var;
	HashMap<Integer, Integer> map;
	@Before
	public void setUp() throws Exception {
		map = new HashMap<Integer, Integer>();
		var = new Variation(1000, 1000, 1000, "add");
	}

	@Test
	public void testCheckStraight() {
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 5);
		map.put(6, 6);
		assertEquals(var.CheckStraight(map), 1000);
		
	}
	@Test
	public void testFullHouse() {
		map.put(1, 3);
		map.put(2, 0);
		map.put(3, 0);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 2);
		assertEquals(var.FullHouse(map), 2000);
		map.put(1, 0);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 0);
		assertEquals(var.FullHouse(map), 1300);
	}
	
	@Test
	public void testCheckFourPlus() {
		map.put(1, 6);
		map.put(2, 0);
		map.put(3, 0);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 0);
		assertEquals(var.checkAll(map), 4000);
	}
	@Test
	public void testThreePair() {
		map.put(1, 0);
		map.put(2, 2);
		map.put(3, 0);
		map.put(4, 2);
		map.put(5, 0);
		map.put(6, 2);
		assertEquals(var.ThreePair(map), 1000);
		
	}
}
	
	


