import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	private PApplet app;
	private int pantalla;
	private Home home;
	private Calendario calen;
	private Mascota mas;
	private Concentracion con;
	private Usuario us;
	private PImage nav, ppal, calendar, ppal2, mascota, timer, mascota2, timer2, calendar2;
	private int encima;

	public Logica(PApplet app) {
		this.app = app;
		pantalla = 1;
		encima = 0;
		nav = app.loadImage("Group 4.png");
		ppal = app.loadImage("ppal.png");
		ppal2 = app.loadImage("ppal2.png");
		mascota = app.loadImage("Mascota.png");
		timer = app.loadImage("timer.png");
		calendar = app.loadImage("calendar.png");
		mascota2 = app.loadImage("Mascotab.png");
		timer2 = app.loadImage("timerb.png");
		calendar2 = app.loadImage("calendarb.png");
		home = new Home(app);
		calen = new Calendario(app);
		mas = new Mascota(app);
		con = new Concentracion(app);
		us = new Usuario(app);
	}

	public void pintar() {
		switch (pantalla) {
		case 0:

			break;
		case 1:
			navegacion();
			home.pintar();
			break;
		case 2:
			navegacion();
			calen.pintar();
			break;
		case 3:
			navegacion();

			mas.pintar();
			break;
		case 4:
			navegacion();

			con.pintar();
			break;
		case 5:
			navegacion();

			us.pintar();
			break;
		}
		if (pantalla != 0) {
			if (app.mouseX > 11 && app.mouseX < 185 && app.mouseY > 134 && app.mouseY < 173) {
				encima = 1;
			} else if (app.mouseX > 11 && app.mouseX < 185 && app.mouseY > 224 && app.mouseY < 260) {
				encima = 2;

			} else if (app.mouseX > 11 && app.mouseX < 185 && app.mouseY > 307 && app.mouseY < 347) {
				encima = 3;
			} else if (app.mouseX > 11 && app.mouseX < 185 && app.mouseY > 397 && app.mouseY < 438) {
				encima = 4;
			} else {
				encima = 0;
			}
		}
	}

	public void mouse() {
		System.out.println(app.mouseX + " " + app.mouseY);
		if (pantalla != 0) {
			if (app.mouseX > 11 && app.mouseX < 185 && app.mouseY > 134 && app.mouseY < 173) {
				pantalla = 1;
			}
			if (app.mouseX > 11 && app.mouseX < 185 && app.mouseY > 224 && app.mouseY < 260) {
				pantalla = 2;
			}
			if (app.mouseX > 11 && app.mouseX < 185 && app.mouseY > 307 && app.mouseY < 347) {
				pantalla = 3;
			}
			if (app.mouseX > 11 && app.mouseX < 185 && app.mouseY > 397 && app.mouseY < 438) {
				pantalla = 4;
			}

		}
		switch (pantalla) {
		case 0:

			break;
		case 1:
			home.mouse();
			break;
		case 2:
			calen.mouse();
			break;
		case 3:
			mas.mouse();
			break;
		case 4:
			con.mouse();
			break;
		case 5:
			us.mouse();
			break;
		}
	}

	public void navegacion() {
		app.image(nav, 0, -2);

		app.imageMode(PApplet.CENTER);
		app.image(ppal2, 11 + ppal.width / 2, 155);
		app.image(calendar, 11 + calendar.width / 2, 243);
		app.image(mascota, 11 + mascota.width / 2, 327);
		app.image(timer, 11 + timer.width / 2, 417);
		app.imageMode(PApplet.CORNER);

		app.fill(197, 197, 197);

		app.imageMode(PApplet.CENTER);
		if (pantalla == 1 || encima == 1) {
			app.fill(232, 71, 91);
			app.image(ppal, 11 + ppal.width / 2, 155);
		}
		app.text("Menú Principal", 64, 162);
		app.fill(197, 197, 197);
		if (pantalla == 2 || encima == 2) {
			app.fill(255, 138, 102);
			app.image(calendar2, 11 + calendar.width / 2, 243);
		}
		app.text("Calendario", 64, 250);
		app.fill(197, 197, 197);
		if (pantalla == 3 || encima == 3) {
			app.fill(244, 150, 25);
			app.image(mascota2, 11 + mascota.width / 2, 327);

		}
		app.text("Mascota", 64, 336);
		app.fill(197, 197, 197);
		if (pantalla == 4 || encima == 4) {
			app.fill(232, 71, 91);
			app.image(timer2, 11 + timer.width / 2, 417);

		}
		app.text("Modo concentración", 64, 424);
		app.imageMode(PApplet.CORNER);

		app.fill(197, 197, 197);

	}
}
