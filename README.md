# Bachelorproef - Backend

Deze repository bevat de backend voor het project uit Ba3 Industrieel ingenieur: Electronica - ICT: Smart Applications. In dit project werd er een platform ontwikkeld voor studenten, professoren en bedrijven ivm masterproeven. Studenten kunnen hun thesisvoorkeuren doorgeven. Bedrijven kunnen masterproef voorstellen indienen. Professoren kunnen masterproefvoorstellen goedkeuren en masterproeven toekennen aan studenten.

De backend bestaat uit een Spring Boot Java applicatie. Hiermee werd een REST api opgemaakt die de verschillende requests van de frontend verwerkt en verwerkt met de MySQL database.

## Builds
De laatste build van dit project is terug te vinden op [Releases](https://github.com/Lukasdewachter/bachelorproef-backend/releases). Deze build kan opgestart worden door volgend commando uit te voeren in de terminal: `java -jar "./bachelorproef-backend-Vx.x.jar"`

## Developer
In developer omgeving kan dit project geopend worden in IntelliJ. Aan de hand van Maven worden de bijhorende Spring Boot, Java-MySQL en JSON WebToken dependencies opgehaald.

Door `.\src\main\java\com\backend\MainBackend.java` te runnen, wordt de Spring Boot omgeving opgestart.

## Packages
De applicatie is opgedeeld in drie verschillende packages. Elke package heeft zijn eigen doel en verwerkt aparte API endpoints.
1. Authentication
2. UserManagement
3. Thesis

## MySQL - *JPA*
Deze Spring Boot applicatie maakt gebruik van een MySQL database om alle gegevens in op te slaan. Volgende variabelen staan gedefinieerd in `\src\main\resources\application.properties` om een verbinding op te zetten met de DB:
* DB: `masterproef_project`  
* User: `mp_backend`  
* WW: `backend`

## HTTPS
De endpoints zijn enkel bereikbaar via een beveiligde HTTPS verbinding. Hiervoor werd er een selfsigned certificaat aangemaakt: `\src\main\resources\sslKey.p12`. 

## JSON Webtoken
Bij de authenticatie van de *users* wordt er gebruik gemaakt van JSON Webtokens. Wanneer de authenticatie geslaagd is, wordt er een token teruggestuurd. Deze token moet vervolgens in de frontend bij elke request meegestuurd worden in de *HTTP header*. De backend controleert dan of de token nog niet vervallen is.

Houdbaarheid van een token is ingesteld op 5 uren.

## Minimale vereisten
* OpenJDK 17