package edu.plu.cs.farkle.server.resource.game;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class DiceTest {
	Variation var;
	HashMap<Integer, Integer> map;
	@Before
	public void setUp() throws Exception {
		map = new HashMap<Integer, Integer>();
		var = new Variation();
	}
	@Test
	public void test() {
		map.put(1, 6);
		map.put(2, 0);
		map.put(3, 0);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 0);
		assertEquals(var.Check6(map), 8000);
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 5);
		map.put(6, 6);
		assertEquals(var.CheckStraight(map), 1000);
		map.put(1, 3);
		map.put(2, 0);
		map.put(3, 0);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 2);
		assertEquals(var.FullHouse(map), 1250);
		map.put(1, 0);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 0);
		assertEquals(var.FullHouse(map), 550);
		map.put(1, 2);
		map.put(2, 2);
		map.put(3, 2);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 0);
		assertEquals(var.ThreePair(map), 1500);
	}

}
