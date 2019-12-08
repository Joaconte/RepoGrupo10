package vista.fasesPartida.faseInicialPartida;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Juego;
import resources.sonidos.Audio;
import vista.VistaDeTablero;

public class PantallaFaseInicialPartida extends HBox {

    public PantallaFaseInicialPartida(Juego juego, Stage escenarioPrincipal){
        Audio.reproducirMusica("registro");
        escenarioPrincipal.setFullScreen(true);
        this.setSpacing(15);
        vistaDeFondo();
        VistaDeTablero vistaDeTablero = new VistaDeTablero(juego.getTablero(), escenarioPrincipal);
        BarraLateralOpciones barraLateral = new BarraLateralOpciones(juego, vistaDeTablero, escenarioPrincipal);

        this.getChildren().add(vistaDeTablero);
        this.getChildren().add(barraLateral);
    }

    private void vistaDeFondo(){
        Image imangenMuro = new Image("resources/texturas/muro2.jpg");
        Background fondoDeContenedor = new Background(new BackgroundImage(imangenMuro,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(90, 90, false, false, false, false)));
        this.setBackground(fondoDeContenedor);
    }





}
