package ood.app;

import ood.exercises.ex3.JukeBox;
import ood.exercises.ex3.Playlist;
import ood.exercises.ex3.Song;

/**
 * This is the simulation of a Jukebox to play music. Shake it out baby!
 * */
public class JukeBoxApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		JukeBox mp3 = JukeBox.getInstance();
		Song song1 = new Song("Blue sky", "Elvis Pepperoni");
		Song song2 = new Song("Eat my short", "the evil kids");
		Song song3 = new Song("everything is ok", "B M");
		Song song4 = new Song("tu puta madre", "Arabola");
		Song song5 = new Song("I want to eat spaguetti tonight", "Mostaccini");
		Song song6 = new Song("Get the hell out of my kitchen", "Feminist Mamma");
		Song song7 = new Song("my room got dark", "The emo boy");
		
		mp3.createPlaylist("myplaylist");
		mp3.addSongToPlaylist("myplaylist", song1);
		mp3.addSongToPlaylist("myplaylist", song2);
		mp3.playPlaylist("myplaylist");
	
		
	}
	
	

}
