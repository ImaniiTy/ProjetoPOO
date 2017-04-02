package formas2D;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class Circuferencia extends Forma {
	/**
	 * @param cor
	 * @param locationsX
	 * @param locationsY
	 */
	public Circuferencia(Color cor, int[] locationsX, int[] locationsY) {
		super(cor, locationsX, locationsY);
		// TODO Auto-generated constructor stub
		Ellipse2D elp = new Ellipse2D.Double();
		
	}
	
}
