package com.licker2689.lem;

import com.licker2689.lem.commands.LEMCommand;
import com.licker2689.lem.events.LEMEvent;
import com.licker2689.lpc.lang.LLang;
import com.licker2689.lpc.utils.ColorUtils;
import com.licker2689.lpc.utils.ConfigUtils;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("all")
public class EasyMessages extends JavaPlugin {
    private static EasyMessages plugin;
    public static YamlConfiguration config;
    public static String prefix;
    public static LLang lang;

    public static EasyMessages getInstance() {
        return plugin;
    }

    public void onEnable() {
        plugin = this;
        config = ConfigUtils.loadDefaultPluginConfig(plugin);
        prefix = ColorUtils.applyColor(config.getString("Settings.prefix"));
        plugin.getServer().getPluginManager().registerEvents(new LEMEvent(), plugin);
        lang = new LLang("Korean", plugin);
        getCommand("lem").setExecutor(new LEMCommand());
    }

    public void onDisable() {
        ConfigUtils.savePluginConfig(plugin, config);
    }
}
