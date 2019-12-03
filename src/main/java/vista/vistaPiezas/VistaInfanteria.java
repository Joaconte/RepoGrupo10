package vista.vistaPiezas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.pieza.Pieza;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.tipos.Infanteria;
import vista.VistaDeTablero;

public class VistaInfanteria extends VistaUnidad {

    Infanteria infanteria;
    VistaInformacionDeUnidad vistaDatos;
    VistaDeTablero vistaDeTablero;


    public VistaInfanteria(Infanteria infanteria, VistaDeTablero vistaDeTablero){

        super();
        this.vistaDeTablero= vistaDeTablero;
        this.infanteria=infanteria;
        vistaParaTablero();

        vistaDatos = new VistaInformacionDeUnidad ("infanteria", infanteria);
        vistaDatos.setAlignment(Pos.CENTER);
        vistaDeDatos();
    }

    public void vistaParaTablero(){
        crearImagenPersonalizada("jinete", infanteria);
        vistaDeTablero.agregarUnidad( this, infanteria.getUbicacion().getPosicionEnX(), infanteria.getUbicacion().getPosicionEnY() );
    }

    public void vistaDeDatos(){
        vistaDatos.getChildren().add(new Label("Unidad de Jugador " + infanteria.getEquipo() ));
        vistaDatos.getChildren().add(new Label("Columna: " + infanteria.getUbicacion().getPosicionEnX() ));
        vistaDatos.getChildren().add(new Label("Fila " +  infanteria.getUbicacion().getPosicionEnY() ));
        vistaDatos.getChildren().add((new Label("Vida restante: " + infanteria.getPuntosVida())));
    }


    @Override
    public Infanteria getPieza() {
        return infanteria;
    }

    @Override
    public VBox getVistaInformacion() {
        return vistaDatos;
    }
}