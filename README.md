# Introduction à l’utilisation de Git à l’Insee

:arrow_forward: Diaporama [Gitlab](http://wehdrc.pages.innovation.insee.eu/formation-git) | [Github](https://romain-warnan.github.io/formation-git)

:bookmark_tabs: Imprimer [Gitlab](http://wehdrc.pages.innovation.insee.eu/formation-git/?print-pdf#/) | [Github](https://romain-warnan.github.io/formation-git/?print-pdf#/) (avec Chrome)

## Plan

 1. Présentation générale de Git
 2. Opérations de base
 3. Branches
 4. Utilitaires
 5. Personnalisation
 
## Travaux pratiques

### 1. Configuration et fondamentaux

#### Configuration

Paramétrer son nom et son email :
```bash
git config --global user.name "Prénom Nom"
git config --global user.email "prenom.nom@insee.fr"
```

Paramétrer le proxy Insee
```bash
git config --global http.proxy http://proxy-rie.http.insee.fr:8080
git config --global https.proxy http://proxy-rie.http.insee.fr:8080
```

Choisir son éditeur de texte favori
```bash
# notepad++
git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -nosession"

# vim
git config --global core.editor vim
```

Afficher l’ancêtre commun lors d’un conflit 
```bash
git config --global merge.conflictstyle diff3
```

<details>
	<summary>Quelle est la valeur de la propriété <code>help.format</code> ?</summary>
	<code>git config help.format</code>
</details>
<br />
<details>
	<summary>Dans quel fichier cette propriété est-elle enregistrée ?</summary>
	<code>git config --list --show-origin | grep "help.format"</code>
</details>
<br />
<details>
	<summary>Combien y-a-til de propriétés système dans ce fichier ?</summary>
	<code>cat /c/ProgramData/Git/config | wc -l</code>
</details>

#### Opérations de base

Ajouter un alias vers Maven :

```bash
# Éditer le fichier .bashrc
vim ~/.bashrc

# Ajouter la ligne suivante et quitter vim
alias mvn='"/c/Program Files (x86)/insee/atelier-dev-2/applications/maven/bin/mvn.bat"'

# Recharger le fichier .bashrc
source ~/.bashrc
```

Créer un nouveau projet Maven :
```bash
cd /d
mvn -B archetype:generate -DgroupId=fr.insee.git -DartifactId=git-base
```

Initialiser un dépôt Git et constater la création du dépôt Git local :
```bash
cd git-base
git init
ls -al
```

Ajouter tous les fichiers dans l’index et valider dans un premier _commit_.
```bash
git add .
git status
git commit -m "Initialisation du projet 'git-base'"
```

Packager l’application, l’exécuter puis inspecter la copie de travail :
```bash
mvn package
java -cp target/git-base-1.0-SNAPSHOT.jar fr.insee.git.App
git status
```

Créer le fichier `.gitignore` pour exclure le répertoire `target/` et l’indexer :
```bash
vim .gitignore
git add .gitignore
git status
```

Constater que le répertoire `target/` n’est plus pris en compte : il n’a pas été ajouté à l’index et ne sera donc pas dans le prochain _commit_.

Valider. 

```bash
git commit -m "Exclusion du répertoire 'target/'"
```

Créer les dossiers `src/main/resources` et `src/test/resources`,  inspecter la copie de travail :
```bash
mkdir -p src/main/resources src/test/resources
git status
```

:warning: Git ne détecte aucun changement car les répertoires sont vides.

Pour que ces dossier vides soient quand même présents dans l’historique, utiliser la technique suivante qui consiste à créer dans le dossier un fichier caché vide et a le valider :

```bash
touch src/main/resources/.git-empty src/test/resources/.git-empty
git status
git add .
git commit -m "Création des répertoires 'src/main/resources/' et 'src/test/resources/'"
```

Créer un fichier <code>README.txt</code> contenant un court texte.</summary>

Modifier le programme `fr.insee.git.App.java` pour qu’il puisse prendre un paramètre :
 - si le paramètre est renseigné, le programme affiche `"Hello {param} !"`,
 - sinon le programme affiche `"Hello World !"`

Compiler puis exécuter le programme en passant en paramètre votre prénom :

```bash
mvn package
java -cp target/git-base-1.0-SNAPSHOT.jar fr.insee.git.App "Prénom"
```

Indexer le fichier `README.txt`.

<details>
	<summary>Afficher les modifications qui seront validées dans le prochain <i>commit</i> :</summary>
	<code>git diff --staged</code>
</details>
<br />
<details>
	<summaryAfficher les modifications de la copie de travail par rapport à l’index :</summary>
	<code>git diff</code>
</details>
<br />

Valider les deux modifications dans deux *commits* séparés :
```bash
git commit -m "Création d’un fichier README.txt"
git commit -am "Possibilité de passer un paramètre à la méthode 'main'"
```

Renommer le fichier `README.txt` en `README.md` puis examiner l’état de la copie de travail :
```bash
mv README.txt README.md
git status
git add .
git status
```

Réinitialiser la copie de travail dans l’état du dernier *commit*
```bash
git reset --hard
```

Puis renommer le fichier avec Git :
```bash
git mv README.txt README.md
git status
```

Le résultat est le même : Git parvient à repérer les fichiers par la somme de contrôle de leur contenu.

:warning: Si en plus, le contenu du fichier est modifié, cela ne fonctionne plus.

### 2. Dépôts distants

En haut à droite de l'interface de Giltab, vérifier que vous ête bien connecté à Gitlab.

En haut de cette page, cliquer sur bouton « [Fork](https://git.stable.innovation.insee.eu/wehdrc/formation-git/forks/new) », puis choisir votre dépôt personnel.

> :information_source: Vous venez de copier le dépôt de la formation dans votre espace personnel Gitlab. Cette opération s'appelle un _fork_.
> 
> Vous avez les droits
>  - en lecture et en écriture sur cette copie,
>  - en lecture seule sur le dépôt d'origine.

Clôner ce dépôt dans votre _workspace_ :
```bash
cd /d/*idep*/Mes\ Documents/eclipse_workspace
git clone [git@git.stable.innovation.insee.eu:22222]:*idep*/formation-git.git
cd formation-git
```

:warning: Pour tout problème SSH, appeler l'intervenant et se référer à cette [aide](https://git.stable.innovation.insee.eu/outils-transverses/migration-svn-git#-ajouter-une-clef-ssh-dans-gitlab)

Dans votre copie locale, effectuer la modification suivante :

<details>
	<summary>Dans le dossier <code>students/</code>, créer un fichier <code>*idep*.txt</code> contenant votre <code>*Prénom Nom*</code>.</summary>
	<code>echo '*Prénom Nom*' > students/*idep*.txt</code>
</details>

Indexer ce nouveau fichier, valider la modification et envoyer vers le serveur dépôt distant :
```bash
git add students/
git commit -m "Ajout d'un fichier idep.txt"
git push
```

Dans votre _fork_ du dépôt sur Gitlab, vérifier que votre fichier *idep*.txt est bien présent. Au contraire, vérifier qu'il est absent du [dépôt original](https://git.stable.innovation.insee.eu/wehdrc/formation-git/tree/master/students).

Ajouter un autre dépôt distant, nommé `upstream`, qui pointe vers le dépôt d'origine :
```bash
git remote add upstream https://git.stable.innovation.insee.eu/wehdrc/formation-git.git
```

Mettre votre copie locale à jour à partir de ce nouveau dépôt :
```bash
git pull upstream
```

Puis partager les éventuelles modifications dans votre dépôt :
 ```bash
git push origin
```

Merge request...

### 3. Historique

Afficher l’historique du dépôt formation-git :

```bash
git log
```

<details>
	<summary>Combien de <i>commits</i> datés d’avant le 31 juillet 2018 ce dépôt contient-il ?</summary>
	<code>518</code>
</details>
<br />
<details>
	<summary>Combien de <i>commits</i> datés d’avant le 31 juillet 2018 concernent les services ?</summary>
	<code>30</code>
</details>
<br />
<details>
	<summary>Dans quel <i>commits</i> a t-on mis en place un système de <i>logging</i> autre que <code>System.out</code> ?</summary>
	<code>df1c990</code>
</details>
<br />
<details>
	<summary>À quel heure de quel jour a été validé le premier test unitaire du projet ?</summary>
	<code>2016-09-01 16:53:26</code>
</details>
<br />

Afficher l’historique sous la forme suivante 

```bash
* 8d0576c 2018-08-10 | Début du TP2 sur les logs (HEAD -> master) [Romain Warnan]
* 97909af 2018-08-10 | Simplification d’écriture de la lambda [Romain Warnan]
* dbf14df 2018-08-10 | Ajout d’icones dans le diaporama (origin/master, origin/HEAD) [Romain Warnan]
* 042c58b 2018-08-10 | Suppression de lignes en trop [Romain Warnan]
```

<details>
	<summary>Indice : <code>git log --graph --date=short --pretty="format:???"</code></summary>
	<code>git log --graph --date=short --pretty="format:%h %ad | %s%dq [%an]"</code>
</details>
<br />

<details>
	<summary>Modifier la commande précédente pour que le <i>hash</i> soit couleur cyan</summary>
	<code>git log --graph --date=short --pretty="format:%C(cyan)%h%Creset %ad | %s%dq [%an]"</code>
</details>
<br />

Créer les deux alias `git ll` et `git lg` qui permettent d’afficher un historique coloré :

```bash
git config --global alias.ll "log --graph --abbrev-commit --pretty=format:'%C(bold magenta)%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(cyan)<%an>%Creset"
git config --global alias.lg 'log --graph --date=format:"%d %b %Y" --pretty="format:%C(bold #f442b6)%h%Creset %C(#fff291)%ad%Creset | %s %C(#66bc5e)§%Creset %C(#848484)(%ar)%Creset %C(#5493ce)%an%Creset%C(#f93131)%d%Creset"'
```

Tester ces affichages :

<details>
	<summary><code>git ll</code></summary>
	<img src="docs/images/log-ll.png" />
</details>
<br />
<details>
	<summary><code>git lg</code></summary>
	<img src="docs/images/log-lg.png" />
</details>
<br />