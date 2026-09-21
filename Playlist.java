import java.util.Arrays;
import java.util.Scanner;

public class Playlist {

    private String[] songs;
    private int songCount;

    public Playlist(int maximumSize) {
        songs = new String[maximumSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount >= songs.length) {
            System.out.println("Playlist is full.");
            return;
        }

        if (song == null || song.trim().isEmpty()) {
            System.out.println("Invalid song name.");
            return;
        }

        songs[songCount] = song;
        songCount++;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);

        playlist.addSong("Song A");
        playlist.addSong("Song B");

        String[] copy = playlist.getSongs();

        System.out.println("Songs before changing copy:");
        System.out.println(Arrays.toString(playlist.getSongs()));

        copy[0] = "Hacked";

        System.out.println("Changed copy:");
        System.out.println(Arrays.toString(copy));

        System.out.println("Actual playlist:");
        System.out.println(Arrays.toString(playlist.getSongs()));

        System.out.println("Song count: "
                + playlist.getSongCount());
    }
}