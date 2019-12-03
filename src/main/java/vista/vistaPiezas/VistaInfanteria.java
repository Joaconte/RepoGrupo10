package vista.vistaPiezas;

import javafx.scene.control.Label;
import modelo.pieza.tipos.Infanteria;
import vista.VistaDeTablero;

public class VistaInfanteria extends VistaDeUnidad {

    Infanteria infanteria;

    public VistaInfanteria(Infanteria infanteria, VistaDeTablero vistaDeTablero){
            super("infanteria",infanteria,vistaDeTablero);
            this.infanteria=infanteria;
            vistaParaTablero("infanteria");

            this.getChildren().add(new Label("Unidad de Jugador " + infanteria.getEquipo() ));
            this.getChildren().add(new Label("Columna: " + infanteria.getUbicacion().getPosicionEnX() ));
            this.getChildren().add(new Label("Fila " +  infanteria.getUbicacion().getPosicionEnY() ));
            this.getChildren().add((new Label("Vida restante: " +  infanteria.getPuntosVida())));

        //unidad.addObserver( this );
        //draw();
            //unidad.addObserver( this );
            //draw();
        }

        public void vistaParaTablero(String nombreClase){
            super.vistaParaTablero(nombreClase);
            this.vistaDeTablero.agregarUnidad(imagenDeUnidad, this, infanteria.getUbicacion().getPosicionEnX(), infanteria.getUbicacion().getPosicionEnY() );

        }
}