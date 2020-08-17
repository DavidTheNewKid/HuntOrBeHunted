package us.davidsprojects.huntorbehunted.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import us.davidsprojects.huntorbehunted.HuntOrBeHunted;

import java.util.UUID;

public class EventListeners implements Listener {

    /**
     * OnRightClick is registered so that everytime a user uses a compass it updates the user it is tracking
     *
     * @param event which is the event
     */
    @EventHandler
    public void onRightClick(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Action action = event.getAction();
        int playerCount = HuntOrBeHunted.hunteds.getPlayers().size();
        ItemStack compass = getCompassFromHand(player);

        // checks if compass is in hand or off hand
        if(compass != null) {
            // checks if the player count on hunteds is more than 0
            if (playerCount > 0) {

                if (HuntOrBeHunted.hunters.findPlayer(player.getName())) {
                    // Circular index, only updated on left click
                    if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                        // index is utilized in a circular fashion (0,1,2,0,1,2,0)
                        // for one person this command can be utilized to continuously track someone

                        // UUID for tracking which player is doing action
                        UUID uniqueId = player.getUniqueId();

                        // Updates index and puts it back in HashMap
                        int index = (HuntOrBeHunted.trackingMap.get(uniqueId) + 1) % playerCount;
                        HuntOrBeHunted.trackingMap.put(uniqueId, index);

                        // Updates tracking target
                        String nameOfTracked = HuntOrBeHunted.hunteds.getPlayers().get(index);
                        Player target = Bukkit.getPlayer(nameOfTracked);
                        HuntOrBeHunted.helper.setTarget(player, compass, target);
                        sendToActionBar(player, "&3&b" + "Tracking location of: " + nameOfTracked + index);
                    }


                } else {
                    // Player not on hunter team so can't use compass
                    sendToActionBar(player, "&3&b" + "Only hunters can track players (/hobh join hunters)");
                }
            } else {
                // No players on the hunted team so no one to track
                sendToActionBar(player, "&3&b" + "No players are on the hunted team to track. (/hobh join hunteds)");
            }
        }

    }

    /**
     * OnPlayerMoves is registered so that everytime a user uses a compass it updates the user it is tracking
     *
     * @param event which is the event
     */
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();

        int playerCount = HuntOrBeHunted.hunteds.getPlayers().size();
        ItemStack[] items = player.getInventory().getContents();

        // checks if compasses exist in inventory
        if(items.length > 0) {
            // checks if the player count on hunteds is more than 0
            if (playerCount > 0) {

                if (HuntOrBeHunted.hunters.findPlayer(player.getName())) {

                    // UUID for tracking which player is doing action
                    UUID uniqueId = player.getUniqueId();

                    // Updates index and puts it back in HashMap
                    int index = HuntOrBeHunted.trackingMap.get(uniqueId);

                    // Updates tracking target
                    String nameOfTracked = HuntOrBeHunted.hunteds.getPlayers().get(index);
                    Player target = Bukkit.getPlayer(nameOfTracked);
                    for(ItemStack item : items) {
                        if(item != null) {
                            if (item.getType() == Material.COMPASS) {
                                HuntOrBeHunted.helper.setTarget(player, item, target);
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        Player player = event.getPlayer();
        ItemStack compass = HuntOrBeHunted.helper.getCompass();
        int playerCount = HuntOrBeHunted.hunteds.getPlayers().size();

        UUID uniqueId = player.getUniqueId();
        PlayerInventory inventory = player.getInventory();

        if(HuntOrBeHunted.hunters.findPlayer(player.getName()))
        {
            if(playerCount > 0)
            {
                int index = HuntOrBeHunted.trackingMap.get(uniqueId);
                String nameOfTracked = HuntOrBeHunted.hunteds.getPlayers().get(index);
                Player target = Bukkit.getPlayer(nameOfTracked);
                HuntOrBeHunted.helper.setTarget(player, compass, target);
                inventory.addItem(compass);
            }
        }
        if(HuntOrBeHunted.hunteds.findPlayer(player.getName()))
        {
            player.sendMessage(ChatColor.RED + "" + "You've died as a hunted. All dreams have to come to an end.");
        }
    }



    /**
     * Makes sure that the compass is in the main hand slot and returns it
     * If not in main slot returns null which indicate it isn't there
     *
     * @param player player to get the compass from hand
     * @return compass
     */
    private ItemStack getCompassFromHand(Player player)
    {
        ItemStack compass = null;

        if(player.getInventory().getItemInMainHand().getType() == Material.COMPASS)
        {
            compass = player.getInventory().getItemInMainHand();
        }

        return compass;
    }

    private void sendToActionBar(Player player, String message)
    {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', message)));
    }
}
