package com.milkonight.services;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;

public class EventServiceImpl implements EventService {

    @Override
    public void handleBlockBreak(BlockBreakEvent event) {
        if(event.getBlock().getType().equals(Material.GRASS_BLOCK)){
            String playerName = event.getPlayer().getName();
            event.getPlayer().sendMessage("¡Has roto un bloque de grass "+playerName+"!");
        };
    }
    
}
