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
	
	public void SaisiePioche()
	{
		int x=0;
		int y=0;
		int z=0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Saisie des triominos");
		
		System.out.println("Saisir x : ");
		scan.nextInt(x);
		
		
		System.out.println("Saisir y : ");
		scan.nextInt(y);
		
		System.out.println("Saisir z : ");
		scan.nextInt(z);
		
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