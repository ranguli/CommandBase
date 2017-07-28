import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CheckThisCommand extends CommandBase<Example> {

    public CheckThisCommand(Example plugin) {
        super(plugin);
    }

    @Override
    public boolean runCommand(CommandSender sender, Command rootCommand, String label, String[] args) {
        sender.sendMessage("I'm the first sub command. Fuck year!");
        return true;
    }
}