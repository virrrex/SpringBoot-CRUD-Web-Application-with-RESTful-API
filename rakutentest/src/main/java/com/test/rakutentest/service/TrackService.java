package com.test.rakutentest.service;

import java.util.List;

import com.test.rakutentest.domain.Track;

public interface TrackService {
	public Track addTrackToAlbum(int albumId, Track toBeAdded);
	public List<Track> findByTrackId(int tid);
}
