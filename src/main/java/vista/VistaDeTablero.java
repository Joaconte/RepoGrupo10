package vista;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import modelo.tablero.Tablero;


public class VistaDeTablero extends Group {

    public int altura;
    public int anchura;
    private int alturaCelda = 45;
    private int anchuraCelda = 45;
    private Tablero tablero;

    private GridPane table;
    private Pane[][] panes;

    public VistaDeTablero(Tablero tablero){

        this.tablero = tablero;
        table = new GridPane();
        anchura = anchuraCelda * tablero.getColumnas();
        altura = alturaCelda * tablero.getFilas();
        panes = new Pane[anchura][altura];

        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                Pane v = new Pane();
                v.setMinHeight(this.alturaCelda);
                v.setMinWidth(this.anchuraCelda);
                panes[i][j] = v;
                table.add(v , i, j);
            }
        }

        Background bi = new Background(new BackgroundImage(new Image("tablero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.anchura, this.altura, false, false, false, false)));
        table.setBackground(bi);

        this.addView(table);
    }

    public void agregarUnidad(Node unidad, int x, int y){

        GridPane.setRowIndex(unidad, x);
        GridPane.setColumnIndex(unidad, y);
        table.getChildren().add(unidad);
        addViewOnMap(unidad, x, y);
    }

    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < anchura; i++) {
            for (int j = 0; j < altura; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        panes[x][y].getChildren().add(0, view);
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
