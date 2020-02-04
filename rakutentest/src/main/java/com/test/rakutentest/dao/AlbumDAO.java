package com.test.rakutentest.dao;

import java.util.List;

import com.test.rakutentest.domain.Album;

public interface AlbumDAO {

	public Album save(Album toBeSaved);
	public Album findById(int id);
	public List<Album> findAll();
	public void deleteById(int id);
	public List<Album> finByArtist(String artist);
	public List<Album> findByGenre(String genre);
}
