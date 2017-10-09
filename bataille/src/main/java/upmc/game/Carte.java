package upmc.game;

public class Carte {
    /**
     * Attributs
     */
    private int valeur;
    private int couleur;
    
    public static String tableauCouleur[] = {" de Trèfle"," de Cœur"," de Carreau"," de Pique"};
    public static String tableauValeur[] = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Roi","1"};
    
    /**
     * Constructeur d'une carte 
     */
    public Carte(int pcouleur, int pvaleur) {
        this.valeur = pvaleur;
        this.couleur = pcouleur;
     }
    /**
     * Retourne la valeur de la carte
     */
    public int getValeur() {
        return valeur;
    }
    /**
     * Dédinit la valeur de la carte 
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    /**
     * Retourne la couleur de la carte 
     */
    public int getCouleur() {
        return couleur;
    }
    /**
     * Dédinit la couleur de la carte
     */
    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
    /**
     * Retourne le résultat d'une manche 
     * en comparant Les deux cartes jouées
     */
     public int resultatManche(Carte carteAdverse) {  
        if(this.valeur > carteAdverse.valeur)
            return 1;
        else if (this.valeur < carteAdverse.valeur)
            return -1;
        else
            return 0;
    }
    /**
     * Retourne l'affichage de la carte
     */ 
    public String toString() {
        String retour = tableauValeur[valeur] + tableauCouleur[couleur] ;                
        return  retour ;
    }
}