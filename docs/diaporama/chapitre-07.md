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
 - on reste dans la branche d’origine

Basculer dans une autre branche
 - `git checkout <branch_name>`
 - on ne peut basculer dans une branche que il n’y a pas de risque de perdre de changements
 - sinon : valider (_commit_) ou remiser (_stash_) avant de changer de branche 

Pour créer une branche et basculer dans cette branche <!-- .element: class="icon idea" --> :
 - `git checkout -b <branch_name>`


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" -->
### Branche : schéma
<div class="center fragment fade-in-then-out">
	<pre><code class="lang-bash hljs">git checkout master</code></pre>
	<div class="fixed-height"><img src="images/branches/branch-and-history.png" width="700px" /></div>
<pre><code class="lang-bash hljs">cat .git/HEAD # ref: refs/heads/master
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # cat: .git/refs/heads/testing: No such file or directory</code></pre>
</div>

<div class="center fragment fade-in-then-out">
	<pre><code class="lang-bash hljs">git branch testing</code></pre>
	<div class="fixed-height"><img src="images/branches/head-to-master.png" width="700px" /></div>
<pre><code class="lang-bash hljs">cat .git/HEAD # ref: refs/heads/master
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # f30ab</code></pre>
</div>

<div class="center fragment fade-in-then-out">
	<pre><code class="lang-bash hljs">git checkout testing</code></pre>
	<div class="fixed-height"><img src="images/branches/head-to-testing.png" width="700px" /></div>
<pre><code class="lang-bash hljs">cat .git/HEAD # ref: refs/heads/testing
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # f30ab</code></pre>
</div>

<div class="center fragment fade-in-then-out">
	<pre><code class="lang-bash hljs">git commit -m "Commit dans la branche 'testing'"</code></pre>
	<div class="fixed-height"><img src="images/branches/advance-testing.png" width="700px" /></div>
<pre><code class="lang-bash hljs">cat .git/HEAD # ref: refs/heads/testing
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # 87ab2</code></pre>
</div>

<div class="center fragment fade-in-then-out">
	<pre><code class="lang-bash hljs">git checkout master</code></pre>
	<div class="fixed-height"><img src="images/branches/checkout-master.png" width="700px" /></div>
<pre><code class="lang-bash hljs">cat .git/HEAD # ref: refs/heads/master
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # 87ab2</code></pre>
</div>

<div class="center fragment fade-in-then-out">
	<pre><code class="lang-bash hljs">git commit -m "Commit dans la branche 'master'"</code></pre>
	<div class="fixed-height"><img src="images/branches/advance-master.png" width="700px" /></div>
<pre><code class="lang-bash hljs">cat .git/HEAD # ref: refs/heads/master
cat .git/refs/heads/master # c2b9e
cat .git/refs/heads/testing # 87ab2</code></pre>
</div>


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Remarques sur les branches

Avec Git, travailler avec des branches est recommandé <!-- .element: class="icon info" -->

Rendu possible grâce à la rapidité du système
 - création
 - passage d’une branche à l’autre
 - fusion
  - détermination automatique de l’ancêtre commun
 - ...

Organisation du travail de l’équipe <!-- .element: class="icon idea" -->
 - une branche par *user story*
 - une branche par ticket
 - une branche par environnement
 - branche de *dev*, branche de *prod*
 - branche plus ou moins stable
 - branche protégée
 - *merge request*, *pull request*
 - ...