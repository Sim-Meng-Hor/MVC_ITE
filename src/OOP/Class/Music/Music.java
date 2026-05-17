package OOP.Class.Music;

public class Music {
    String title;
    String artist;
    double duration;
    String genre;
    boolean isPlaying;

    void playMusic(){
        isPlaying = true;
        System.out.println("Music  is Playing...");
    }
    void pauseMusic(){
        isPlaying = false;
        System.out.println("Music is Paused");
    }

    Music(){}
    Music(String title, String artist, double duration, String genre){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
        this.isPlaying = false;
    }

    void getMusicInfo(){
            System.out.println("============ | Music Info | ===========");
            System.out.println("Title : " + title);
            System.out.println("Artist : " + artist);
            System.out.println("Duration : " + duration);
            System.out.println("Genre : " + genre);
            System.out.println("Is Playing : " + isPlaying);
    }
}
