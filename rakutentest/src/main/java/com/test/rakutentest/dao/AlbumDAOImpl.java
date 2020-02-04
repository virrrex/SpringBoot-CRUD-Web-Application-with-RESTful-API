package com.test.rakutentest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.rakutentest.domain.Album;

@Repository
@Transactional
public class AlbumDAOImpl implements AlbumDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public Album save(Album toBeSaved) {
		em.persist(toBeSaved);
		return toBeSaved;
	}

	@Override
	public Album findById(int id) {
		return em.find(Album.class, id);
	}

	@Override
	public List<Album> findAll() {
		Query q = em.createQuery("select a from Album as a");
		List<Album> all = q.getResultList();
		return all;
	}

	@Override
	public void deleteById(int id) {
		Album a = em.find(Album.class, id);
		if(a != null)
			em.remove(a);
	}

	@Override
	public List<Album> finByArtist(String artist) {
		Query q = em.createQuery("select a from Album as a where a.artist=:artParam");
		q.setParameter("artParam", artist);
		return q.getResultList();
	}

	@Override
	public List<Album> findByGenre(String genre) {
		Query q = em.createQuery("select a from Album as a where a.genre=:artParam");
		q.setParameter("artParam", genre);
		return q.getResultList();
	}

}
