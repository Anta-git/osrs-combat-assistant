package com.combatassistant;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

public class AccuracyOverlay extends Overlay
{
	private final Client client;
	private String npcName;

	@Inject
	private AccuracyOverlay(Client client)
	{
		this.client = client;
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_WIDGETS);
	}

	public void setNpcName(String name) { this.npcName = name; }

	@Override
	public Dimension render(Graphics2D g)
	{
		//commented out to always display -something- for testing purposes
		//if (npcName == null) return null;

		// Stub: eventually calculate real accuracy
		double accuracy = 0.75; // example: 75%

		Point mouse = client.getMouseCanvasPosition();
		String text = (npcName != null ? npcName : "no target") + ": 75%";

		g.setColor(Color.BLACK);
		g.fillRect(mouse.getX() + 15, mouse.getY() - 15, g.getFontMetrics().stringWidth(text) + 6, 18);
		g.setColor(Color.WHITE);
		g.drawString(text, mouse.getX() + 18, mouse.getY() - 2);

		return null;
	}
}