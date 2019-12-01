package vista;


import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modelo.tablero.Tablero;


public class VistaDeTablero extends Group {

    public int altura;
    public int anchura;
    private int alturaCelda = 45;
    private int anchuraCelda = 45;
    private Tablero tablero;
    private Rectangle rectangulo = new Rectangle(45,45,Color.rgb(0,0,0,0.4));

    private GridPane contenedorTabla;
    private Pane[][] casillaTabla;

    public VistaDeTablero(Tablero tablero){

        this.tablero = tablero;
        contenedorTabla = new GridPane();
        anchura = anchuraCelda * tablero.getColumnas();
        altura = alturaCelda * tablero.getFilas();
        casillaTabla = new Pane[anchura][altura];
        contenedorTabla.add(rectangulo,9,9);

        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                Pane v = new Pane();
                v.setMinHeight(this.alturaCelda);
                v.setMinWidth(this.anchuraCelda);
                casillaTabla[i][j] = v;
                contenedorTabla.add(v , i, j);
            }
        }

        Background fondoDeContenedor = new Background(new BackgroundImage(new Image("resources/tablero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.anchura, this.altura, false, false, false, false)));
        contenedorTabla.setBackground(fondoDeContenedor);

        this.addView(contenedorTabla);
    }

    public Rectangle getCirculo(){
        return rectangulo;
    }

    public void agregarUnidad(Node unidad, int x, int y){

        GridPane.setRowIndex(unidad, x);
        GridPane.setColumnIndex(unidad, y);
        contenedorTabla.getChildren().add(unidad);
        addViewOnMap(unidad, x, y);
    }

    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < anchura; i++) {
            for (int j = 0; j < altura; j++) {
                try {
                    casillaTabla[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        casillaTabla[x][y].getChildren().add(0, view);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }

    public Tablero getTablero(){ return tablero;}

}