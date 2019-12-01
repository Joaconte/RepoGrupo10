package vista.fasePartida.botonesMoverEnTablero;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import vista.CamposDeTexto;
import vista.VistaDeTablero;

public class PanelDeDirecciones extends GridPane {
    public PanelDeDirecciones (VistaDeTablero vistaDeTablero, CamposDeTexto camposDeTexto){
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.add(new BotonMoverArriba(vistaDeTablero, camposDeTexto),1,0);
        this.add(new BotonMoverAbajo(vistaDeTablero, camposDeTexto),1,3);
        this.add(new BotonMoverDerecha(vistaDeTablero, camposDeTexto),2,2);
        this.add(new BotonMoverIzquierda(vistaDeTablero,camposDeTexto),0,2);

    }
}
