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
### Réécrire des modifications plus anciennes

```bash
pick 2e672b9 Correction de la fonction de recherche approximative
pick 6e47d26 Ménage : servlet-dispatcher.xml
pick 0d37c11 Suppression d'un vieux fichier
pick bd37b08 Connexion à la base embarquée
pick c80645c Suppression des RowMappers devenus inutiles
pick cfb0daa Tentative de simplification avec les @Query
pick b5f409e Réécriture complète des DAO avec spring-data
pick db9f793 Refactor : dao -> repository
pick fe0d95c JPA : Role
pick 090b778 JPA : Employe
pick 4f99ebc JPA : Coctail
pick 7afc44a JPA : Client
```

%%%

<!-- .slide: class="tp" -->
## [TP6](https://git.stable.innovation.insee.eu/wehdrc/formation-git#6-r%C3%A9%C3%A9crire-lhistorique)
<div class="center">
	<img src="images/keyboard.png" width="600px" class="blur" />
</div>