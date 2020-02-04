package com.test.rakutentest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rakutentest.dao.AlbumDAO;
import com.test.rakutentest.dao.TrackDAO;
import com.test.rakutentest.domain.Album;
import com.test.rakutentest.domain.Track;

@Service
public class TrackServiceImpl implements TrackService{

	@Autowired
	TrackDAO trackDAO;
	
	@Autowired
	AlbumDAO albumDAO;
	
	@Override
	public Track addTrackToAlbum(int albumId, Track toBeAdded) {
		Album anAlbum = albumDAO.findById(albumId);
		if(anAlbum != null) {
			toBeAdded.setAlbum(anAlbum);
			trackDAO.save(toBeAdded);
			return toBeAdded;
		}
		else
			throw new IllegalArgumentException("No such album: " + albumId);
	}

	@Override
	public List<Track> findByTrackId(int tid) {
		return trackDAO.findByAlbumId(tid);
	}

}
