package controlador.buttonHandlers.agregarPiezasEventHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import modelo.jugador.PiezaFueraDeSectorException;
import modelo.jugador.UbicacionInvalidaException;
import modelo.jugador.presupuesto.CompraInvalidaException;
import modelo.jugador.presupuesto.PresupuestoAgotadoException;
import modelo.pieza.Pieza;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;
import vista.fasesPartida.faseInicialPartida.EtiquetaPresupuestoJugador;

public abstract class BotonAgregarPiezaEventHandler implements EventHandler<ActionEvent> {

    private TextField textFieldUno;
    private TextField textFieldDos;
    private Label textoComunicador;
    private VistaDeTablero vistaDeTablero;
    private EtiquetaPresupuestoJugador etiquetaPuntos;
    private String nombre;

    public BotonAgregarPiezaEventHandler(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPresupuestoJugador etiquetaPuntos, String nombre, Label etiquetaComunicadora) {

        textFieldUno = camposDeTexto.textoUno;
        textFieldDos = camposDeTexto.textoDos;
        textoComunicador = etiquetaComunicadora;
        this.vistaDeTablero = vistaDeTablero;
        this.etiquetaPuntos= etiquetaPuntos;
        this.nombre = nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.textFieldUno.getText().trim().equals("") || this.textFieldDos.getText().trim().equals("")) {

            this.textoComunicador.setText("Debe ingresar ambas coordenadas");
            this.textoComunicador.setTextFill(Color.web("#FF0000"));

        } else {

            try {
                String sX = this.textFieldUno.getText();
                String sY = this.textFieldDos.getText();
                int x = Integer.parseInt(sX);
                int y = Integer.parseInt(sY);
                crearPiezaYAgregarATablero(x, y, vistaDeTablero);
                etiquetaPuntos.actualizarEtiqueta();
            }

            catch (NumberFormatException e){
                this.textoComunicador.setText("Debe ingresar numeros");
                this.textoComunicador.setTextFill(Color.web("#FF0000"));
            }

        }
    }

    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero){
        try {
            this.textoComunicador.setText("Tropa agregada con exito");
            this.textoComunicador.setTextFill(Color.web("#336600"));
            Pieza pieza = etiquetaPuntos.juego.crearPieza(nombre, x, y);
            VistaDeUnidad vistaDeUnidad = new VistaDeUnidad(vistaDeTablero, pieza, nombre.toLowerCase());

        }
        catch ( PiezaFueraDeSectorException e){
            this.textoComunicador.setText("Ubica la pieza en tu sector.");
            this.textoComunicador.setTextFill(Color.web("#FF0000")); }
        catch (PresupuestoAgotadoException e){
            this.textoComunicador.setText("Ya puedes acabar tu turno.");
            this.textoComunicador.setTextFill(Color.web("#FF0000")); }
        catch (UbicacionInvalidaException e){
            this.textoComunicador.setText("Ya hay una pieza en la casilla.");
            this.textoComunicador.setTextFill(Color.web("#FF0000")); }
        catch (CompraInvalidaException  e){
            this.textoComunicador.setText("Presupuesto insuficiente para la pieza.");
            this.textoComunicador.setTextFill(Color.web("#FF0000")); }


    }

}