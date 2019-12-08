package vista;


import controlador.*;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import modelo.pieza.Pieza;
import modelo.pieza.ataque.PiezaAtacante;
import modelo.pieza.tipos.Curandero;
import modelo.tablero.Tablero;

import resources.sonidos.Audio;
import vista.vistaPiezas.VistaUnidad;
import java.util.ArrayList;
import java.util.List;


public class VistaDeTablero extends Group {

    public int altura;
    public int anchura;
    private int alturaCelda = 45;
    private int anchuraCelda = 45;
    private Stage stage;
    private Tablero tablero;
    private Rectangle rectanguloDeMovimiento = new Rectangle(45,45,Color.rgb(0,0,0,0.4));
    private GridPane contenedorTabla;
    private Pane[][] casillaTabla;
    private VBox vistaUnidadClikeada = new VBox();
    private List<VistaUnidad> listaDeUnidades = new ArrayList<>();
    int ubicacionDelCursorX;
    int ubicacionDelCursorY;


    public VistaDeTablero(Tablero tablero, Stage stage){

        this.stage=stage;
        this.tablero = tablero;
        contenedorTabla = new GridPane();
        anchura = anchuraCelda * tablero.getColumnas();
        altura = alturaCelda * tablero.getFilas();
        casillaTabla = new Pane[anchura][altura];
        contenedorTabla.add(rectanguloDeMovimiento,9,9);
        ubicacionDelCursorY=9;
        ubicacionDelCursorX=9;

        crearPanelesPorDefecto();

        Background fondoDeContenedor = new Background(new BackgroundImage(new Image("resources/texturas/tablero.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.anchura, this.altura, false, false, false, false)));
        contenedorTabla.setBackground(fondoDeContenedor);

        this.getChildren().add(contenedorTabla);
    }



    public VBox getVistaDePiezaClikeada(){return vistaUnidadClikeada;}

    public void crearPanelesPorDefecto(){
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                Pane v = new Pane();
                v.setOnMouseClicked(new ClickEnZonaEventHandler(rectanguloDeMovimiento,v, this));
                v.setMinHeight(this.alturaCelda);
                v.setMinWidth(this.anchuraCelda);
                casillaTabla[i][j] = v;
                contenedorTabla.add(v , i, j);
            }
        }
    }

    public void actualizarTableroPorMuertas(){
        List <VistaUnidad> auxiliar = new ArrayList<>();
        listaDeUnidades.stream()
                .filter(p-> p.getPieza().estaMuerta())
                .forEach(p-> {Audio.reproducirMuerte(p.getNombre());
                    casillaTabla[p.getPieza().getPosicionEnColumnaQueOcupa()][p.getPieza().getPosicionEnColumnaQueOcupa()].getChildren().clear(); });
        listaDeUnidades.stream()
                .filter(p->p.getPieza().getPuntosVida()>0)
                .forEach(auxiliar::add);
        listaDeUnidades.clear();
        listaDeUnidades.addAll(auxiliar);
    }


    public void agregarUnidad(VistaUnidad etiquetaUnidad, int x, int y){
        casillaTabla[x][y].getChildren().add(0, etiquetaUnidad);
        listaDeUnidades.add(etiquetaUnidad);
    }

    public void tableroNormal(){
        listaDeUnidades.forEach(p->p.setOnMouseClicked(new ClickEnPiezaEventHandler(vistaUnidadClikeada,p)));
    }

    public void tableroEnModoAtaque(PiezaAtacante piezaAtacante){
        listaDeUnidades.forEach(p->p.setOnMouseClicked(new ClickEnPiezaAtaqueActivoEventHandler(vistaUnidadClikeada,p, piezaAtacante, this, stage)));
    }

    public void tableroEnModoCuracion(Curandero pieza){
        listaDeUnidades.forEach(p->p.setOnMouseClicked(new ClickEnPiezaModoCuracionEventHandler(vistaUnidadClikeada,p,pieza,this)));
    }


    public void tableroEnModoMovimiento(VistaUnidad vistaUnidad, Label etiquetaTexto){
        rectanguloDeMovimiento.setVisible(false);
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                casillaTabla[i][j].setOnMouseClicked(new ClickEnPiezaModoMovimientoEventHandler(i, j, this, vistaUnidad,etiquetaTexto));
            }
        }
    }

    public void restablecerTableroMovimiento(){
        rectanguloDeMovimiento.setVisible(true);
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                casillaTabla[i][j].setOnMouseClicked(new ClickEnZonaEventHandler(rectanguloDeMovimiento,casillaTabla[i][j], this));
            }
        }
    }

    public Tablero getTablero(){ return tablero;}

    public void tableroEnModoArmarBatallon(ArrayList<Pieza> piezas) {
        listaDeUnidades.forEach(p->p.setOnMouseClicked(new ClickEnPiezaModoCrearBatallonEventHandler(vistaUnidadClikeada,p,piezas,this)));

    }

    public void tableroEnModoMovimientoBatallon(VistaUnidad vistaUnidad, Label etiquetaTexto) {
        rectanguloDeMovimiento.setVisible(false);
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                casillaTabla[i][j].setOnMouseClicked(new ClickEnPiezaModoMovimientoBatallonEventHandler(i, j, this, vistaUnidad,etiquetaTexto));
            }
        }
    }


    private void vaciarPaneles(){
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                casillaTabla[i][j].getChildren().clear();
                }
            }
        }


    public void actualizarUbicaciones() {
        vaciarPaneles();
        listaDeUnidades.forEach(p-> casillaTabla[p.getPieza().getPosicionEnColumnaQueOcupa()][p.getPieza().getPosicionEnFilaQueOcupa()].getChildren().add(p));

    }

    public void setUbicacionClik(Integer columnIndex, Integer rowIndex) {
        ubicacionDelCursorX=columnIndex;
        ubicacionDelCursorY=rowIndex;
    }
    public int getUbicacionDelCursorX(){
        return ubicacionDelCursorX;
    }
    public int getUbicacionDelCursorY(){
        return ubicacionDelCursorY;
    }
}