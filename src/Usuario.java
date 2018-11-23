import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Usuario {
	private PApplet app;
	private PFont roboto1, roboto2;
	private PImage cuadro2, cuadro, icono, cuadroUG1, pico, cuadroUG2, conteM, conteM1, acti, actiCua;
	private boolean materia;

	public Usuario(PApplet app) {
		this.app = app;
		roboto1 = app.createFont("Roboto-Bold.ttf", 20);
		roboto2 = app.createFont("Roboto-Regular.ttf", 20);
		cuadro = app.loadImage("cuadrouser.png");
		cuadro2 = app.loadImage("cuadrouser2.png");
		icono = app.loadImage("userGrande.png");
		cuadroUG1 = app.loadImage("cuadroUG1.png");
		pico = app.loadImage("pico.png");
		cuadroUG2 = app.loadImage("cuadroUG2.png");
		conteM = app.loadImage("conteM.png");
		conteM1 = app.loadImage("conteM1.png");
		acti = app.loadImage("acti.png");
		actiCua = app.loadImage("actiCua.png");
		materia = false;
	}

	public void pintar() {

		app.image(cuadro, 112, 127);
		app.image(cuadro2, 112, 399);
		app.image(icono, 128, 145);
		if (materia == true) {
			app.image(pico, 483, 318);
			app.image(cuadroUG2, 408, 359);
			for (int i = 0; i < 3; i++) {
				app.image(acti, 449, 93 * i + 385);
				app.image(actiCua, 449, 93 * i + 388);
			}
		}
		app.image(cuadroUG1, 408, 124);
		app.fill(116, 111, 126);
		app.textFont(roboto2);
		app.textSize(16);
		app.text("Tus materias", 735, 160);
		for (int i = 0; i < 5; i++) {
			app.image(conteM, (float) (140 * i + 450.26), 175.83f);
			if (app.mouseX > (float) (140 * i + 450.26) && app.mouseX < (float) (140 * i + 450.26) + conteM.width
					&& app.mouseY > 175 && app.mouseY < 175 + conteM.height) {
				app.image(conteM1, (float) (140 * i + 450.26), 175.83f);
			}
		}

	}

	public void mouse() {
		for (int i = 0; i < 5; i++) {
			if (app.mouseX > (float) (140 * i + 450.26) && app.mouseX < (float) (140 * i + 450.26) + conteM.width
					&& app.mouseY > 175 && app.mouseY < 175 + conteM.height) {
				materia = true;
			}

		}
	}
}
