package com.milkonight.services;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class SaludServiceImpl implements SaludService {

    @Override
    public void regenerarSalud(Player jugador) {
        //Logica para regenerar la salud

        final double maxHealth = jugador.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
        jugador.setHealth(maxHealth);
        jugador.sendMessage("Tu salud ha sido regenerada");
        
    }
    
}
