package com.test.rakutentest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="album_id")
	int id;
	@Column(name="album_name")
	String name;
	@Column(name="album_artist")
	String artist;
	@Column(name="album_genre")
	String genre;
	@Column(length = 1000)
	String image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Album() {
		// TODO Auto-generated constructor stub
	}
	public Album(String name, String artist, String genre) {
		super();
		this.name = name;
		this.artist = artist;
		this.genre = genre;
	}
}
