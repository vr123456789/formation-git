<!-- .slide: data-background-image="images/git-logo.png" data-background-size="600px" class="chapter" -->
## 1
### Opérations de base


---


<!-- .slide: class="slide" -->
### Cloner le code depuis le dépôt distant

```bash
git clone https://github.com/romain-warnan/git-au-quotidien.git
cd git-au-quotidien
```

Différence majeure par rapport à SVN
 - le dépôt entier est cloné : y compris l’historique
  - répertoire `.git/`
  - `git log`
 - dépôt local ≠ dépôt distant


%%%


<!-- .slide: data-background-image="images/eclipse-logo.png" data-background-size="700px" class="slide" -->
### Cloner à partir de FusionForge (1)

FusionForge, onglet « Code source » : copier l’url `git+ssh…`

<div class="center">
    <img src="egit/clone-0.0.png" class="boxed-img" />
</div>