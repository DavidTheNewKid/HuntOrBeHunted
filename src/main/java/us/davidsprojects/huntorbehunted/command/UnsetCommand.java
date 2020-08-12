package us.davidsprojects.huntorbehunted.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.davidsprojects.huntorbehunted.HuntOrBeHunted;

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
        if(args.length == 3) {
            String playerName = args[1];
            String teamName = args[2];
            String status;

            Player player = Bukkit.getPlayer(playerName);

            if(player != null)
            {
                if(teamName.equals("hunters"))
                {
                    status = HuntOrBeHunted.hunters.removePlayer(playerName);
                    HuntOrBeHunted.trackingMap.remove(player.getUniqueId());
                }
                else if(teamName.equals("hunteds"))
                {
                    status = HuntOrBeHunted.hunteds.removePlayer(playerName);
                }
                else
                {
                    status = "/hobh unset [player] [team] - Invalid team name";
                }
            }
            else
            {
                status = "/hobh unset [player] [team] - Invalid player/Player not found";
            }

            sender.sendMessage(status);

        }
        else
        {
            sender.sendMessage("/hobh unset [player] [team] - Missing player or team");
        }
    }

}
