package us.davidsprojects.huntorbehunted.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class UnsetCommand extends AbstractCommand {
    /**
     * The name of the command
     */
    public static final String NAME = "unset";

    /**
     * The description of the command
     */
    public static final String DESCRIPTION = "unset a player's team";

    /**
     * The permission of the command
     */
    public static final String PERMISSION = "hobh.unset";

    /**
     * The subpermissions of the command
     */
    private static final String[] SUBPERMISSIONS = {};

    /**
     * The usage of the command
     */
    private static final String USAGE = "/hobh unset [player]";

    /**
     * Construct the command
     *
     * @param sender    the command sender
     */
    public UnsetCommand(CommandSender sender)
    {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUBPERMISSIONS, USAGE);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {

    }

}
