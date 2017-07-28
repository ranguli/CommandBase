/*
 * EXAMPLE USAGE
 */
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Example extends JavaPlugin {

    @Override
    public void onEnable() {
        
        // Anonymous implementation of "/check" root command.
        CommandBase<Example> checkCommand = new CommandBase<Example>(this) {
            @Override
            public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
                sender.sendMessage("The root command does nothing! Use a sub command.");
                return false;
            }
        };
        
        CheckThisCommand checkThisCommand = new CheckThisCommand(this);
        // Register "/check this" with the root "/check" command.
        checkCommand.registerSubCommand("this", checkThisCommand);
        
        // Register "/check this out" with the sub command "/check this".
        checkThisCommand.registerSubCommand("out", new CheckThisOutCommand());
        
        // Register "/check" command executor with Bukkit.
        getCommand("check").setExecutor(checkCommand);
    }
}
