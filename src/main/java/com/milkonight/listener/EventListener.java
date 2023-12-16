package com.milkonight.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.milkonight.services.EventService;

public class EventListener implements Listener{
    private final EventService eventService;
    public EventListener(EventService eventService) {
        this.eventService = eventService;
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        eventService.handleBlockBreak(event);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        eventService.handlePlayerInteract(event);
    }
}
