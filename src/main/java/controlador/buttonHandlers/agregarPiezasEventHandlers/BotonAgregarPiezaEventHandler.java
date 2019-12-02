package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;
import vista.faseInicial.EtiquetaPuntosJugador;
import vista.faseInicial.EtiquetaTurnoJugador;

public abstract class BotonAgregarPiezaEventHandler implements EventHandler<ActionEvent> {

    private TextField textFieldUno;
    private TextField textFieldDos;
    private Label comunicadoTexto;
    private VistaDeTablero vistaDeTablero;
    private EtiquetaPuntosJugador etiquetaPuntos;
    private String nombre;

    public BotonAgregarPiezaEventHandler(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos, String nombre) {

        textFieldUno = camposDeTexto.textoUno;
        textFieldDos = camposDeTexto.textoDos;
        comunicadoTexto = camposDeTexto.etiquetaUno;
        this.vistaDeTablero = vistaDeTablero;
        this.etiquetaPuntos= etiquetaPuntos;
        this.nombre = nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            String sX = this.textFieldUno.getText();
            String sY = this.textFieldDos.getText();
            int x = Integer.parseInt(sX);
            int y = Integer.parseInt(sY);
            crearPiezaYAgregarATablero(x, y, vistaDeTablero);
            etiquetaPuntos.actualizarEtiqueta();
        }
        catch (NumberFormatException e){
            this.comunicadoTexto.setText("Debe ingresar numeros");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000"));
        }
    }


    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero){
        try {
            this.comunicadoTexto.setText("Tropa agregada con exito");
            this.comunicadoTexto.setTextFill(Color.web("#336600"));
            Pieza pieza = etiquetaPuntos.juego.crearPieza(nombre, x, y);
            VistaDeUnidad vistaDeUnidad = new VistaDeUnidad(vistaDeTablero, pieza, nombre.toLowerCase());

        }
        catch ( PiezaFueraDeSectorException e){
            this.comunicadoTexto.setText("Ubica la pieza en tu sector.");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000")); }
        catch (PresupuestoAgotadoException e){
            this.comunicadoTexto.setText("Ya puedes acabar tu turno.");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000")); }
        catch (UbicacionInvalidaException e){
            this.comunicadoTexto.setText("Ya hay una pieza en la casilla.");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000")); }
        catch (CompraInvalidaException  e){
            this.comunicadoTexto.setText("Presupuesto insuficiente para la pieza.");
            this.comunicadoTexto.setTextFill(Color.web("#FF0000")); }


    }

}