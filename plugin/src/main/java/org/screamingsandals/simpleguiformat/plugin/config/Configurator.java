package org.screamingsandals.simpleguiformat.plugin.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.screamingsandals.simpleguiformat.plugin.SimpleGuiPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Configurator {
    public File configFile;
    public FileConfiguration config;

    public final File dataFolder;
    
    private SimpleGuiPlugin main;

    public Configurator(SimpleGuiPlugin main) {
        this.dataFolder = main.getDataFolder();
        this.main = main;
    }

    public void createFiles() {
        dataFolder.mkdirs();

        configFile = new File(dataFolder, "config.yml");

        config = new YamlConfiguration();

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        AtomicBoolean modify = new AtomicBoolean(false);
        checkOrSetConfig(modify, "inventories", new HashMap<String, Object>() {
        	{
        		put("sample", new HashMap<String, Object>() {
        			{
        				put("file", "sample.yml");
        				put("section", "data");
        				put("options", new HashMap<>());
        			}
        		});
        	}
        });
        
        if (modify.get()) {
            try {
                config.save(configFile);
                main.saveResource("sample.yml", false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkOrSetConfig(AtomicBoolean modify, String path, Object value) {
        checkOrSet(modify, this.config, path, value);
    }

    private static void checkOrSet(AtomicBoolean modify, FileConfiguration config, String path, Object value) {
        if (!config.isSet(path)) {
            if (value instanceof Map) {
                config.createSection(path, (Map<?, ?>) value);
            } else {
                config.set(path, value);
            }
            modify.set(true);
        }
    }
}
