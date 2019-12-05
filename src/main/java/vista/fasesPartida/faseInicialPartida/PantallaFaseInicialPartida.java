package vista.fasesPartida.faseInicialPartida;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.pieza.Ubicacion;
import resources.sonidos.Audio;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasesPartida.EtiquetaTurnoJugador;
import vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas.ContenedorElegirPieza;

public class PantallaFaseInicialPartida extends HBox {

    private VBox barraLateral;
    private VistaDeTablero vistaDeTablero;
    private EtiquetaTurnoJugador etiquetaDeJugadorEnTurno;
    private EtiquetaPresupuestoJugador etiquetaPresupuestoDelJugador;
    private Ubicacion ubicacion;
    private ContenedorElegirPieza botoneraPiezasACrear;
    private BotonConfirmarEjercito botonConfirmarEjercito;
    private Label etiquetaComunicacion;

    public PantallaFaseInicialPartida(Juego juego, Stage escenarioPrincipal){
        //Audio.reproducirCargaJugadores();
        Audio.reproducirMusica("registro");

        this.setSpacing(10);

        this.barraLateral = new VBox();
        this.etiquetaComunicacion = new Label("Desplazate en el tablero para posicionar piezas.");
        this.etiquetaPresupuestoDelJugador = new EtiquetaPresupuestoJugador( juego );
        this.etiquetaDeJugadorEnTurno = new EtiquetaTurnoJugador( juego );
        this.vistaDeTablero = new VistaDeTablero(juego.getTablero(),escenarioPrincipal);
        this.ubicacion = vistaDeTablero.getUbicacionDelCursor();
        this.botoneraPiezasACrear = new ContenedorElegirPieza(vistaDeTablero, ubicacion, etiquetaPresupuestoDelJugador,etiquetaComunicacion);
        this.botonConfirmarEjercito = new BotonConfirmarEjercito(etiquetaDeJugadorEnTurno,etiquetaPresupuestoDelJugador,juego,etiquetaComunicacion,escenarioPrincipal,vistaDeTablero);


        this.getChildren().add(vistaDeTablero);
        this.configurarBarraLateral();
        this.getChildren().add(barraLateral);
    }


    private void configurarBarraLateral() {

        barraLateral.setSpacing(15);
        barraLateral.getChildren().addAll(etiquetaDeJugadorEnTurno.etiqueta, etiquetaPresupuestoDelJugador.etiqueta,etiquetaComunicacion);
        barraLateral.getChildren().addAll( botoneraPiezasACrear, botonConfirmarEjercito);
    }


}
