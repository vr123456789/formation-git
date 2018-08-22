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

<!-- .element: class="icon warn" -->L'ordre des *commits* est inversé par rapport à `git log`
 - ordre chronologique &rarr; « on réécrit l'histoire »


%%%

<!-- .slide: class="tp" -->
## [TP6](https://git.stable.innovation.insee.eu/wehdrc/formation-git#6-r%C3%A9%C3%A9crire-lhistorique)
<div class="center">
	<img src="images/keyboard.png" width="600px" class="blur" />
</div>