package com.test.rakutentest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rakutentest.dao.AlbumDAO;
import com.test.rakutentest.domain.Album;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	AlbumDAO dao;
	
	@Override
	public int addNewAlbum(Album toBeAdded) {
		if(toBeAdded.getArtist().equalsIgnoreCase("Britney Spears") || toBeAdded.getGenre().equalsIgnoreCase("Bhangra")) {
			throw new IllegalArgumentException("Britney Spears album is forbidden.");
		}
		else {
			Album saved = dao.save(toBeAdded);
			return saved.getId();
		}
	}

	@Override
	public void removeExisting(int id) {
		Album existing = dao.findById(id);
		if(existing != null) {
			if(existing.getGenre().equalsIgnoreCase("Bhajans"))
				throw new IllegalArgumentException("Can't delete albums of genre Bhajans");
			else
				dao.deleteById(id);
		}
		
	}

	@Override
	public Album findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Album> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Album> findByArtist(String artist) {
		return dao.finByArtist(artist);
	}

	@Override
	public List<Album> findByGenre(String genre) {
		return dao.findByGenre(genre);
	}

}
