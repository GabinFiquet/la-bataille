package upmc.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paquet {
    //--
    // Attributs
    //--
    private List<Carte> tas_joueur = new ArrayList<Carte>();
    
    /**
     * Constructeur faisant un deck par rapport aux parametres des cartes.
     * Prends en parametre un boolean remplissage
     * si faux : cree un deck vide
     * si vrai : rempli le deck de cartes 
     */
    public Paquet(boolean remplissage) {
        if(remplissage==true){
            for(int c=0; c < Carte.tableauCouleur.length; c++) {
                for(int v=0; v < Carte.tableauValeur.length; v++ ) {
                    Carte carteActuelle = new Carte(c,v);           
                    tas_joueur.add(carteActuelle);
                }
            }
        }
    }
    
    /**
     * Retourne le nombre de carte
     */
    public int nbCartes() {
        return this.tas_joueur.size();
    }
    
    /**
     * Retourne le paquet de cartes en entier
     */
    public String toString() {
        String result="";

        for(int i=0; i<tas_joueur.size(); i++){
            result+=(i+1)+" : "+tas_joueur.get(i).toString()+"\n";
        }
        return result;
    }
    
    /**
     * Retourne vrai si le deck est vide, sinon retourne faux
     */
    public boolean estVide() {        
        if(this.tas_joueur.size() == 0) 
            return true;
        else
            return false;
    }
    
    /**
     * Melange le deck
     */
    public void melange() {
        Collections.shuffle(this.tas_joueur);
    }
    
    /**
     * Retourne la dernière cartes du deck et la supprime
     */
    public Carte derniereCarte() {
        return this.tas_joueur.remove(tas_joueur.size()-1);
    }
    
    /**
     * Ajoute une carte au debut du deck
     */
    public void ajouterCarte(Carte parCarte) {
        this.tas_joueur.add(0, parCarte);
    }
}