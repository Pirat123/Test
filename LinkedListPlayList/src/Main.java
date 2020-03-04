import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Stormbringer", "Deep Purple");

        album.addSongIntoAlbum("Stormbringer", 4.6);
        album.addSongIntoAlbum("Love don't mean thing", 3.7);
        album.addSongIntoAlbum("Holy Man", 6.1);
        album.addSongIntoAlbum("Hold On", 5.15);
        album.addSongIntoAlbum("Lady Double Dealer", 3.6);
        album.addSongIntoAlbum("You can't do it right", 2.4);
        album.addSongIntoAlbum("High ball shooter", 4.6);
        album.addSongIntoAlbum("The Gypsy", 6.6);
        album.addSongIntoAlbum("Soldier of Fortune", 7.1);
        albums.add(album); //vkládám celý objekt album, který obsahuje arraylist se všemi songy

        album = new Album("For those about to rock", "AC/DC");
        album.addSongIntoAlbum("For those about to rock", 4.6);
        album.addSongIntoAlbum("I put a finger on you", 3.7);
        album.addSongIntoAlbum("Let's go", 6.1);
        album.addSongIntoAlbum("Inject the venom", 5.15);
        album.addSongIntoAlbum("Snowballed", 3.6);
        album.addSongIntoAlbum("Evil walks", 2.4);
        album.addSongIntoAlbum("C.O.D", 4.6);
        album.addSongIntoAlbum("Breaking the rules", 6.6);
        album.addSongIntoAlbum("Night of the long knives", 7.1);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("The Gypsy", playList);
        albums.get(1).addToPlaylist("Holy Man", playList);
        albums.get(0).addToPlaylist("Soldier of Fortune", playList);

        System.out.println("tdmtdm" + albums.get(0).getSongs().get(7));
//        albums.get(0).addToPlaylist("Speaking", playList);
//        albums.get(0).addToPlaylist(1, playList);
//
//        albums.get(1).addToPlaylist(1, playList);
//        albums.get(1).addToPlaylist(3, playList);
//        albums.get(1).addToPlaylist(4, playList);
//        albums.get(1).addToPlaylist(5, playList);
//        albums.get(1).addToPlaylist(28, playList);

        play(playList);
		
		System.out.println("tdmtdm" + albums.get(0).getSongs().get(7));
		


    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in, "Windows-1250");
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("No songs in playlist");
            return;
        } else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist complete.");
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list.");
                        }
                    } else{
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list.");
                        }
                    }
                    break;
                case 4:
//                    printList(playList);
                    break;
                case 5:
//                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n +" +
                "1 - to play next song\n" +
                "2 - to play previous song\n +" +
                "3 - to replay current song\n +" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("============================");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("============================");
    }
}
