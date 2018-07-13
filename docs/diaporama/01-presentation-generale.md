<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="chapter" -->
## 1
### Présentation générale de Git


%%%


<!-- .slide: class="slide" data-background-image="images/logo-git.png" data-background-size="600px" -->
### Système de contrôle de version

Un VCS (_Version Control System_) 
 - enregistre les modifications successives d’un ensemble de fichiers

Cela permet de :
 - revenir à une version spécifique
 - revenir à une version antérieure d'un fichier spécifique
 - retrouver la dernière modification qui a pu introduire un problème

En plus, on peut en général :
 - partager ses modifications et de récupérer celles des autres

Surtout utile pour les fichiers textes
 - comme le code source !


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Bref historique

<table>
	<tr>
		<td>Local (LVCS)</td>
		<td>Cenralisé (CVCS)</td>
		<td>Distribué (DVCS)</td>
	</tr>
	<tr>
		<td><img src="images/local.png" width="300px" /></td>
		<td><img src="images/centralized.png" width="300px" /></td>
		<td><img src="images/distributed.png" width="300px" /></td>
	</tr>
	<tr>
		<td>RCS</td>
		<td>CVS, __Subversion__, Perforce</td>
		<td>__Git__, Mercurial, Bazaar, Darcs</td>
	</tr>
</table>


%%%


<!-- .slide: data-background-image="images/logo-git.png" data-background-size="600px" class="slide" -->
### Les avantages de la gestion distribuée

Gestion de version centralisée :

 - (+) chacun peut savoir qui fait quoi
 - (+) on peut partager son travail et récupérer celui des autres
 - (&ndash;) point unique de panne
  - coupure du serveur : plus personne ne peut collaborer
  - corruption du disque: données définitivement perdue
 
Gestion de version distribuée :

 - (+) sécurité grâce à la redondance des dépôts</li>
 - (+) permet l’organisation de « groupes de travail »</li>
 - (+) rapidité</li>
