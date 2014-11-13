package agi2;

public class GameLogicImpl implements FourWinsLogic, TicTacToeLogic {

	Chip playingField[][];
	Result status;

	public GameLogicImpl(int row, int column) {
		playingField = new Chip[row][column];
	}

	public Result throwChip(Chip color, int column) {

		placeChip(color, column);

		status = checkResult(color, column);

		if (status == Result.won) {
			return status;
		} else if (status == Result.continues) {
			return status;
		} else {
			return Result.tied;
		}
	}

	private boolean checkThreeBottomToTop(Chip color, int column, int row) {
		if (row >= playingField.length - 3) {
			if (playingField[row - 1][column] == color
					&& playingField[row - 2][column] == color) {
				return true;
			}
		}
		return false;
	}

	private boolean checkTwoToTheRight(Chip color, int column, int row) {
		if (playingField[row][column + 1] == color
				&& playingField[row][column + 2] == color) {
			return true;
		}
		return false;
	}

	private boolean checkTwoToTheLeft(Chip color, int column, int row) {
		if (playingField[row][column - 1] == color
				&& playingField[row][column - 2] == color) {
			return true;
		}
		return false;
	}

	private boolean checkLeftAndRight(Chip color, int column, int row) {
		if (playingField[row][column - 1] == color
				&& playingField[row][column + 1] == color) {
			return true;
		}

		return false;
	}

	private boolean checkDiagonalyToTheUpperRight(Chip color, int column,
			int row) {
		if (playingField[row - 1][column + 1] == color
				&& playingField[row - 2][column + 2] == color) {
			return true;
		}

		return false;

	}

	private boolean checkDiagonalyToTheLowerLeft(Chip color, int column, int row) {
		if (playingField[row + 2][column - 2] == color
				&& playingField[row + 1][column - 1] == color) {
			return true;
		}

		return false;
	}

	private boolean checkDiagonalyToTheUpperLeft(Chip color, int column, int row) {
		if (playingField[row - 1][column - 1] == color
				&& playingField[row - 2][column - 2] == color) {
			return true;
		}

		return false;
	}

	private boolean checkDiagonalyToTheLowerRight(Chip color, int column,
			int row) {
		if (playingField[row + 1][column + 1] == color
				&& playingField[row + 2][column + 2] == color) {
			return true;
		}
		return false;
	}

	private Result checkResult(Chip color, int column) {
		for (int i = playingField.length - 1; i >= 0; i--) {
			if (playingField[i][column] == color) {
				// 3 nach oben/unten testen
				if (checkThreeBottomToTop(color, column, i)
						&& playingField[i - 3][column] == color) {
					return Result.won;
				}
				// 3 nach rechts testen
				if (column < 4) {
					if (checkTwoToTheRight(color, column, i)
							&& playingField[i][column + 3] == color) {
						return Result.won;
					}
				} // 3 nach links testen
				if (column > 2) {
					if (checkTwoToTheLeft(color, column, i)
							&& playingField[i][column - 3] == color) {
						return Result.won;
					}
				} // 1 nach links 2 nach rechts
				if (column > 0 && column < 5) {
					if (checkLeftAndRight(color, column, i)
							&& playingField[i][column + 2] == color) {
						return Result.won;
					}
				} // 2 nach links 1 nach rechts
				if (column > 1 && column < 6) {
					if (checkLeftAndRight(color, column, i)
							&& playingField[i][column - 2] == color) {
						return Result.won;
					}
				}// 3 diagonal nach rechts oben
				if (column < 4 && i >= playingField.length - 3) {
					if (checkDiagonalyToTheUpperRight(color, column, i)
							&& playingField[i - 3][column + 3] == color) {
						return Result.won;
					}
				}// 2 diagonal rechts oben 1 links runter
				if (column < 5 && column > 0 && i <= playingField.length - 2
						&& i >= playingField.length - 4) {
					if (checkDiagonalyToTheUpperRight(color, column, i)
							&& playingField[i + 1][column - 1] == color) {
						return Result.won;
					}
				}// 1 rechts oben 2 links unten
				if (column < 6 && column > 1 && i <= playingField.length - 3
						&& i >= playingField.length - 5) {
					if (playingField[i - 1][column + 1] == color
							&& checkDiagonalyToTheLowerLeft(color, column, i)) {
						return Result.won;
					}
				}// 3 links unten
				if (column > 2 && i <= playingField.length - 4) {
					if (checkDiagonalyToTheLowerLeft(color, column, i)
							&& playingField[i + 3][column - 3] == color) {
						return Result.won;
					}
				}// 3 links hoch
				if (column > 2 && i >= playingField.length - 4) {
					if (checkDiagonalyToTheUpperLeft(color, column, i)
							&& playingField[i - 3][column - 3] == color) {
						return Result.won;
					}
				}
				// 3 rechts unten
				if (column < 4 && i <= playingField.length - 4) {
					if (checkDiagonalyToTheLowerRight(color, column, i)
							&& playingField[i + 3][column + 3] == color) {
						return Result.won;
					}
				}// 2 rechts unten 1 links oben
				if (column < 5 && column > 0 && i <= playingField.length - 2
						&& i >= playingField.length - 5) {
					if (checkDiagonalyToTheLowerRight(color, column, i)
							&& playingField[i - 1][column - 1] == color) {
						return Result.won;
					}
				}// 1 rechts unten 2 links oben
				if (column < 6 && column > 1 && i <= playingField.length - 2
						&& i >= playingField.length - 4) {
					if (playingField[i + 1][column + 1] == color
							&& checkDiagonalyToTheUpperLeft(color, column, i)) {
						return Result.won;
					}
				}
			}
		}
		if (isPlayingFieldFull())
			return Result.tied;

		return Result.continues;
	}

	private void placeChip(Chip color, int column)
			throws ArrayIndexOutOfBoundsException {
		if (isColumnFull(column))
			throw new ArrayIndexOutOfBoundsException("Spalte ist voll!");
		for (int i = playingField.length - 1; i >= 0; i--) {
			if (playingField[i][column] == null) {
				playingField[i][column] = color;
				i = -1;
			}
		}
	}

	public boolean isColumnFull(int column) {
		for (int i = 0; i < 6; i++) {
			if (playingField[i][column] == null)
				return false;
		}
		return true;
	}

	public boolean isPlayingFieldFull() {
		for (int i = 0; i < 7; i++) {
			if (playingField[0][i] == null)
				return false;
		}
		return true;
	}

	@Override
	public Result setChip(Chip chip, int row, int col) {

		placeChip(chip, row, col);

		status = checkResult(chip, row, col);

		if (status == Result.won) {
			return status;
		} else if (status == Result.continues) {
			return status;
		} else {
			return Result.tied;
		}
	}

	private Result checkResult(Chip chip, int row, int col) {
		if (row == 2) {
			if (checkThreeBottomToTop(chip, col, row)) {
				return Result.won;
			}
		}
		if (col == 2) {
			if (checkTwoToTheLeft(chip, col, row)) {
				return Result.won;
			}
		}
		if (col == 1) {
			if (checkLeftAndRight(chip, col, row)) {
				return Result.won;
			}
		}

		if (isTicTacToeFieldFull()) {
			return Result.tied;
		}

		return Result.continues;
	}

	private boolean isTicTacToeFieldFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (playingField[j][i] == null) {
					return false;
				}
			}
		}
		return true;
	}

	private void placeChip(Chip chip, int row, int col) {
		if (playingField[row][col] == null) {
			playingField[row][col] = chip;
		}
	}

}
