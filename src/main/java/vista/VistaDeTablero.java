package vista;


import controlador.ClickEnPiezaEventHandler;
import controlador.ClickEnZonaEventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.Juego;
import modelo.pieza.Ubicacion;
import modelo.tablero.Tablero;
import vista.vistaPiezas.VistaDeUnidad;


public class VistaDeTablero extends Group {

    public int altura;
    public int anchura;
    private int alturaCelda = 45;
    private int anchuraCelda = 45;
    private Tablero tablero;
    private Rectangle rectanguloDeMovimiento = new Rectangle(45,45,Color.rgb(0,0,0,0.4));
    private GridPane contenedorTabla;
    private Pane[][] casillaTabla;
    private Ubicacion ubicacionDelCursor;
    private VistaDeUnidad vistaPiezaClikeada;

    public VistaDeTablero(Tablero tablero){

        this.tablero = tablero;
        this.ubicacionDelCursor =new Ubicacion(9,9);
        this.vistaPiezaClikeada = new VistaDeUnidad();
        contenedorTabla = new GridPane();
        anchura = anchuraCelda * tablero.getColumnas();
        altura = alturaCelda * tablero.getFilas();
        casillaTabla = new Pane[anchura][altura];
        contenedorTabla.add(rectanguloDeMovimiento,9,9);

        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                Pane v = new Pane();
                v.setOnMouseClicked(new ClickEnZonaEventHandler(rectanguloDeMovimiento,v, ubicacionDelCursor));
                v.setMinHeight(this.alturaCelda);
                v.setMinWidth(this.anchuraCelda);
                casillaTabla[i][j] = v;
                contenedorTabla.add(v , i, j);
            }
        }

        Background fondoDeContenedor = new Background(new BackgroundImage(new Image("resources/texturas/tablero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.anchura, this.altura, false, false, false, false)));
        contenedorTabla.setBackground(fondoDeContenedor);

        this.getChildren().add(contenedorTabla);
    }

    public Rectangle getRectanguloDeMovimiento(){
        return rectanguloDeMovimiento;
    }
    public Ubicacion getUbicacionDelCursor(){return ubicacionDelCursor;}
    public VBox getVistaDePiezaClikeada(){return vistaPiezaClikeada;}

    public void agregarUnidad(Node unidadImagen, VistaDeUnidad piezaClikeada,  int x, int y){

        GridPane.setRowIndex(unidadImagen, x);
        GridPane.setColumnIndex(unidadImagen, y);
        contenedorTabla.getChildren().add(unidadImagen);
        casillaTabla[x][y].getChildren().add(0, unidadImagen);
        unidadImagen.setOnMouseClicked(new ClickEnPiezaEventHandler(unidadImagen,vistaPiezaClikeada,piezaClikeada));
    }

    public void moverUnidad(Ubicacion ubicacionInicial){

        Node unidadImagen = vistaPiezaClikeada.getImagenDeUnidad();
        vistaPiezaClikeada.setUbicacion(ubicacionDelCursor);
        agregarUnidad(unidadImagen, vistaPiezaClikeada, ubicacionDelCursor.getPosicionEnX(), ubicacionDelCursor.getPosicionEnY());

    }


    public Tablero getTablero(){ return tablero;}

}