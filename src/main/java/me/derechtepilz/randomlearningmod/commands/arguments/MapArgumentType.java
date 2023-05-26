package me.derechtepilz.randomlearningmod.commands.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class MapArgumentType<K, V> implements ArgumentType<MapArgument<K, V>> {

	private final Function<String, K> keyMapper;
	private final Function<String, V> valueMapper;

	private final List<String> keyList;
	private final List<String> valueList;

	private final boolean keyListEmpty;
	private final boolean valueListEmpty;

	private final boolean allowValueDuplicates;

	public MapArgumentType(Function<String, K> keyMapper, Function<String, V> valueMapper, List<String> keyList, List<String> valueList, boolean allowValueDuplicates) {
		this.keyMapper = keyMapper;
		this.valueMapper = valueMapper;

		this.keyList = keyList;
		this.valueList = valueList;

		this.keyListEmpty = keyList.isEmpty();
		this.valueListEmpty = valueList.isEmpty();

		this.allowValueDuplicates = allowValueDuplicates;
	}

	public StringArgumentType onePair() {
		return StringArgumentType.word();
	}

	public StringArgumentType multiplePairs() {
		return StringArgumentType.greedyString();
	}

	public static <S> MapArgument<?, ?> getMapArgument(CommandContext<S> context, String name) {
		return (MapArgument<?, ?>) context.getArgument(name, MapArgument.class);
	}

	@Override
	public MapArgument<K, V> parse(StringReader reader) throws CommandSyntaxException {
		LinkedHashMap<K, V> results = new LinkedHashMap<>();
		while (reader.canRead()) {
			K mapKey = parseKey(reader, results);
			V mapValue = parseValue(reader, results);
			results.put(mapKey, mapValue);
			reader.skipWhitespace();
		}

		return new MapArgument<>(results);
	}

	private K parseKey(StringReader reader, LinkedHashMap<K, V> results) throws CommandSyntaxException {
		StringBuilder builder = new StringBuilder();
		K mapKey = null;
		while (reader.canRead()) { // looks at the character returned by reader.peek()
			if (reader.peek() == ':') {
				if (!reader.canRead(2)) {
					reader.skip();
					throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Quotation mark required after writing the delimiter");
				}
				reader.skip();
				return mapKey;
			} else if (reader.peek() == '"') {
				reader.skip();
				throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "You must separate a key/value pair with a ':'");
			} else {
				builder.append(reader.read());
				if (!reader.canRead()) {
					if (keyList.contains(builder.toString())) {
						throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Delimiter required after writing a key");
					}
					if (!keyListEmpty) {
						throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Invalid key: " + builder);
					}
					throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Delimiter required after writing a key");
				}
				if ((!keyList.contains(builder.toString()) && !keyListEmpty) && reader.peek() == ':') {
					throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Invalid key: " + builder);
				}
				if (reader.peek() == ':') {
					mapKey = tryParseKey(reader, builder.toString());
					if (results.containsKey(mapKey)) {
						throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Duplicate keys are not allowed");
					}
				}
			}
		}
		return null;
	}

	private V parseValue(StringReader reader, LinkedHashMap<K, V> results) throws CommandSyntaxException {
		StringBuilder builder = new StringBuilder();
		try {
			reader.expect('"');
		} catch (CommandSyntaxException e) {
			throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "A value must start with a quotation mark");
		}
		if (!reader.canRead()) {
			throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Value required after opening quotation mark");
		}
		while (reader.canRead()) {
			if (reader.peek() == '\\') {
				// Reached an escape character, skip it and add the next one to the builder
				reader.skip();
				if (reader.peek() == '\\' || reader.peek() == '"') {
					builder.append(reader.read());
				}
			} else if (reader.peek() == '"') {
				if (!valueList.contains(builder.toString()) && !valueListEmpty) {
					throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Invalid value: " + builder);
				}
				V mapValue = tryParseValue(reader, builder.toString());
				if (results.containsValue(mapValue) && !allowValueDuplicates) {
					throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Duplicate values are not allowed here");
				}
				return mapValue;
			} else {
				builder.append(reader.read());
				if (valueList.contains(builder.toString()) && !reader.canRead()) {
					if (builder.length() != 0) {
						throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "A value must end with a quotation mark");
					}
				}
				if ((!valueList.contains(builder.toString()) && !valueListEmpty) && reader.peek() == '"') {
					throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Invalid value: " + builder);
				}
			}
		}
		if (builder.length() > 0) {
			throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "A value must end with a quotation mark");
		}
		return null;
	}

	private K tryParseKey(StringReader reader, String key) throws CommandSyntaxException {
		K mapKey;
		try {
			mapKey = keyMapper.apply(key);
		} catch (Exception e) {
			throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Invalid key (" + key + "): cannot be converted to a key");
		}
		return mapKey;
	}

	private V tryParseValue(StringReader reader, String value) throws CommandSyntaxException {
		V mapValue;
		try {
			mapValue = valueMapper.apply(value);
		} catch (Exception e) {
			throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().createWithContext(reader, "Invalid value (" + value + "): cannot be converted to a value");
		}
		return mapValue;
	}

	@Override
	public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
		return ArgumentType.super.listSuggestions(context, builder);
	}

	@Override
	public Collection<String> getExamples() {
		return ArgumentType.super.getExamples();
	}
}
