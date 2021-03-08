package odd.exercise.ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simulates a Jukebox to play music. To make it simple there is no thread use in this class, 
 * but ideally every playlist that is meant to be played, should be a new thread.
 * 
 * @author luisa
 * */
public class JukeBox {
	
	protected static JukeBox instance;
	private JukeBox() {
		this.songlist = new HashMap<String, Song>();
		this.albums = new HashMap<String, Album>();
		this.playlists = new HashMap<String, Playlist>();
	}
	public JukeBox getInstance() {
		if (instance == null) {
			instance = new JukeBox();
		}
		
		return instance;
	}
	
	private Map<String, Song> songlist;
	private Map<String, Playlist> playlists;
	private Map<String, Album> albums;
	
	public void addAlbum(Album album) {
		instance.albums.put(album.getTitle(), album);
	}
	
	public void addSong(Song song) {
		instance.songlist.put(song.getTitle(), song);
	}
	
	public void addSongToPlaylist(String songName, String playlistName) {
		Song song = instance.songlist.get(songName);
		if(song == null) {
			song = searchSongInAlbum(songName);
			if(song == null)
				throw new Exception ("Cannot find the song");
		}
		
		Playlist playlist = instance.playlists.get(playlistName);
		playlist.addSong(song);
		instance.playlists.put(playlistName, playlist);
		
	}
	
	public Song searchSongInAlbum(String songName) {
		
	}
	
	public void playAbum(String albumName) {
		
	}
	
	public void playSong(String songName) {
		
	}
	
	public void playPlaylist(String PlayList) {
		
	}
	
	
	
	
	
	
	

}
