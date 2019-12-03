package resources.sonidos;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;


public class Audio {
    private static MediaPlayer mediaPlayer;
    private static String rutaSonido = "src/main/java/resources/sonidos/";

    public static void reproducirIntro() {
        reproducir(rutaSonido+"intro.wav");
    }

    public static void reproducirAlerta() {
        reproducir(rutaSonido+"alerta.wav");
    }

    public static void reproducirClick() {
        reproducir(rutaSonido+"click.wav");
    }

    public static void reproducirJugando() {
        mediaPlayer.pause();
        reproducir(rutaSonido+"jugando.wav");
    }

    public static void reproducirVictoria() {
        //mediaPlayer.pause();
        reproducir(rutaSonido+"victoria.wav");
    }
    private static void reproducir (String path) {
        Media media = new Media(new File(path).toURI().toString());
        //Media media = new Media(Audio.class.getResource(path).toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.5);

    }

    public static void mutear(){
        if (mediaPlayer.isMute()){
            mediaPlayer.setMute(false);
        } else {
            mediaPlayer.setMute(true);
        }
    }

    public static void reproducirCreacionUnidad( String nombreUnidad){
        reproducir(rutaSonido + "creacion/" + nombreUnidad + ".wav");
    }

    public static void bajarVolumen(){
        mediaPlayer.setVolume(Math.max(0,mediaPlayer.getVolume()-0.1));
    }

    public static void subirVolumen(){
        mediaPlayer.setVolume(mediaPlayer.getVolume()+0.1);
    }
}