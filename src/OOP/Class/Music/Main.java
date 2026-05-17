package OOP.Class.Music;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Music music1 = new Music();

        music1.title = "Shape of You";
        music1.artist = "Ed Sheeran";
        music1.duration = 4.5;
        music1.genre = "Pop";
        music1.isPlaying = false;

        music1.getMusicInfo();
        music1.playMusic();
        music1.pauseMusic();
    }
}
