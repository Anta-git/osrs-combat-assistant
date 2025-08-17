package com.combatassistant;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Combat Assistant"
)
public class CAPlugin extends Plugin
{
	@Inject	private Client client;
	@Inject	private CAConfig config;
	@Inject private OverlayManager overlayManager;
	@Inject private AccuracyOverlay overlay;

	private String hoveredNpcName;

	@Provides
	CAConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CAConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		log.info("Combat Assistant started!");
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Combat Assistant stopped!");
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		MenuEntry entry = event.getMenuEntry();
		String option = entry.getOption();

		if ("Attack".equals(option))
		{
			hoveredNpcName = entry.getTarget();
			overlay.setNpcName(hoveredNpcName);

			// Debug to confirm
			client.addChatMessage(
					net.runelite.api.ChatMessageType.GAMEMESSAGE,
					"", "Hovering over: " + hoveredNpcName, null
			);
		}
	}
}
