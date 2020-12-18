package org.screamingsandals.simpleinventories.bukkit.material.meta;

import org.bukkit.enchantments.Enchantment;
import org.screamingsandals.simpleinventories.material.meta.EnchantmentHolder;
import org.screamingsandals.simpleinventories.material.meta.EnchantmentMapping;

import java.util.Arrays;

public class BukkitEnchantmentMapping extends EnchantmentMapping {

    public static void init() {
        EnchantmentMapping.init(BukkitEnchantmentMapping::new);
    }

    public BukkitEnchantmentMapping() {
        resultConverter
                .register(Enchantment.class, e -> Enchantment.getByName(e.getPlatformName()));

        argumentConverter
                .register(Enchantment.class, e -> new EnchantmentHolder(e.getName()));

        Arrays.stream(Enchantment.values()).forEach(enchantment -> enchantmentMapping.put(enchantment.getName().toUpperCase(), new EnchantmentHolder(enchantment.getName())));
    }

}
