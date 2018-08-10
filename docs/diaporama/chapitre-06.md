<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 6
### Dépôts distants


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Travailler avec des dépôts distants

Collaborer au même projet
 - partager son travail
  - `git push`
  - « pousser » ses modifications
 - récupérer le travail des autres développeurs
  - `git fetch` ou `git pull`
  - « tirer » les modifications des autres

Il peut exister plusieurs dépôts distants
 - droits en lecture seule ou en lecture / écriture
 - exemple de la contribution à un projet libre


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Connexion à un dépôt distant

Soit automatique lors q'un `git clone`
 - après le clonage, le dépôt local est automatiquement relié au dépôt distant
 - alias du dépôt distant : `origin`

Soit manuellement
 - exemple 1 : suite à `git init`, aucun dépôt distant n'est configuré

```bash
git remote add origin https://git.stable.innovation.insee.eu/wehdrc/formation-git.git
```

 - exemple 2 : si on contribue à un projet libre

```bash
git clone git@github.com:romain/react.git # lecture / écriture (fork)
git remote add upstream https://github.com/facebook/react.git # lecture seule
```

On peut lister les dépôts distants avec leurs adresses :

```bash
$ git remote -v
origin	git@github.com/romain/react.git (fetch)
origin	git@github.com/romain/react.git (push)
upstream	https://github.com/facebook/react.git (fetch)
upstream	https://github.com/facebook/react.git (push)
```
