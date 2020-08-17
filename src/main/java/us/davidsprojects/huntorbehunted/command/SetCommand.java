package us.davidsprojects.huntorbehunted.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import us.davidsprojects.huntorbehunted.HuntOrBeHunted;

public class SetCommand extends AbstractCommand {
    /**
     * The name of the command
     */
    public static final String NAME = "set";

    /**
     * The description of the command
     */
    public static final String DESCRIPTION = "sets a player's team";

    /**
     * The permission of the command
     */
    public static final String PERMISSION = "hobh.set";

    /**
     * The subpermissions of the command
     */
    private static final String[] SUBPERMISSIONS = {};

    /**
     * The usage of the command
     */
    private static final String USAGE = "/hobh set [player] [team]";

    /**
     * Construct the command
     *
     * @param sender    the command sender
     */
    public SetCommand(CommandSender sender)
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
                if(teamName.equals("hunters") && !HuntOrBeHunted.hunteds.findPlayer(playerName))
                {
                    if(!HuntOrBeHunted.hunteds.findPlayer(playerName))
                    {
                        PlayerInventory inventory = player.getInventory();
                        ItemStack compass = HuntOrBeHunted.helper.getCompass();

                        status = HuntOrBeHunted.hunters.addPlayer(playerName);
                        HuntOrBeHunted.trackingMap.put(player.getUniqueId(), 0);

                        inventory.addItem(compass);
                    }
                    else
                    {
                        status = "Player already in team - /hobh unset hunteds";
                    }
                }
                else if(teamName.equals("hunteds"))
                {
                    if(!HuntOrBeHunted.hunters.findPlayer(playerName))
                    {
                        status = HuntOrBeHunted.hunteds.addPlayer(playerName);
                    }
                    else
                    {
                        status = "Player already in team - /hobh unset hunters";
                    }
                }
                else
                {
                    status = "/hobh set [player] [team] - Invalid team name";
                }
            }
            else
            {
               status = "/hobh set [player] [team] - Invalid player/Player not found";
            }

            sender.sendMessage(status);

        }
        else
        {
            sender.sendMessage("/hobh set [player] [team] - Missing player or team");
        }

    }

}
