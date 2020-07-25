package us.davidsprojects.huntorbehunted.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class LeaveCommand extends AbstractCommand {
    /**
     * The name of the command
     */
    public static final String NAME = "leave";

    /**
     * The description of the command
     */
    public static final String DESCRIPTION = "lets a player leave a team";

    /**
     * The permission of the command
     */
    public static final String PERMISSION = "hobh.leave";

    /**
     * The subpermissions of the command
     */
    private static final String[] SUBPERMISSIONS = {};

    /**
     * The usage of the command
     */
    private static final String USAGE = "/hobh leave";

    /**
     * Construct the command
     *
     * @param sender    the command sender
     */
    public LeaveCommand(CommandSender sender)
    {
        super(sender, NAME, DESCRIPTION, PERMISSION, SUBPERMISSIONS, USAGE);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {

    }

}
