package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.jugador.EjercitoIncompletoException;
import vista.VistaDeTablero;
import vista.fasesPartida.faseInicialPartida.BarraLateralOpciones;
import vista.fasesPartida.faseMediaPartida.PantallaFaseMediaPartida;

public class BotonConfirmarEjercitoEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private VistaDeTablero vistaDeTablero;
    private Stage escenarioPrincipal;
    private BarraLateralOpciones vistaLateral;

    public BotonConfirmarEjercitoEventHandler(Juego juego, Stage escenarioPrincipal, VistaDeTablero vistaDeTablero, BarraLateralOpciones vistaLateral){
        this.juego = juego;
        this.vistaDeTablero = vistaDeTablero;
        this.escenarioPrincipal= escenarioPrincipal;
        this.vistaLateral = vistaLateral;
    }


    @Override
    public void handle(ActionEvent event) {
        try{
            juego.cambiarTurno();
            vistaLateral.vistaTurnosActualizada();
            vistaLateral.vistaPuntosActualizada();
            if (!juego.estaEnFaseInicial()){
                PantallaFaseMediaPartida pantallaFaseMediaPartida = new PantallaFaseMediaPartida(vistaDeTablero, juego , escenarioPrincipal);
                ScrollPane panelConBarrasDeMovimiento = new ScrollPane();
                panelConBarrasDeMovimiento.setContent(pantallaFaseMediaPartida);
                Scene escenaFaseInicial = new Scene (panelConBarrasDeMovimiento);
                escenarioPrincipal.setScene(escenaFaseInicial);
            }
        }
        catch (EjercitoIncompletoException e){
            vistaLateral.vistaAlertas("Tus tropas deben estar completas");
        }
    }
}
