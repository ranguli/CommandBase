import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CheckThisOutCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("I'm a leaf, get it?");
        // returning false will cause the root commands description to be sent to the sender.
        return false;
    }
}