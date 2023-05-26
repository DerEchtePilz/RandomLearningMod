package me.derechtepilz.randomlearningmod.commands.arguments;

import java.util.LinkedHashMap;

public class MapArgument<K, V> {

	private final LinkedHashMap<K, V> results;

	public MapArgument(LinkedHashMap<K, V> results) {
		this.results = results;
	}

	public LinkedHashMap<K, V> getResults() {
		return results;
	}
}
