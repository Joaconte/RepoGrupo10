package vista.fasePartida.faseInicialPartida;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Juego;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.fasePartida.botonesMoverEnTablero.PanelDeDirecciones;
import vista.fasePartida.EtiquetaTurnoJugador;
import vista.fasePartida.faseInicialPartida.botonesAgregarPiezas.ContenedorElegirPieza;

public class ContenedorFaseInicialPartida extends HBox {

    private VBox barraLateral;
    private VistaDeTablero vistaDeTablero;
    private EtiquetaTurnoJugador etiquetaDeJugadorEnTurno;
    private EtiquetaPuntosJugador etiquetaPresupuestoDelJugador;
    private CamposDeTexto camposDeTexto;
    private ContenedorElegirPieza botoneraPiezasACrear;
    private BotonConfirmarEjercito botonConfirmarEjercito;
    private PanelDeDirecciones panelDeDirecciones;

    public ContenedorFaseInicialPartida (Juego juego, Stage escenarioPrincipal){

        this.setSpacing(20);
        this.barraLateral = new VBox();
        this.etiquetaPresupuestoDelJugador = new EtiquetaPuntosJugador( juego );
        this.vistaDeTablero = new VistaDeTablero(juego.getTablero());
        this.etiquetaDeJugadorEnTurno = new EtiquetaTurnoJugador( juego );
        this.camposDeTexto = new CamposDeTexto("Ingrese coordenada x", "Ingrese coordenada y");
        this.botoneraPiezasACrear = new ContenedorElegirPieza(vistaDeTablero, barraLateral, camposDeTexto, etiquetaPresupuestoDelJugador);
        this.panelDeDirecciones = new PanelDeDirecciones(vistaDeTablero, camposDeTexto);

        this.botonConfirmarEjercito = new BotonConfirmarEjercito(etiquetaDeJugadorEnTurno,etiquetaPresupuestoDelJugador,juego,camposDeTexto,escenarioPrincipal);

        this.getChildren().add(vistaDeTablero);
        this.configurarBarraLateral(juego);
        this.getChildren().add(barraLateral);
    }


    private void configurarBarraLateral(Juego juego) {

        barraLateral.setSpacing(15);
        barraLateral.getChildren().addAll(etiquetaDeJugadorEnTurno.etiqueta, etiquetaPresupuestoDelJugador.etiqueta, camposDeTexto.textoUno, camposDeTexto.textoDos,camposDeTexto.etiquetaUno);
        barraLateral.getChildren().addAll(panelDeDirecciones, botonConfirmarEjercito, botoneraPiezasACrear);
    }


}
