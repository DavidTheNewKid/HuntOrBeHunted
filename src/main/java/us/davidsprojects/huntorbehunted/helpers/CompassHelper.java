package us.davidsprojects.huntorbehunted.helpers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CompassHelper {
    public void setTarget(Player player, ItemStack compass, Player target) {
        if (target != null) {
            CompassMeta meta = (CompassMeta) compass.getItemMeta();
            if(meta != null)
            {
                meta.setLodestone(target.getLocation());
                meta.setLodestoneTracked(false);
                compass.setItemMeta(meta);
            }
        }
    }

    public ItemStack getCompass()
    {
        ItemStack trackerCompass = new ItemStack(Material.COMPASS);
        ItemMeta trackerMeta = trackerCompass.getItemMeta();
        trackerMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Tracker Compass");

        List<String> trackerLore = new ArrayList<>();

        trackerLore.add(ChatColor.GRAY + "Hunt down your enemies!");
        trackerLore.add(ChatColor.GRAY + "Left-click to choose next target");

        trackerMeta.setLore(trackerLore);

        trackerCompass.setItemMeta(trackerMeta);

        return trackerCompass;
    }
}
