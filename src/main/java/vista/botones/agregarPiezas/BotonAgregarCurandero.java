package vista.botones.agregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarCuranderoEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;


public class BotonAgregarCurandero extends Button {

    public BotonAgregarCurandero(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarCuranderoEventHandler(camposDeTexto.textoUno, camposDeTexto.textoDos,
                camposDeTexto.etiquetaUno, vistaDeTablero));
        this.setText("Agregar curandero");
    }
}
