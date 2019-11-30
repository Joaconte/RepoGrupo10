package vista.botones.agregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarCatapultaEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonAgregarCatapulta extends Button {

    public BotonAgregarCatapulta(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarCatapultaEventHandler(camposDeTexto.textoUno, camposDeTexto.textoDos,
                camposDeTexto.etiquetaUno, vistaDeTablero));
        this.setText("Agregar catapulta");
    }
}
