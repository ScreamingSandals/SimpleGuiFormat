package org.screamingsandals.simpleinventories.bukkit.material.meta;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.screamingsandals.simpleinventories.material.meta.PotionHolder;
import org.screamingsandals.simpleinventories.material.meta.PotionMapping;

import java.util.Arrays;

public class BukkitPotionMapping extends PotionMapping {

    @Getter
    private int versionNumber;

    public static void init() {
        PotionMapping.init(BukkitPotionMapping::new);
    }

    public BukkitPotionMapping() {
        String[] bukkitVersion = Bukkit.getBukkitVersion().split("-")[0].split("\\.");
        versionNumber = 0;

        for (int i = 0; i < 2; i++) {
            versionNumber += Integer.parseInt(bukkitVersion[i]) * (i == 0 ? 100 : 1);
        }

        resultConverter
                .register(PotionType.class, e -> {
                    if (e.getPlatformName().toUpperCase().startsWith("LONG_")) {
                        return PotionType.valueOf(e.getPlatformName().substring(5).toUpperCase());
                    } else if (e.getPlatformName().toUpperCase().startsWith("STRONG_")) {
                        return PotionType.valueOf(e.getPlatformName().substring(7).toUpperCase());
                    } else {
                        return PotionType.valueOf(e.getPlatformName().toUpperCase());
                    }
                })
                .register(PotionData.class, e -> {
                    if (e.getPlatformName().toUpperCase().startsWith("LONG_")) {
                        return new PotionData(PotionType.valueOf(e.getPlatformName().substring(5)), true, false);
                    } else if (e.getPlatformName().toUpperCase().startsWith("STRONG_")) {
                        return new PotionData(PotionType.valueOf(e.getPlatformName().substring(7)), false, true);
                    } else {
                        return new PotionData(PotionType.valueOf(e.getPlatformName()));
                    }
                });

        argumentConverter
                .register(PotionType.class, potion -> new PotionHolder(potion.name()))
                .register(PotionData.class, data -> {
                    if (data.isExtended()) {
                        return new PotionHolder("LONG_" + data.getType().name());
                    } else if (data.isUpgraded()) {
                        return new PotionHolder("STRONG_" + data.getType().name());
                    } else {
                        return new PotionHolder(data.getType().name());
                    }
                });

        Arrays.stream(PotionType.values()).forEach(potion -> {
            potionMapping.put(potion.name().toUpperCase(), new PotionHolder(potion.name()));
            if (potion.isExtendable()) {
                potionMapping.put("LONG_" + potion.name().toUpperCase(), new PotionHolder("LONG_" + potion.name()));
            }
            if (potion.isUpgradeable()) {
                potionMapping.put("STRONG_" + potion.name().toUpperCase(), new PotionHolder("STRONG_" + potion.name()));
            }
        });
    }
}
