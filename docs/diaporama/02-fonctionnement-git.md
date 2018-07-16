<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 2
### Fonctionnement de Git


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Mode de stockage

Stockage sous forme d'instantanés (_snapshot_)
 - et non différences (_deltas_)

Système de références (_cf._ lien symbolique)
 - pour éviter de stocker plusieurs fois un fichier non-modifié

On peut voir Git comme une sorte de mini système de fichiers
 - possédant en plus une dimension temporelle


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Schéma du mode de stockage

Différences (Subversion)
<div class="center">
	<img src="images/deltas.png" width="550px" />
</div>

Instantanés (Git)
<div class="center">
	<img src="images/snapshots.png" width="550px" />
</div>


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Travailler en local

La plupart des opérations se déroulent localement
 - car tout l'historique est stocké localement
 - donc pas de latence réseau
 - donc très rapide
 - et possibilité de travailler hors connexion
  - dans les transports (avion, train)
  - hors du réseau de l'Insee
  - quand GForge est tombé
 
Exemples
 - afficher l'historique
 - récupérer une ancienne version
 - générer un _patch_ entre deux versions d'un fichier

 