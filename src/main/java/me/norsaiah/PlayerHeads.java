package me.norsaiah;

import me.norsaiah.listener.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerHeads extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
    }
}