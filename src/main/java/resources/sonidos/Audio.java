package resources.sonidos;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;


public class Audio {
    private static MediaPlayer mediaPlayer = null;
    private static MediaPlayer player = null;
    private static String rutaSonido = "src/main/java/resources/sonidos/";

    // -------------- musica de fondo pantallas ------------
    // genericos. conociendo nombre del archivo wav
    public static void reproducirMusica(String nombre){
        reproducir(rutaSonido+"musica/"+nombre+".wav");
    }

    // Particulares. estandar
    public static void reproducirIntro() {

        reproducir(rutaSonido+"intro.wav");
        mediaPlayer.setVolume(0.08);
    }

    public static void reproducirCargaJugadores() {
        mediaPlayer.pause();
        reproducir(rutaSonido + "musica/registro.wav");
    }
    public static void reproducirJugando() {
        mediaPlayer.pause();
        reproducir(rutaSonido+"/musica/jugando.wav");
        mediaPlayer.setVolume(0.08);
    }

    public static void reproducirVictoria() {
        mediaPlayer.pause();
        reproducir(rutaSonido+"musica/victoria.wav");
    }

    // ------------ efectos de sonido ----------
    public static void reproducirAtaque(String nombre){
        reproducirEfecto(rutaSonido+"/ataque/"+nombre+".wav");
    }

    public static void reproducirInterfaz(String nombre){
        reproducirEfecto(rutaSonido+"/interfaz/"+nombre+".wav");
    }

    public static void reproducirMovimiento(String nombre){
        reproducirEfecto(rutaSonido+"/movimiento/"+nombre+".wav");
    }

    public static void reproducirMuerte(String nombre){
        reproducirEfecto(rutaSonido+"/muerte/"+nombre+".wav");
    }

    public static void reproducirCreacionUnidad( String nombreUnidad){
        reproducirEfecto(rutaSonido + "creacion/" + nombreUnidad + ".wav");
    }

    public static void reproducirAlerta(){
        reproducirEfecto(rutaSonido+"interfaz/alerta.wav");
    }

    public static void reproducirClick() {
        reproducirEfecto(rutaSonido+"interfaz/click.wav");
    }


    // -----------------------------------------
    private static void reproducir (String path) {
        if ( mediaPlayer != null){
            mediaPlayer.pause();
        }
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);

    }

    private static void reproducirEfecto(String path) {
        Media media = new Media(new File(path).toURI().toString());
        player = new MediaPlayer(media);
        player.setVolume(8);
        player.play();
    }

    public static void mutear(){
        if (mediaPlayer.isMute()){
            mediaPlayer.setMute(false);
        } else {
            mediaPlayer.setMute(true);
        }
    }

    public static void bajarVolumen(){
        mediaPlayer.setVolume(Math.max(0,mediaPlayer.getVolume()-0.1));
    }

    public static void subirVolumen(){
        mediaPlayer.setVolume(mediaPlayer.getVolume()+0.1);
    }
}