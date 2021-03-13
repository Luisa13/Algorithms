package ood.exercises.ex3;

import java.util.ArrayList;
import java.util.List;

public class Album {
	
	private String title;
	private String artist;
	private List<Song> songs;
	
	public Album(String title, String artist, List<Song> songs) {
		this.title = title;
		this.artist = artist;
		this.songs = songs;
	}
	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public List<Song> getSongs(){
		return this.songs;
	}
	public void addSong(Song newSong) {
		this.songs.add(newSong);
	}
	
	/**
	 * Returns the song found in the album. Null in case the 
	 * album does not contain it.
	 * 
	 * @param Song
	 * */
	public Song searchSong(String songName) {
		List<Song> found = new ArrayList<>();
		songs.stream()
		.filter((s) -> s.getTitle().equals(songName) )
		.forEach((s) -> found.add(s));
		
		return found.get(0);
	}
	
	/**
	 * Plays all the song of the album
	 * */
	void play() throws InterruptedException {
		System.out.print("Playing the album " + this.title + " by " + this.artist );
		
		for(Song currentSong: this.songs) {
			currentSong.play();
		}
	}

}
