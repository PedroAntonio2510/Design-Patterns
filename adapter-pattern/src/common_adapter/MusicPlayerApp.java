package common_adapter;

public class MusicPlayerApp {
    public static void main(String[] args) {
        AudioPlayer mp3Player = new Mp3Player();
        mp3Player.play("song.mp3");

        AudioPlayer wavAdapter = new WavAdapter(new WavPlayer());
        wavAdapter.play("song.wav");

        AudioPlayer flacAdapter = new FlacAdapter(new FlacPlayer());
        flacAdapter.play("song.flac");


    }
}

// 1 - target Interface
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

// 3 - Adapters
class WavAdapter implements AudioPlayer {
    private WavPlayer wavPlayer;

    public WavAdapter(WavPlayer wavPlayer) {
        this.wavPlayer = wavPlayer;
    }

    @Override
    public void play(String fileName) {
        wavPlayer.playWav(fileName);
    }
}

class FlacAdapter implements AudioPlayer {
    private FlacPlayer flacPlayer;

    public FlacAdapter(FlacPlayer flacPlayer) {
        this.flacPlayer = flacPlayer;
    }

    @Override
    public void play(String fileName) {
        flacPlayer.playFlac(fileName);
    }
}

class Mp3Player implements AudioPlayer{
    public void play(String fileName) {
        System.out.println("Playing mp3 file: " + fileName);
    }
}