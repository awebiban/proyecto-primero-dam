package com.task.manager.dam1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.task.manager.dam1.web.controllers.MenuController;

@SpringBootApplication
public class Dam1Application {

	public static void main(String[] args) {
		SpringApplication.run(Dam1Application.class, args);
		MenuController menuController = new MenuController();
		menuController.mostrarMenu();
	}

}
