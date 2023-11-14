package com.milkonight.services;

import org.bukkit.event.block.BlockBreakEvent;

public interface EventService {
    void handleBlockBreak(BlockBreakEvent event);
}
