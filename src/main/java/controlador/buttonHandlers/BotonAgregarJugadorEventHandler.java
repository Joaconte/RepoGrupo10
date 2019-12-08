package controlador.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Juego;
import vista.faseBienvenida.BotonIniciarPartida;
import vista.faseBienvenida.MenuCargaJugadores;

public class BotonAgregarJugadorEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private MenuCargaJugadores menuDeCargaDeJugadores;
    private BotonIniciarPartida botonIniciarPartida;
    private boolean primeraVez = true;

    public BotonAgregarJugadorEventHandler(Juego juego, MenuCargaJugadores menu, Stage stage) {

        this.juego = juego;
        this.menuDeCargaDeJugadores = menu;
        botonIniciarPartida=new BotonIniciarPartida(juego, stage);
        botonIniciarPartida.setDisable(true);
        botonIniciarPartida.setVisible(false);

    }

    @Override
    public void handle(ActionEvent actionEvent) {


        String jugadorUno = lectorDeNombres(menuDeCargaDeJugadores.getCargadoEnTextoUno());
        String jugadorDos = lectorDeNombres(menuDeCargaDeJugadores.getCargadoEnTextoDos());

        if (jugadorUno.isEmpty() || jugadorDos.isEmpty()) {
            botonIniciarPartida.setDisable(true);
            botonIniciarPartida.setVisible(false);
            menuDeCargaDeJugadores.comunicarEnEtiquetaUno("Ingresar dos nombres","#FF0000" );
            menuDeCargaDeJugadores.comunicarEnEtiquetaDos("e iniciar la partida.","#FF0000");

        } else if (jugadorUno.equals(jugadorDos)) {
            botonIniciarPartida.setDisable(true);
            botonIniciarPartida.setVisible(false);
            menuDeCargaDeJugadores.comunicarEnEtiquetaUno("Ingresar dos nombres distintos","#FF0000" );
            menuDeCargaDeJugadores.comunicarEnEtiquetaDos("e iniciar la partida.","#FF0000");


        } else if (jugadorUno.length() > 10 || jugadorDos.length() > 10 ) {
            botonIniciarPartida.setDisable(true);
            botonIniciarPartida.setVisible(false);
            menuDeCargaDeJugadores.comunicarEnEtiquetaUno("Ingresar dos nombres de menos","#FF0000" );
            menuDeCargaDeJugadores.comunicarEnEtiquetaDos("de 10 letras e iniciar la partida.","#FF0000");


        } else {

            menuDeCargaDeJugadores.comunicarEnEtiquetaUno("Jugador "+ jugadorUno + " agregado correctamente.","#336600" );
            menuDeCargaDeJugadores.comunicarEnEtiquetaDos("Jugador "+ jugadorDos + " agregado correctamente.","#336600");
            juego.agregarJugadores(jugadorUno, jugadorDos);
            botonIniciarPartida.setDisable(false);
            botonIniciarPartida.setVisible(true);

            if (primeraVez){
                primeraVez=false;
                menuDeCargaDeJugadores.getChildren().add(botonIniciarPartida);
            }
        }
    }

    public String lectorDeNombres(String textFieldDato){
       try{
            String primerCaracter = textFieldDato.substring(0,1).toUpperCase();
            String restoCaracteres = textFieldDato.substring(1).toLowerCase();
            return primerCaracter + restoCaracteres;
       }catch (  StringIndexOutOfBoundsException e){return "";}
    }
}
