package vista.vistaPiezas;

import javafx.scene.control.Label;
import modelo.pieza.tipos.Curandero;
import vista.VistaDeTablero;

public class VistaCurandero extends VistaDeUnidad {

    Curandero curandero;

    public VistaCurandero(Curandero curandero, VistaDeTablero vistaDeTablero){
        super("curandero",curandero,vistaDeTablero);
        this.curandero=curandero;
        vistaParaTablero("curandero");

        this.getChildren().add(new Label("Unidad de Jugador " + curandero.getEquipo() ));
        this.getChildren().add(new Label("Columna: " + curandero.getUbicacion().getPosicionEnX() ));
        this.getChildren().add(new Label("Fila " +  curandero.getUbicacion().getPosicionEnY() ));
        this.getChildren().add((new Label("Vida restante: " +  curandero.getPuntosVida())));

        //unidad.addObserver( this );
        //draw();
    }

    public void vistaParaTablero(String nombreClase){
        super.vistaParaTablero(nombreClase);
        this.vistaDeTablero.agregarUnidad(imagenDeUnidad, this, curandero.getUbicacion().getPosicionEnX(), curandero.getUbicacion().getPosicionEnY() );

    }

}