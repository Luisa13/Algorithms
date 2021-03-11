package ood.exercise.ex3;


/**
 * Represents a song with a name, artist name, the album that belongs to and the duration
 * @author luisa
 * */
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
	
	/**
	 * Plays the song
	 * */
	public void play() throws InterruptedException {
		System.out.println("Playing: " + this.title + "\n Lalalalalala...");
		this.isPlaying = true;
		Thread.sleep(2000);
		this.isPlaying = false;
	}
	
	/**
	 * Gets the title of the song
	 * */
	public String getTitle() {
		return this.title;
	}
	
	
	/**
	 * Gets the artist who interpret the song
	 * */
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * Get the album that contains the song originally
	 * */
	public String getAlbum() {
		return this.album;
	}
	
	
	/**
	 * Returns true if the song is being played. False otherwise
	 * */
	public boolean isPlaying() {
		return this.isPlaying;
	}
}
