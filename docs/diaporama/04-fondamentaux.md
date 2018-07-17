<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 4
### Fondamentaux


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Obtenir un dépôt Git

Transformer un dossier en dépôt Git
 - `git init`
 - Le répertoire `.git/` est créé dans le dossier
 - Il ne contient aucun commit
 - Les fichiers déjà présents sont considérés comme non suivis par Git (_untracked_) 
 
Clôner un dépôt Git distant
 - `git clone <url>`
 - Le dépôt complet est copié à partir de l'url dans un dossier `.git/` local
  - `git clone ssh://git@git.stable.innovation.insee.eu:22222/wehdrc/formation-git.git`
  - &rarr; `formation-git/.git/`
 - La dernière version de la branche `master` est extraite
 - Le dépôt local reste connecté au dépôt distant
  - `cat .git/config` :

```bash
[remote "origin"]
	url = ssh://git@git.stable.innovation.insee.eu:22222/wehdrc/formation-git.git
```