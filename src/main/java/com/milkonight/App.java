package com.milkonight;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class App extends JavaPlugin
{

    @Override
    public void onEnable(){
        getLogger().info("Iniciando Plugin");
    }

    @Override
    public void onDisable(){
        getLogger().info("Deshabilitando Plugin");
    }

}
