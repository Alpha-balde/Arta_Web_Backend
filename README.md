# Arta_Web_Backend
projet de gestion de membres de l'association ARTA Belguim.  
Ce repository est la partie backend qui doit contenir tous les web services necessaires au developpement de l'interface utilisateur.

# SETUP
**Pour pouvoir lancer le projet en local, il faut installer docker et make sur ça machine**

le fichier Makefile contient les commandes pour lancer, stoper et détruire la base de données.
```
make env-up   => lance la db
make env-stop => arrete la db
make env-down => detruit la db
```
## Les outils et Librairies Utilisés:  
1. IntelliJ IDEA (https://www.jetbrains.com/fr-fr/idea/)
2. StarUML (https://staruml.io/)  
3. Spring Boot (https://spring.io/projects/spring-boot)
4. Spring Data (https://spring.io/projects/spring-data)
5. maven (https://maven.apache.org/)
6. lombok (https://projectlombok.org/)
7. PostgrSql
##### Pour ouvrir le fichier Arta.mdj qui se trouve dans le dossier modelisation il faut intaller StarUML.
  
## Documenting the REST API
**We use a tool that simplifies the generation and maintenance of API docs 
based on the OpenAPI 3 specification for Spring Boot 1.x and 2.x applications.**
1. the OpenAPI descriptions will be available at the path ```http://localhost:8080/api-docs/```
2. Now we can access the API documentation at ```http://localhost:8080/swagger-ui.html```

