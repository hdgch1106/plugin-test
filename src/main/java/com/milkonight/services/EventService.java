package com.milkonight.services;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface EventService {
    void handleBlockBreak(BlockBreakEvent event);
    void handlePlayerInteract(PlayerInteractEvent event);
}
