package com.milkonight.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.milkonight.helpers.MensajeHelper;
import com.milkonight.services.FlyService;

public class CommandFly implements CommandExecutor {
    private final FlyService flyService;

    public CommandFly(FlyService flyService) {
        this.flyService = flyService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            MensajeHelper.enviarMensaje(sender, "Este comando solo puede ser ejecutado por un jugador");
            return true;
        }

        Player jugador = (Player) sender;

        if(jugador.hasPermission("testyt.fly")){
            flyService.toggleFly(jugador);
        } else {
            MensajeHelper.enviarMensaje(sender, "&cNo tienes permisos para alternar el modo de vuelo.");
        }

        return true;
    }
    
}
