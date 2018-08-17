<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 9
### Branches distantes


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Généralités

Références locales vers l’état des branches du dépôt distant

Non modifiables par l’utilisateur
 - uniquement par la communication avec le dépôt distant

Nommées `repository-name/branch-name`
 - `origin/master`
 - `origin/dev`
 - `github/master`
 - ...

Le dépôt distant <!-- .element: class="icon info" --> `origin` n’est pas particulier
 - c’est seulement le nom donné par défaut au dépôt que l’on a clôné


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Création d’une branche de suivi

Automatiquement, après un clone, la branche `master` suit `origin/master`

Suivre une autre branche distante existante :

```bash
git checkout --track origin/branch_name
```

 - équivalent à `git checkout -b branch_name origin/branch_name`
 - ou même plus simplement : `git checkout branch_name`
  - il existe une branche `branch_name` dans le dépôt `origin`
  - il n’existe pas de branche locale `branch_name`

Créer une branche locale et la pousser vers le dépôt distant :
```bash
git checkout -b branch_name
git push -u origin branch_name
```

Par la suite on utilise simplement <!-- .element: class="icon info" --> `git push`

%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Gestion des branches de suivi

Lister les branches et leurs éventuelles « branches amont » (*upstream*) :
```bash
git branch -vv
```
<div class="center">
    <img src="images/branch-vv.png" class="boxed-img" width="800px" />
</div>

Une fois le suivi activé, `fetch` et `push` fonctionnent sans précisions supplémentaires
 - rappel : `fetch` met jour `remote/branch_name`
 - il faut ensuite fusionner dans la branche locale : `git merge`

En utilisant <!-- .element: class="icon idea" --> `pull`, on fait les deux opérations d’un coup


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" -->
### Divergence des historiques

<table>
<tr>
<td>
<img src="images/remote-branches-2.png" />
</td>
<td>
<img src="images/remote-branches-3.png" />
</td>
</tr>
</table>

Source potentielle de conflits <!-- .element class="icon warn" -->

Source fréquente de <!-- .element class="icon info" --> *commits* de fusion

%%%


<!-- .slide: class="tp" -->
## [TP4](https://git.stable.innovation.insee.eu/wehdrc/formation-git#4-branches)
<div class="center">
	<img src="images/keyboard.png" width="600px" class="blur" />
</div>