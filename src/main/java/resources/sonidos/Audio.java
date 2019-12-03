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

    }

}