package ood.exercises.ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simulates a Jukebox to play music. To make it simple there is no thread use in this class, 
 * but ideally every playlist that is meant to be played, should be a new thread while the "GUI"
 * get idle to allow the user interact with it.
 * 
 * @author luisa
 * */
public class JukeBox {
	
	protected static JukeBox instance;
	
	private Map<String, Song> songlist;
	private Map<String, Playlist> playlists;
	private Map<String, Album> albums;
	
	private JukeBox() {
		this.songlist = new HashMap<String, Song>();
		this.albums = new HashMap<String, Album>();
		this.playlists = new HashMap<String, Playlist>();
	}
	
	/**
	 * Get the unique JukeBox instance
	 * 
	 * @return JukeBox
	 * */
	public static JukeBox getInstance() {
		if (instance == null) {
			instance = new JukeBox();
		}
		
		return instance;
	}

	/**
	 * Adds an album
	 * @param Album
	 * */
	public void addAlbum(Album album) {
		instance.albums.put(album.getTitle(), album);
	}
	
	/**
	 * Adds a song
	 * @param Song
	 * */
	public void addSong(Song song) {
		instance.songlist.put(song.getTitle(), song);
	}
	
	/**
	 * Add a song to a playlist
	 * @throws Exception 
	 * */
	public void addSongToPlaylist(String songName, String playlistName) throws Exception {
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
	
	/**
	 * Adds a song to a playlist. Both must exist in the system already.
	 * 
	 * @param String
	 * @param Song
	 * */
	public void addSongToPlaylist( String playlistName, Song song) {
		Playlist p = instance.playlists.get(playlistName);
		p.addSong(song);
		instance.playlists.put(playlistName, p);
		
	}
	
	/**
	 * Creates an empty playlist
	 * @param String
	 * */
	public void createPlaylist(String name) {
		Playlist playlist = new Playlist(name);
		instance.playlists.put(name, playlist);
	}
	
	/**
	 * Search a specific song in all the albums
	 * @param String
	 * */
	public Song searchSongInAlbum(String songName) {
		Song song = null;
		for(Album album: instance.albums.values()){
			 song = album.searchSong(songName);
			if(song != null)
				break;
		}
		
		return song;
	}
	
	/**
	 * Plays a specific Album
	 * @param String
	 * */
	public void playAbum(String albumName) throws InterruptedException {
		instance.albums.get(albumName).play();
	}
	
	/**
	 * Plays a specific song
	 * @param String
	 * */
	public void playSong(String songName) throws InterruptedException {
		instance.songlist.get(songName).play();
	}
	
	/**
	 * Plays a specific playlist
	 * @param String
	 * */
	public void playPlaylist(String PlayList) throws InterruptedException {
		instance.playlists.get(PlayList).play();
	}
	
	
	
	
	
	
	

}
