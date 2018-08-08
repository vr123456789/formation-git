<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 2
### Fonctionnement de Git


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Mode de stockage

Stockage sous forme d’instantanés (_snapshot_)
 - et non de différences (_deltas_)

Système de références (_cf._ lien symbolique)
 - pour éviter de stocker plusieurs fois un fichier non-modifié

On peut voir Git comme une sorte de mini système de fichiers
 - possédant en plus une dimension temporelle


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" -->
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


<!-- .slide: class="slide" -->
### Aperçu de la structure du dépôt Git

Le dépôt Git local est situé dans le répertoire `.git/` du projet :
<div class="center">
	<img src="images/content-git.png" width="400px" />
</div>


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Travailler en local

La plupart des opérations se déroulent localement
 - car tout l’historique est stocké localement
 - donc pas de latence réseau
 - donc très rapide
 - et possibilité de travailler hors connexion
  - dans les transports (avion, train)
  - hors du réseau de l’Insee
  - quand GForge est tombé
 
Exemples
 - afficher l’historique
 - récupérer une ancienne version
 - générer un _patch_ entre deux versions d’un fichier




%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Intégrité des données

Tout est vérifié par une somme de contrôle (_checksum_)
 - algorithme `SHA-1`
  - `[0-9a-f]{40}`
  - exemple : `0dbfc1be5cb26d6325978929debf753681af7b69`
 
Les objets sont identifiés par la somme de contrôle de leur contenu
 - il est impossible de modifier le contenu d’un fichier ou d’un dossier sans que Git ne le détecte
 - il ne peut pas y avoir de corruption de donnée sur le réseau

Sauf exception, Git ne fait qu’ajouter de nouvelles données
 - il est presque impossible de perdre son travail
 - on court peu de risques de faire une grosse bêtise
 

%%%


<!-- .slide: class="slide" -->
### Les trois états d’un fichier

<div class="center">
	<img src="images/three-states.png" />
</div>