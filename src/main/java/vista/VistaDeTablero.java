package vista;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.tablero.Tablero;


public class VistaDeTablero extends Group {

    public int altura;
    public int anchura;
    private int alturaCelda = 45;
    private int anchuraCelda = 45;

    private GridPane table;
    private Pane[][] panes;

    public VistaDeTablero(Tablero tablero){

        table = new GridPane();
        anchura = anchuraCelda * tablero.getColumnas();
        altura = alturaCelda * tablero.getFilas();
        panes = new Pane[ (int)anchura][(int)altura];

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

    private void mostrarFondo(VBox vbox, Stage stage){
        Image image = new Image("Tablero.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        vbox.getChildren().add(imageView);
        stage.sizeToScene();
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

}
