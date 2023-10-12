package com.milkonight;
import org.bukkit.plugin.java.JavaPlugin;

import com.milkonight.commands.ComandoSalud;
import com.milkonight.services.SaludService;
import com.milkonight.services.SaludServiceImpl;

/**
 * Hello world!
 *
 */
public class Main extends JavaPlugin
{

    private SaludService saludService;
    private ComandoSalud comandoSalud;

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
        saludService = new SaludServiceImpl();
    }

    private void registrarComandos(){
        comandoSalud = new ComandoSalud(saludService);
        getCommand("salud").setExecutor(comandoSalud);
    }

}
