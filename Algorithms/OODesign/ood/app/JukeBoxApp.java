package ood.app;

import odd.exercise.ex3.JukeBox;
import odd.exercise.ex3.Playlist;
import odd.exercise.ex3.Song;

public class JukeBoxApp {
	
	public static void main(String[] args) throws InterruptedException {
		
		JukeBox mp3 = JukeBox.getInstance();
		Song song1 = new Song("Blue sky", "Elvis Pepperoni");
		Song song2 = new Song("Eat my short", "the evil kids");
		Song song3 = new Song("everything is ok", "B M");
		Song song4 = new Song("tu puta madre", "Arabola");
		Song song5 = new Song("I want to eat spaguetti tonight", "Mostaccini");
		Song song6 = new Song("Get the hell out of my kitchen", "feminist mama");
		Song song7 = new Song("my room got dark", "emo boy");
		
		mp3.createPlaylist("myplaylist");
		mp3.addSongToPlaylist("myplaylist", song1);
		mp3.addSongToPlaylist("myplaylist", song2);
		mp3.playPlaylist("myplaylist");
	
		
	}
	
	

}
