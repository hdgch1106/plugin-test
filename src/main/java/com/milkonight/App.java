package com.milkonight;
import org.bukkit.plugin.java.JavaPlugin;

import com.milkonight.listener.EventListener;
import com.milkonight.services.EventService;
import com.milkonight.services.EventServiceImpl;

/**
 * Hello world!
 *
 */
public class App extends JavaPlugin
{

    private EventService eventService;
    private EventListener eventListener;

    @Override
    public void onEnable(){
        configurarServicios();
        registerEventsListener();
        getLogger().info("Iniciando Plugin");
    }

    @Override
    public void onDisable(){
        getLogger().info("Deshabilitando Plugin");
    }

    private void configurarServicios(){
        eventService = new EventServiceImpl();
    }

    private void registerEventsListener(){
        eventListener = new EventListener(eventService);
        getServer().getPluginManager().registerEvents(eventListener, this);
    }

}
