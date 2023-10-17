package com.milkonight.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.milkonight.helper.MensajeHelper;
import com.milkonight.services.SaludService;

public class ComandoSalud implements CommandExecutor {
    private final SaludService saludService;

    public ComandoSalud(SaludService saludService) {
        this.saludService = saludService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Este comando debe ser ejecutado por un jugador");
            return true;
        }

        Player jugador = (Player) sender;
        if (command.getName().equalsIgnoreCase("salud")) {
            if (args.length == 0) {
                saludService.regenerarSalud(jugador, 20);
                return true;
            } else if(args.length == 1){
                try {
                    int cantidad = Integer.parseInt(args[0]);
                saludService.regenerarSalud(jugador, cantidad);
                } catch (NumberFormatException e) {
                    MensajeHelper.enviarMensaje(sender, "&4Por favor, ingrese un carácter numérico.");
                }
                
            } else {
                MensajeHelper.enviarMensaje(sender, "&4Uso incorrecto del comando. /salud [catidad].");
            }

        }

        return false;
    }

}
