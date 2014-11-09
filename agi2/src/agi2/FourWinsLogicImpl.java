package agi2;

public class FourWinsLogicImpl implements FourWinsLogic {

	Chip playingField[][] = new Chip[6][7];
	Result status;

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

	private Result checkResult(Chip color, int column) {
		for (int i = playingField.length - 1; i >= 0; i--) {
			if (playingField[i][column] == color) {
				// 3 nach oben/unten testen
				if (i >= playingField.length - 3) {
					if (playingField[i - 1][column] == color
							&& playingField[i - 2][column] == color
							&& playingField[i - 3][column] == color) {
						return Result.won;
					}
				}
				// 3 nach rechts testen
				if (column < 4) {
					if (playingField[i][column + 1] == color
							&& playingField[i][column + 2] == color
							&& playingField[i][column + 3] == color) {
						return Result.won;
					}
				} // 3 nach links testen
				if (column > 2) {
					if (playingField[i][column - 1] == color
							&& playingField[i][column - 2] == color
							&& playingField[i][column - 3] == color) {
						return Result.won;
					}
				} // 1 nach links 2 nach rechts
				if (column > 0 && column < 5) {
					if (playingField[i][column - 1] == color
							&& playingField[i][column + 1] == color
							&& playingField[i][column + 2] == color) {
						return Result.won;
					}
				} // 2 nach links 1 nach rechts
				if (column > 1 && column < 6) {
					if (playingField[i][column - 1] == color
							&& playingField[i][column + 1] == color
							&& playingField[i][column - 2] == color) {
						return Result.won;
					}
				}// 3 diagonal nach rechts oben
				if (column < 4 && i >= playingField.length - 3) {
					if (playingField[i - 1][column + 1] == color
							&& playingField[i - 2][column + 2] == color
							&& playingField[i - 3][column + 3] == color) {
						return Result.won;
					}
				}// 2 diagonal rechts oben 1 links runter
				if (column < 5 && column > 0 && i <= playingField.length - 2
						&& i >= playingField.length - 4) {
					if (playingField[i - 1][column + 1] == color
							&& playingField[i - 2][column + 2] == color
							&& playingField[i + 1][column - 1] == color) {
						return Result.won;
					}
				}// 1 rechts oben 2 links unten
				if (column < 6 && column > 1 && i <= playingField.length - 3
						&& i >= playingField.length - 5) {
					if (playingField[i - 1][column + 1] == color
							&& playingField[i + 2][column - 2] == color
							&& playingField[i + 1][column - 1] == color) {
						return Result.won;
					}
				}// 3 links unten
				if (column > 2 && i <= playingField.length - 4) {
					if (playingField[i + 1][column - 1] == color
							&& playingField[i + 2][column - 2] == color
							&& playingField[i + 3][column - 3] == color) {
						return Result.won;
					}
				}// 3 links hoch
				if (column > 2 && i >= playingField.length - 4) {
					if (playingField[i - 1][column - 1] == color
							&& playingField[i - 2][column - 2] == color
							&& playingField[i - 3][column - 3] == color) {
						return Result.won;
					}
				}
				// 3 rechts unten
				if (column < 4 && i <= playingField.length - 4) {
					if (playingField[i + 1][column + 1] == color
							&& playingField[i + 2][column + 2] == color
							&& playingField[i + 3][column + 3] == color) {
						return Result.won;
					}
				}// 2 rechts unten 1 links oben
				if (column < 5 && column > 0 && i <= playingField.length - 2
						&& i >= playingField.length - 5) {
					if (playingField[i + 1][column + 1] == color
							&& playingField[i + 2][column + 2] == color
							&& playingField[i - 1][column - 1] == color) {
						return Result.won;
					}
				}// 1 rechts unten 2 links oben
				if (column < 6 && column > 1 && i <= playingField.length - 2
						&& i >= playingField.length - 4) {
					if (playingField[i + 1][column + 1] == color
							&& playingField[i - 1][column - 1] == color
							&& playingField[i - 2][column - 2] == color) {
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
			throws IndexOutOfBoundsException {
		if (isPlayingFieldFull())
			throw new IndexOutOfBoundsException("Spielfeld ist voll!");
		for (int i = playingField.length - 1; i >= 0; i--) {
			if (playingField[i][column] == null) {
				playingField[i][column] = color;
				i = -1;
			}
		}
	}

	public boolean isPlayingFieldFull() {
		for (int i = 0; i < 7; i++) {
			if (playingField[0][i] == null)
				return false;
		}
		return true;
	}

}
