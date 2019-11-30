package vista.botones.agregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarInfanteriaEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;


public class BotonAgregarInfanteria extends Button {

    public BotonAgregarInfanteria(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarInfanteriaEventHandler(camposDeTexto.textoUno, camposDeTexto.textoDos,
                camposDeTexto.etiquetaUno, vistaDeTablero));
        this.setText("Agregar infanteria");
    }
}
