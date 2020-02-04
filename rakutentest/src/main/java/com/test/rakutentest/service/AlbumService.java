package com.test.rakutentest.service;

import java.util.List;

import com.test.rakutentest.domain.Album;

public interface AlbumService {
	public int addNewAlbum(Album toBeAdded);
	public void removeExisting(int id);
	public Album findById(int id);
	public List<Album> findAll();
	public List<Album> findByArtist(String artist);
	public List<Album> findByGenre(String genre);
}
