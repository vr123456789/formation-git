<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 7
### Branches


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" -->
### Stockage des éléments dans Git

Un _commit_
<div class="center">
	<img src="images/commit-and-tree.png" width="800px" />
</div>


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" -->
### Stockage des éléments dans Git

La succession des _commits_
<div class="center">
	<img src="images/commits-and-parents.png" width="800px" />
</div>


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Notion de branche dans Git

Une branche dans Git est simplement un pointeur léger et déplaçable vers un _commit_

À chaque nouveau _commit_, la branche « avance »
 - elle pointe vers le dernier _commit_

Créer une nouvelle branche :
 - `git branch <branch_name>`
 - on reste dans la branche d'origine

Basculer dans une autre branche
 - `git checkout <branch_name>`
 - on ne peut basculer dans une branche que il n'y a pas de risque de perdre de changements
 - sinon : valider (_commit_) ou remiser (_stash_) avant de changer de branche 

Pour créer une branche et basculer dans cette branche <!-- .element: class="icon idea" --> :
 - `git checkout -b <branch_name>`


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" -->
### Branche : schéma
<div class="center fragment fade-in-then-out">
	<img src="images/branches/head-to-master.png" width="700px" />
</div>
<div class="center fragment fade-in-then-out">
	<img src="images/branches/head-to-testing.png" width="700px" />
</div>
<div class="center fragment fade-in-then-out">
	<img src="images/branches/advance-testing.png" width="700px" />
</div>
<div class="center fragment fade-in-then-out">
	<img src="images/branches/checkout-master.png" width="700px" />
</div>
<div class="center fragment fade-in-then-out">
	<img src="images/branches/advance-master.png" width="700px" />
</div>


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Détail

 - une branche est un _hash_ de 40 caractères
  - dans un fichier du dossier `.git/refs/heads/`
  - par exemple : `.git/refs/heads/master`

  - par exemple la contenu du fichier `.git/refs/heads/master` contient le _hash_ du dernier _commit_