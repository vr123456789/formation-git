<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 8
### Fusion


%%%


<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Quelques précisions : *merge*, *rebase* et *pull*

Les fusions se produisent dans trois cas :
 - intégration d’une branche
  - `git merge <branche_name>`
 - récupération de modifications « extérieures »
  - `pull`, `cherry-pick`, `patch`
 - réécriture de l’historique local
  - `git rebase master`

Les techniques présentées ici sont valables dans les trois cas
 - Rappel : `git pull` =
  - `git fetch`
  - `git merge origin/master` 

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Généralités

La fusion est toujours locale
 - aucun risque de casser quoique ce soit

On peut toujours annuler l’opération
 - `git merge --abort`
 - `git rebase --abort`

Il est toujours préférable d’avoir une copie de travail propre
 - valider : `git commit`
 - ou remiser : `git stash`

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Conflits de fusion

La __même ligne__ du __même fichier__ a été modifée différemment  

 - Sans conflit

```bash
# git tag ici
git diff ex1a..ex1b
git diff ex1a..bex1
git reset --hard ex1b
git merge bex1
# git reset --hard ici
# git tag -d ici
```

 - Avec conflit
  - Résolution d’un conflit simple en ligne de commande

```bash
# git tag ici
git diff ex2a..ex2b
git diff ex2a..bex2
git reset --hard ex2b
git merge bex2
# git reset --hard ici
# git tag -d ici
```

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Résoudre un conflit

Lors de la fusion on est avertis qu’il y a eu des conflits :
```bash
Automatic merge failed; fix conflicts and then commit the result.
```

État de la copie locale, `git status` :

```bash
both modified:   src/main/java/fr/insee/bar/controller/AccueilController.java
```

Le code contient des marqueurs de conlits :
```java
@GetMapping("/")
<<<<<<< HEAD
@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
=======
@ResponseStatus(HttpStatus.OK)
>>>>>>> origin/bex2
```

Modifier le code pour supprimer les conflits et les marqueurs

Ajouter les fichiers corrigés dans l’index

Commiter une fois que tout est résolu

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Conseils et astuces : avant la fusion

Activer les marqueurs pour voir l’ancêtre commun :
 - `git config --global merge.conflictstyle diff3`

```java
@GetMapping("/")
<<<<<<< HEAD
@ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
||||||| merged common ancestors
@ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
=======
@ResponseStatus(HttpStatus.OK)
>>>>>>> origin/bex2
```

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Conseils et astuces : pendant la fusion

Lister les *commits* concernés par le conflit :
 - `git log --oneline --left-right --merge`

```bash
< 5b9d46d (HEAD -> master, tag: ex2b) Redirection temporaire vers permanente
> de1d14b (origin/bex2) Redirection vers OK
```

Voir les parties du code contenant des conflits : 
- `git diff` pendant la fusion

```patch
@@@ -16,7 -16,7 +16,13 @@@ public class AccueilController
        private String name;

        @GetMapping("/")
++<<<<<<< HEAD
 +      @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
++||||||| merged common ancestors
++      @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
++=======
+       @ResponseStatus(HttpStatus.OK)
++>>>>>>> origin/bex2
        public String welcome() {
                return "redirect:/accueil";
        }
```

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Conseils et astuces : après la résolution des conflits

Avant *commit*
 - `git diff` ne doit plus rien afficher
 - compiler et lancer l’application
 - exécuter les tests

Après *commit*
 - `git log --cc -p -1` permet d’afficher le patch de la résolution 

```patch
        @GetMapping("/")
-       @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
 -      @ResponseStatus(HttpStatus.OK)
++      @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
        public String welcome() {
                return "redirect:/accueil";
        }

```

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Exemple complet

Problème :
 - dans une branche `bex3`, on a renommé une classe du modèle
  - `Employe` &rarr; `Agent`
  - beaucoup de fichiers sont donc modifiés
 - on aussi supprimé une classe inutile
  - `DroitsController`
 - et ajouté de la Javadoc
 - dans `master` on renommé une autre classe du modèle
  - `Personne` &rarr; `Client`
 
<div class="center">
    <img src="images/graph-1.png" class="boxed-img" />
</div>

On veut fusionner `bex3` dans `master`

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Étapes de la résolution des conflits

```bash
git reset --hard ex3b
```

Solution :
 - on fait la fusion dans Eclipse
 - on localise les conflits : `git diff`
 - on résoud le problème de la classe supprimée
 - on résoud les conflits dans les deux contrôleurs
 - on identifie les *commits* concernés : `git log --oneline --left-right --merge`
 - on lance l’application
 - on valide le résultat : `git commit`
 - on vérifie nos modifications : `git log --cc -p -1`

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Ignorer les espaces

Problème :
 - dans une branche `bex4`, on a fait une petite correction
 - mais par inadvertance toutes les tabulations ont été remplacées par des espaces
  - `Tab` &rarr; `Espaces` 
 - dans `master`, on renommé une classe du modèle
  - `Agent` &rarr; `Employe`

<div class="center">
    <img src="images/graph-2.png" class="boxed-img" />
</div>

```bash
git reset --hard ex4b
```

Solution :
 - on fait la fusion : `git merge bex4`
 - il y a beaucoup de conflits
 - on annule la fusion : `git merge --abort`
 - on refait la fusion en ignorant les espaces : `git merge -Xignore-space-change bex4`
 - la fusion est automatique
 
%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Choisir une version

Résoudre un conflit en utilisant l’une ou l’autre version

 - Globalement :

```bash
git merge <branche> # conflits
git merge --abort

git merge -Xours <branche> # garder notre version pour toutes les lignes en conflit

git merge -Xtheirs <branche> # garder leurs version pour toutes les lignes en conflit
``` 

 - Au cas par cas :

```bash
git merge <branche> # conflits

# garder notre version pour les lignes en conflit dans ce fichier :
git checkout --ours fichier_en_conflit.txt

# garder leurs version pour les lignes en conflit dans ce fichier :
git checkout --theirs autre_fichier_en_conflit.txt

git add .
git commit
```

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Annuler une fusion

Pas encore partagée
 - le résultat de la fusion n’a pas encore été envoyé vers le dépôt distant
 - il suffit de revenir au commit précédent la fusion : `git reset --hard HEAD~`

Déjà partagée
 - le résultat de la fusion a déjà été envoyé vers le dépôt distant
 - on ne peut pas réécrire l’historique
 - on va donc faire un `git revert`
  - &rarr; *revert* = annuler un *commit* en appliquant le *patch* inverse

```bash
git revert --mainline 1 HEAD
```

<div class="center">
    <img src="images/undomerge-revert.png" class="boxed-img" width="500px" />
</div>

%%%

<!-- .slide: data-background-image="images/merge-logo.png" data-background-size="600px" class="slide" -->
### Mieux vaut éviter les conflits que les résoudre

*Commiter* souvent 
 - des petits lots de modifications homogènes
  
Avoir des petits fichiers
 - bien découper les classes selon leurs responsabilités
  
Communiquer avec les autres membres de l’équipe
 - dire sur quoi on travaille
 - bien prévenir en cas du *refactoring* important

Mettre à jour sa copie locale régulièrement
 - *pull* ou *rebase* 