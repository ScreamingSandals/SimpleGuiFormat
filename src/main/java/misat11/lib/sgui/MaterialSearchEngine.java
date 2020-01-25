package misat11.lib.sgui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public class MaterialSearchEngine {
	
	public static class Result {
		private Material material;
		private short damage;
		
		public Result(Material material, short damage) {
			this.material = material;
			this.damage = damage;
		}
		
		public Material getMaterial() {
			return material;
		}
		
		public short getDamage() {
			return damage;
		}
		
		public boolean hasDamage() {
			return damage > 0;
		}
	}
	
	/**
	 * From Flattening to Legacy Material name translator
	 */
	public static enum FFTLTranslator {
		ACACIA_BOAT("BOAT_ACACIA"),
		ACACIA_BUTTON("WOOD_BUTTON"),
		ACACIA_DOOR("ACACIA_DOOR_ITEM"),
		ACACIA_LEAVES("LEAVES_2"),
		ACACIA_LOG("LOG_2"),
		ACACIA_PLANKS("WOOD", 4),
		ACACIA_PRESSURE_PLATE("WOOD_PLATE"),
		ACACIA_SAPLING("SAPLING", 4),
		ACACIA_SIGN("SIGN"),
		ACACIA_SLAB("WOOD_STEP", 4),
		ACACIA_TRAPDOOR("TRAP_DOOR"),
		ACACIA_WOOD("LOG_2"),
		ALLIUM("RED_ROSE", 2),
		ANDESITE("STONE", 5),
		ATTACHED_MELON_STEM("MELON_STEM", 7),
		ATTACHED_PUMPKIN_STEM("PUMPKIN_STEM", 7),
		AZURE_BLUET("RED_ROSE", 3),
		BAT_SPAWN_EGG("MONSTER_EGG", 65),
		BEEF("RAW_BEEF"),
		BEETROOT("BEETROOT_BLOCK"),
		BEETROOTS("BEETROOT"),
		BIRCH_BOAT("BOAT_BIRCH"),
		BIRCH_BUTTON("WOOD_BUTTON"),
		BIRCH_DOOR("BIRCH_DOOR_ITEM"),
		BIRCH_LEAVES("LEAVES", 2),
		BIRCH_LOG("LOG", 2),
		BIRCH_PLANKS("WOOD", 2),
		BIRCH_PRESSURE_PLATE("WOOD_PLATE"),
		BIRCH_SAPLING("SAPLING", 2),
		BIRCH_SIGN("SIGN"),
		BIRCH_SLAB("WOOD_STEP", 2),
		BIRCH_STAIRS("BIRCH_WOOD_STAIRS"),
		BIRCH_TRAPDOOR("TRAP_DOOR"),
		BIRCH_WOOD("LOG", 2),
		BLACK_BANNER("BANNER"),
		BLACK_BED("BED", 15),
		BLACK_CARPET("CARPET", 15),
		BLACK_CONCRETE("CONCRETE", 15),
		BLACK_CONCRETE_POWDER("CONCRETE_POWDER", 15),
		BLACK_DYE("INK_SACK"),
		BLACK_STAINED_GLASS("STAINED_GLASS", 15),
		BLACK_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 15),
		BLACK_TERRACOTTA("STAINED_CLAY", 15),
		BLACK_WOOL("WOOL", 15),
		BLAZE_SPAWN_EGG("MONSTER_EGG", 61),
		BLUE_BANNER("BANNER", 11),
		BLUE_BED("BED", 4),
		BLUE_CARPET("CARPET", 11),
		BLUE_CONCRETE("CONCRETE", 11),
		BLUE_CONCRETE_POWDER("CONCRETE_POWDER", 11),
		BLUE_DYE("INK_SACK", 4),
		BLUE_ORCHID("RED_ROSE", 1),
		BLUE_STAINED_GLASS("STAINED_GLASS", 11),
		BLUE_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 11),
		BLUE_TERRACOTTA("STAINED_CLAY", 11),
		BLUE_WOOL("WOOL", 11),
		BONE_MEAL("INK_SACK", 15),
		BREWING_STAND("BREWING_STAND_ITEM"),
		BRICK("CLAY_BRICK"),
		BRICKS("BRICK"),
		BRICK_SLAB("STEP", 4),
		BROWN_BANNER("BANNER", 3),
		BROWN_BED("BED", 12),
		BROWN_DYE("INK_SACK", 3),
		BROWN_CARPET("CARPET", 12),
		BROWN_CONCRETE("CONCRETE", 12),
		BROWN_CONCRETE_POWDER("CONCRETE_POWDER", 12),
		BROWN_MUSHROOM_BLOCK("HUGE_MUSHROOM_1"),
		BROWN_STAINED_GLASS("STAINED_GLASS", 12),
		BROWN_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 12),
		BROWN_TERRACOTTA("STAINED_CLAY", 12),
		BROWN_WOOL("WOOL", 12),
		CAKE("CAKE_BLOCK"),
		CARROT("CARROT_ITEM"),
		CARROTS("CARROT"),
		CARROT_ON_A_STICK("CARROT_STICK"),
		CARVED_PUMPKIN("PUMPKIN"),
		CAULDRON("CAULDRON_ITEM"),
		CAVE_AIR("AIR"),
		CAVE_SPIDER_SPAWN_EGG("MONSTER_EGG", 59),
		CHAIN_COMMAND_BLOCK("COMMAND_CHAIN"),
		CHARCOAL("COAL", 1),
		CHEST("LOCKED_CHEST"),
		CHEST_MINECART("STORAGE_MINECART"),
		CHICKEN("RAW_CHICKEN"),
		CHICKEN_SPAWN_EGG("MONSTER_EGG", 93),
		CHIPPED_ANVIL("ANVIL", 1),
		CHISELED_QUARTZ_BLOCK("QUARTZ_BLOCK", 1),
		CHISELED_RED_SANDSTONE("RED_SANDSTONE", 1),
		CHISELED_SANDSTONE("SANDSTONE", 1),
		CHISELED_STONE_BRICKS("SMOOTH_BRICK", 3),
		CLOCK("WATCH"),
		COARSE_DIRT("DIRT", 1),
		COBBLESTONE_SLAB("STEP", 3),
		COBWEB("WEB"),
		COCOA_BEANS("INK_SACK", 3),
		COD("RAW_FISH"),
		COMMAND_BLOCK("COMMAND"),
		COMMAND_BLOCK_MINECART("COMMAND_MINECART"),
		COMPARATOR("REDSTONE_COMPARATOR"),
		COOKED_COD("COOKED_FISH"),
		COOKED_PORKCHOP("GRILLED_PORK"),
		COOKED_SALMON("COOKED_FISH", 1),
		COW_SPAWN_EGG("MONSTER_EGG", 92),
		CRACKED_STONE_BRICKS("SMOOTH_BRICK", 2),
		CRAFTING_TABLE("WORKBENCH"),
		CREEPER_HEAD("SKULL_ITEM", 4),
		CREEPER_SPAWN_EGG("MONSTER_EGG", 50),
		CUT_RED_SANDSTONE_SLAB("STONE_SLAB2"),
		CUT_SANDSTONE("SANDSTONE", 2),
		CUT_SANDSTONE_SLAB("STEP"),
		CYAN_BANNER("BANNER", 6),
		CYAN_BED("BED", 9),
		CYAN_CARPET("CARPET", 9),
		CYAN_CONCRETE("CONCRETE", 9),
		CYAN_CONCRETE_POWDER("CONCRETE_POWDER", 9),
		CYAN_DYE("INK_SACK", 6),
		CYAN_STAINED_GLASS("STAINED_GLASS", 9),
		CYAN_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 9),
		CYAN_TERRACOTTA("STAINED_CLAY", 9),
		CYAN_WOOL("WOOL", 9),
		DAMAGED_ANVIL("ANVIL", 2),
		DANDELION("YELLOW_FLOWER"),
		DARK_OAK_BOAT("BOAT_DARK_OAK"),
		DARK_OAK_BUTTON("WOOD_BUTTON"),
		DARK_OAK_DOOR("DARK_OAK_DOOR_ITEM"),
		DARK_OAK_LEAVES("LEAVES_2", 1),
		DARK_OAK_LOG("LOG_2", 1),
		DARK_OAK_PLANKS("WOOD", 5),
		DARK_OAK_PRESSURE_PLATE("WOOD_PLATE"),
		DARK_OAK_SAPLING("SAPLING", 5),
		DARK_OAK_SIGN("SIGN"),
		DARK_OAK_SLAB("WOOD_STEP"),
		DARK_OAK_TRAPDOOR("TRAP_DOOR"),
		DARK_OAK_WOOD("LOG_2", 1),
		DARK_PRISMARINE("PRISMARINE", 1),
		DAYLIGHT_DETECTOR("DAYLIGHT_DETECTOR_INVERTED"),
		DIAMOND_HORSE_ARMOR("DIAMOND_BARDING"),
		DIAMOND_SHOVEL("DIAMOND_SPADE"),
		DIORITE("STONE", 3),
		DONKEY_SPAWN_EGG("MONSTER_EGG", 32),
		DRAGON_BREATH("DRAGONS_BREATH"),
		DRAGON_HEAD("SKULL_ITEM", 5),
		ELDER_GUARDIAN_SPAWN_EGG("MONSTER_EGG", 4),
		ENCHANTED_GOLDEN_APPLE("GOLDEN_APPLE", 1),
		ENCHANTING_TABLE("ENCHANTMENT_TABLE"),
		ENDERMAN_SPAWN_EGG("MONSTER_EGG", 58),
		ENDERMITE_SPAWN_EGG("MONSTER_EGG", 67),
		ENDER_EYE("EYE_OF_ENDER"),
		END_PORTAL("ENDER_PORTAL"),
		END_PORTAL_FRAME("ENDER_PORTAL_FRAME"),
		END_STONE("ENDER_STONE"),
		END_STONE_BRICKS("END_BRICKS"),
		END_STONE_BRICK_SLAB("STEP", 4),
		END_STONE_BRICK_STAIRS("SMOOTH_STAIRS"),
		EVOKER_SPAWN_EGG("MONSTER_EGG", 34),
		EXPERIENCE_BOTTLE("EXP_BOTTLE"),
		FARMLAND("SOIL"),
		FERN("LONG_GRASS", 2),
		FILLED_MAP("MAP"),
		FIREWORK_ROCKET("FIREWORK"),
		FIREWORK_STAR("FIREWORK_CHARGE"),
		FIRE_CHARGE("FIREBALL"),
		FLOWER_POT("FLOWER_POT_ITEM"),
		FURNACE("BURNING_FURNACE"),
		FURNACE_MINECART("POWERED_MINECART"),
		GHAST_SPAWN_EGG("MONSTER_EGG", 56),
		GLASS_PANE("THIN_GLASS"),
		GLISTERING_MELON_SLICE("SPECKLED_MELON"),
		GOLDEN_AXE("GOLD_AXE"),
		GOLDEN_BOOTS("GOLD_BOOTS"),
		GOLDEN_CHESTPLATE("GOLD_CHESTPLATE"),
		GOLDEN_HELMET("GOLD_HELMET"),
		GOLDEN_HOE("GOLD_HOE"),
		GOLDEN_HORSE_ARMOR("GOLD_BARDING"),
		GOLDEN_LEGGINGS("GOLD_LEGGINGS"),
		GOLDEN_PICKAXE("GOLD_PICKAXE"),
		GOLDEN_SHOVEL("GOLD_SPADE"),
		GOLDEN_SWORD("GOLD_SWORD"),
		GRANITE("STONE", 1),
		GRASS_BLOCK("GRASS"),
		GRAY_BANNER("BANNER", 8),
		GRAY_BED("BED", 7),
		GRAY_CARPET("CARPET", 7),
		GRAY_CONCRETE("CONCRETE", 7),
		GRAY_CONCRETE_POWDER("CONCRETE_POWDER", 7),
		GRAY_DYE("INK_SACK", 8),
		GRAY_STAINED_GLASS("STAINED_GLASS", 8),
		GRAY_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 7),
		GRAY_TERRACOTTA("STAINED_CLAY", 7),
		GRAY_WOOL("WOOL", 8),
		GREEN_BANNER("BANNER", 2),
		GREEN_BED("BED", 13),
		GREEN_CARPET("CARPET", 13),
		GREEN_CONCRETE("CONCRETE", 13),
		GREEN_CONCRETE_POWDER("CONCRETE_POWDER", 13),
		GREEN_DYE("INK_SACK", 2),
		GREEN_STAINED_GLASS("STAINED_GLASS", 13),
		GREEN_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 13),
		GREEN_TERRACOTTA("STAINED_CLAY", 13),
		GREEN_WOOL("WOOL", 13),
		GUARDIAN_SPAWN_EGG("MONSTER_EGG", 68),
		GUNPOWDER("SULPHUR"),
		HEAVY_WEIGHTED_PRESSURE_PLATE("IRON_PLATE"),
		HORSE_SPAWN_EGG("MONSTER_EGG", 100),
		HUSK_SPAWN_EGG("MONSTER_EGG", 23),
		INFESTED_CHISELED_STONE_BRICKS("MONSTER_EGGS", 5),
		INFESTED_COBBLESTONE("MONSTER_EGGS", 1),
		INFESTED_CRACKED_STONE_BRICKS("MONSTER_EGGS", 4),
		INFESTED_MOSSY_STONE_BRICKS("MONSTER_EGGS", 3),
		INFESTED_STONE("MONSTER_EGGS"),
		INFESTED_STONE_BRICKS("MONSTER_EGGS", 2),
		INK_SAC("INK_SACK"),
		IRON_BARS("IRON_FENCE"),
		IRON_DOOR("IRON_DOOR_BLOCK"),
		IRON_HORSE_ARMOR("IRON_BARDING"),
		IRON_SHOVEL("IRON_SPADE"),
		JUNGLE_BOAT("BOAT_JUNGLE"),
		JUNGLE_BUTTON("WOOD_BUTTON"),
		JUNGLE_DOOR("JUNGLE_DOOR_ITEM"),
		JUNGLE_LEAVES("LEAVES", 3),
		JUNGLE_LOG("LOG", 3),
		JUNGLE_PLANKS("WOOD", 3),
		JUNGLE_PRESSURE_PLATE("WOOD_PLATE"),
		JUNGLE_SAPLING("SAPLING", 3),
		JUNGLE_SIGN("SIGN"),
		JUNGLE_SLAB("WOOD_STEP", 3),
		JUNGLE_STAIRS("JUNGLE_WOOD_STAIRS"),
		JUNGLE_TRAPDOOR("TRAP_DOOR"),
		JUNGLE_WOOD("LOG", 3),
		LAPIS_LAZULI("INK_SACK", 4),
		LARGE_FERN("DOUBLE_PLANT", 3),
		LAVA("STATIONARY_LAVA"),
		LEAD("LEASH"),
		LIGHT_BLUE_BANNER("BANNER", 11),
		LIGHT_BLUE_BED("BED", 3),
		LIGHT_BLUE_CARPET("CARPET", 3),
		LIGHT_BLUE_CONCRETE("CONCRETE", 3),
		LIGHT_BLUE_CONCRETE_POWDER("CONCRETE_POWDER", 3),
		LIGHT_BLUE_DYE("INK_SACK", 12),
		LIGHT_BLUE_STAINED_GLASS("STAINED_GLASS", 11),
		LIGHT_BLUE_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 3),
		LIGHT_BLUE_TERRACOTTA("STAINED_CLAY", 3),
		LIGHT_BLUE_WOOL("WOOL", 11),
		LIGHT_GRAY_BANNER("BANNER", 7),
		LIGHT_GRAY_BED("BED", 7),
		LIGHT_GRAY_CARPET("CARPET", 8),
		LIGHT_GRAY_CONCRETE("CONCRETE", 8),
		LIGHT_GRAY_CONCRETE_POWDER("CONCRETE_POWDER", 8),
		LIGHT_GRAY_DYE("INK_SACK", 7),
		LIGHT_GRAY_GLAZED_TERRACOTTA("SILVER_GLAZED_TERRACOTTA", 8),
		LIGHT_GRAY_SHULKER_BOX("SILVER_SHULKER_BOX"),
		LIGHT_GRAY_STAINED_GLASS("STAINED_GLASS", 8),
		LIGHT_GRAY_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 8),
		LIGHT_GRAY_TERRACOTTA("STAINED_CLAY", 8),
		LIGHT_GRAY_WOOL("WOOL", 8),
		LIGHT_WEIGHTED_PRESSURE_PLATE("GOLD_PLATE"),
		LILAC("DOUBLE_PLANT", 1),
		LILY_PAD("WATER_LILY"),
		LIME_BANNER("BANNER", 10),
		LIME_BED("BED", 5),
		LIME_CARPET("CARPET", 5),
		LIME_CONCRETE("CONCRETE", 5),
		LIME_CONCRETE_POWDER("CONCRETE_POWDER", 5),
		LIME_DYE("INK_SACK", 10),
		LIME_STAINED_GLASS("STAINED_GLASS", 5),
		LIME_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 5),
		LIME_TERRACOTTA("STAINED_CLAY", 5),
		LIME_WOOL("WOOL", 5),
		LLAMA_SPAWN_EGG("MONSTER_EGG", 103),
		MAGENTA_BANNER("BANNER", 13),
		MAGENTA_BED("BED", 2),
		MAGENTA_CARPET("CARPET", 2),
		MAGENTA_CONCRETE("CONCRETE", 2),
		MAGENTA_CONCRETE_POWDER("CONCRETE_POWDER", 2),
		MAGENTA_DYE("INK_SACK", 13),
		MAGENTA_STAINED_GLASS("STAINED_GLASS", 2),
		MAGENTA_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 2),
		MAGENTA_TERRACOTTA("STAINED_CLAY", 2),
		MAGENTA_WOOL("WOOL", 2),
		MAGMA_BLOCK("MAGMA"),
		MAGMA_CUBE_SPAWN_EGG("MONSTER_EGG", 62),
		MAP("EMPTY_MAP"),
		MELON("MELON_BLOCK"),
		MELON_SLICE("MELON"),
		MOOSHROOM_SPAWN_EGG("MONSTER_EGG", 96),
		MOSSY_COBBLESTONE_SLAB("STEP", 3),
		MOSSY_STONE_BRICKS("SMOOTH_BRICK", 1),
		MOSSY_STONE_BRICK_SLAB("STEP", 4),
		MOSSY_STONE_BRICK_STAIRS("SMOOTH_STAIRS"),
		MULE_SPAWN_EGG("MONSTER_EGG", 32),
		MUSHROOM_STEM("BROWN_MUSHROOM"),
		MUSHROOM_STEW("MUSHROOM_SOUP"),
		MUSIC_DISC_11("GOLD_RECORD"),
		MUSIC_DISC_13("GREEN_RECORD"),
		MUSIC_DISC_BLOCKS("RECORD_3"),
		MUSIC_DISC_CAT("RECORD_4"),
		MUSIC_DISC_CHIRP("RECORD_5"),
		MUSIC_DISC_FAR("RECORD_6"),
		MUSIC_DISC_MALL("RECORD_7"),
		MUSIC_DISC_MELLOHI("RECORD_8"),
		MUSIC_DISC_STAL("RECORD_9"),
		MUSIC_DISC_STRAD("RECORD_10"),
		MUSIC_DISC_WAIT("RECORD_11"),
		MUSIC_DISC_WARD("RECORD_12"),
		MYCELIUM("MYCEL"),
		NETHER_BRICK("NETHER_BRICK_ITEM"),
		NETHER_BRICKS("NETHER_BRICK"),
		NETHER_BRICK_FENCE("NETHER_FENCE"),
		NETHER_BRICK_SLAB("STEP", 4),
		NETHER_PORTAL("PORTAL"),
		NETHER_QUARTZ_ORE("QUARTZ_ORE"),
		NETHER_WART("NETHER_STALK"),
		NETHER_WART_BLOCK("NETHER_WARTS"),
		OAK_BOAT("BOAT"),
		OAK_BUTTON("WOOD_BUTTON"),
		OAK_DOOR("WOODEN_DOOR"),
		OAK_FENCE("FENCE"),
		OAK_FENCE_GATE("FENCE_GATE"),
		OAK_LEAVES("LEAVES"),
		OAK_LOG("LOG"),
		OAK_PLANKS("WOOD"),
		OAK_PRESSURE_PLATE("WOOD_PLATE"),
		OAK_SAPLING("SAPLING"),
		OAK_SIGN("SIGN"),
		OAK_SLAB("WOOD_STEP"),
		OAK_STAIRS("WOOD_STAIRS"),
		OAK_TRAPDOOR("TRAP_DOOR"),
		OAK_WOOD("LOG"),
		OCELOT_SPAWN_EGG("MONSTER_EGG", 98),
		ORANGE_BANNER("BANNER", 14),
		ORANGE_BED("BED", 1),
		ORANGE_CARPET("CARPET", 1),
		ORANGE_CONCRETE("CONCRETE", 1),
		ORANGE_CONCRETE_POWDER("CONCRETE_POWDER", 1),
		ORANGE_DYE("INK_SACK", 14),
		ORANGE_STAINED_GLASS("STAINED_GLASS", 1),
		ORANGE_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 1),
		ORANGE_TERRACOTTA("STAINED_CLAY", 1),
		ORANGE_TULIP("RED_ROSE", 5),
		ORANGE_WOOL("WOOL", 1),
		OXEYE_DAISY("RED_ROSE", 8),
		PARROT_SPAWN_EGG("MONSTER_EGG", 105),
		PEONY("DOUBLE_PLANT", 5),
		PETRIFIED_OAK_SLAB("WOOD_STEP"),
		PIG_SPAWN_EGG("MONSTER_EGG", 90),
		PINK_BANNER("BANNER", 9),
		PINK_BED("BED", 6),
		PINK_CARPET("CARPET", 6),
		PINK_CONCRETE("CONCRETE", 6),
		PINK_CONCRETE_POWDER("CONCRETE_POWDER", 6),
		PINK_DYE("INK_SACK", 9),
		PINK_STAINED_GLASS("STAINED_GLASS", 6),
		PINK_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 6),
		PINK_TERRACOTTA("STAINED_CLAY", 6),
		PINK_TULIP("RED_ROSE", 7),
		PINK_WOOL("WOOL", 6),
		PISTON("PISTON_BASE"),
		PISTON_HEAD("PISTON_EXTENSION"),
		PLAYER_HEAD("SKULL_ITEM", 3),
		PODZOL("DIRT", 2),
		POLAR_BEAR_SPAWN_EGG("MONSTER_EGG", 102),
		POLISHED_ANDESITE("STONE", 6),
		POLISHED_DIORITE("STONE", 4),
		POLISHED_GRANITE("STONE", 2),
		POPPED_CHORUS_FRUIT("CHORUS_FRUIT_POPPED"),
		POPPY("RED_ROSE"),
		PORKCHOP("PORK"),
		POTATO("POTATO_ITEM"),
		POTATOES("POTATO"),
		PRISMARINE_BRICKS("PRISMARINE", 2),
		PRISMARINE_BRICK_SLAB("STEP", 4),
		PUFFERFISH("RAW_FISH", 3),
		PURPLE_BANNER("BANNER", 5),
		PURPLE_BED("BED", 10),
		PURPLE_CARPET("CARPET", 10),
		PURPLE_CONCRETE("CONCRETE", 10),
		PURPLE_CONCRETE_POWDER("CONCRETE_POWDER", 10),
		PURPLE_DYE("INK_SACK", 5),
		PURPLE_STAINED_GLASS("STAINED_GLASS", 10),
		PURPLE_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 10),
		PURPLE_TERRACOTTA("STAINED_CLAY", 10),
		PURPLE_WOOL("WOOL", 10),
		PURPUR_SLAB("PURPUR_DOUBLE_SLAB"),
		QUARTZ_PILLAR("QUARTZ_BLOCK", 2),
		QUARTZ_SLAB("STEP", 7),
		RABBIT_SPAWN_EGG("MONSTER_EGG", 101),
		RAIL("RAILS"),
		REDSTONE_LAMP("REDSTONE_LAMP_OFF"),
		REDSTONE_ORE("GLOWING_REDSTONE_ORE"),
		REDSTONE_TORCH("REDSTONE_TORCH_OFF"),
		RED_BANNER("BANNER", 1),
		RED_BED("BED", 14),
		RED_CARPET("CARPET", 14),
		RED_CONCRETE("CONCRETE", 14),
		RED_CONCRETE_POWDER("CONCRETE_POWDER", 14),
		RED_DYE("ROSE_RED", 1),
		RED_MUSHROOM_BLOCK("HUGE_MUSHROOM_2"),
		RED_NETHER_BRICKS("RED_NETHER_BRICK"),
		RED_NETHER_BRICK_SLAB("STEP", 4),
		RED_SAND("SAND", 1),
		RED_SANDSTONE_SLAB("STONE_SLAB2"),
		RED_STAINED_GLASS("STAINED_GLASS", 14),
		RED_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 14),
		RED_TERRACOTTA("STAINED_CLAY", 14),
		RED_TULIP("RED_ROSE", 4),
		RED_WOOL("WOOL", 14),
		REPEATER("DIODE"),
		REPEATING_COMMAND_BLOCK("COMMAND_REPEATING"),
		ROSE_BUSH("DOUBLE_PLANT", 4),
		SALMON("RAW_FISH", 1),
		SANDSTONE_SLAB("STEP", 1),
		SHEEP_SPAWN_EGG("MONSTER_EGG", 91),
		SHULKER_BOX("PURPLE_SHULKER_BOX"),
		SHULKER_SPAWN_EGG("MONSTER_EGG", 69),
		SILVERFISH_SPAWN_EGG("MONSTER_EGG", 60),
		SKELETON_HORSE_SPAWN_EGG("MONSTER_EGG", 28),
		SKELETON_SKULL("SKULL_ITEM"),
		SKELETON_SPAWN_EGG("MONSTER_EGG", 51),
		SLIME_SPAWN_EGG("MONSTER_EGG", 55),
		SMOOTH_QUARTZ_SLAB("STEP", 7),
		SMOOTH_RED_SANDSTONE("RED_SANDSTONE", 2),
		SMOOTH_RED_SANDSTONE_SLAB("STONE_SLAB2"),
		SMOOTH_SANDSTONE("SANDSTONE", 2),
		SMOOTH_SANDSTONE_SLAB("STEP"),
		SMOOTH_STONE("STEP"),
		SMOOTH_STONE_SLAB("STEP"),
		SNOWBALL("SNOW_BALL"),
		SPAWNER("MOB_SPAWNER"),
		SPIDER_SPAWN_EGG("MONSTER_EGG", 52),
		SPRUCE_BOAT("BOAT_SPRUCE"),
		SPRUCE_BUTTON("WOOD_BUTTON"),
		SPRUCE_DOOR("SPRUCE_DOOR_ITEM"),
		SPRUCE_LEAVES("LEAVES", 1),
		SPRUCE_LOG("LOG", 1),
		SPRUCE_PLANKS("WOOD", 1),
		SPRUCE_PRESSURE_PLATE("WOOD_PLATE"),
		SPRUCE_SAPLING("SAPLING", 1),
		SPRUCE_SIGN("SIGN"),
		SPRUCE_SLAB("WOOD_STEP", 1),
		SPRUCE_STAIRS("SPRUCE_WOOD_STAIRS"),
		SPRUCE_TRAPDOOR("TRAP_DOOR"),
		SPRUCE_WOOD("LOG", 1),
		SQUID_SPAWN_EGG("MONSTER_EGG", 94),
		STICKY_PISTON("PISTON_STICKY_BASE"),
		STONE_BRICKS("SMOOTH_BRICK"),
		STONE_BRICK_SLAB("STEP", 4),
		STONE_BRICK_STAIRS("SMOOTH_STAIRS"),
		STONE_PRESSURE_PLATE("STONE_PLATE"),
		STONE_SHOVEL("STONE_SPADE"),
		STONE_SLAB("STEP"),
		STRAY_SPAWN_EGG("MONSTER_EGG", 6),
		STRIPPED_ACACIA_LOG("LOG_2"),
		STRIPPED_ACACIA_WOOD("LOG_2"),
		STRIPPED_BIRCH_LOG("LOG", 2),
		STRIPPED_BIRCH_WOOD("LOG", 2),
		STRIPPED_DARK_OAK_LOG("LOG"),
		STRIPPED_DARK_OAK_WOOD("LOG"),
		STRIPPED_JUNGLE_LOG("LOG", 3),
		STRIPPED_JUNGLE_WOOD("LOG", 3),
		STRIPPED_OAK_LOG("LOG"),
		STRIPPED_OAK_WOOD("LOG"),
		STRIPPED_SPRUCE_LOG("LOG", 1),
		STRIPPED_SPRUCE_WOOD("LOG", 1),
		SUGAR_CANE("SUGAR_CANE_BLOCK"),
		SUNFLOWER("DOUBLE_PLANT"),
		TALL_GRASS("DOUBLE_PLANT", 2),
		TERRACOTTA("HARD_CLAY"),
		TNT_MINECART("EXPLOSIVE_MINECART"),
		TOTEM_OF_UNDYING("TOTEM"),
		TROPICAL_FISH("RAW_FISH", 2),
		VEX_SPAWN_EGG("MONSTER_EGG", 35),
		VILLAGER_SPAWN_EGG("MONSTER_EGG", 120),
		VINDICATOR_SPAWN_EGG("MONSTER_EGG", 36),
		VOID_AIR("AIR"),
		WATER("STATIONARY_WATER"),
		WET_SPONGE("SPONGE", 1),
		WHEAT("CROPS"),
		WHEAT_SEEDS("SEEDS"),
		WHITE_BANNER("BANNER", 15),
		WHITE_BED("BED"),
		WHITE_CARPET("CARPET"),
		WHITE_CONCRETE("CONCRETE"),
		WHITE_CONCRETE_POWDER("CONCRETE_POWDER"),
		WHITE_DYE("INK_SACK", 15),
		WHITE_STAINED_GLASS("STAINED_GLASS"),
		WHITE_STAINED_GLASS_PANE("STAINED_GLASS_PANE"),
		WHITE_TERRACOTTA("STAINED_CLAY"),
		WHITE_TULIP("RED_ROSE", 6),
		WHITE_WOOL("WOOL"),
		WITCH_SPAWN_EGG("MONSTER_EGG", 66),
		WITHER_SKELETON_SKULL("SKULL_ITEM", 1),
		WITHER_SKELETON_SPAWN_EGG("MONSTER_EGG", 5),
		WOLF_SPAWN_EGG("MONSTER_EGG", 95),
		WOODEN_AXE("WOOD_AXE"),
		WOODEN_HOE("WOOD_HOE"),
		WOODEN_PICKAXE("WOOD_PICKAXE"),
		WOODEN_SHOVEL("WOOD_SPADE"),
		WOODEN_SWORD("WOOD_SWORD"),
		WRITABLE_BOOK("BOOK_AND_QUILL"),
		YELLOW_BANNER("BANNER", 11),
		YELLOW_BED("BED", 4),
		YELLOW_CARPET("CARPET", 4),
		YELLOW_CONCRETE("CONCRETE", 4),
		YELLOW_CONCRETE_POWDER("CONCRETE_POWDER", 4),
		YELLOW_DYE("INK_SACK", 11),
		YELLOW_STAINED_GLASS("STAINED_GLASS", 4),
		YELLOW_STAINED_GLASS_PANE("STAINED_GLASS_PANE", 4),
		YELLOW_TERRACOTTA("STAINED_CLAY", 4),
		YELLOW_WOOL("WOOL", 4),
		ZOMBIE_HEAD("SKULL_ITEM", 2),
		ZOMBIE_HORSE_SPAWN_EGG("MONSTER_EGG", 29),
		ZOMBIE_PIGMAN_SPAWN_EGG("MONSTER_EGG", 57),
		ZOMBIE_SPAWN_EGG("MONSTER_EGG", 54),
		ZOMBIE_VILLAGER_SPAWN_EGG("MONSTER_EGG", 27),
		
		// Material names from 1.13
		CACTUS_GREEN("INK_SACK", 2),
		DANDELION_YELLOW("INK_SACK", 11),
		ROSE_RED("INK_SACK", 1);
		
		private String translate;
		private short damage;
		
		private FFTLTranslator(String translate) {
			this(translate, (short) 0);
		}
		
		private FFTLTranslator(String translate, int damage) {
			this.translate = translate;
			this.damage = (short) damage;
		}
		
	}
	
	// ATV = Aquatic to Village
	public static enum ATVTranslate {
		CACTUS_GREEN("GREEN_DYE"),
		DANDELION_YELLOW("YELLOW_DYE"),
		ROSE_RED("RED_DYE");
		
		private String translate;
		
		private ATVTranslate(String translate) {
			this.translate = translate;
		}
	}
	
	// VTA = Village to Aquatic
	public static enum VTATranslate {
		GREEN_DYE("CACTUS_GREEN"),
		YELLOW_DYE("DANDELION_YELLOW"),
		RED_DYE("ROSE_RED");
		
		private String translate;
		
		private VTATranslate(String translate) {
			this.translate = translate;
		}
	}
	
	private static int versionNumber;
	private static boolean isLegacy;
	
	static {
        String[] bukkitVersion = Bukkit.getBukkitVersion().split("-")[0].split("\\.");
        versionNumber = 0;
        for (int i = 0; i < 2; i++) {
            versionNumber += Integer.parseInt(bukkitVersion[i]) * (i == 0 ? 100 : 1);
        }

        isLegacy = versionNumber < 113;
	}
	
	public static Result find(String materialArgument) {
		String[] splitByColon = materialArgument.split(":");
		String materialString = splitByColon[0];
		short damageShort = 0;
		if (splitByColon.length > 1) {
			String damageString = splitByColon[1];
			try {
				damageShort = (short) Integer.parseInt(damageString);
			} catch (Throwable t) {
			}
		}
		return Attemptor.start().attempt((material, damage) -> {
			Material mat = Material.matchMaterial(material);
			return new Result(mat, damage);
		}).attempt(isLegacy, (material, damage) -> {
			FFTLTranslator translate = FFTLTranslator.valueOf(material.toUpperCase());
			Material mat = Material.matchMaterial(translate.translate);
			return new Result(mat, translate.damage);
		}).attempt(versionNumber > 113, (material, damage) -> {
			ATVTranslate translate = ATVTranslate.valueOf(material.toUpperCase());
			Material mat = Material.matchMaterial(translate.translate);
			return new Result(mat, damage);
		}).attempt(versionNumber == 113, (material, damage) -> {
			VTATranslate translate = VTATranslate.valueOf(material.toUpperCase());
			Material mat = Material.matchMaterial(translate.translate);
			return new Result(mat, damage);
		}).attempt(!isLegacy, (material, damage) -> {
			Material mat = Material.matchMaterial(material, true);
			return new Result(mat, damage);
		}).attempt((material, damage) -> {
			int legacyId = Integer.parseInt(material);
			
			for (Material mater : Material.values()) {
				try {
					if (mater.getId() == legacyId) {
						return new Result(mater, damage);
					}
				} catch (Throwable t) {
					// This material is not legacy
				}
			}
			return null;
		}).end(materialString, damageShort);
	}
	
	private static class Attemptor {
		private List<Attempt> attempts = new ArrayList<>();
		
		public static Attemptor start() {
			return new Attemptor();
		}
		
		public Attemptor attempt(Attempt attempt) {
			attempts.add(attempt);
			return this;
		} 

		public Attemptor attempt(boolean condition, Attempt attempt) {
			if (condition) {
				attempts.add(attempt);
			}
			return this;
		} 
		
		public Result end(String material, short damage) {
			for (Attempt attempt : attempts) {
				try {
					Result result = attempt.attempt(material, damage);
					if (result != null && result.material != null) {
						return result; 
					}
				} catch (Throwable t) {
				}
			}
			
			Bukkit.getLogger().warning("[SimpleGuiFormat] Cannot find material for " + material + ":" + damage + "! Your configuration is invalid!");
			return new Result(Material.AIR, (short) 0);
		}
	}
	
	private static interface Attempt {
		public Result attempt(String material, short damage) throws Throwable;
	}
}
