package vista;


import controlador.*;
import javafx.scene.Group;
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
import vista.fasesPartida.faseMediaPartida.VistaPiezaClikeada;
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
    private Rectangle rectanguloDeMovimiento = new Rectangle(45,45,Color.rgb(0,0,0));
    private GridPane contenedorTabla;
    private Pane[][] casillaTabla;
    private VistaPiezaClikeada vistaUnidadClikeada = new VistaPiezaClikeada();
    private List<VistaUnidad> listaDeUnidades = new ArrayList<>();
    private List<VistaUnidad> listaDeUnidadesBajas = new ArrayList<>();
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

    public VistaPiezaClikeada getVistaDePiezaClikeada(){return vistaUnidadClikeada;}

    public void crearPanelesPorDefecto(){
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                Pane v = new Pane();
                v.setOnMouseClicked(new ClickEnZonaEventHandler(rectanguloDeMovimiento,v, this,vistaUnidadClikeada));
                v.setMinHeight(this.alturaCelda);
                v.setMinWidth(this.anchuraCelda);
                Background fondoDeContenedor = new Background(new BackgroundImage(new Image("resources/texturas/campo.jpg"),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        new BackgroundSize(42, 42, false, false, false, false)));
                v.setBackground(fondoDeContenedor);
                casillaTabla[i][j] = v;
                contenedorTabla.add(v , i, j);
            }
        }
    }

    public void actualizarTableroPorMuertas(){

        List <VistaUnidad> auxiliar = new ArrayList<>();
        listaDeUnidades.stream()
                .filter(VistaUnidad::getEstaMuerta)
                .forEach(p-> {Audio.reproducirMuerte(p.getNombre());
                    listaDeUnidadesBajas.add(p);
                    casillaTabla[p.getPosicionX()][p.getPosicionY()].getChildren().clear(); });
        listaDeUnidades.stream()
                .filter(p->!p.getEstaMuerta())
                .forEach(auxiliar::add);
        listaDeUnidades.clear();
        listaDeUnidades.addAll(auxiliar);
    }

    public void agregarUnidad(VistaUnidad etiquetaUnidad, int x, int y){
        casillaTabla[x][y].getChildren().add(0, etiquetaUnidad);
        listaDeUnidades.add(etiquetaUnidad);
    }

    public void tableroFaseMediaNormalizado(){
        listaDeUnidades.forEach(p->p.setOnMouseClicked(new ClickEnPiezaEventHandler(vistaUnidadClikeada,p)));
    }

    public void tableroEnModoAtaque(PiezaAtacante piezaAtacante){
        listaDeUnidades.forEach(p->p.setOnMouseClicked(new ClickEnPiezaAtaqueActivoEventHandler(vistaUnidadClikeada,p, piezaAtacante, this, stage)));
    }

    public void tableroEnModoCuracion(Curandero pieza){
        listaDeUnidades.forEach(p->p.setOnMouseClicked(new ClickEnPiezaModoCuracionEventHandler(vistaUnidadClikeada,p,pieza,this)));
    }


    public void tableroEnModoMovimiento(VistaUnidad vistaUnidad){
        rectanguloDeMovimiento.setVisible(false);
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                casillaTabla[i][j].setOnMouseClicked(new ClickEnPiezaModoMovimientoEventHandler(i, j, this, vistaUnidad,vistaUnidadClikeada));
            }
        }
    }

    public void restablecerTableroMovimiento(){
        rectanguloDeMovimiento.setVisible(true);
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                casillaTabla[i][j].setOnMouseClicked(new ClickEnZonaEventHandler(rectanguloDeMovimiento,casillaTabla[i][j], this,vistaUnidadClikeada));
            }
        }
    }

    public Tablero getTablero(){ return tablero;}

    public void tableroEnModoArmarBatallon(ArrayList<Pieza> piezas) {
        listaDeUnidades.forEach(p->p.setOnMouseClicked(new ClickEnPiezaModoCrearBatallonEventHandler(vistaUnidadClikeada,p,piezas,this)));

    }

    public void tableroEnModoMovimientoBatallon(VistaUnidad vistaUnidad) {
        rectanguloDeMovimiento.setVisible(false);
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                casillaTabla[i][j].setOnMouseClicked(new ClickEnPiezaModoMovimientoBatallonEventHandler(vistaUnidadClikeada,i, j, this, vistaUnidad));
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

    public void vistaComunicacion(String s) {
        vistaUnidadClikeada.vistaMensaje(s);
    }

    public List<VistaUnidad> getListaDeUnidades(){
        return listaDeUnidades;
    }

    public List<VistaUnidad> getListaDeUnidadesBajas(){
        return listaDeUnidadesBajas;
    }

}