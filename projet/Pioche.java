package projet;

import java.util.*;

public class Pioche {

	List<triomino> pioche;
	
	// Note : La pioche est bien remplie de 0.0.0 a 5.5.5
	
	
	// Constructeur
	
	public Pioche() {
	
		pioche = new ArrayList<triomino>();
			
	}
	
	
	// Méthodes 
	
	public void SaisiePioche(int x, int y, int z)
	{		
		triomino t = new triomino(x,y,z);
		
		this.pioche.add(t);
	}
	
	public int TaillePioche()
	{
		return this.pioche.size();
	}
	
	public void RetirerPioche(triomino t)
	{
		this.pioche.remove(t);
	}

	public triomino get(int i) 
	{
		return this.pioche.get(i);
	}
}