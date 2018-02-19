Projet Maven + Sonar : 

- But du projet : 
	
	- Maven : 
	
	- Réaliser la migration d'une application java d'entreprise "classique" (Application métier architecturée en 3 couches) vers un projet Maven. 
	
	- Marche à suivre : 
		- Division du projet en 4 sous-modules 
			- Root (projet principal)
				- Frontend 
				- Business Layer 
				- Backend 
				- Model
		- Globalement on reprend la structure actuelle du projet mais on transforme chacun des packages (sous fr.anthonyrey) en modules Maven

	- Réalisation d'une présentation de ce qui a été réalisé pour la soutenance. 
		- Présentation des pom.xml 
		- Réflexions personnelles sur l'utilité de Maven dans le contexte de ce projet 
		- Build, lancement du jar et lancement des tests lors de la soutenance


	-  Sonar : 

		- Réalisation d'une présentation des fonctionnalités de Sonar et des différentes observations sur le projet 

		- Marche à suivre : 
			- Utiliser Sonar cloud ou installer son propre sonar 
			- Mettre en place un Runner Sonar / Lancer une analyse du projet 
			- Présenter globalement les différentes fonctionalités de Sonar 
			- Corriger les defects "pertinents" que j'ai introduit délibérement sur le projet 
				- Présenter l'évolution pointée par les différents graphes de Sonar
				- Réflexion sur la pertinence des mesures 

		- Exemple : 
			- Jeter un oeil aux profils de qualité, changer les règles, mesurer la pertinence etc..
			- Ajouter des bugs et observer etc..
