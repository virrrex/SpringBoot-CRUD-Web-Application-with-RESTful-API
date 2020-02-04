package com.test.rakutentest.dao;

import java.util.List;

import com.test.rakutentest.domain.Track;

public interface TrackDAO {
	public Track save(Track r);
	public List<Track> findByAlbumId(int aid);
}
