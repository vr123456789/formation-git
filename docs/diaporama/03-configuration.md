<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 3
### Configuration et personalisation


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Le système de configuration

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
### Configuration de base

Configuration obligatoire pour commiter :
```bash
git config --global user.name "Prénom Nom"
git config --global user.email "prenom.nom@insee.fr"
```

Configuration bien utile :
```bash
# Éditeur de texte pour les messages de commit, etc.
git config --global core.editor vim

# Pour utiliser notepad++
git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -nosession"

# Afficher l'ancêtre commun dans les conflits
git config --global merge.conflictstyle diff3

# Paraméter le proxy de l'Insee
git config --global http.proxy http://proxy-rie.http.insee.fr:8080
git config --global https.proxy http://proxy-rie.http.insee.fr:8080

# Alias pour commit : git co
git config --global alias.co=commit

# Alias pour afficher une belle log : git lg
git config --global alias.lg = log --color --graph --abbrev-commit --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset'
```


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Consulter la configuration
Résultat dans les fichiers de configuration, par exemple `~/.gitconfig` :

```ini
[user]
	name = Romain Warnan
	email = romain.warnan@insee.fr
[merge]
	conflictstyle = diff3
[core]
	editor = vim
[http]
	proxy = http://proxy-rie.http.insee.fr:8080
[alias]
	co = commit
```

Voir la valeur d'une propriété :
```bash
git config user.name
```

Lister toute la configuration avec le nom du fichier
```bash
git config --list --show-origin
```


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Accéder à la documentation

Documentation complète dans le terminal :
```bash
git help <verb>
```

Autant aller voir sur internet en français :
 - [Git Book (fr)](https://git-scm.com/book/fr/v1/)

Pour un aide-mémoire rapide :
```bash
git <verb> -h
```