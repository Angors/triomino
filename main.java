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
			System.out.println("Votre plateau sera-t-il deja rempli ? Ecrivez '0' ou le nombre de triomino que vous voulez saisir . ");
			int rempli = scan.nextInt();
			
			if (rempli != 0) 
			{
				//__________________________PLATEAU REMPLI___________________//
				plateau Jeu = new plateau(rempli);
				
				System.out.println(Jeu.cote_libre.nbTrio); // retourne 0
				
				triomino test = new triomino(1,5,2);
				triomino test1 = new triomino(2,5,2);
				triomino test2 = new triomino(3,4,2);
				triomino test3 = new triomino(4,5,2);
				
				System.out.println(Jeu.plat[0][0].get_ne().getX());
				System.out.println(Jeu.plat[0][0].get_ne().getY()); // retourne bien -1, case vide
				
				
				// On ajoute le premier triomino
				
				int o = 0; // nbc est a 0 car on a pas encore commencé à jouer
			
				o = Jeu.ajouter_SL(test,o);
				System.out.println(Jeu.Recherche(test)); // Retourne bien true
				System.out.println(o); // retourne correctement 3
				
				o = Jeu.ajouter_SL(test1, o);
				System.out.println(Jeu.Recherche(test1));
				
				o = Jeu.ajouter_SL(test2, o);
				System.out.println(Jeu.Recherche(test2));
				
				o = Jeu.ajouter_SL(test3, o);
				System.out.println(Jeu.Recherche(test3));
				//Jeu.OuPlacerTriomino(o); 
				
				Jeu.GetCellule(14, 14);

				o = Jeu.ajouter_SL(test, o);
				System.out.println(o);
				
				Jeu.GetCellule(14, 15);
				Jeu.GetCellule(15, 14);
				Jeu.GetCellule(15, 15);
				
				//o = Jeu.ajouter(P.get(5), o);
				//System.out.println(o);
				//System.out.println(Jeu.Recherche(P.get(2))); // Retourne false donc t n'a pas pu être ajouté
				
				//Jeu.OuPlacerTriomino(o);
				
				//System.out.println(Jeu.cote_libre.n); // Retourne correctement 3
				//System.out.println(Jeu.cote_libre.get("0")); // retourne (-oo, null)
			
			}
			else
			{
				// ___________________ PLATEAU VIDE ___________________________//
			plateau Jeu = new plateau(); 
			System.out.println(Jeu.cote_libre.nbTrio); // retourne 0
			
			triomino test = new triomino(1,5,2);
			
			System.out.println(Jeu.plat[0][0].get_ne().getX());
			System.out.println(Jeu.plat[0][0].get_ne().getY()); // retourne bien -1, case vide
			
			
			// On ajoute le premier triomino
			
			int o = 0; // nbc est a 0 car on a pas encore commencé à jouer
		
			o = Jeu.ajouter_SL(test,o);
			System.out.println(Jeu.Recherche(test)); // Retourne bien true
			System.out.println(o); // retourne correctement 3
			
			Jeu.OuPlacerTriomino(o); 
			
			Jeu.GetCellule(14, 14);

			o = Jeu.ajouter_SL(test, o);
			System.out.println(o);
			
			Jeu.GetCellule(14, 15);
			Jeu.GetCellule(15, 14);
			Jeu.GetCellule(15, 15);
			
			//o = Jeu.ajouter(P.get(5), o);
			//System.out.println(o);
			//System.out.println(Jeu.Recherche(P.get(2))); // Retourne false donc t n'a pas pu être ajouté
			
			//Jeu.OuPlacerTriomino(o);
			
			//System.out.println(Jeu.cote_libre.n); // Retourne correctement 3
			//System.out.println(Jeu.cote_libre.get("0")); // retourne (-oo, null)
			}
		} else {
			if (sd == 2)
			{
				System.out.println("ABR choisit");
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