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


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Affichage compact de l'historique

`git log --oneline`
 - une ligne par *commit*
 - *hash* abrégé sur 7 caractères
 - équivalent à `git log --pretty=oneline --abbrev-commit`

<div class="center">
	<img src="images/log-oneline.png" width="800px" />
</div>


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Visualisation des branches dans l'historique
`git log --graph [--oneline]`

<div class="center">
	<img src="images/log-graph.png" width="800px" />
</div>


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Personnaliser l'affichage de l'historique
`git log --pretty=format:"%h - %an, %ar : %s"`
 - [liste des options &rarr;](https://git-scm.com/book/fr/v2/Les-bases-de-Git-Visualiser-l%E2%80%99historique-des-validations#pretty_format)
 - [liste des couleurs &rarr;](https://stackoverflow.com/questions/15458237/git-pretty-format-colors/15458378#15458378)

Exemple :
```
log --color --graph --abbrev-commit --pretty=format:'%C(bold magenta)%h%Creset -%C(yellow)%d%Creset %s %C(green)(%cr) %C(cyan)<%an>%Creset'
```

<div class="center">
	<img src="images/log-pretty.png" width="900px" />
</div>