package odd.exercise.ex3;

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

}
