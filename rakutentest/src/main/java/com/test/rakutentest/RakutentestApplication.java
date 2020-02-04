package com.test.rakutentest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.test.rakutentest.ui.AlbumConsoleUI;

@SpringBootApplication
public class RakutentestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RakutentestApplication.class, args);
		
		/*
		 * ApplicationContext springContainer =
		 * SpringApplication.run(RakutentestApplication.class, args);
		 * 
		 * AlbumConsoleUI ui = springContainer.getBean(AlbumConsoleUI.class);
		 * ui.createAlbumWithUI();
		 */
	}

}
