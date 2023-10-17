package com.milkonight.services;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class SaludServiceImpl implements SaludService {

    @Override
    public void regenerarSalud(Player jugador, int cantidad) {
        //Logica para regenerar la salud

        final double maxHealth = jugador.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
        double saludActual = jugador.getHealth();


        if((saludActual + cantidad) > maxHealth){
            jugador.setHealth(maxHealth);
        } else {
            jugador.setHealth(saludActual + cantidad);
        }

        int corazones = (int) jugador.getHealth()/2;
        jugador.sendMessage("Tu salud ha sido regenerada y tienes "+corazones+" corazones");
        // jugador.setHealth(maxHealth);
        // jugador.sendMessage("Tu salud ha sido regenerada");
        
    }
    
}
