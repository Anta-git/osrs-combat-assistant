package com.combatassistant;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface CAConfig extends Config
{
	@ConfigItem(
			keyName = "showAlways",
			name = "Show even off hover",
			description = "Keep showing last target when mouse not over NPC"
	)
	default boolean showAlways() { return false; }
	default String greeting()
	{
		return "Hello";
	}
}
