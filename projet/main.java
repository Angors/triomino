package projet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		//www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Map/skip-list-impl.html
		
		
		//____________________CREATION DE LA PIOCHE____________________________//
		Pioche P = new Pioche();
		Scanner scan = new Scanner(System.in);
		
		
		
		
		
		// Deuxieme Etape : Choisir avec quel SD jouer 
		
		System.out.println("Choississez votre structure de Données pour votre jeu de triomino.");
		System.out.println("Ecrivez 1 pour Skip-list ou 2 pour un ABR");
		
		int sd = scan.nextInt();
		
		if (sd == 1)
		{
			System.out.println("Skip-List choisi");
		
			//__________________________PLATEAU REMPLI___________________//
			plateau_SL Jeu = new plateau_SL();
				
			System.out.println("Nombre de triominos a placer :");
			
			int rempli = scan.nextInt();
			
			
			for (int i = 0; i <rempli; i++)
			{
				int x = scan.nextInt();
				int y = scan.nextInt();
				int z = scan.nextInt();
				
				int compt = i;
				int compt2 = i+1;
				int compt3 = i+2;
				
				int coordx = scan.nextInt();
				int coordy = scan.nextInt();
				
				Jeu.SaisiePlateau_test(x,y,z,coordx,coordy,compt,compt2,compt3);
			}
				
			
			System.out.println("Veuillez remplir votre pioche. Choississez le nombre de triomino");
			rempli = scan.nextInt();
			
			for (int i = 0; i <rempli ;i++)
			{
				int x = scan.nextInt();
				int y = scan.nextInt();
				int z = scan.nextInt();
				
				P.SaisiePioche(x,y,z);
			}
			
			if (P.TaillePioche() == 0)
			{
				System.out.println("Pioche Vide" );
				return;
			}
				
				
			Jeu.OuPlacerTriomino();	
			
			
				
			/*	
				o = Jeu.ajouter_SL(test1, o);
				System.out.println(Jeu.Recherche(test1));
				
				o = Jeu.ajouter_SL(test2, o);
				System.out.println(Jeu.Recherche(test2));
				
				o = Jeu.ajouter_SL(test3, o);
				System.out.println(Jeu.Recherche(test3));
				//Jeu.OuPlacerTriomino(o); 
				
				Jeu.GetCellule(14, 14);

				//o = Jeu.ajouter_SL(test, o);
				System.out.println(o);
				
				Jeu.GetCellule(14, 15);
				Jeu.GetCellule(15, 14);
				Jeu.GetCellule(15, 15);
				*/
				//o = Jeu.ajouter(P.get(5), o);
				//System.out.println(o);
				//System.out.println(Jeu.Recherche(P.get(2))); // Retourne false donc t n'a pas pu être ajouté
				
				//Jeu.OuPlacerTriomino(o);
				
				//System.out.println(Jeu.cote_libre.n); // Retourne correctement 3
				//System.out.println(Jeu.cote_libre.get("0")); // retourne (-oo, null)
			
		} else {
			if (sd == 2)
			{
				System.out.println("ABR choisit");
				
				plateau Jeu_ABR = new plateau();
				
				System.out.println("Nombre de triominos a placer :");
				
				int rempli = scan.nextInt();
				
				
				for (int i = 0; i <rempli; i++)
				{
					int x = scan.nextInt();
					int y = scan.nextInt();
					int z = scan.nextInt();
					
					int compt = i;
					int compt2 = i+1;
					int compt3 = i+2;
					
					int coordx = scan.nextInt();
					int coordy = scan.nextInt();
					
					Jeu_ABR.SaisiePlateau_test(x,y,z,coordx,coordy,compt,compt2,compt3);
				}
					
				
				System.out.println("Veuillez remplir votre pioche. Choississez le nombre de triomino");
				rempli = scan.nextInt();
				
				for (int i = 0; i <rempli ;i++)
				{
					int x = scan.nextInt();
					int y = scan.nextInt();
					int z = scan.nextInt();
					
					P.SaisiePioche(x,y,z);
				}
				
				if (P.TaillePioche() == 0)
				{
					System.out.println("Pioche Vide" );
					return;
				}
					
					
				Jeu_ABR.OuPlacerTriomino(P.get(1));	
				
				
				
			} else {
				System.out.println("Erreur ! Veuillez saisir 1 ou 2 ! (1:Skip-list, 2:ABR)");
				sd = scan.nextInt();
			}
		}
		
		
		
		// Note : Skip list bien instanciée, on peut afficher la valeur a la clef
		//		  Chacunes de ces clefs seront "l'identité" des triominos présents dans la Skip list
		
		// On créé le plateau (Tableau 2D) qui fera office de plateau de jeu
		
		//plateau Jeu = new plateau();
		
		// On initialise toutes les cases du tableau

	}

	private static String toString(int j) {
		// TODO Auto-generated method stub
		return null;
	}
}