package formas2D;

import java.awt.Color;

@SuppressWarnings("serial")
public class Retangulo extends Forma {
	private final int N_PONTOS = 4;
	/**
	 * @param cor
	 * @param locationsX
	 * @param locationsY
	 */
	public Retangulo(Color cor, int[] locationsX, int[] locationsY) {
		super(cor, locationsX, locationsY);
		for (int i = 0; i < N_PONTOS; i++) {
			addPoint(locationsX[i], locationsY[i]);
		}
	}
	/**
	 * @return the nPontos
	 */
	public int getnPontos() {
		return N_PONTOS;
	}
	
	public String toString() {
		return "Retangulo";
	}
}
