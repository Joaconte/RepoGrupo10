package vista;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import vista.vistaPiezas.VistaInformacionDeUnidad;

public class VistaPiezaClikeada extends VBox {

    private Label comunicador;
    private Label posiciones;
    private VBox datosDePieza;

    public VistaPiezaClikeada(){
        super();
        etiquetasDeTextoVista();

        this.getChildren().addAll(comunicador,posiciones);
        datosDePieza= new VBox();
        comunicador.setText("Puedes pasar turno cuando quieras.");
        this.getChildren().add(datosDePieza);
        vistaDeFondo();

    }

    public void vistaActualizada(VistaInformacionDeUnidad vistaInformacion) {
        datosDePieza.getChildren().clear();
        vistaInformacion.actualizarDatosEnPartida();
        datosDePieza.getChildren().add(vistaInformacion);
    }

    private void etiquetasDeTextoVista(){
        comunicador = new Label();
        posiciones = new Label();
        posiciones.setAlignment(Pos.CENTER);
        comunicador.setAlignment(Pos.CENTER);
        comunicador.setFont(Font.font("tahoma", FontWeight.EXTRA_BOLD, 14));
        posiciones.setFont(Font.font("tahoma", FontWeight.EXTRA_BOLD, 14));
    }

    public void vistaLimpiaDeDatos(){
        datosDePieza.getChildren().clear();
    }

    private void vistaDeFondo(){
        Image imangenMuro = new Image("resources/texturas/pergamino.png");
        Background fondoDeContenedor = new Background(new BackgroundImage(imangenMuro,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(200, 400, false, false, false, false)));
        datosDePieza.setBackground(fondoDeContenedor);
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
