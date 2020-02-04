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
import org.springframework.web.bind.annotation.RestController;

import com.test.rakutentest.domain.Album;
import com.test.rakutentest.domain.Track;
import com.test.rakutentest.service.AlbumService;
import com.test.rakutentest.service.TrackService;

@RestController
@CrossOrigin
public class TrackController {
	
	@Autowired
	TrackService trackService;
	
	@Autowired
	AlbumService albumService;
	
	@GetMapping("/albums/{aid}/tracks")
	public ResponseEntity<List<Track>> getTracksForAnAlbum(@PathVariable("aid") int albumId) {
		Album a = albumService.findById(albumId);
		if(a == null)
			return new ResponseEntity<List<Track>>(HttpStatus.NOT_FOUND);
		List<Track> tracks = trackService.findByTrackId(albumId);
		return new ResponseEntity<List<Track>>(tracks, HttpStatus.OK);
	}
	
	@PostMapping("/albums/{aid}/tracks")
	public ResponseEntity<Track> addTrackToAlbum(@PathVariable("aid") int albumId, @RequestBody Track track){
		Album a = albumService.findById(albumId);
		if(a == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		Track added = trackService.addTrackToAlbum(albumId, track);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/albums/"+albumId+"/tracks/"+added.getId()));
		return new ResponseEntity<Track>(added, headers, HttpStatus.CREATED);
	}
}
