package odd.exercise.ex3;

public class Song {

	private String title;
	private String artist;
	private String album;
	private boolean isPlaying;

	
	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
		this.isPlaying = false;
	}
	
	public Song(String title, String artist, String album) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.isPlaying = false;
	}
	
	public void play() throws InterruptedException {
		System.out.println("Playing: " + this.title + "\n Lalalalalala...");
		this.isPlaying = true;
		Thread.sleep(2000);
		this.isPlaying = false;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public String getAlbum() {
		return this.album;
	}
	
	public boolean isPlaying() {
		return this.isPlaying;
	}
}
