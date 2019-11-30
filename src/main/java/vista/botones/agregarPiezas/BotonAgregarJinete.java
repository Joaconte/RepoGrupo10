package vista.botones.agregarPiezas;

import controlador.buttonHandlers.agregarPiezasEventHandlers.BotonAgregarJineteEventHandler;
import javafx.scene.control.Button;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class BotonAgregarJinete extends Button {

    public BotonAgregarJinete(CamposDeTexto camposDeTexto, VistaDeTablero vistaDeTablero) {

        super();
        this.setMinHeight(20);
        this.setOnAction(new BotonAgregarJineteEventHandler(camposDeTexto.textoUno, camposDeTexto.textoDos,
                camposDeTexto.etiquetaUno, vistaDeTablero));
        this.setText("Agregar jinete");
    }
}
