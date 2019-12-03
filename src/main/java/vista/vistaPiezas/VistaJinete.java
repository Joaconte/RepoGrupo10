package vista.vistaPiezas;

import javafx.scene.control.Label;
import modelo.pieza.tipos.Jinete;
import vista.VistaDeTablero;

public class VistaJinete extends VistaDeUnidad {

    Jinete jinete;

    public VistaJinete(Jinete jinete, VistaDeTablero vistaDeTablero){
        super("jinete",jinete,vistaDeTablero);
        this.jinete=jinete;
        vistaParaTablero("jinete");

        this.getChildren().add(new Label("Unidad de Jugador " + jinete.getEquipo() ));
        this.getChildren().add(new Label("Columna: " + jinete.getUbicacion().getPosicionEnX() ));
        this.getChildren().add(new Label("Fila " +  jinete.getUbicacion().getPosicionEnY() ));
        this.getChildren().add((new Label("Vida restante: " + jinete.getPuntosVida())));


        //unidad.addObserver( this );
        //draw();
    }

    public void vistaParaTablero(String nombreClase){
        super.vistaParaTablero(nombreClase);
        this.vistaDeTablero.agregarUnidad(imagenDeUnidad, this, jinete.getUbicacion().getPosicionEnX(), jinete.getUbicacion().getPosicionEnY() );

    }
}