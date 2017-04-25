package formas2D;

import java.awt.Color;

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
		raio = Math.abs(locationsXFromCenter[0] - locationsXFromCenter[2]);
		double angulo = 0;
		int x,y;
		calculatePoints(locationsX[0],locationsY[0]);
	}
	public void refactor() {
		super.calculateLocationsFromCenter();
		reset();
		calculatePoints(getCenter().x, getCenter().y);
	}
	public void calculatePoints(int centerX, int centerY) {
		double angulo = 0;
		int x,y;
		for (int i = 0; i < 36; i++, angulo += 10) {
			x = (int) (centerX + raio*(Math.cos(Math.toRadians(angulo))));
			y = (int) (centerY + raio*(Math.sin(Math.toRadians(angulo))));
			addPoint(x, y);
		}
	}
	
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	public double getRaio() {
		return raio;
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
