package vista.fasesPartida.faseMediaPartida;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import vista.vistaPiezas.VistaInformacionDeUnidad;
import vista.vistaPiezas.VistaUnidad;

public class VistaPiezaClikeada extends VBox {

    private Label comunicador;
    private Label posiciones;
    private VBox datosDePieza;
    private VistaUnidad ultimaVistaUnidadConBotonesActivos;

    public VistaPiezaClikeada(){
        super();
        etiquetasDeTextoVista();
        this.setMinHeight(600);

        this.getChildren().addAll(comunicador,posiciones);
        datosDePieza= new VBox();
        comunicador.setText("Puedes pasar turno cuando quieras.");
        this.getChildren().add(datosDePieza);
        vistaDeFondo();

    }

    public void vistaActualizada(VistaUnidad vistaUnidad) {
        datosDePieza.getChildren().clear();
        ultimaVistaUnidadConBotonesActivos =vistaUnidad; //Sirve para que en el cambio de turno no queden botones activos.
        vistaUnidad.barraDeOpciones();
        VistaInformacionDeUnidad vistaInformacion = vistaUnidad.getVistaInformacion();
        vistaInformacion.actualizarDatosEnPartida();
        datosDePieza.getChildren().add(vistaInformacion);
    }

    //Cuando formo batallon le desactivo los botones a TODAS.
    public void vistaActualizada(VistaInformacionDeUnidad vistaInformacion) {
        datosDePieza.getChildren().clear();
        vistaInformacion.actualizarDatosEnPartida();
        datosDePieza.getChildren().add(vistaInformacion);
    }

    public void vistaCambioDeTurno(){
        try{
            ultimaVistaUnidadConBotonesActivos.barraDeOpciones();}
        catch (NullPointerException e){}
    }


    private void etiquetasDeTextoVista(){
        comunicador = new Label();
        comunicador.setTextFill(Color.color(0,0.7,0));
        posiciones = new Label();
        posiciones.setTextFill(Color.color(0,0.7,0));

        posiciones.setAlignment(Pos.CENTER);
        comunicador.setAlignment(Pos.CENTER);
        comunicador.setFont(Font.font("tahoma", FontWeight.EXTRA_BOLD, 12));
        posiciones.setFont(Font.font("tahoma", FontWeight.EXTRA_BOLD, 12));
    }

    private void vistaDeFondo(){
        Image imangenMuro = new Image("resources/texturas/pergamino.png");
        Background fondoDeContenedor = new Background(new BackgroundImage(imangenMuro,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(250, 420, false, false, false, false)));
        datosDePieza.setBackground(fondoDeContenedor);
        datosDePieza.setMinHeight(420);
        datosDePieza.setMinWidth(250);

    }

    public void vistaAlerta(String texto){
        comunicador.setTextFill(Color.color(0.7,0,0));
        comunicador.setText(texto);
    }

    public void vistaMensaje(String texto){
        comunicador.setTextFill(Color.color(0,0.7,0));
        comunicador.setText(texto);
    }

    public void vistaMensajeUbicacion(String s) {
        posiciones.setText(s);
    }
}
