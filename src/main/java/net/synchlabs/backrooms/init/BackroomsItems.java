package net.synchlabs.backrooms.init;

import java.util.LinkedHashMap;
import java.util.Map;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.synchlabs.backrooms.Backrooms;
import net.synchlabs.backrooms.items.WallpaperPatternItem;
import net.synchlabs.backrooms.util.WallpaperType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BackroomsItems {

	private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

	public static final Item PATTERNED_PATTERN = add("patterned_pattern", new WallpaperPatternItem(BackroomsLoomPatterns.ARROWED, WallpaperType.ARROWED, new FabricItemSettings().group(ItemGroup.MISC)));
	public static final Item STRIPED_PATTERN = add("striped_pattern", new WallpaperPatternItem(BackroomsLoomPatterns.LINED, WallpaperType.LINED, new FabricItemSettings().group(ItemGroup.MISC)));
	public static final Item DOTTED_PATTERN = add("dotted_pattern", new WallpaperPatternItem(BackroomsLoomPatterns.DOTTED, WallpaperType.DOTTED, new FabricItemSettings().group(ItemGroup.MISC)));
	public static final Item BLANK_PATTERN = add("blank_pattern", new WallpaperPatternItem(BackroomsLoomPatterns.BLANK, WallpaperType.BLANK, new FabricItemSettings().group(ItemGroup.MISC)));

	private static <I extends Item> I add(String name, I item) {
		ITEMS.put(Backrooms.id(name), item);
		return item;
	}

	public static void init() {
		for (Identifier id : ITEMS.keySet()) {
			Registry.register(Registry.ITEM, id, ITEMS.get(id));
		}
	}
}
