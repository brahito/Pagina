import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private int pantalla;
	private Home home;
	private Calendario calen;
	private Mascota mas;
	private Concentracion con;
	private Usuario us;

	public Logica(PApplet app) {
		this.app = app;
		pantalla = 0;
		home = new Home(app);
		calen = new Calendario(app);
		mas = new Mascota(app);
		con = new Concentracion(app);
		us = new Usuario(app);
	}

	public void pintar() {
		switch (pantalla) {
		case 0:
			app.textFont(app.createFont("Roboto-Regular.tff", 160));
			app.textSize(24);
			app.fill(0);
			app.text("nfini", 124, 42);
			break;
		case 1:
			home.pintar();
			break;
		case 2:
			calen.pintar();
			break;
		case 3:
			mas.pintar();
			break;
		case 4:
			con.pintar();
			break;
		case 5:
			us.pintar();
			break;
		}
	}

	public void mouse() {
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

}
