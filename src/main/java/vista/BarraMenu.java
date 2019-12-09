package vista;

import controlador.barraMenu.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import modelo.Juego;

public class BarraMenu extends MenuBar {
    MenuItem opcionesPantalla = new MenuItem("Pantalla completa");

    public BarraMenu(Stage stage, Juego juego) {
        Menu menuArchivo = new Menu("Archivo");
        Menu menuAyuda = new Menu("Ayuda");
        Menu menuSonido = new Menu("Sonido");
        Menu menuJugarOtraPartida = new Menu("Nueva partida");
        Menu menuVolverAlMenuPrincipal = new Menu("Nuevo juego");



        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionComoAtacar = new MenuItem("Como atacan.");
        MenuItem opcionRangosAtaque = new MenuItem("Que rangos hay.");
        MenuItem opcionAccionesDeTurno = new MenuItem("Cuantas acciones tengo.");


        MenuItem opcionFasesJuego = new MenuItem("Fase del juego.");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        MenuItem opcionMutear = new MenuItem("Mutear/Desmutear");
        MenuItem opcionBajarVolumen = new MenuItem("Bajar volumen");
        MenuItem opcionSubirVolumen = new MenuItem("Subir volumen");
        MenuItem opcionNuevoJuego = new MenuItem("Main inicial");
        MenuItem opcionReiniciarPartida = new MenuItem("Otra partida");


        OpcionNuevoJuegoEventHandler nuevoJuego = new OpcionNuevoJuegoEventHandler(stage);
        opcionNuevoJuego.setOnAction(nuevoJuego);

        OpcionReiniciarPartidaEventHandler nuevaPartida = new OpcionReiniciarPartidaEventHandler(stage,juego);
        opcionReiniciarPartida.setOnAction(nuevaPartida);

        OpcionSalirEventHandler salirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(salirHandler);

        OpcionComoAtacarEventHandler comoAtacar = new OpcionComoAtacarEventHandler();
        opcionComoAtacar.setOnAction(comoAtacar);

        OpcionRangosAtaqueEventHandler rangoAtaque = new OpcionRangosAtaqueEventHandler();
        opcionRangosAtaque.setOnAction(rangoAtaque);

        OpcionAccionesDeTurnoEventHandler accionTurno = new OpcionAccionesDeTurnoEventHandler();
        opcionAccionesDeTurno.setOnAction(accionTurno);

        OpcionFasesJuegoEventHandler fasesJuego = new OpcionFasesJuegoEventHandler();
        opcionFasesJuego.setOnAction(fasesJuego);

        OpcionAcercaDeEventHandler acercaDe = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(acercaDe);

        OpcionMutearEventHandler mutear = new OpcionMutearEventHandler();
        opcionMutear.setOnAction(mutear);

        OpcionBajarVolumenEventHandler bajarVolumen = new OpcionBajarVolumenEventHandler();
        opcionBajarVolumen.setOnAction(bajarVolumen);

        OpcionSubirVolumenEventHandler subirVolumen = new OpcionSubirVolumenEventHandler();
        opcionSubirVolumen.setOnAction(subirVolumen);

        menuArchivo.getItems().add(opcionSalir);
        menuAyuda.getItems().addAll(opcionFasesJuego,opcionComoAtacar,opcionRangosAtaque,opcionAccionesDeTurno,opcionAcercaDe);
        menuSonido.getItems().addAll(opcionBajarVolumen, opcionSubirVolumen,opcionMutear);
        menuJugarOtraPartida.getItems().add(opcionReiniciarPartida);
        menuVolverAlMenuPrincipal.getItems().add(opcionNuevoJuego);

        this.getMenus().addAll(menuArchivo,menuAyuda,menuSonido,menuJugarOtraPartida, menuVolverAlMenuPrincipal);
    }
}
