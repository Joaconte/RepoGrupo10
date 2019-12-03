package vista.vistaPiezas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.pieza.Pieza;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.tipos.Curandero;
import vista.VistaDeTablero;

public class VistaCurandero extends VistaUnidad {

    Curandero curandero;
    VistaInformacionDeUnidad vistaDatos;
    VistaDeTablero vistaDeTablero;


    public VistaCurandero(Curandero curandero, VistaDeTablero vistaDeTablero){

        super();
        this.vistaDeTablero= vistaDeTablero;
        this.curandero =curandero;
        vistaParaTablero();
        vistaDatos = new VistaInformacionDeUnidad ("curandero", curandero);
        vistaDatos.setAlignment(Pos.CENTER);
        vistaDeDatos();
    }

    public void vistaParaTablero(){
        crearImagenPersonalizada("curandero", curandero);
        vistaDeTablero.agregarUnidad( this, curandero.getUbicacion().getPosicionEnX(), curandero.getUbicacion().getPosicionEnY() );
    }

    public void vistaDeDatos(){
        vistaDatos.getChildren().add(new Label("Unidad de Jugador " + curandero.getEquipo() ));
        vistaDatos.getChildren().add(new Label("Columna: " + curandero.getUbicacion().getPosicionEnX() ));
        vistaDatos.getChildren().add(new Label("Fila " +  curandero.getUbicacion().getPosicionEnY() ));
        vistaDatos.getChildren().add((new Label("Vida restante: " + curandero.getPuntosVida())));
    }


    @Override
    public Curandero getPieza() {
        return curandero;
    }

    @Override
    public VBox getVistaInformacion() {
        return vistaDatos;
    }
}