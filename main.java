package projet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class main {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void TriominosAPlacer(ArrayList<triomino> main,int nb)
	{
		for (int i = 0; i < nb; i++)
		{
			int x = scan.nextInt();
			int y = scan.nextInt();
			int z = scan.nextInt();
			
			triomino saisie = new triomino(x,y,z);
			main.add(saisie);
		}
	}
	
	public static void main(String[] args) {
		
		//www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Map/skip-list-impl.html
		
		
		//____________________CREATION DE LA PIOCHE____________________________//
		Pioche P = new Pioche();
		Scanner scan = new Scanner(System.in);
		
		
		//___________________________MAIN JOUEUR_____________________________//
		
		ArrayList<triomino> Main_Joueur= new ArrayList<triomino>(); 
		Random rand = new Random();
		
		
		
		// Deuxieme Etape : Choisir avec quel SD jouer 
		
		System.out.println("Choississez votre structure de Donn�es pour votre jeu de triomino.");
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
				System.out.println("Pioche vide. Fin du jeu.");
				return;
			}	
			
			int o = 0;
			
			
			// ________________________ JEU DU TRIOMINO ___________________________//
		
			System.out.println("Veuillez saisir le nombre de triomino que vous voulez en main");
			
			int nb = scan.nextInt();
			
			TriominosAPlacer(Main_Joueur, nb); // Saisie de la main du joueur
			
			// Jouer //
				
			while (Main_Joueur.isEmpty() == false || o == 30)
			{
				if(Main_Joueur.size() == 1 && P.pioche.size() > 0)
				{
					int randy = rand.nextInt(P.pioche.size());
					Main_Joueur.add(P.get(randy));
					P.RetirerPioche(randy);
				}
				
				if(Main_Joueur.size() == 1 && P.pioche.size() == 0)
				{
					o = Jeu.ajouter_SL(Main_Joueur.get(0), o);
					Main_Joueur.remove(0);
				}
				
				System.out.println("Saisissez quel Triomino jouer");
				int x = scan.nextInt();
				
				if(x >= 0 && x < Main_Joueur.size()) 
				{
					o = Jeu.ajouter_SL(Main_Joueur.get(x), o);
					Main_Joueur.remove(x);
				}
			}
							  // Ou pour eviter les boucles infinis
				
				
			
				
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
				//System.out.println(Jeu.Recherche(P.get(2))); // Retourne false donc t n'a pas pu �tre ajout�
				
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
					
				int o = 0; // Initialisation du nombre de coup en d�but de partie
				
				Jeu_ABR.OuPlacerTriomino(P.get(1));	
				
				// Probleme ajout sur ABR
				
				o = Jeu_ABR.ajouter_SL(P.get(1), o);
				o = Jeu_ABR.ajouter_SL(P.get(0), o);
				
				
			} else {
				System.out.println("Erreur ! Veuillez saisir 1 ou 2 ! (1:Skip-list, 2:ABR)");
				sd = scan.nextInt();
			}
		}
		
		
		
		// Note : Skip list bien instanci�e, on peut afficher la valeur a la clef
		//		  Chacunes de ces clefs seront "l'identit�" des triominos pr�sents dans la Skip list
		
		// On cr�� le plateau (Tableau 2D) qui fera office de plateau de jeu
		
		//plateau Jeu = new plateau();
		
		// On initialise toutes les cases du tableau

	}

	private static String toString(int j) {
		// TODO Auto-generated method stub
		return null;
	}
}