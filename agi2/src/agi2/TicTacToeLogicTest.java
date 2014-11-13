package agi2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeLogicTest {
	GameLogicImpl game;

	@Before
	public void setUp() {
		game = new GameLogicImpl(3, 3);
	}

	@Test
	public void testIfGameContinues() {
		assertEquals(Result.continues, game.setChip(Chip.blue, 1, 1));
	}

	@Test
	public void testIfGameIsWonVertical() {
		game.setChip(Chip.blue, 0, 0);
		game.setChip(Chip.blue, 1, 0);
		assertEquals(Result.won, game.setChip(Chip.blue, 2, 0));
	}

	@Test
	public void testIfGameIsTied() {
		game.setChip(Chip.blue, 0, 0);
		game.setChip(Chip.red, 1, 0);
		game.setChip(Chip.blue, 2, 0);

		game.setChip(Chip.blue, 0, 1);
		game.setChip(Chip.red, 1, 1);
		game.setChip(Chip.blue, 2, 1);

		game.setChip(Chip.red, 0, 2);
		game.setChip(Chip.blue, 1, 2);
		assertEquals(Result.tied, game.setChip(Chip.red, 2, 2));

	}

	@Test
	public void testIfGameIsWonHorizontal() {
		game.setChip(Chip.blue, 0, 0);
		game.setChip(Chip.blue, 0, 1);
		assertEquals(Result.won, game.setChip(Chip.blue, 0, 2));
	}

	@Test
	public void testIfGameIsWonHorizontalLeftAndRight() {
		game.setChip(Chip.blue, 0, 0);
		game.setChip(Chip.blue, 0, 2);
		assertEquals(Result.won, game.setChip(Chip.blue, 0, 1));
	}
}
