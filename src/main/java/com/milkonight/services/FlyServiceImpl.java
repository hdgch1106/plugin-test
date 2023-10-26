package com.milkonight.services;

import org.bukkit.entity.Player;

import com.milkonight.helpers.MensajeHelper;

public class FlyServiceImpl implements FlyService {

    @Override
    public void toggleFly(Player player) {
        if(player.getAllowFlight()){
            player.setAllowFlight(false);
            MensajeHelper.enviarMensaje(player, "&cModo de vuelo desactivado.");
        } else {
            player.setAllowFlight(true);
            MensajeHelper.enviarMensaje(player, "&cModo de vuelo activado.");

        }
    }
    
}
