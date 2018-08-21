<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 11
### Réécrire l’historique


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Modifier la dernière validation

On se rend compte après <!-- .element: class="icon idea" --> *commit* d’une erreur :
 - faute dans le message
 - fichiers oubliés ou en trop
 - ...

Modifier simplement le message
 - `git commit --amend`
  - l’éditeur de texte s'ouvre, il contient le dernier message de *commit*
 - Aussi possible : `git commit --amend --message "Message de commit"`
 
Modifier aussi le contenu
 - indexer ou supprimer des modifications au préalable
  - `git add` ou `git rm`
 - puis `git commit --amend`

Interdit si les modifications ont déjà été poussées vers le dépôt distant <!-- .element: class="icon warn" -->


%%%




%%%

<!-- .slide: class="tp" -->
## [TP6](https://git.stable.innovation.insee.eu/wehdrc/formation-git#6-r%C3%A9%C3%A9crire-lhistorique)
<div class="center">
	<img src="images/keyboard.png" width="600px" class="blur" />
</div>