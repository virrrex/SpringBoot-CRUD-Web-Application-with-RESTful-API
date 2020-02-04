package com.test.rakutentest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.rakutentest.domain.Track;

@Repository
@Transactional
public class TrackDAOImpl implements TrackDAO{
	
	@Autowired
	EntityManager em;

	@Override
	public Track save(Track t) {
		em.persist(t);
		return t;
	}

	@Override
	public List<Track> findByAlbumId(int aid) {
		Query q = em.createQuery("select t from Track as t where t.album.id=:aidParam");
		q.setParameter("aidParam", aid);
		return q.getResultList();
	}
	
	
}
