package upmc.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MenuPseudo {
    
  /**
   *Choix du mode de lecture des pseudos 
   */  
    
    public LecturePseudo modeLecturePseudo() throws IOException{
        System.out.println("Renseigner les pseudos par \n 1. Console \n 2. Fichier");
        
        Scanner sc = new Scanner(System.in);   
        int mode = sc.nextInt();
// Si choix en mode console
        if(mode==1){
            System.out.println("Vous avez séléctioné le mode console");
            
            LectureConsole lc = new LectureConsole();
            ArrayList<String> tab_console = lc.lirePseudo(); 

            Joueur joueur1 = new Joueur(tab_console.get(0));
            Joueur joueur2 = new Joueur(tab_console.get(1)); 
// Si choix en mode fichier
        }else if(mode==2){
            System.out.println("Vous avez séléctioné le mode Fichier");
            
            LectureFichier lf = new LectureFichier(); 
            ArrayList<String> tab_fichier = lf.lirePseudo(); 

            Joueur joueur1 = new Joueur(tab_fichier.get(0));
            Joueur joueur2 = new Joueur(tab_fichier.get(1)); 
            
        }
        else{
            System.out.println("Il y a un probleme de séléction \n Veuillez saisir 1 ou 2");
            modeLecturePseudo();
        }
        return null;
    }   
}