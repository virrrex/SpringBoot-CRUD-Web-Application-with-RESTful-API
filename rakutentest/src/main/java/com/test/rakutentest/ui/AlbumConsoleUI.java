package com.test.rakutentest.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.rakutentest.domain.Album;
import com.test.rakutentest.service.AlbumService;

@Component
public class AlbumConsoleUI {
	
	@Autowired
	AlbumService service;
	
	public void createAlbumWithUI() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter album name: ");
		String name = s.nextLine();
		System.out.println("Enter artist name: ");
		String artist = s.nextLine();
		System.out.println("Enter genre name: ");
		String genre = s.nextLine();
		
		Album anAlbum = new Album(name, artist, genre);
		int id = service.addNewAlbum(anAlbum);
		System.out.println("Added album with ID: " + id);
	}
	
}
