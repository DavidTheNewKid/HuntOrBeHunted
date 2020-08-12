package us.davidsprojects.huntorbehunted.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.davidsprojects.huntorbehunted.HuntOrBeHunted;

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
        if(sender instanceof Player)
        {
            Player player = (Player) sender;
            // used for interpreting what the outcome was for the player
            String status;
            if(args.length >= 2)
            {
                String team = args[1].toLowerCase();
                if(team.equals("hunters"))
                {
                    status = HuntOrBeHunted.hunters.removePlayer(player.getName());
                    HuntOrBeHunted.trackingMap.remove(player.getUniqueId());
                }
                else if(team.equals("hunteds"))
                {
                    status = HuntOrBeHunted.hunteds.removePlayer(player.getName());
                }
                else
                {
                    status = "Tried to leave an invalid team";
                }
            }
            else
            {
                status = "/hobh leave [team] - Missing team";
            }

            player.sendMessage(status);

        }
        else
        {
            sender.sendMessage("Need to be a player to leave a team");
        }
    }

}
