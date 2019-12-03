package vista.vistaPiezas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.pieza.Pieza;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.tipos.Catapulta;
import vista.VistaDeTablero;

public class VistaCatapulta extends VistaUnidad {
    Catapulta catapulta;
    VistaInformacionDeUnidad vistaDatos;
    VistaDeTablero vistaDeTablero;


    public VistaCatapulta(Catapulta catapulta, VistaDeTablero vistaDeTablero){

        super();
        this.vistaDeTablero= vistaDeTablero;
        this.catapulta =catapulta;
        vistaParaTablero();

        vistaDatos = new VistaInformacionDeUnidad ("catapulta", catapulta);
        vistaDatos.setAlignment(Pos.CENTER);
        vistaDeDatos();
    }

    public void vistaParaTablero(){
        crearImagenPersonalizada("catapulta", catapulta);
        vistaDeTablero.agregarUnidad(this, catapulta.getUbicacion().getPosicionEnX(), catapulta.getUbicacion().getPosicionEnY() );
    }

    public void vistaDeDatos(){
        vistaDatos.getChildren().add(new Label("Unidad de Jugador " + catapulta.getEquipo() ));
        vistaDatos.getChildren().add(new Label("Columna: " + catapulta.getUbicacion().getPosicionEnX() ));
        vistaDatos.getChildren().add(new Label("Fila " +  catapulta.getUbicacion().getPosicionEnY() ));
        vistaDatos.getChildren().add((new Label("Vida restante: " + catapulta.getPuntosVida())));
    }

    @Override
    public Catapulta getPieza() {
        return catapulta;
    }

    @Override
    public VBox getVistaInformacion() {
        return vistaDatos;
    }
}