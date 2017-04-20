package formas2D;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class Circuferencia extends Forma {
	private double raio;
	/**
	 * @param cor
	 * @param locationsX
	 * @param locationsY
	 */
	public Circuferencia(Color cor, int[] locationsX, int[] locationsY) {
		super(cor, locationsX, locationsY);
		raio = Math.abs(locationsX[0] - locationsX[2]);
		double angulo = 0;
		int x,y;
		for (int i = 0; i < 36; i++, angulo += 10) {
			x = (int) (locationsX[0] + raio*(Math.cos(Math.toRadians(angulo))));
			y = (int) (locationsY[0] + raio*(Math.sin(Math.toRadians(angulo))));
			addPoint(x, y);
		}
	}
	
	public String toString() {
		return "Circunferencia";
	}
	/* Nao usado, mas util
	public double calcularDistanciaPontos() {
		return Math.cbrt(Math.pow((locationsX[0] - locationsX[2]), 2) + Math.pow((locationsY[0] - locationsY[2]), 2));
	}
	*/
}
