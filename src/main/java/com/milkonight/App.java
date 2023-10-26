package com.milkonight;
import org.bukkit.plugin.java.JavaPlugin;

import com.milkonight.commands.CommandFly;
import com.milkonight.services.FlyService;
import com.milkonight.services.FlyServiceImpl;

/**
 * Hello world!
 *
 */
public class App extends JavaPlugin
{   
    private FlyService flyService;
    private CommandFly commandFly;

    @Override
    public void onEnable(){
        configurarServicios();
        registrarComandos();
        getLogger().info("Iniciando Plugin");
    }

    @Override
    public void onDisable(){
        getLogger().info("Deshabilitando Plugin");
    }

    private void configurarServicios(){
        flyService = new FlyServiceImpl();
    }


    private void registrarComandos(){
        commandFly = new CommandFly(flyService);
        getCommand("fly").setExecutor(commandFly);
    }


}
