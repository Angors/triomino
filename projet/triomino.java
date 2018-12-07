package projet;

public class triomino {
// Classe convernant les pieces de triominos
	
	//Face du triomino
	face no;
	face ne;
	face south; 
	String nbcoup; // Nom du triomino
	int Cmax = 5,Cmin = -1; // Constante de limite des valeurs triominos
	
	//Constructeur
	public triomino(int x,int y,int z)
	{
		if ((x < Cmax+1) && (y < Cmax+1) && (z < Cmax+1) && (x >= Cmin) && (y >= Cmin) && (z >= Cmin)) // Il faut que les valeurs soient entre 0 et 5
		{
			no = new face(x,y);
			ne = new face(x,z);
			south = new face(y,z);					
	    } else 
	    {
	    	System.out.print("erreur dans les valeurs saisies");
	    }
	}

	public triomino() {
		// TODO Auto-generated constructor stub
		no = new face(-1,-1);
		ne = new face(-1,-1);
		south = new face(-1,-1);
	}

	public void set_nom(String s)
	{
		this.nbcoup = s;
	}
	
	//Methodes
	/*
	public void rotation_gauche()
	// Rotation a gauche [a,b,c] => [b,c,a] => [c,a,b] => [a,b,c]
	{
		int tmp;
		tmp = this.a;
		this.a = this.b;
		this.b = this.c;
		this.c = tmp;
	}
*/
	
	public void AfficherTriomino()
	{
		System.out.println(this.ne.getX() + "," + this.ne.getY() + "," + this.no.getY());
	}
	
	
	public face get_ne() {
		return this.ne;
	}
	
	public face get_no() {
		return this.no;
	}
	
	public face get_south() {
		return this.south;
	}
	
	public void toString_face_NE()
	// Methode pour récupérer la face a et b situé en haut et a droite
	{
				System.out.println("Face Nord-Est: ("+this.ne.getX()+","+this.ne.getY()+")");
	}
	
	public void toString_face_NO()
	// Methode pour récupérer la face a et b situé en haut et a gauche
	{
		System.out.println("Face Nord-Ouest: ("+this.no.getX()+","+this.no.getY()+")");
	}
	
	public void toString_face_SOUTH()
	// Methode pour récupérer la face a et b situé en bas
	{
		System.out.println("Face Sud: ("+this.south.getX()+","+this.south.getY()+")");
	}
	
	// En travaux, besoin de travailler sur une frontiere a implementer dans une classe
	
	/*
	public void placer_triomino(plateau_frontiere A)
	// Prends en parametre un plateau A sur lequel on placera le triomino
	// Le but de cet méthode est de tester les combinaisons possibles de la frontiere avec le triomino
	{
		int i,j,h; // iterateur pour le tableau du plateau
		face[] B;
	
		
		// Dans le cas ou la frontiere est vide :
		if(A.frontiere[0] == NULL)
		{
			System.out.println("Il n'y a pas de triomino sur ce plateau.");
			A.frontiere[0] = this.ne;
			A.frontiere[1] = this.no;
			A.frontiere[2] = this.south;
		}
		// Dans le cas ou la frontiere n'est pas vide
		for (i = 0; i <= A.length; i++)
		{		
				B[j] = A.frontiere[j]; // On sauvegarde les valeurs pour décaler si il existe un triomino
							 		   // Qui puisse s'ajouter a la frontiere			
				if (A.frontiere[i] == this.ne)
				// Si deux cases cote a cote sont egaux pour la frontiere et le triomino alors
				// le triomino se rajoutera a la frontiere en rajoutant l'élément qui ne match pas
				// entre les deux valeurs qui match dans le tableau	
				{
					//A finir
					A.frontiere[i] = this.ne;
					for(h = i+1; h <= A.length; h++)
					// Décalage des valeurs de la frontiere pour libérer une place
					{
						A.frontiere[h] = B[h]; // A partir de A[i+2] on met les valeurs de i+1 a la fin
					}
				}
		}
	}
	*/	
}