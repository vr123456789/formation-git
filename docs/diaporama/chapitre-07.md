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


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="slide-in none-out" -->
### Branche : schéma (1)
```bash
git checkout master
```

<div class="fixed-height"><img src="images/branches/branch-and-history.png" width="700px" /></div>

```bash
cat .git/HEAD # ref: refs/heads/master
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # cat: .git/refs/heads/testing: No such file or directory
```


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="none" -->
### Branche : schéma (2)

```bash
git branch testing
```

<div class="fixed-height"><img src="images/branches/head-to-master.png" width="700px" /></div>

```bash
cat .git/HEAD # ref: refs/heads/master
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # f30ab</code></pre>
```


%%%

<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="none" -->
### Branche : schéma (3)

```bash
git checkout testing
```

<div class="fixed-height"><img src="images/branches/head-to-testing.png" width="700px" /></div>

```bash
cat .git/HEAD # ref: refs/heads/testing
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # f30ab
```


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="none" -->
### Branche : schéma (4)

```bash
git commit -m "Commit dans la branche 'testing'"
```

<div class="fixed-height"><img src="images/branches/advance-testing.png" width="700px" /></div>

```bash
cat .git/HEAD # ref: refs/heads/testing
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # 87ab2
```


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="none" -->
### Branche : schéma (5)

```bash
git checkout master
```

<div class="fixed-height"><img src="images/branches/checkout-master.png" width="700px" /></div>

```bash
cat .git/HEAD # ref: refs/heads/master
cat .git/refs/heads/master # f30ab
cat .git/refs/heads/testing # 87ab2
```


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="none-in slide-out" -->
### Branche : schéma (6)

```bash
git commit -m "Commit dans la branche 'master'"
```

<div class="fixed-height"><img src="images/branches/advance-master.png" width="700px" /></div>

```bash
cat .git/HEAD # ref: refs/heads/master
cat .git/refs/heads/master # c2b9e
cat .git/refs/heads/testing # 87ab2
```


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Remarques sur les branches

Avec Git, travailler avec des branches est recommandé <!-- .element: class="icon idea" -->

Rendu possible grâce à la rapidité du système
 - création
 - passage d’une branche à l’autre
 - fusion
  - détermination automatique de l’ancêtre commun
 - ...

La branche <!-- .element: class="icon info" --> *master*
 - a un fonctionnement identique aux autres
 - c’est simplement la branche créée lors d’un `git init`
  - et la branche extraite par défaut après un `git clone`


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" -->
### Exemple d’utilisation des branches

<div class="fragment fade-in-then-out">
	<p>Situation initiale</p>
	<div class="center"><img src="images/basic-branching/basic-branching-1.png" width="700px" /></div>
</div>
<div class="fragment fade-in-then-out">
	<p>Création d’une nouvelle branche pour le développement du ticket 53</p>
	<ul>
		<li><code>git checkout -b iss53</code></li>
	</ul>
	<div class="center"><img src="images/basic-branching/basic-branching-2.png" width="700px" /></div>
</div>

<div class="fragment fade-in-then-out">
	<p>Développements du ticket 53 dans la branche <code>iss53</code></p>
	<ul>
		<li><code>git commit -m "ajout d’un pied de page [problème 53]"</code></li>
	</ul>
	<div class="center"><img src="images/basic-branching/basic-branching-3.png" width="700px" /></div>
</div>

<div class="fragment fade-in-then-out">
	<p class="icon warn">Un problème urgent est signalé en production</p>
	<ul>
		<li>Ne pas déployer les développements en cours du ticket 53 en plus du correctifs</li>
		<li>Simple retour sur la branche <code>master</code> :
			<ul><li><code>git checkout master</code></li></ul>
		</li>
	</ul>
	<div class="center"><img src="images/basic-branching/basic-branching-3.png" width="700px" /></div>
</div>

<div class="fragment fade-in-then-out">
	<p>Création d’une branche <code>hotfix</code> pour le correctif urgent à partir de <code>master</code></p>
	<ul>
		<li><code>git checkout -b hotfix</code></li>
	</ul>
	<p>Correction du problème dans la branche <code>hotfix</code></p>
	<ul>
		<li><code>git commit -m "correction de l’adresse email incorrecte"</code></li>
	</ul>
	<div class="center"><img src="images/basic-branching/basic-branching-4.png" width="700px" /></div>
</div>

<div class="fragment fade-in-then-out">
	<p>Test de la correction et fusion dans la branche <code>master</code></p>
	<ul>
		<li><code>git checkout master</code></li>
		<li><code>git merge hotfix</code></li>
	</ul>
	<div class="center"><img src="images/basic-branching/basic-branching-5.png" width="700px" /></div>
</div>

<div class="fragment fade-in-then-out">
	<p>La fusion se fait en avance rapide (<i>fast-forward</i>)</p>
<pre><code class="lang-bash hljs">Updating f42c576..3a0874c
Fast-forward
 index.html | 2 ++
 1 file changed, 2 insertions(+)</code></pre>
	<div class="center"><img src="images/basic-branching/basic-branching-5.png" width="700px" /></div>
</div>

<div class="fragment fade-in-then-out">
	<p>Suppression de la branche <code>hotfix</code></p>
	<ul>
		<li><code>git branch -d hotfix</code></li>
	</ul>
	<p>Fin des développements du ticket 53 dans la branche <code>iss53</code></p>
	<ul>
		<li><code>git checkout iss53</code></li>
		<li><code>git commit -m "Nouveau pied de page terminé [issue 53]"</code></li>
	</ul>
	<div class="center"><img src="images/basic-branching/basic-branching-6.png" width="700px" /></div>
</div>

<div class="fragment fade-in-then-out">
	<p>Fusion de la branche <code>iss53</code> dans <code>master</code></p>
	<ul>
		<li><code>git checkout master</code></li>
		<li><code>git merge iss53</code></li>
	</ul>
	<p><i>Commit</i> de fusion</p>
	<div class="center"><img src="images/basic-branching/basic-branching-7.png" width="700px" /></div>
</div>

<div class="fragment fade-in-then-out">
	<p>La fusion est une fusion à trois sources (<i>three-way merge</i>)</p>
<pre><code class="lang-bash hljs">Merge made by the 'recursive' strategy.
README | 1 +
1 file changed, 1 insertion(+)</code></pre>
	<div class="center"><img src="images/basic-branching/basic-branching-8.png" width="700px" /></div>
</div>


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Quand utiliser des branches ?

Organisation du travail de l’équipe <!-- .element: class="icon idea" -->
 - une branche par *user story*
 - une branche par ticket
 - une branche par environnement
 - branche de *dev*, branche de *prod*
 - branche plus ou moins stable
 - branche protégée
  - *merge request*, *pull request*
 - ...


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Gestion des branches

Lister les branches `git branch -v`
<div class="center">
	<img src="images/branch-v.png" />
</div>

Uniquement les branches fusionnées dans `HEAD`
 - `git branch --merged` 
 - `git branch --no-merged` 

Supprimer une branche `git branch -d <branch_name>`
 - si la branche n'a pas été fusionnée :  `git branch -D <branch_name>`
  - dans ce cas, perte de données possible <!-- .element: class="icon warn" -->
