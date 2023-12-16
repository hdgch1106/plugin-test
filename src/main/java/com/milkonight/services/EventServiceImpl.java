package com.milkonight.services;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.milkonight.App;

public class EventServiceImpl implements EventService {

    private final App app;

    public EventServiceImpl(App app) {
        this.app = app;
    }

    @Override
    public void handleBlockBreak(BlockBreakEvent event) {
        if(event.getBlock().getType().equals(Material.GRASS_BLOCK)){
            String playerName = event.getPlayer().getName();
            event.getPlayer().sendMessage("¡Has roto un bloque de grass "+playerName+"!");
        };
    }

    @Override
    public void handlePlayerInteract(PlayerInteractEvent event) {
        Player jugador = event.getPlayer();

        //Verificar si el jugador hizo click derecho con una espada de diamante
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            ItemStack itemEnMano = jugador.getInventory().getItemInMainHand();

            //Verificar si el iteam en mano es una espada de diamante, en la mano principal
            if(itemEnMano != null && itemEnMano.getType().equals(Material.DIAMOND_SWORD)){
                //Crear una bola de fuego desde la posicion del jugador
                Fireball bolaDeFuego = jugador.launchProjectile(Fireball.class);

                //Cambiar la velocidad de la boda de fuego
                bolaDeFuego.setVelocity(jugador.getLocation().getDirection().multiply(2));

                //Elimina la bola de fuego 1.5 segundos despues de ser lanzada
                Bukkit.getScheduler().runTaskLater(app, () -> bolaDeFuego.remove(), 30);
            }
        }
    }
    
}
