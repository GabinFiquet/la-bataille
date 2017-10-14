package upmc.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;


public class LectureFichier {
    
    private ArrayList<String> pseudo = new ArrayList<String>(); 
    
    public ArrayList<String> lirePseudo() throws FileNotFoundException, IOException {
        
        
        System.out.println("Veuillez indiquer le nom du fichier .rtf");
        Scanner sc_nom_fichier = new Scanner(System.in);
        String nom_fichier = sc_nom_fichier.nextLine();
        
        File f = new File(nom_fichier+ ".rtf");
        
        FileInputStream fis = null;
        
        
        if(f.exists()){ 
            System.out.println("Vous avez selectionné le fichier : " +nom_fichier+ ".rtf");
            
            
            try {
                FileReader c = new FileReader(nom_fichier +".rtf");
                BufferedReader r = new BufferedReader(c);

                String line = r.readLine();
                
                System.out.println("Les pseudos des joueurs sont : ");
                while (line != null) {
                    String[] decompose = line.split(";");
                    String a = decompose[0];
                    System.out.println(a);
                    this.pseudo.add(a);
                    line = r.readLine();
                }

                r.close();

            } catch (IOException e) {
                    throw new Error(e);
            }
        }else{
            System.out.println(nom_fichier + ".rtf  n'existe pas"); 
            lirePseudo();
        }
        return this.pseudo;
    }   
}