package agi2;

public class FourWinsLogicImpl {

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
		if (isPlayingFieldFull())
			return Result.tied;

		for (int i = playingField.length - 1; i >= 0; i--) {
			if (playingField[i][column] == color) {
				if (i >= playingField.length - 3) {
					if (playingField[i - 1][column] == color
							&& playingField[i - 2][column] == color
							&& playingField[i - 3][column] == color) {
						return Result.won;
					} else if (column < 4) {
						if (playingField[i][column + 1] == color
								&& playingField[i][column + 2] == color
								&& playingField[i][column + 3] == color) {
							return Result.won;
						} else if (column > 2) {
							if (playingField[i][column - 1] == color
									&& playingField[i][column - 2] == color
									&& playingField[i][column - 3] == color) {
								return Result.won;
							}
						}
					}
				}
			}
		}

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
