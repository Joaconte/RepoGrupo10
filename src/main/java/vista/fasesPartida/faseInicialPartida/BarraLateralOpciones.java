package vista.fasesPartida.faseInicialPartida;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.Juego;
import vista.VistaDeTablero;
import vista.fasesPartida.EtiquetaTurnoJugador;
import vista.fasesPartida.faseInicialPartida.botonesAgregarPiezas.ContenedorElegirPieza;

public class BarraLateralOpciones extends VBox {

    private EtiquetaTurnoJugador etiquetaDeJugadorEnTurno;
    private EtiquetaPresupuestoJugador etiquetaPresupuestoDelJugador;
    private ContenedorElegirPieza botoneraPiezasACrear;
    private BotonConfirmarEjercito botonConfirmarEjercito;
    private Label etiquetaComunicacion;

    public BarraLateralOpciones(Juego juego, VistaDeTablero vistaDeTablero, Stage escenarioPrincipal){

        this.etiquetaComunicacion = new Label("¡Desplazate y agrega tus piezas!");
        etiquetaComunicacion.setMinWidth(390);
        etiquetaComunicacion.setAlignment(Pos.CENTER);
        etiquetaComunicacion.setStyle("-fx-background-color: gray;");
        this.setMinWidth(400);
        this.etiquetaPresupuestoDelJugador = new EtiquetaPresupuestoJugador( juego );
        this.etiquetaDeJugadorEnTurno = new EtiquetaTurnoJugador( juego );
        this.botoneraPiezasACrear = new ContenedorElegirPieza(vistaDeTablero, this, juego);
        this.botonConfirmarEjercito = new BotonConfirmarEjercito(juego,escenarioPrincipal, vistaDeTablero, this);


        configurarBarraLateral();
    }

    private void configurarBarraLateral() {
        this.setSpacing(15);
        this.getChildren().addAll(etiquetaDeJugadorEnTurno, etiquetaPresupuestoDelJugador,etiquetaComunicacion);
        this.getChildren().addAll( botoneraPiezasACrear, botonConfirmarEjercito);
    }

    public void vistaTurnosActualizada() {
        etiquetaDeJugadorEnTurno.actualizarEtiqueta();
        etiquetaComunicacion.setTextFill(Color.web("#ffffff"));
        this.etiquetaComunicacion.setText("¡Desplazate y agrega tus piezas!");

    }

    public void vistaPuntosActualizada(String nombre) {
        etiquetaComunicacion.setTextFill(Color.web("#ffffff"));
        this.etiquetaComunicacion.setText("¡" + nombre + " se agrego exitosamente!");
        etiquetaPresupuestoDelJugador.actualizarEtiqueta();
    }

    public void vistaPuntosActualizada() {
        etiquetaPresupuestoDelJugador.actualizarEtiqueta();
    }

    public void vistaAlertas(String texto){
        etiquetaComunicacion.setTextFill(Color.web("#FF0000"));
        etiquetaComunicacion.setText(texto);
    }
}
