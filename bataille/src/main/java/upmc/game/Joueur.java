package upmc.game;

public class Joueur {

    /**
     * Attributs
     */
    private String nom;
    private Paquet deck = new Paquet(false);
    private boolean abandon = false;
    private int point = 0;

    /**
     * Constructeur d'un Joueur
     */
    public Joueur(String pnom) {
        this.nom = pnom;
    }

    /**
     * Retourne l'affichage le nom plus ne nombre de cartes plus les points d'un
     * joueur (le score d'un joueur)
     */
    public String toString() {
        //Si le joueur a une carte ou moins et qu'il a un point ou moins
        if (this.deck.nbCartes() <= 1 && this.point <= 1) {
            return this.nom + " : " + this.deck.nbCartes() + " carte / " + this.point + " point";
        } //Si le joueur a plus d'une carte et qu'il a un point ou moins
        else if (this.deck.nbCartes() > 1 && this.point <= 1) {
            return this.nom + " : " + this.deck.nbCartes() + " cartes / " + this.point + " point";
        } //Si le joueur a une carte ou moins et qu'il a plus d'un point
        else if (this.deck.nbCartes() <= 1 && this.point > 1) {
            return this.nom + " : " + this.deck.nbCartes() + " carte / " + this.point + " points";
        } //Si le joueur a plus d'une carte et qu'il a plus d'un point
        else {
            return this.nom + " : " + this.deck.nbCartes() + " cartes / " + this.point + " points";
        }
    }

    /**
     * Affichage du nom du joueur
     */
    public String afficheNom() {
        return this.nom;
    }

    /**
     * Affichage du score du joueur
     */
    public String afficheScore() {
        return "Le score de " + this.nom + " est de " + this.point;
    }

    /**
     * Affichage du nombre de cartes
     */
    public String afficheNbCartes() {
        //Si le joueur a une carte ou moins
        if (this.deck.nbCartes() <= 1) {
            return "Le joueur " + this.nom + " possede " + this.deck.nbCartes() + " carte";
        } //Si le joueur a plus d'une carte
        else {
            return "Le joueur " + this.nom + " possede " + this.deck.nbCartes() + " cartes";
        }
    }

    /**
     * Change le nom du joueur
     */
    public void setNom(String pnom) {
        this.nom = pnom;
    }

    /**
     * L'attribut abandon du joueur passe à vrai
     */
    public void abandonne() {
        this.abandon = true;
    }

    /**
     * Retourne un boolean pour indiquer si le joueur a abandonner
     */
    public boolean boolAbandon() {
        if (this.abandon) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retourne vrai si le deck du joueur est vide sinon retourne faux
     */
    public boolean deckVide() {
        if (this.deck.estVide()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Ajoute une carte au debut du deck du joueur
     */
    public void ajouterCarte(Carte pCarte) {
        this.deck.ajouterCarte(pCarte);
    }

    /**
     * Tirage d'une carte pour la jouer
     */
    public Carte tireCarte() {
        return deck.derniereCarte();
    }

    /**
     * Incrémente le score du joueur
     */
    public void gagnePoint() {
        this.point++;
    }
}
