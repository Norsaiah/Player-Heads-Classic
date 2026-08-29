package me.norsaiah.listener;

import me.norsaiah.PlayerHeads;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collections;

public class PlayerDeathListener implements Listener {
    PlayerHeads plugin;

    public PlayerDeathListener(PlayerHeads plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player killer = player.getKiller();

        if(killer != null) {
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setOwner(killer.getName());
            meta.setLore(Collections.singletonList("Killed by " + killer.getName()));

            skull.setItemMeta(meta);

            event.getDrops().add(skull);
        }
    }
}
