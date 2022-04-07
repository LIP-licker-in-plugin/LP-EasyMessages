package com.darksoldier1404.dem;

import com.darksoldier1404.dem.commands.DEMCommand;
import com.darksoldier1404.dem.events.DEMEvent;
import com.darksoldier1404.dppc.lang.DLang;
import com.darksoldier1404.dppc.utils.ColorUtils;
import com.darksoldier1404.dppc.utils.ConfigUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("all")
public class EasyMessages extends JavaPlugin {
    private static EasyMessages plugin;
    public static YamlConfiguration config;
    public static String prefix;
    public static DLang lang;

    public static EasyMessages getInstance() {
        return plugin;
    }

    public void onEnable() {
        plugin = this;
        config = ConfigUtils.loadDefaultPluginConfig(plugin);
        prefix = ColorUtils.applyColor(config.getString("Settings.prefix"));
        plugin.getServer().getPluginManager().registerEvents(new DEMEvent(), plugin);
        lang = new DLang("Korean", plugin);
        getCommand("dem").setExecutor(new DEMCommand());
    }

    public void onDisable() {
        ConfigUtils.savePluginConfig(plugin, config);
    }
}
