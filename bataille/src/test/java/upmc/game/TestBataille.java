
package upmc.game;

import org.junit.*;


public class TestBataille{
    private Bataille batailletest;
  
  @Before
  public void testBataille() {
    batailletest = new Bataille();
  }
    
    @Test
    public void testChoixJoueur(){
        // Arrange
        Joueur joueur = new Joueur("joueur1");
        Joueur autreJoueur = new Joueur("autreJoueur");
        // Act
        batailletest.choixJoueur(joueur, autreJoueur);
    }
    
    @Test
    public void testAfficheGagnant(){
        // Arrange
        Joueur joueur = new Joueur("joueur1");
        Joueur autreJoueur = new Joueur("autreJoueur");
        // Act
        batailletest.choixJoueur(joueur, autreJoueur);
    }
}
