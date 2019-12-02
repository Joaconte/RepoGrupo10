package vista;

import controlador.barraMenu.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraMenu extends MenuBar {
    MenuItem opcionesPantalla = new MenuItem("Pantalla completa");

    public BarraMenu(Stage stage) {
        Menu menuArchivo = new Menu("Archivo");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionComoAtacar = new MenuItem("Como atacan...");
        MenuItem opcionFasesJuego = new MenuItem("Sobre las fases del juego...");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        OpcionSalirEventHandler salirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(salirHandler);

        OpcionComoAtacarEventHandler comoAtacar = new OpcionComoAtacarEventHandler();
        opcionComoAtacar.setOnAction(comoAtacar);

        OpcionFasesJuegoEventHandler fasesJuego = new OpcionFasesJuegoEventHandler();
        opcionFasesJuego.setOnAction(fasesJuego);

        OpcionAcercaDeEventHandler acercaDe = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(acercaDe);

        menuArchivo.getItems().add(opcionSalir);
        menuAyuda.getItems().addAll(opcionFasesJuego,opcionComoAtacar,opcionAcercaDe);

        this.getMenus().addAll(menuArchivo,menuAyuda);
    }
}
