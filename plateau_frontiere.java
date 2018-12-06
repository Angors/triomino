package projet;

public class plateau_frontiere {
	
	face frontiere[]; // Tableau d'entier qui stock les valeurs des triominos qui se trouvent a la frontiere
	int length; // Nombre d'element dans la frontiere

	// Constructeur
	public plateau_frontiere()
	{
		length = 28; 
		frontiere = new face[length];
	}

	// Methode
	public void afficher_frontiere(plateau_frontiere A)
	// Affiche les elements a la frontiere
	{
		for (int i = 0; i <= A.length; i++)
		{
			System.out.println(A.frontiere[i]);
		}
	}
	
	

}
