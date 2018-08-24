<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 10
### Rebasage


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Rebaser

**Rebasage** : autre manière d’intégrer une branche dans une autre
 - `git rebase`
 - alternative à la fusion

Les modifications apportées dans une branche sont rejouées dans la branche de destination
 - équivalent à appliquer des *patchs*
  - calculés une branche
  - appliqués dans une autre 


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Exemple de *patch*


```patch
diff --git a/src/.../controller/ClientsController.java b/src/.../ClientsController.java
index 4bc826f..54cf87a 100644
--- a/src/main/java/fr/insee/bar/controller/ClientsController.java
+++ b/src/main/java/fr/insee/bar/controller/ClientsController.java
@@ -7,18 +7,18 @@ import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;

-import fr.insee.bar.dao.ClientDao;
 import fr.insee.bar.model.Client;
+import fr.insee.bar.repository.ClientRepository;

@Controller
public class ClientsController {

	@Autowired
-	private ClientDao clientDao;
+	private ClientRepository clientRepository;

@GetMapping("/clients")
public String clients(Model model) {
-	List<Client> clients = clientDao.findAll();
+	List<Client> clients = clientRepository.findAll();
 	model.addAttribute("clients", clients);
 	return "clients";
}
```

%%%


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="slide-in fade-out" -->
### Schéma : situation initiale

```bash
#
git checkout master
```

<div class="fixed-height center">
	<img src="images/basic-rebase-1.png" width="700px" />
</div>


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="fade" -->
### Schéma : fusion à trois sources

```bash
#
git merge experiment
```

<div class="fixed-height center">
	<img src="images/basic-rebase-2.png" width="700px" />
</div>


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="fade" -->
### Schéma : situation initiale

```bash
#
git checkout experiment
```

<div class="fixed-height center">
	<img src="images/basic-rebase-1.png" width="700px" />
</div>


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="fade" -->
### Schéma : rebasage

```bash
#
git rebase master
```

<div class="fixed-height center">
	<img src="images/basic-rebase-3.png" width="700px" />
</div>


%%%


<!-- .slide: class="slide" data-background-color="#7580ba" data-transition="fade-in slide-out" -->
### Schéma : fusion en avance rapide

```bash
git checkout master
git merge experiment
```

<div class="fixed-height center">
	<img src="images/basic-rebase-4.png" width="700px" />
</div>


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Conséquence du rebasage

L’historique devient linéaire
 - il ne correspond plus à ce qui *réellement* passé
 - les *commits* de la branche sont réécrits

Il n’y a pas de *commit* de fusion
 - puisque l’historique est linéaire

Il ne faut <!-- .element: class="icon warn" --> **jamais** rebaser du code déjà poussé sur le dépôt distant
 - en cas de réécriture de l’historique, `git push --force`
  - si le dépôt distant le permet
  - se synchroniser avec le reste de l’équipe
 - le rebasage se fait dans sa copie de travail
  - avant d’avoir partager ses modifications

Exemple de la contribution à un projet libre
 - *pull request*
 - fusion en avance rapide uniquement
 - analyse du code soumis plus simple grâce a l’historique linéaire

%%%


<!-- .slide: class="tp" -->
## [TP5](https://git.stable.innovation.insee.eu/wehdrc/formation-git#5-rebasage)
<div class="center">
	<img src="images/keyboard.png" width="600px" class="blur" />
</div>