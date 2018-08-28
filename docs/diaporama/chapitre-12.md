<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 12
### Boite à outils Git


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Faire référence à un *commit*

Il existe plusieurs manière de faie référence à un *commit* dans une commande Git :

Références fixes dans le temps :
 - le SHA-1 : `847ef1c44c7ad48c86889e03943bb9d0315dfa1a`
 - une partie du SHA-1 : `847ef1c`
  - minimum 4 caratères et pas d'ambiguïté
 - le nom d'un *tag* : `v3.0`
 
Références qui évoluent
 - le nom d'une branche : `tp6`
 - le pointeur `HEAD`
 - une *reflog* : `HEAD@{5}`
  - `git reflog` ou `git log -g` pour les lister