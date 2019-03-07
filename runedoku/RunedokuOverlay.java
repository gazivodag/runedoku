package net.runelite.client.plugins.runedoku;

import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.tooltip.TooltipManager;

import javax.inject.Inject;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.RED;

/**
 * @author gazivodag
 */
class RunedokuOverlay extends Overlay {

	private final RunedokuPlugin plugin;
	private final Client client;
	private final TooltipManager tooltipManager;
	private final PanelComponent panelComponent = new PanelComponent();


	@Inject
	private RunedokuOverlay(final RunedokuPlugin plugin, final Client client, final TooltipManager tooltipManager) {
		super(plugin);
		this.plugin = plugin;
		this.client = client;
		this.tooltipManager = tooltipManager;

		setPosition(OverlayPosition.DETACHED);
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		setPriority(OverlayPriority.MED);

	}

	@Override
	public Dimension render(Graphics2D graphics) {

		final Widget sudokuScreen = client.getWidget(288,131);

		if (sudokuScreen != null) {
			if (!sudokuScreen.isHidden()) {

				Sudoku sudoku = new Sudoku(Sudoku.createTable(client));
				boolean solved = sudoku.solve();

				ArrayList<Integer> simpleArr = RunedokuPlugin.makeSimple(sudoku.getBoard());

				//reference runes on the left handside
				for (int i = 121 ; i < 130 ; i++) {
					Widget widget = client.getWidget(288, i);
					if (solved) {
						OverlayUtil.renderPolygon(graphics, RectangleToPolygon(widget.getBounds()), RunedokuPlugin.referenceColors(i));
					} else {
						OverlayUtil.renderPolygon(graphics, RectangleToPolygon(widget.getBounds()), RED);
					}

				}

				//highlight each cell to tell you which piece to place
				int iteration = 0;
				for (int i = 10 ; i < 91 ; i++) {
					Widget squareToHighlight = client.getWidget(288, i);
					if (solved) {
						OverlayUtil.renderPolygon(graphics, RectangleToPolygon(squareToHighlight.getBounds()), RunedokuPlugin.sudokuPieceToColor(simpleArr.get(iteration)));
						iteration++;
					} else {
						OverlayUtil.renderPolygon(graphics, RectangleToPolygon(squareToHighlight.getBounds()), RED);
					}

				}
			}

		}


		return null;
	}

	static Polygon RectangleToPolygon(Rectangle rect) {
		int[] xpoints = {rect.x, rect.x + rect.width, rect.x + rect.width, rect.x};
		int[] ypoints = {rect.y, rect.y, rect.y + rect.height, rect.y + rect.height};
		return new Polygon(xpoints, ypoints, 4);
	}

}
