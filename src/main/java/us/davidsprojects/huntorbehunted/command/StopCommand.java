package us.davidsprojects.huntorbehunted.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;


// TODO: Possbily change StopCommand to EndGame to make it more clear on what it actually does
public class StopCommand extends AbstractCommand {
    /**
     * The name of the command
     */
    public static final String NAME = "stop";

    /**
     * The description of the command
     */
    public static final String DESCRIPTION = "stops a game";

    /**
     * The permission of the command
     */
    public static final String PERMISSION = "hobh.stop";

    /**
     * The subpermissions of the command
     */
    private static final String[] SUBPERMISSIONS = {};

    /**
     * The usage of the command
     */
    private static final String USAGE = "/hobh stop";

    /**
     * Construct the command
     *
     * @param sender    the command sender
     */
    public StopCommand(CommandSender sender)
    {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUBPERMISSIONS, USAGE);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {

    }

}
