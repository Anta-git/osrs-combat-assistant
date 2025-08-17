package com.combatassistant;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class CATest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(CAPlugin.class);
		RuneLite.main(args);
	}
}