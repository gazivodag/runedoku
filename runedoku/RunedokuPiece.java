package net.runelite.client.plugins.runedoku;

public enum RunedokuPiece {

	NPC_PLACED_MIND_RUNE(6436, 1), //1
	NPC_PLACED_FIRE_RUNE(6428, 2), //2
	NPC_PLACED_BODY_RUNE(6438, 3), //3
	NPC_PLACED_AIR_RUNE(6422, 4), //4
	NPC_PLACED_DEATH_RUNE(6432, 5), //5
	NPC_PLACED_WATER_RUNE(6424, 6), //6
	NPC_PLACED_CHAOS_RUNE(6430, 7), //7
	NPC_PLACED_EARTH_RUNE(6426, 8), //8
	NPC_PLACED_LAW_RUNE(6434, 9), //9

	PLAYER_PLACED_MIND_RUNE(558, 1), //1
	PLAYER_PLACED_FIRE_RUNE(554, 2), //2
	PLAYER_PLACED_BODY_RUNE(559, 3), //3
	PLAYER_PLACED_AIR_RUNE(556, 4), //4
	PLAYER_PLACED_DEATH_RUNE(560, 5), //5
	PLAYER_PLACED_WATER_RUNE(555, 6), //6
	PLAYER_PLACED_CHAOS_RUNE(562, 7), //7
	PLAYER_PLACED_EARTH_RUNE(557, 8), //8
	PLAYER_PLACED_LAW_RUNE(563, 9), //9
	;

	private final int pieceID;
	private final int pieceForSodoku;

	RunedokuPiece (int pieceID, int pieceForSodoku) {
		this.pieceID = pieceID;
		this.pieceForSodoku = pieceForSodoku;
	}

	int getId () {
		return pieceID;
	}

	int getPieceForSodoku () {
		return pieceForSodoku;
	}

	static RunedokuPiece getById(int pieceID) {
		for (RunedokuPiece e : RunedokuPiece.values()) {
			if (e.getId() == pieceID) {
				return e;
			}
		}
		return null;
	}

}
