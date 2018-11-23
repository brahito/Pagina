import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Calendario {
	private PApplet app;
	private PFont roboto1, roboto2;
	private PImage cuadroBuho, buho, mas, calbar, calbar2, eliminar;
	private boolean evento;

	public Calendario(PApplet app) {
		this.app = app;
		roboto1 = app.createFont("Roboto-Bold.ttf", 20);
		roboto2 = app.createFont("Roboto-Regular.ttf", 20);
		cuadroBuho = app.loadImage("cuadroBuho.png");
		buho = app.loadImage("buhocal.png");
		mas = app.loadImage("calevent.png");
		calbar = app.loadImage("calbar.png");
		calbar2 = app.loadImage("calbar2.png");
		eliminar = app.loadImage("eliminar.png");
		evento = false;
	}

	public void pintar() {
		app.image(cuadroBuho, 112, 121);
		app.image(buho, 114, 121);
		app.image(mas, 157, 28);
		if (app.mouseX > 155 && app.mouseX < 210 && app.mouseY > 30 && app.mouseY < 80) {
			app.tint(255, 0, 0, 40);
			app.image(mas, 157, 28);
			app.noTint();
		}
		app.image(calbar2, 112, 408);
		app.image(calbar, 112, 370);
		app.image(eliminar, 230, 560);
		app.fill(255, 138, 102);
		app.textSize(12);
		app.text("Eliminar", 221, 610);
		if (evento == true) {
			app.fill(0, 100);
			app.rect(0, 0, app.width, app.height);
		}

	}

	public void mouse() {
		if (app.mouseX > 155 && app.mouseX < 210 && app.mouseY > 30 && app.mouseY < 80) {
			evento = true;
		}

	}
}
