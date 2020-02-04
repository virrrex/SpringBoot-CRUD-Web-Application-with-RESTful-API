package com.test.rakutentest.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.rakutentest.domain.Album;
import com.test.rakutentest.service.AlbumService;

@RestController
@CrossOrigin
public class AlbumController {
	
	@Autowired
	AlbumService service;
	
	@GetMapping("/albums")
	public List<Album> getAllAlbums() {
		return service.findAll();
	}
	
	@GetMapping("/albums/{id}")
	public ResponseEntity<Album> getById(@PathVariable("id") int id) {
		Album a = service.findById(id);
		if(a != null)
			return new ResponseEntity<Album>(a, HttpStatus.OK);
		else
			return new ResponseEntity<Album>(a, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/albums")
	public ResponseEntity<Album> addAlbum(@RequestBody Album toBeAdded) {
		try {
			int id = service.addNewAlbum(toBeAdded);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/albums/"+id));
			return new ResponseEntity<Album>(toBeAdded, headers, HttpStatus.CREATED);
		}
		catch(IllegalArgumentException e) {
			return new ResponseEntity<Album>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/albums/searchByArtist")
	public ResponseEntity<List<Album>> getAlbumsByArtist(@RequestParam("artist") String artist) {
		List<Album> a = service.findByArtist(artist);
		if(a.size() != 0) {
			return new ResponseEntity<List<Album>>(a, HttpStatus.OK);
		}
		//URL is /albums/searchByArtist?artist=Mohit+Chauhan
		else
			return new ResponseEntity<List<Album>>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/albums/searchByGenre")
	public ResponseEntity<List<Album>> getAlbumsByGenre(@RequestParam("genre") String genre) {
		List<Album> a = service.findByGenre(genre);
		if(a.size() != 0) {
			return new ResponseEntity<List<Album>>(a, HttpStatus.OK);
		}
		//URL is /albums/searchByArtist?genre=Bhangra
		else
			return new ResponseEntity<List<Album>>(HttpStatus.NOT_FOUND);
	}
}
