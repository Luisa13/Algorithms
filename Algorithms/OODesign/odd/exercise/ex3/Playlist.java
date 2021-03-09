package odd.exercise.ex3;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a playlist that contains a song list and a name
 * 
 * @author luisa
 * */
public class Playlist {

	private List<Song> songs;
	private String name;
	
	public Playlist(String name) {
		this.name = name;
		this.songs = new ArrayList<>();
	}
	
	/**
	 * Parameter contructor
	 * */
	public Playlist(String name, List<Song> songs) {
		this.name = name;
		this.songs = songs;
	}
	
	/**
	 * Returns the name of the playlist
	 * */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the songs included in the playlist
	 * */
	public List<Song> getSongs(){
		return this.songs;
	}
	
	/**
	 * Plays all the songs defined in the playlist
	 * */
	public void play() throws InterruptedException {
		for(Song currentSong: songs) {
			currentSong.play();
		}
	}
}
