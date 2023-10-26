package com.milkonight.helpers;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class MensajeHelper {
    public static void enviarMensaje(CommandSender sender, String mensaje){
        if(sender instanceof Player){
            Player jugador = (Player) sender;
            jugador.sendMessage(ChatColor.translateAlternateColorCodes('&', mensaje));
        } else {
            sender.sendMessage(mensaje);
        }

    }
}