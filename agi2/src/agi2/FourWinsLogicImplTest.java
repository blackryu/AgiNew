package agi2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FourWinsLogicImplTest {
	GameLogicImpl game;

	@Before
	public void setUp() {
		game = new GameLogicImpl(6,7);
	}

	@Test
	public void testIfGameContinues() {
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
	}

	@Test
	public void testIfGameIsWonVertical() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.won, game.throwChip(Chip.red, 2));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testIfGameIsTied() {
		game.throwChip(Chip.blue, 0);
		game.throwChip(Chip.blue, 0);
		game.throwChip(Chip.red, 0);
		game.throwChip(Chip.red, 0);
		game.throwChip(Chip.blue, 0);
		game.throwChip(Chip.blue, 0);

		game.throwChip(Chip.red, 1);
		game.throwChip(Chip.red, 1);
		game.throwChip(Chip.blue, 1);
		game.throwChip(Chip.blue, 1);
		game.throwChip(Chip.red, 1);
		game.throwChip(Chip.red, 1);

		game.throwChip(Chip.blue, 2);
		game.throwChip(Chip.blue, 2);
		game.throwChip(Chip.red, 2);
		game.throwChip(Chip.red, 2);
		game.throwChip(Chip.blue, 2);
		game.throwChip(Chip.blue, 2);

		game.throwChip(Chip.red, 3);
		game.throwChip(Chip.red, 3);
		game.throwChip(Chip.blue, 3);
		game.throwChip(Chip.blue, 3);
		game.throwChip(Chip.red, 3);
		game.throwChip(Chip.red, 3);

		game.throwChip(Chip.blue, 4);
		game.throwChip(Chip.blue, 4);
		game.throwChip(Chip.red, 4);
		game.throwChip(Chip.red, 4);
		game.throwChip(Chip.blue, 4);
		game.throwChip(Chip.blue, 4);

		game.throwChip(Chip.red, 5);
		game.throwChip(Chip.red, 5);
		game.throwChip(Chip.blue, 5);
		game.throwChip(Chip.blue, 5);
		game.throwChip(Chip.red, 5);
		game.throwChip(Chip.red, 5);

		game.throwChip(Chip.blue, 6);
		game.throwChip(Chip.blue, 6);
		game.throwChip(Chip.red, 6);
		game.throwChip(Chip.red, 6);
		game.throwChip(Chip.blue, 6);
		assertEquals(Result.tied, game.throwChip(Chip.blue, 6));
		game.throwChip(Chip.blue, 6);
	}

	@Test
	public void testIfGameIsWonHorizontalToTheRight() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 5));
		assertEquals(Result.continues, game.throwChip(Chip.red, 4));
		assertEquals(Result.won, game.throwChip(Chip.red, 3));
	}

	@Test
	public void testIfGameIsWonHorizontalToTheLeft() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 1));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.won, game.throwChip(Chip.red, 3));
	}

	@Test
	public void testIfGameIsWonHorizontalOneToTheLeftTwoToTheRight() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 3));
		assertEquals(Result.won, game.throwChip(Chip.red, 1));
	}

	@Test
	public void testIfGameIsWonHorizontalOneToTheRightTwoToTheLeft() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 1));
		assertEquals(Result.continues, game.throwChip(Chip.red, 3));
		assertEquals(Result.won, game.throwChip(Chip.red, 2));
	}

	@Test
	public void testIfGameIsWonThreeDiagonalyToTheUpperRight() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 6));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.red, 5));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.red, 5));

		assertEquals(Result.continues, game.throwChip(Chip.red, 4));
		assertEquals(Result.continues, game.throwChip(Chip.red, 4));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 4));
		assertEquals(Result.continues, game.throwChip(Chip.red, 4));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.won, game.throwChip(Chip.red, 3));
	}

	@Test
	public void testIfGameIsWonThreeDiagonalyToTheBottomLeft() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 6));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.red, 5));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.red, 5));

		assertEquals(Result.continues, game.throwChip(Chip.red, 4));
		assertEquals(Result.continues, game.throwChip(Chip.red, 4));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 4));
		assertEquals(Result.continues, game.throwChip(Chip.red, 4));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.red, 3));

		assertEquals(Result.won, game.throwChip(Chip.red, 6));
	}

	@Test
	public void testIfGameIsWonTwoDiagonalyToTheUpperRightOneLowerLeft() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 6));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.red, 5));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.red, 5));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.red, 3));

		assertEquals(Result.continues, game.throwChip(Chip.red, 4));
		assertEquals(Result.continues, game.throwChip(Chip.red, 4));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 4));
		assertEquals(Result.won, game.throwChip(Chip.red, 4));
	}

	@Test
	public void testIfGameIsWonOneDiagonalyToTheUpperRightTwoLowerLeft() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 6));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));
		assertEquals(Result.continues, game.throwChip(Chip.red, 6));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));
		assertEquals(Result.continues, game.throwChip(Chip.red, 5));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 5));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.red, 3));

		assertEquals(Result.continues, game.throwChip(Chip.red, 4));
		assertEquals(Result.continues, game.throwChip(Chip.red, 4));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 4));
		assertEquals(Result.continues, game.throwChip(Chip.red, 4));

		assertEquals(Result.won, game.throwChip(Chip.red, 5));

	}

	@Test
	public void testIfGameIsWonThreeDiagonalyToTheUpperLeft() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 0));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.red, 1));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.red, 1));

		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.won, game.throwChip(Chip.red, 3));
	}

	@Test
	public void testIfGameIsWonThreeDiagonalyToTheBottomRight() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 0));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.red, 1));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.red, 1));

		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.red, 3));

		assertEquals(Result.won, game.throwChip(Chip.red, 0));
	}

	@Test
	public void testIfGameIsWonOneDiagonalyToTheUpperLeftTwoLowerRight() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 0));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.red, 1));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));	

		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.red, 3));

		assertEquals(Result.won, game.throwChip(Chip.red, 1));
		
	}

	@Test
	public void testIfGameIsWonTwoDiagonalyToTheUpperLeftOneLowerRight() {
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 0));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));
		assertEquals(Result.continues, game.throwChip(Chip.red, 0));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.red, 1));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 1));
		assertEquals(Result.continues, game.throwChip(Chip.red, 1));

		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.red, 2));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 2));

		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.blue, 3));
		assertEquals(Result.continues, game.throwChip(Chip.red, 3));

		assertEquals(Result.won, game.throwChip(Chip.red, 2));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testIfColumnIsFull() {
		game.throwChip(Chip.blue, 0);
		game.throwChip(Chip.blue, 0);
		game.throwChip(Chip.blue, 0);
		game.throwChip(Chip.blue, 0);
		game.throwChip(Chip.blue, 0);
		game.throwChip(Chip.red, 0);
		game.throwChip(Chip.blue, 0);
	}
}
