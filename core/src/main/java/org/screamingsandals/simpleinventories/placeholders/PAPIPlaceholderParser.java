package org.screamingsandals.simpleinventories.placeholders;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderHook;

public class PAPIPlaceholderParser implements PlaceholderParser {

	@Override
	public String processPlaceholder(String key, Player player, String[] arguments) {
		String format = String.join(".", arguments);
		if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
			Map<String, PlaceholderHook> hooks = PlaceholderAPI.getPlaceholders();
			int index = format.indexOf("_");
			if (index <= 0 || index >= format.length()) {
				return "%" + format + "%"; // ignore this placeholder
			}
			String identifier = format.substring(0, index).toLowerCase();
			String params = format.substring(index + 1);
			if (hooks.containsKey(identifier)) {
				String value = hooks.get(identifier).onPlaceholderRequest(player, params);
				if (value != null) {
					return value;
				}
			}
		}
		return "%" + format + "%"; // ignore this placeholder
	}

}
