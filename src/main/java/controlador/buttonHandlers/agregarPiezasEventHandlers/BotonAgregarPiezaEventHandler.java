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
import modelo.pieza.tipos.Jinete;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.VistaDeUnidad;
import vista.faseInicial.EtiquetaPuntosJugador;

public abstract class BotonAgregarPiezaEventHandler implements EventHandler<ActionEvent> {

    private TextField textFieldUno;
    private TextField textFieldDos;
    private Label labelUno;
    private VistaDeTablero vistaDeTablero;
    protected EtiquetaPuntosJugador etiquetaPuntos;
    private  String nombre;

    public void initialize(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos, String nombre) {

        textFieldUno = camposDeTexto.textoUno;
        textFieldDos = camposDeTexto.textoDos;
        labelUno = camposDeTexto.etiquetaUno;
        this.vistaDeTablero = vistaDeTablero;
        this.etiquetaPuntos= etiquetaPuntos;
        this.nombre = nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.textFieldUno.getText().trim().equals("") || this.textFieldDos.getText().trim().equals("")) {

            this.labelUno.setText("Debe ingresar ambas coordenadas");
            this.labelUno.setTextFill(Color.web("#FF0000"));

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
                this.labelUno.setText("Debe ingresar numeros");
                this.labelUno.setTextFill(Color.web("#FF0000"));
            }

        }
    }

    public void crearPiezaYAgregarATablero(int x, int y, VistaDeTablero vistaDeTablero){
        try {
            Pieza pieza = etiquetaPuntos.juego.crearPieza(nombre, x, y);
            this.labelUno.setText("Pieza ubicada con exito.");
            VistaDeUnidad vistaDeUnidad = new VistaDeUnidad(vistaDeTablero, pieza, nombre.toLowerCase());

        }
        catch (UbicacionInvalidaException | PiezaFueraDeSectorException e){
            this.labelUno.setText("Ubica la pieza en una casilla libre de tu sector.");
            this.labelUno.setTextFill(Color.web("#FF0000")); }
        catch (PresupuestoAgotadoException | CompraInvalidaException e){
            this.labelUno.setText("Presupuesto insuficiente para la compra.");
            this.labelUno.setTextFill(Color.web("#FF0000")); }


    }

}