package us.davidsprojects.minigames;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;

public class HunterCommand implements CommandExecutor {
    @Override
    @SuppressWarnings("ConstantConditions")
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(!(sender instanceof Player))
        {
            sender.sendMessage("This command is only available for players.");
            return false;
        }

        if(args.length < 1)
        {
            sender.sendMessage("Needs more than one argument");
        }

        String arguments = "";
        int i = 0;

        for(i = 0; i < args.length; i++)
        {
            arguments = arguments + args[i] + " ";
        }

        sender.sendMessage(arguments);


        return true;
    }
}
