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
  - l’éditeur de texte s’ouvre, il contient le dernier message de *commit*
 - Aussi possible : `git commit --amend --message "Message de commit"`
 
Modifier aussi le contenu
 - indexer ou supprimer des modifications au préalable
  - `git add` ou `git rm`
 - puis `git commit --amend`

Interdit si les modifications ont déjà été poussées vers le dépôt distant <!-- .element: class="icon warn" -->


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Réécrire des modifications plus anciennes

Pas d’outil spécifique mais « rebasage interactif »
 - pour modifier les `n` derniers *commits* : `git rebase -i HEAD~n`

Pour chacun des `n` derniers *commits* on a le choix entre :
 
<table class="left small">
	<tr>
		<th><code>pick</code></th>
		<th><code>p</code></th>
		<th>Garder le commit tel quel</th>
	</tr>
	<tr>
		<td><code>reword</code></td>
		<td><code>r</code></td>
		<td>Changer le message</td>
	</tr>
	<tr>
		<td><code>edit</code></td>
		<td><code>e</code></td>
		<td>S’arrêter pour modifier le commit</td>
	</tr>
	<tr>
		<td><code>squash</code></td>
		<td><code>s</code></td>
		<td>Fusionner ce commit avec le précédent</td>
	</tr>
	<tr>
		<td><code>fixup</code></td>
		<td><code>f</code></td>
		<td>Fusionner ce commit avec le précédent et utiliser le message précédent</td>
	</tr>
	<tr>
		<td><code>exec</code></td>
		<td><code>x</code></td>
		<td>Exécuter une commande</td>
	</tr>
</table>

On peut en plus :
 - réordonner les *commits* en changeant l’ordre des lignes
 - supprimer des *commits* en supprimant la ligne correspondante

Annuler le rebasage :
 - `git rebase --abort`


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Programme de rebasage interactif

```bash
git log --oneline
```

<div class="center">
	<img src="images/rebase-i-log.png" width="400px" />
</div>

```bash
git rebase -i 7afc44a^
```

<div class="center">
	<img src="images/rebase-i-todo.png" width="400px" />
</div>

<!-- .element: class="icon warn" -->L’ordre des *commits* est inversé par rapport à `git log`
 - ordre chronologique &rarr; « on réécrit l’histoire »


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Fusionner des *commits*

`fixup`
 - c’est le message du plus ancien *commit* qui sera utilisé
  - on peut en profiter pour modifier ce message

<table class="medium">
<tr>
<td>avant</td>
<td>programme</td>
<td>après</td>
</tr>
<tr>
<td><pre><code class="lang-bash hljs">fe0d95c JPA : Role
090b778 JPA : Employe
4f99ebc JPA : Cocktail
7afc44a JPA : Client</code></pre></td>
<td><pre><code class="lang-bash hljs">reword 7afc44a JPA : Client
fixup 4f99ebc JPA : Cocktail
fixup 090b778 JPA : Employe
fixup fe0d95c JPA : Role</code></pre></td>
<td><pre><code class="lang-bash hljs">67d60cc Ajout des annotations JPA sur les entités</code></pre></td>
</tr>
</table>

`squash`
 - l’éditeur de texte s’ouvre
  - il contient les trois messages, on peut en faire ce qu’on veut

<table class="medium">
<tr>
<td>avant</td>
<td>programme</td>
<td>après</td>
</tr>
<tr>
<td><pre><code class="lang-bash hljs">4b5e1b5 Ignorer le dossier docs/
6e47d26 Ménage : servlet-dispatcher.xml
0d37c11 Suppression d’un vieux fichier</code></pre></td>
<td><pre><code class="lang-bash hljs">pick 0d37c11 Suppression d’un vieux fichier
squash 6e47d26 Ménage : servlet-dispatcher.xml
squash 4b5e1b5 Ignorer le dossier docs/</code></pre></td>
<td><pre><code class="lang-bash hljs">346113b Ménage</code></pre></td>
</tr>
</table>


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Fusionner des *commits* automatiquement 

<!-- .element: class="icon idea" -->Option `--autosquash` de `git rebase -i`
 - activer l’option par défaut : `git config --global rebase.autosquash true`

Oubli dans un *commit* qu’on ne peut plus amender

```bash
git add a.txt && git commit -m "Modification a.txt"
git log --oneline -1 # 32f91fd Modification a.txt

git add src/ && git commit -am "Correction problème Y"
git log --oneline -1 # cba893a Correction problème Y

vi a.txt # Correction d’un oubli dans le fichier a.txt
git add a.txt
git commit --fixup 32f91fd # <== option '--fixup'
git log --oneline -1 # 7fef6a9 fixup! Modification a.txt

git rebase -i master
```

Le programme de rebasage est déjà bon :

```bash
pick 32f91fd Modification a.txt
fixup 7fef6a9 fixup! Modification a.txt
pick cba893a Correction problème Y
```


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Diviser un *commit* en plusieurs

`edit`
 - le programme s’arrête et nous donne la main
 - on en profite pour revenir un cran en arrière : `git reset HEAD^`
  - l’index est vide
  - la copie de travail contient les modifications
 - on indexe puis on valide les fichiers que l’on souhaite
  - possibilité d’indexer des parties de fichier avec `git add --patch`
 - on répète les opérations d’indexation et de validation autant de fois que l’on souhaite
 - on laisse le rebasage se poursuivre : `git rebase --continue`

<table class="medium">
<tr>
<td>avant</td>
<td>programme</td>
<td>après</td>
</tr>
<tr>
<td><pre><code class="lang-bash hljs">b5f409e Titre README.md et corrections</code></pre></td>
<td><pre><code class="lang-bash hljs">edit b5f409e Titre README.md et corrections</code></pre></td>
<td><pre><code class="lang-bash hljs">6e47d26 Titre dans README.md
346113b Orthographe</code></pre></td>
</tr>
</table>


%%%


<!-- .slide: class="tp" -->
## [TP6](https://git.stable.innovation.insee.eu/wehdrc/formation-git#6-r%C3%A9%C3%A9crire-lhistorique)
<div class="center">
	<img src="images/keyboard.png" width="600px" class="blur" />
</div>