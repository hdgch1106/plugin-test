package com.milkonight.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.milkonight.services.SaludService;

public class ComandoSalud implements CommandExecutor {
    private final SaludService saludService;

    public ComandoSalud(SaludService saludService) {
        this.saludService = saludService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if(!(sender instanceof Player)){
            sender.sendMessage("Este comando debe ser ejecutado por un jugador");
            return true;
        }

        Player jugador = (Player) sender;
        if(command.getName().equalsIgnoreCase("salud")){
            saludService.regenerarSalud(jugador);
            return true;
        }

        return false;
    }
    
}
