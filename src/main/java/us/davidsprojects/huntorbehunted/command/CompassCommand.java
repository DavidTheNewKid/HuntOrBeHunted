package us.davidsprojects.huntorbehunted.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class CompassCommand extends AbstractCommand {
    /**
     * The name of the command
     */
    public static final String NAME = "compass";

    /**
     * The description of the command
     */
    public static final String DESCRIPTION = "gives hunter team members a compass (or everyone if set in config)";

    /**
     * The permission of the command
     */
    public static final String PERMISSION = "hobh.compass";

    /**
     * The subpermissions of the command
     */
    private static final String[] SUBPERMISSIONS = {};

    /**
     * The usage of the command
     */
    private static final String USAGE = "/hobh compass";

    /**
     * Construct the command
     *
     * @param sender    the command sender
     */
    public CompassCommand(CommandSender sender)
    {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUBPERMISSIONS, USAGE);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        PlayerInventory inventory = player.getInventory();

        inventory.addItem(new ItemStack(Material.COMPASS));

    }

}