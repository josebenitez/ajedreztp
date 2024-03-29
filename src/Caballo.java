/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.util.*;
import java.io.*;

public class Caballo extends Pieza {

	// Constructor
	public Caballo (int color, int x, int y) {
		
		super(color, x, y, "imagenes/c");
		//System.out.println("Caballo.Caballo(): \tCreado con color <" + color + "> y posicion (" + x + ", " + y + ")");
	}

	public String toString () {

		if (color == BLANCO)
			return "C";
		else
			return "c";
	}

	public Pieza copiar () {

		return new Caballo(this.color, this.f, this.c);
	}

	public boolean validarMovimiento (Tablero tablero, int fF, int cF) {
	
		if (fF > 7 || fF < 0)
			return false;
		if (cF > 7 || cF < 0)
			return false;

		int difFil, difCol;
		Pieza p;
		
		p = tablero.get(fF, cF);

		difFil = this.f - fF;
		difCol = this.c - cF;

		// el movimiento del caballo se caracteriza por un salto de
		// 1 en las filas y 2 en las columnas o viceversa (en valor absoluto)
		if (((Math.abs(difFil) == 1) && (Math.abs(difCol) == 2)) || ((Math.abs(difFil) == 2) && (Math.abs(difCol) == 1))) {
			// solo podemos comer al rival
			if (p != null )
				if (p.getColor() == this.color)
					return false;
			return true;
		}
		else 
			return false;
	}

	public ArrayList posiblesMovimientos(Tablero t) {

		ArrayList a = new ArrayList();

		for (int df=-2; df<=2; df++)
			if (df != 0)
				for (int dc=-2; dc<=2; dc++)
					if (dc != 0)
						if (validarMovimiento(t, this.f+df, this.c+dc)) {
							a.add(new Movimiento(this, this.f+df, this.c+dc));
						}
		return a;
	}
}

