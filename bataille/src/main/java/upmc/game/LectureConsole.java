package upmc.game;

import java.util.ArrayList;
import java.util.Scanner;


public class LectureConsole implements LecturePseudo{
    
    private ArrayList<String> pseudo = new ArrayList<String>(); 
        
    public ArrayList<String> lirePseudo() {
        
        for(int joueurNo = 1; joueurNo<=2; joueurNo++) {
            System.out.println("Veuillez entrer le nom du joueur " + joueurNo);
            Scanner sc = new Scanner(System.in);
            this.pseudo.add(sc.nextLine());
        }
        return this.pseudo;
    }
}