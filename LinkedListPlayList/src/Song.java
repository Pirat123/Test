public class Song {

    private String songTitle;

    private double duration;

    public Song(String songTitle, double duration){
        this.songTitle = songTitle;
        this.duration = duration;
    }

   @Override
    public String toString(){
        return this.songTitle + ": " + this.duration;
   }

   public String getSongTitle(){
        return this.songTitle;
   }
}
