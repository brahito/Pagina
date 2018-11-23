import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Concentracion {
	private PApplet app;
	private PFont roboto1, roboto2;
	private boolean estado;

	public Concentracion(PApplet app) {
		this.app = app;
		
		roboto1 = app.createFont("Roboto-Bold.ttf", 20);
		estado = false;
		roboto2 = app.createFont("Roboto-Regular.ttf", 20);
	}

	public void pintar() {
		app.fill(54, 70, 93);
		

		if (estado == true) {
		} else {
		
		}
		
	}

	public void mouse() {
		// TODO Auto-generated method stub

	}
}
