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
