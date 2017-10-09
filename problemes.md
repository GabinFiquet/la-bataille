Problèmes Github
================

Classe A
********

* Fork le dépôt et modifier le projet sur le dépôt forké
* Mettre son nom sur le dépôt Github (sinon comment je sais que c'est vous ?)
* Tester le projet avant de le rendre, régler les conflits:

```
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 2a0aa9fd2b4ecdb54dbb9ee8ac1e295cb54597e8
```

À faire (entre autres !!) :

1. Supprimer les dépôts qui ne sont pas forkés.
2. Supprimer les forks inutiles si vous avez plusieurs comptes.
3. Ne créer pas un autre projet bataille à l'intérieur du projet, modifier le code existant.
4. Faites un git pull de mon répertoire.

Classe B
********

* Petit commit et messages explicites.
* Ne pas commit dans le dépôt les fichiers générés (.class, dossier "dist"/"build"/"classes"/"nbproject"/...)


Problèmes projet
================

Classe A
********

* Il faut que le projet compile avec Maven, donc vous devez avoir un pom.xml !
* Respecter les packages initiaux.
* Indentation clair.

Classe C
********

* Ne pas mélanger les tabulations et les espaces, préférer indenter avec des espaces.
Il faut aussi que l'indentation soit consistente (2 ou 4 espaces partout par exemple).

Problèmes code
==============

Classe A
********

* Il faut faire des petites méthodes et pas tout mettre dans le main ou une autre méthode. (max environ 10 lignes par méthode).
* DRY: Don't repeat yourself!! Il ne doit pas y avoir deux lignes de code qui ont l'air pareil.
* Découper le code en classes ! (au moins comme dans l'énoncé mais vous pouvez toujours faire plus de classes si ça aide).

Classe B
********

* Méthode en minuscule / nom de classe en Majuscule

Classe C
********

* Les commentaires comme :

```
    /**
     * Affiche le nombre de carte
     */
    public String afficheNbCartes()
```

ne sont pas très utiles vu qu'ils répètent le nom de la méthode.
Privilégier d'abord les commentaires globaux à la classe: comment est-ce que votre code fonctionne ?

* Le franglais `addCarteToPaquet`, `showMenuPartie`,... interdit.