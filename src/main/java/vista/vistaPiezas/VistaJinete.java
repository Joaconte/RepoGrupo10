package vista.vistaPiezas;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modelo.pieza.Pieza;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.tipos.Jinete;
import vista.VistaDeTablero;

public class VistaJinete extends VistaUnidad {

    Jinete jinete;
    VistaInformacionDeUnidad vistaDatos;
    VistaDeTablero vistaDeTablero;


    public VistaJinete(Jinete jinete, VistaDeTablero vistaDeTablero){

        super();
        this.vistaDeTablero= vistaDeTablero;
        this.jinete=jinete;
        vistaParaTablero();

        vistaDatos = new VistaInformacionDeUnidad ("jinete", jinete);
        vistaDatos.setAlignment(Pos.CENTER);
        vistaDeDatos();
    }

    public void vistaParaTablero(){
        crearImagenPersonalizada("jinete", jinete);
        vistaDeTablero.agregarUnidad(this, jinete.getUbicacion().getPosicionEnX(), jinete.getUbicacion().getPosicionEnY() );
    }

    public void vistaDeDatos(){
        vistaDatos.getChildren().add(new Label("Unidad de Jugador " + jinete.getEquipo() ));
        vistaDatos.getChildren().add(new Label("Columna: " + jinete.getUbicacion().getPosicionEnX() ));
        vistaDatos.getChildren().add(new Label("Fila " +  jinete.getUbicacion().getPosicionEnY() ));
        vistaDatos.getChildren().add((new Label("Vida restante: " + jinete.getPuntosVida())));
    }



    @Override
    public Jinete getPieza() {
        return jinete;
    }

    @Override
    public VBox getVistaInformacion() {
        return vistaDatos;
    }
}