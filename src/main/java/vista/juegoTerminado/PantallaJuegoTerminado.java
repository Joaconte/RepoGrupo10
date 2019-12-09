package vista.juegoTerminado;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Juego;
import vista.BarraMenu;
import vista.VistaDeTablero;
import vista.vistaPiezas.VistaUnidad;

import java.util.ArrayList;
import java.util.List;


public class PantallaJuegoTerminado extends BorderPane {

    private String jugador1;
    private String jugador2;
    private Juego juego;
    private VistaDeTablero vistaDeTablero;

    public PantallaJuegoTerminado (Juego juego, Stage escenarioPrincipal, String textoResultado, VistaDeTablero vistaDeTablero){
        jugador1=juego.getNombreDeJugadorUno();
        jugador2=juego.getNombreDeJugadorDos();
        this.juego=juego;
        this.vistaDeTablero=vistaDeTablero;
        this.setMinWidth(1200);

        vistaDeFondo();
        setTop(textoResultado,escenarioPrincipal);
        setRight();
        setLeft();


    }

    private void vistaDeFondo(){
        Image imangenMuro = new Image("resources/texturas/fondopixel.jpg");
        Background fondoDeContenedor = new Background(new BackgroundImage(imangenMuro,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(90, 90, false, false, false, false)));
        this.setBackground(fondoDeContenedor);
    }


    private void setTop(String textoResultado,Stage escenario){

        VBox vBox = new VBox();
        vBox.getChildren().add(new BarraMenu(escenario,juego));
        vBox.setSpacing(15);

        Label etiqueta = new Label("¡Juego terminado! " + textoResultado + ". Asi quedaron las estadisticas.");
        etiqueta.setAlignment(Pos.CENTER);
        etiqueta.setFont(Font.font("tahoma", FontWeight.EXTRA_BOLD, 22));
        etiqueta.setTextFill(Color.rgb(243,156,4,0.8));

        vBox.getChildren().add(etiqueta);

        this.setTop(vBox);
    }

    private void setLeft(){
        this.setLeft(estadisticasUsuario(1,jugador1));
    }

    private void setRight(){
        this.setRight(estadisticasUsuario(2,jugador2));
    }

    private VBox estadisticasUsuario(int numeroUsuario, String nombreJugador){
        VBox barraEstadistica= new VBox();
        barraEstadistica.setSpacing(10);
        barraEstadistica.setMinHeight(900);


        Label etiqueta = new Label("Estadisticas jugador " + nombreJugador + ":");
        etiqueta.setFont(Font.font("tahoma", FontWeight.EXTRA_BOLD, 16));
        etiqueta.setAlignment(Pos.CENTER);

        Label etiqueta2 = new Label("Piezas vivas:");
        etiqueta.setFont(Font.font("tahoma", FontWeight.EXTRA_BOLD, 16));
        etiqueta2.setAlignment(Pos.CENTER);

        barraEstadistica.getChildren().addAll(etiqueta,etiqueta2);

        barraEstadistica.getChildren().addAll(
                contenedorEstadisticas(numeroUsuario,vistaDeTablero.getListaDeUnidades(), "catapulta"),
                contenedorEstadisticas(numeroUsuario,vistaDeTablero.getListaDeUnidades(), "jinete"),
                contenedorEstadisticas(numeroUsuario,vistaDeTablero.getListaDeUnidades(), "curandero"),
                contenedorEstadisticas(numeroUsuario,vistaDeTablero.getListaDeUnidades(), "infanteria"));

        Label etiqueta3 = new Label("Piezas caidas en accion::");
        etiqueta.setFont(Font.font("tahoma", FontWeight.EXTRA_BOLD, 16));
        etiqueta2.setAlignment(Pos.CENTER);

        barraEstadistica.getChildren().add(etiqueta3);


        barraEstadistica.getChildren().addAll(
                contenedorEstadisticas(numeroUsuario,vistaDeTablero.getListaDeUnidadesBajas(), "catapulta"),
                contenedorEstadisticas(numeroUsuario,vistaDeTablero.getListaDeUnidadesBajas(), "jinete"),
                contenedorEstadisticas(numeroUsuario,vistaDeTablero.getListaDeUnidadesBajas(), "curandero"),
                contenedorEstadisticas(numeroUsuario,vistaDeTablero.getListaDeUnidadesBajas(), "infanteria"));


        return barraEstadistica;
    }
    private HBox contenedorEstadisticas(int numeroUsuario, List<VistaUnidad> listaDeUnidades, String nombreUnidad) {
        HBox boxPieza = new HBox();

        List<VistaUnidad> listaDeUnidadesDelusuario=new ArrayList<>();
        listaDeUnidades.stream().filter(p->p.getPieza().getEquipo()==numeroUsuario).forEach(listaDeUnidadesDelusuario::add);

        listaDeUnidadesDelusuario.stream()
                .filter(p->p.getEquipo()==numeroUsuario && p.getNombre().equals(nombreUnidad))
                .forEach(p-> boxPieza.getChildren().add(p.getMiniAvatar()));
        return boxPieza;
    }


}
