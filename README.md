# Introduction à l’utilisation de Git à l’Insee

:arrow_forward: [Diaporama](http://wehdrc.pages.innovation.insee.eu/formation-git)

:bookmark_tabs: [Imprimer](http://wehdrc.pages.innovation.insee.eu/formation/?print-pdf#/) (avec Chrome)

## Plan

 1. Présentation générale de Git
 2. Opérations de base
 3. Branches
 4. Utilitaires
 5. Personnalisation
 
## Travaux pratiques

### 1. Configuration et fondamentaux

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

Créer le fichier `.gitignore` pour exclure le répertoire `target/` et le valider :
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
```

:warning: Git ne détecte aucun changement car les répertoires sont vides.

Pour que ces dossier soient quand même présents dans l’historique bien qu’ils soient vides, utiliser la technique suivante qui consiste à créer dans le dossier un fichier caché vide et a le valider :

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

### 2. Historique

On va désormais travailler sur un dépôt existant.

Clôner ce dépôt dans votre _workspace_ :
```bash
cd /d/*idep*/Mes\ Documents\eclipse_workspace
git clone https://git.stable.innovation.insee.eu/wehdrc/formation-git.git
cd formation-git
```

Afficher l'historique de ce dépôt :

```bash
git log
```

<details>
	<summary>Combien de <i>commits</i> datés d'avant le 31 juillet 2018 ce dépôt contient-il ?</summary>
	<code>518</code>
</details>
<br />
<details>
	<summary>Combien de <i>commits</i> datés d'avant le 31 juillet 2018 concernent les services ?</summary>
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