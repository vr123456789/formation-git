<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 5
### Historique des validations


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Lister l’historique des validations : `git log`

Lister en ordre chronologique inversé les validations réalisées :
 - `git log`

<div class="center">
	<img src="images/log.png" width="800px" />
</div>

 - Utiliser les flèches « &uarr; » et « &darr; » pour naviguer dans l'historique
 - Taper « q » pour quitter


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Afficher plus d'informations dans l'historique

Patch de chaque *commit* :
 - `git log --patch` ou `git log -p`
 - permet de connaître toutes les modifications apportées par un *commit*
 - assez verbeux

Liste des fichiers modifiés par chaque *commit* :
 - `git log --name-only`
<div class="center">
	<img src="images/log-name-only.png" width="800px" />
</div>

