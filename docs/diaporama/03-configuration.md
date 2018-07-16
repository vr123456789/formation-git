<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 3
### Configuration et personalisation


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Configuration de base

Système de surcharge à trois niveaux

`--system` : pour tous les utilisateurs
 - `/c/ProgramData/Git/config`

```ini
core.symlinks=false
core.autocrlf=true
```

`--global` : pour tous les dépôts de l'utilisateur
 - `~/.gitconfig`

```ini
user.name=Prénom Nom
user.email=prenom.nom@insee.fr
alias.lg=log --oneline
```

`--local` : uniquement pour un dépot
 - `./.git/config`

```ini
remote.origin.url=ssh://git@git.stable.innovation.insee.eu:22222/wehdrc/formation-git.git
branch.master.remote=origin
```


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
Configuration obligatoire pour commiter :
```bash
git config --global user.name "Prénom Nom"
git config --global user.email "prenom.nom@insee.fr"
```