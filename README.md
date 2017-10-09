# la-bataille
Jeu de carte "la bataille" dans le cadre du cours Java/UPMC

Instructions
============

Le jeu se compile avec la commande `mvn compile`.

Vous pouvez lancer une partie avec `mvn exec:java -Dexec.mainClass="upmc.game.Bataille"`

TP 1
====

* Le début de l'énoncé du TP se trouve à la fin du cours 1
* En plus, on vous demande de proposer un mode interactif dans lequel :
  1. Le système indique quelle joueur doit jouer.
  2. L'utilisateur peut décider de tirer une carte (simplement en appuyant sur "enter").
* Proposer un menu à 2 entrées : (1) Tirer la prochaine carte (2) Quitter.
* Permettez aux deux joueurs d'entrer leurs noms.
* Proposer un mode où un joueur peut jouer contre un ordinateur.
* Rendre le projet le plus ergonomique et soigné possible.
* Étendez les règles à votre sauce pour rendre le tout plus intéressant.
* Faites un rapport d'une page maximum pour expliquer les nouvelles règles implémentées.
* Veuillez à respecter la grille d'évaluation.

La date de rendu est sur le [site du cours](hyc.io/teaching/java.html).

TP 2
====

* Lire l'interface `LecturePseudo` pour lire le pseudo d'un joueur.
* Implémenter cette interface avec `LectureConsole` et `LectureFichier` pour lire les pseudos d'un fichier et de la console.
* Ajouter une classe `MenuPseudo` qui propose une méthode `public LecturePseudo lirePseudo()` qui va demander proposer un menu pour que l'utilisateur puisse choisir de quelles manières il veut lire les pseudos et renvoyer la classe correspondante.
* Utiliser `MenuPseudo` dans votre méthode `main` principale.

La date de rendu est sur le [site du cours](hyc.io/teaching/java.html).
