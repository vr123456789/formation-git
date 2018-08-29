<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 13
### Boite à outils Git


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Remisage : `git stash`

Changer de branche alors que la copie de travail est instable
 - on est en plein milieu d’un travail
 - valider ne serait pas une bonne idée

```bash
# Remiser les fichiers modifiés
git stash

# Remiser les fichiers modifiés et les fichiers ajoutés
git stash -u
```

Récupérer le contenu de la remise

```bash
# Récupérer la dernière remise
git stash apply

# Supprimer la dernière remise
git stash drop

# Recupérer et supprimer la dernière remise
git stash pop
```

<!-- .element: class="icon idea" -->En général, `git stash` suivi peu après de `git stash pop` suffisent


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Remisage

Lister les remises
```bash
$ git stash list
stash@{0}: WIP on master: 049d078 added the index file
stash@{1}: WIP on master: c264051... Revert "added file_size"
stash@{2}: WIP on master: 21d80a5... added number to log
```

Agir sur une remise plus ancienne
```bash
$ git stash drop stash@{0}
Dropped stash@{1} (364e91f3f268f0900bc3ee613f9f733e82aaed43)
```

Récupérer une remise dans une nouvelle branche
 - si on a tardé à récupérer la remise, risque de conflits

```bash
$ git stash branch testchanges
Switched to a new branch "testchanges"
```
<!-- .element: class="icon info" -->La remise est alors supprimée



%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Étiquetage : `git tag`

Marquer un *commit*
 - souvent les versions livrées en production

<!-- .element: class="icon warn" -->Les étiquettes font toujours référence au même *commit*
 - à la différence des branches qui avancent à chaque nouveau *commit*

Créer une étiquette :
```bash
# Créer une étiquette légère
git tag v2.1

# Créer une étiquette annotée
git tag -a v2.1 -m "Message associé à l’étiquette"
```

Étiqueter après coup
```bash
git tag -a v2.1 9fceb02
```

%%%

<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Étiquetage


Lister les étiquettes
```bash
git tag
```

Partager ses étiquettes
```bash
# Partager une étiquette
git push origin v2.1

# Partager toutes ses étiquettes
git push origin --tags
```

Supprimer une étiquette
```bash
# Du dépôt local
git tag -d v2.1

# Du dépôt distant
git push --delete origin v2.1
```


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Revenir en arrière localement
Modifications non poussées vers le dépôt distant
```bash
# Revenir à un commit donné
git reset --hard 9fceb02

# Annuler les modifications de son espace de travail ~ svn revert
git reset --hard

# Pour supprimer également les fichiers et les dossiers ajoutés
git clean -d -f
```
<!-- .element: class="icon warn" -->Perte des modifications non validées
 - certains *commits* deviennent inaccessibles
  - sauf en utilisant `reflog` ou `tag`


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Annuler un rebasage râté

Le rebasage réécrit l’historique
 - &rarr; si on revient en arrière, on revient dans le « mauvais » passé

La commande `git reflog` affiche l’historique des positions de `HEAD`
 - historique purement local
  - vide après un clone
  - différent pour chaque développeur
 - pas plus de quelques mois

```bash
1e3845d (origin/tp6, github/tp6, tp6) HEAD@{1}: checkout: moving from master to tp6
b306d5b (tp5) HEAD@{2}: commit: Correction dans les exemples de code filter-branch
a14d9b6 HEAD@{3}: commit: Enoncé tp6 : filter-branch
327d7e6 HEAD@{4}: rebase -i (finish): returning to refs/heads/master
327d7e6 HEAD@{5}: rebase -i (squash): Enoncé du TP6, partie rebasage
34098fe HEAD@{6}: rebase -i (continue): Enoncé du TP6, partie rebasage
624d244 HEAD@{7}: rebase -i (start): checkout refs/remotes/origin/master
63c80c4 HEAD@{8}: commit: Enoncé du TP6, partie rebasage
4794f33 HEAD@{9}: checkout: moving from tp6 to master
```

<!-- .element: class="icon idea" -->Ici pour revenir avant le rebasage :
 - `git reset --hard HEAD@{8}`


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Annuler des modifications distantes
Modifications déjà poussées vers un dépôt distant

<!-- .element: class="icon warn" -->On ne peut plus réécrire l’historique

Commande `git revert`
 - annule un *commit* ou une plage de *commits* en appliquant le *patch* inverse
 - &rarr; création de nouveaux *commits* qui annulent des modifications plus anciennes

```bash
git revert 6686231..b24a4d0
```

```bash
67d6edd (HEAD -> master) Revert "Images des exercices"
d772e54 Revert "Icone question"
6327641 (origin/master, origin/HEAD) Diapos exercice !
f84c416 Exercices sur les références et les ranges
b24a4d0 Icone question
a0f2358 Images des exercices
6686231 Plages de commits
 ```