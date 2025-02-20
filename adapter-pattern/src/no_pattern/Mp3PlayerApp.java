package no_pattern;

public class Mp3PlayerApp {
    public static void main(String[] args) {
        Mp3Player mp3Player = new Mp3Player();
        mp3Player.playMp3("song.mp3");

        WavPlayer wavPlayer = new WavPlayer();
        wavPlayer.playMp3("song.wav");

        FlacPlayer flacPlayer = new FlacPlayer();
        flacPlayer.playMp3("song.flac");
    }
}


class Mp3Player {
    public void playMp3(String fileName) {
        System.out.println("Playing mp3 file: " + fileName);
    }
}

class WavPlayer {
    public void playMp3(String fileName) {
        System.out.println("Playing wav file: " + fileName);
    }
}

class FlacPlayer {
    public void playMp3(String fileName) {
        System.out.println("Playing flac file: " + fileName);
    }
}