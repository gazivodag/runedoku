package net.runelite.client.plugins.runedoku;

import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.QueryRunner;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;

@PluginDescriptor(
		name = "Runedoku Solver",
		description = "Show solutions for current Runedoku puzzle.",
		tags = {"overlay", "runedoku", "sudoku", "puzzle", "solving"}
)

public class RunedokuPlugin extends Plugin {

	static final Color MIND_RUNE_COLOR = Color.PINK; //1
	static final Color FIRE_RUNE_COLOR = Color.RED; //2
	static final Color BODY_RUNE_COLOR = Color.MAGENTA; //3
	static final Color AIR_RUNE_COLOR = Color.WHITE; //4
	static final Color DEATH_RUNE_COLOR = Color.BLACK; //5
	static final Color WATER_RUNE_COLOR = Color.BLUE; //6
	static final Color CHAOS_RUNE_COLOR = Color.YELLOW; //7
	static final Color EARTH_RUNE_COLOR = Color.GREEN; //8
	static final Color LAW_RUNE_COLOR = Color.CYAN; //9

	@Inject
	QueryRunner queryRunner;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private RunedokuOverlay runedokuOverlay;

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(runedokuOverlay);
	}

	@Override
	protected void shutDown() throws Exception {
		System.out.println("I was shut down!");
		overlayManager.remove(runedokuOverlay);
	}

	static Color sudokuPieceToColor(int i) {
		switch (i) {
			case 1:
				return MIND_RUNE_COLOR;
			case 2:
				return FIRE_RUNE_COLOR;
			case 3:
				return BODY_RUNE_COLOR;
			case 4:
				return AIR_RUNE_COLOR;
			case 5:
				return DEATH_RUNE_COLOR;
			case 6:
				return WATER_RUNE_COLOR;
			case 7:
				return CHAOS_RUNE_COLOR;
			case 8:
				return EARTH_RUNE_COLOR;
			case 9:
				return LAW_RUNE_COLOR;
			default:
				return Color.RED;
		}
	}

	static Color referenceColors(int i) {
		switch (i) {
			case 121: //earth
				return RunedokuPlugin.EARTH_RUNE_COLOR;
			case 122: //water
				return RunedokuPlugin.WATER_RUNE_COLOR;
			case 123: //air
				return RunedokuPlugin.AIR_RUNE_COLOR;
			case 124: //mind
				return RunedokuPlugin.MIND_RUNE_COLOR;
			case 125: //fire
				return RunedokuPlugin.FIRE_RUNE_COLOR;
			case 126: //body
				return RunedokuPlugin.BODY_RUNE_COLOR;
			case 127: //death
				return RunedokuPlugin.DEATH_RUNE_COLOR;
			case 128: //chaos
				return RunedokuPlugin.CHAOS_RUNE_COLOR;
			case 129: //law
				return RunedokuPlugin.LAW_RUNE_COLOR;
			default:
				return Color.RED;
		}
	}

	/**
	 * Make the 2d array into an arraylist
	 * @param board
	 * @return
	 */
	static ArrayList<Integer> makeSimple(int[][] board) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0 ; i < 9 ; i++) {
			for (int ii = 0 ; ii < 9 ; ii++) {
				list.add(board[i][ii]);
			}
		}
		return list;
	}


}
