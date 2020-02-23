import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {

    private String albumTitle;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String artist, String albumTitle){
        this.artist = artist;
        this.albumTitle = albumTitle;
        this.songs = new ArrayList<Song>();
    }



    public void addSongIntoAlbum(String songTitle, double duration){
        if(!isSongPresent(songTitle)) {
            this.songs.add(new Song(songTitle, duration));
            System.out.println(songTitle + " successfully added into " + albumTitle);
        } else{
            System.out.println(songTitle + " cannot be added. This song is already present in " + albumTitle);
        }
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        if ((index >=0) && (index <= this.songs.size())){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String songTitle, LinkedList<Song> playList){
        if(!isSongPresent(songTitle)){
            int index = songs.indexOf(songTitle);
            if ((index >=0) && (index <= this.songs.size())) {
                playList.add(songs.get(index));
                return true;
            }
        }
        System.out.println("This album does not have a track " + songTitle);
        return false;
    }

    public boolean isSongPresent(String songTitle){
        for(Song current : songs){
            if(current.getSongTitle().equals(songTitle)){
                return true;
            }
        }
        return false;
    }

    public String getAlbumTitle(){
        return albumTitle;
    }

    public ArrayList<Song> getSongs(){
        return songs;
    }
}
