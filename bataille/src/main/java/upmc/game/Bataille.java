
package upmc.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bataille est la classe qui contient la methode principale du jeu de bataille
 */
public class Bataille {
    
    public static void main(String[] args) throws IOException {
        /**
         * Initialisation variables
         */
        
        Scanner scan = new Scanner(System.in);
        //int mode = 0;
        
        int resultatManche = 0;
        boolean bataille = false;
        Paquet deckTemp = new Paquet(false);
        Paquet deck = new Paquet(true);
        
        Joueur joueur1 = new Joueur("Joueur1");
        Joueur joueur2 = new Joueur("Joueur2");
        
        Carte carte1;
        Carte carte2;

        //Initialisation du jeu
        System.out.println(" La Bataille\n");
        System.out.println("Règle :\n - Chaque manche les deux joueurs jouent leurs cartes en meme temps.");
        System.out.println(" - Celui qui à la plus grande valeur gagne la manche.");
        System.out.println(" - Si les valeurs sont égales il y a bataille et il faut re-jouer chacun une nouvelle carte.");
        System.out.println("\nBut du jeu : avoir toutes les cartes.");
        System.out.println("\n BONNE CHANCE");
        deck.melange();

        //Choix du mode de jeu
        int mode = modePartie();

        //Choix du nom des joueurs
        System.out.println("Nom du Joueur 1 : ");
        joueur1.setNom(scan.nextLine());
        if (mode == 1) {
            System.out.println("Nom du Joueur 2 : ");
            joueur2.setNom(scan.nextLine());
        } else {
            System.out.println("Nom du Joueur 1 : ");
            joueur1.setNom(scan.nextLine());
            joueur2.setNom("Ordinateur");
        }

        

        

        //Distribution egales des cartes
        while (!deck.estVide()) {
            if (deck.nbCartes() % 2 == 0) {
                joueur1.ajouterCarte(deck.derniereCarte());
            } else {
                joueur2.ajouterCarte(deck.derniereCarte());
            }
        }

        //Boucle de jeu principale
        while (!joueur1.deckVide() && !joueur2.deckVide() && !joueur1.boolAbandon() && !joueur2.boolAbandon()) {
            //Tirages des cartes puis elles sont place dans une pile temporaire pour la suite
            carte1 = joueur1.tireCarte();
            carte2 = joueur2.tireCarte();
            deckTemp.ajouterCarte(carte1);
            deckTemp.ajouterCarte(carte2);

            //Compare les cartes
            if (!bataille) {
                System.out.println("\n");
            }
            System.out.println("(" + joueur1.afficheNom() + ")" + carte1.toString() + " VS " + carte2.toString() + "(" + joueur2.afficheNom() + ")");
            resultatManche = carte1.resultatManche(carte2);

            //Si joueur 1 gagne la manche
            if (resultatManche == 1) {
                System.out.println(joueur1.afficheNom() + " gagne la manche\n");
                joueur1.gagnePoint();
                //Le joueur 1 reprends les cartes
                while (!deckTemp.estVide()) {
                    joueur1.ajouterCarte(deckTemp.derniereCarte());
                }
                bataille = false;
            } //Si joueur 2 gagne la manche
            else if (resultatManche == -1) {
                System.out.println(joueur2.afficheNom() + " gagne la manche\n");
                joueur2.gagnePoint();
                //Le joueur 2 reprends les cartes
                while (!deckTemp.estVide()) {
                    joueur2.ajouterCarte(deckTemp.derniereCarte());
                }
                bataille = false;
            } 
            /**
             * Si bataille Les joueurs posent une carte suplementaire et on
             * revient au debut de la boucle avec cette fois plus de cartes dans
             * le deck temp jusqu'a ce qu'un joueur l'emporte
             */
            else {
                System.out.println("Bataille !\n");
                if (!joueur1.deckVide()) {
                    deckTemp.ajouterCarte(joueur1.tireCarte());
                }
                if (!joueur2.deckVide()) {
                    deckTemp.ajouterCarte(joueur2.tireCarte());
                }
                bataille = true;
            }
            /**
             * si bataille on passe cette etape Demande si les joueurs veulent
             * continuer ou abandonner
             */
            if (!bataille) {
                System.out.println("Chaque joueur peut maintenant choisir quoi faire :");
                System.out.println(" - entree : continuer\n - q+entree : abandonner\n - s+entree : afficher ses stats");
                choixJoueur(joueur1, joueur2);
                //S'il y a deux joueurs
                if (mode == 1) {
                    choixJoueur(joueur2, joueur1);
                }
            }
            //Affiche le joueur gagnant
            afficheGagnant(joueur1, joueur2);

        }
    }
    
    public static int modePartie (){
        int mode = 0;
        Scanner scan = new Scanner(System.in);
        
        while (mode != 1 && mode != 2 && mode != 3) {
            System.out.println("\nQuel mode de jeu voulez-vous ?");
            System.out.println(" 1. À deux joueurs\n 2. En solo contre l'ordinateur");
            System.out.println("Votre choix : ");
            mode = scan.nextInt();
        }
        //vide la ligne
        scan.nextLine();
        return mode;
    }

    /**
     * Demande au joueur s'il veut continuer ou abandoner ou voir le score
     */
    public static void choixJoueur(Joueur joueur, Joueur autreJoueur) {
        Scanner scanChoix = new Scanner(System.in);
        String choix = "undefined";

        while (!choix.equals("") && !choix.equals("q")) {
            System.out.println(joueur.afficheNom() + " : Que voulez-vous faire ? ");
            choix = scanChoix.nextLine();

            //Abandon
            if (choix.equals("q")) {
                joueur.abandonne();
                System.out.println("Le joueur " + joueur.afficheNom() + " abandonne !");
            } //Affiche le score
            else if (choix.equals("s")) {
                System.out.println(joueur.toString() + " | " + autreJoueur.toString() + "\n");

            }
        }
    }

    /**
     * Affichage du gagnant
     */
    public static void afficheGagnant(Joueur joueur1, Joueur joueur2) {
        //Si abandon
        if (joueur1.boolAbandon()) {
            System.out.println(joueur2.afficheNom() + " gagne par abandon de " + joueur1.afficheNom() + " !");
        } else if (joueur2.boolAbandon()) {
            System.out.println(joueur1.afficheNom() + " gagne par abandon de " + joueur2.afficheNom() + " !");
        } //Si plus de cartes
        else if (joueur1.deckVide()) {
            System.out.println(joueur2.afficheNom() + " gagne car" + joueur1.afficheNom() + " n'a plus de cartes !");
        } else if (joueur2.deckVide()) {
            System.out.println(joueur1.afficheNom() + " gagne car" + joueur2.afficheNom() + " n'a plus de cartes !");
        }

        System.out.println("===================");
        System.out.println("Score final : ");
        System.out.println(joueur1.toString() + " | " + joueur2.toString());
        System.out.println("===================");
    }
}
