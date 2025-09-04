package com.github.ringoame196_s_mcPlugin

import com.github.ringoame196_s_mcPlugin.commands.MoneyCommand
import com.github.ringoame196_s_mcPlugin.commands.MoneyManagerCommand
import com.github.ringoame196_s_mcPlugin.events.Events
import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabCompleter
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var instance: Main
            private set
    }

    override fun onEnable() {
        super.onEnable()
        instance = this
        registerCommands()
        registerEvents()
    }

    private fun registerCommands() {
        registerCommand("money", MoneyCommand())
        registerCommand("moneymanager", MoneyManagerCommand())
    }

    private fun registerEvents() {
        server.pluginManager.registerEvents(Events(), this)
    }

    private fun registerCommand(name: String, executor: Any) {
        getCommand(name)?.apply {
            setExecutor(executor as? CommandExecutor)
            if (executor is TabCompleter) {
                tabCompleter = executor
            }
        } ?: logger.warning("Command /$name is not defined in plugin.yml")
    }
}
