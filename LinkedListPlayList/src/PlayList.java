import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class PlayList {

    private String playlistTitle;

    private LinkedList<Song> playlist;

    private ArrayList<Album> albums;

    public PlayList(String playlistTitle){
        this.playlistTitle = playlistTitle;
        this.playlist = new LinkedList<>();
        this.albums = new ArrayList<>();
    }


    //getter na album
    //linkedList na aktuální playlist
    //menu of options

    public void addAlbum(String artist, String albumTitle){
        if(!isAlbumPresent(albumTitle)) {
            this.albums.add(new Album(artist, albumTitle));
            System.out.println(albumTitle + " has been successfully added into list of all albums.");
        } else{
            System.out.println(albumTitle + " cannot be added. Album with same name is already present in the list.");
        }
    }

    private boolean isAlbumPresent(String albumTitle){
//        ListIterator listIterator = albums.listIterator();
//        while(listIterator.hasNext()){
//            if(!listIterator.next().getAlbumTitle()){
//                return false;
//            }
//        }
//        return true;
        for(Album current : albums){
            if(!current.getAlbumTitle().equals(albumTitle)){
                return false;
            }
        }
        return true;
    }



    private void addSongToPlaylist(String songTitle, String albumName){
        //proiterovat alba - tam, kde shoda, vytáhnout ten OBJEKT a vložit ho do LL
//        for(Album current : albums){
//            if(current.isSongPresent(songTitle)){
//               ArrayList<Song> albumSongs = current.getSongs();
//               for(Song currentSong : albumSongs){
//                   int song = albumSongs.indexOf(currentSong.getSongTitle());
//                   playlist.add(albumSongs.get(song));
//               }
//            } else{
//                System.out.println("Sorry, there's no such song in any album.");
//            }
        ListIterator listIterator = albums.listIterator();
        while(listIterator.hasNext()){
            listIterator.next();
        }
        for(Album currentAlbum : albums){
            if(currentAlbum.getAlbumTitle().equals(albumName)){
                ArrayList<Song> albumSongs = currentAlbum.getSongs();

                for(Song currentSong : albumSongs){
                    String currentSongTitle = currentSong.getSongTitle();

                    if(currentSongTitle.equals(songTitle)) {
                        int songPosition = albumSongs.indexOf(currentSongTitle);
                        playlist.add(albumSongs.get(songPosition));
                    }
                }
            }
        }
    }

    private static LinkedList<String> linkedList = new LinkedList<>();

   private static void addNames(){
       linkedList.add("Adam");
       linkedList.add("Verunka");
       linkedList.add("Božena");
   }

    public static void test(){
        ListIterator listIterator = linkedList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.nextIndex() + ". index: " + listIterator.next());
        }
        listIterator.previous();

        while(listIterator.hasPrevious()){
            System.out.println(listIterator.nextIndex() + ". index: " + listIterator.previous());
            String abc = (String)listIterator.next();
            System.out.println("abc" + abc);
            return;
        }
    }

    public static void main(String [] args){
       addNames();
       test();
    }
}
