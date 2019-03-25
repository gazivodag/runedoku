/*
 * Copyright (c) 2019, gazivodag <https://github.com/gazivodag>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

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

@SuppressWarnings("unused")
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
				return EARTH_RUNE_COLOR;
			case 122: //water
				return WATER_RUNE_COLOR;
			case 123: //air
				return AIR_RUNE_COLOR;
			case 124: //mind
				return MIND_RUNE_COLOR;
			case 125: //fire
				return FIRE_RUNE_COLOR;
			case 126: //body
				return BODY_RUNE_COLOR;
			case 127: //death
				return DEATH_RUNE_COLOR;
			case 128: //chaos
				return CHAOS_RUNE_COLOR;
			case 129: //law
				return LAW_RUNE_COLOR;
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
