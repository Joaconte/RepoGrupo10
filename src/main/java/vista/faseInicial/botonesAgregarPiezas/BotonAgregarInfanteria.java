package vista.faseInicial.botonesAgregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarCuranderoEventHandler;
import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarInfanteriaEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;
import vista.faseInicial.EtiquetaPuntosJugador;

public class BotonAgregarInfanteria extends Button {

    public BotonAgregarInfanteria(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero, EtiquetaPuntosJugador etiquetaPuntos) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarCuranderoEventHandler(camposDeTexto.textoUno, camposDeTexto.textoDos,
                camposDeTexto.etiquetaUno, vistaDeTablero, etiquetaPuntos));
        this.setText("Agregar infanteria");
    }
}
