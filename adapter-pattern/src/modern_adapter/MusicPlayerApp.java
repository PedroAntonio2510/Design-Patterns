package modern_adapter;

public class MusicPlayerApp {
    public static void main(String[] args) {
        var mp3Player = new Mp3Player();
        AudioPlayer audioPlayer = filename -> mp3Player.playMp3(filename);
        audioPlayer.play("song.mp3");

        var wavPlayer = new WavPlayer();
        audioPlayer = fileName -> wavPlayer.playWav(fileName);
        audioPlayer.play("song.wav");

        var flacPlayer = new FlacPlayer();
        audioPlayer = fileName -> flacPlayer.playFlac(fileName);
        audioPlayer.play("song.flac");
    }
}

// 1 - Target Interface
@FunctionalInterface
interface AudioPlayer {
    void play(String fileName);
}

// 2 - Adaptee
class WavPlayer {
    public void playWav(String fileName) {
        System.out.println("Playing wav file: " + fileName);
    }
}

class FlacPlayer {
    public void playFlac(String fileName) {
        System.out.println("Playing flac file: " + fileName);
    }
}

class Mp3Player {
    public void playMp3(String fileName) {
        System.out.println("Playing mp3 file: " + fileName);
    }
}
