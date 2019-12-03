package vista.vistaPiezas;

import javafx.scene.control.Label;
import modelo.pieza.tipos.Catapulta;
import vista.VistaDeTablero;

public class VistaCatapulta extends VistaDeUnidad {

    Catapulta catapulta;

    public VistaCatapulta(Catapulta catapulta, VistaDeTablero vistaDeTablero){
        super("catapulta",catapulta,vistaDeTablero);
        this.catapulta=catapulta;
        vistaParaTablero("catapulta");

        this.getChildren().add(new Label("Unidad de Jugador " + catapulta.getEquipo() ));
        this.getChildren().add(new Label("Columna: " + catapulta.getUbicacion().getPosicionEnX() ));
        this.getChildren().add(new Label("Fila " +  catapulta.getUbicacion().getPosicionEnY() ));
        this.getChildren().add((new Label("Vida restante: " +  catapulta.getPuntosVida())));

    }

    public void vistaParaTablero(String nombreClase){
        super.vistaParaTablero(nombreClase);
        this.vistaDeTablero.agregarUnidad(imagenDeUnidad, this, catapulta.getUbicacion().getPosicionEnX(), catapulta.getUbicacion().getPosicionEnY() );

    }

}