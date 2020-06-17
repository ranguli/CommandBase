/*
* EXAMPLE USAGE
*/
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
class Example:JavaPlugin() {
  fun onEnable() {
    // Anonymous implementation of "/check" root command.
    val checkCommand = object:CommandBase<Example>(this) {
      fun runCommand(sender:CommandSender, rootCommand:Command, label:String, args:Array<String>):Boolean {
        sender.sendMessage("The root command does nothing! Use a sub command.")
        return false
      }
    }
    val checkThisCommand = CheckThisCommand(this)
    // Register "/check this" with the root "/check" command.
    checkCommand.registerSubCommand("this", checkThisCommand)
    // Register "/check this out" with the sub command "/check this".
    checkThisCommand.registerSubCommand("out", CheckThisOutCommand())
    // Register "/check" command executor with Bukkit.
    getCommand("check").setExecutor(checkCommand)
  }
  private class CheckThisCommand(plugin:Example):CommandBase<Example>(plugin) {
    fun runCommand(sender:CommandSender, rootCommand:Command, label:String, args:Array<String>):Boolean {
      sender.sendMessage("I'm the first sub command. Fuck year!")
      return true
    }
  }
  private class CheckThisOutCommand:CommandExecutor {
    fun onCommand(sender:CommandSender, command:Command, label:String, args:Array<String>):Boolean {
      sender.sendMessage("I'm a leaf, get it?")
      // returning false will cause the root commands description to be sent to the sender.
      return false
    }
  }
}
