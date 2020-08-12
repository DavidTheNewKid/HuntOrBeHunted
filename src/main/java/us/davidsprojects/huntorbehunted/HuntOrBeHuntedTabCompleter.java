package us.davidsprojects.huntorbehunted;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HuntOrBeHuntedTabCompleter implements TabCompleter {
    /*
     * Valid commands.
     */
    private static final String[] COMMANDS = {"start", "stop", "set", "unset", "join", "leave", "compass", "help","list"};
    /*
     * Valid teams.
     */
    private static final String[] TEAMS = {"hunters","hunteds"};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender.isOp() || sender.hasPermission("hobh.*") || sender.hasPermission("hobh." + args[0]))
        {
            List<String> completions = new ArrayList<>();

            if (args.length == 1)
            {
                // Lists available sub-commands available
                String partialCommand = args[0];
                List<String> commands = new ArrayList<>(Arrays.asList(COMMANDS));
                StringUtil.copyPartialMatches(partialCommand, commands, completions);
            }
            else if (args.length == 2)
            {
                String subCommand = args[0].toLowerCase();
                String partialCommand = args[1];

                if(subCommand.equals("set") || subCommand.equals("unset"))
                {
                    // List available players as auto-complete
                    List<String> commands = new ArrayList<>(Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList()));
                    StringUtil.copyPartialMatches(partialCommand, commands, completions);
                }
                else if(subCommand.equals("join") || subCommand.equals("leave"))
                {
                    // List available teams as auto-complete
                    List<String> commands = new ArrayList<>(Arrays.asList(TEAMS));
                    StringUtil.copyPartialMatches(partialCommand, commands, completions);
                }
                else
                {
                    // no more options available for commands
                    return null;
                }
            }
            else if (args.length == 3)
            {
                String subCommand = args[0].toLowerCase();
                String partialCommand = args[2];
                if (subCommand.equals("set") || subCommand.equals("unset"))
                {
                    // List available teams as auto-complete
                    List<String> commands = new ArrayList<>(Arrays.asList(TEAMS));
                    StringUtil.copyPartialMatches(partialCommand, commands, completions);
                }
                else
                {
                    // no more options available for commands
                    return null;
                }
            }
            else
            {
                // no more options available for commands
                return null;
            }

            Collections.sort(completions);
            return completions;
        }

        // Lacking perms, don't show the commands available
        return null;
    }

}
