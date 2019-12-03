package resources.sonidos;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;


public class Audio {
    private static MediaPlayer mediaPlayer;
    private static String rutaSonido = "src/main/java/resources/sonidos/";

    // -------------- musica de fondo patallas ------------
    public static void reproducirIntro() {
        reproducir(rutaSonido+"intro.wav");
    }

    public static void reproducirCargaJugadores() {
        mediaPlayer.pause();
        reproducir(rutaSonido+"registro.wav");
    }
    public static void reproducirJugando() {
        mediaPlayer.pause();
        reproducir(rutaSonido+"jugando.wav");
    }

    public static void reproducirVictoria() {
        mediaPlayer.pause();
        reproducir(rutaSonido+"victoria.wav");
    }

    // ------------ efectos de sonido ----------

    public static void reproducirAlerta() {
        reproducirEfecto(rutaSonido+"alerta.wav");
    }

    public static void reproducirClick() {
        reproducirEfecto(rutaSonido+"click.wav");
    }

    public static void reproducirCatapultaRota() { reproducirEfecto(rutaSonido+"catapultaRota.wav");}

    public static void reproducirDolor() { reproducirEfecto(rutaSonido+"dolor.wav"); }

    public static void reproducirCreacionUnidad( String nombreUnidad){
        reproducir(rutaSonido + "creacion/" + nombreUnidad + ".wav");
    }
    // -----------------------------------------
    private static void reproducir (String path) {
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.setCycleCount(mediaPlayer.INDEFINITE);
    }

    private static void reproducirEfecto (String path) {
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
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