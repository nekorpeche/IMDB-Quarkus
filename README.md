# lunatech-imdb-assessment-template

La documentation du projet est disponible ici [documentation.pdf](IMDB-lunatech-documentation.pdf)

Technologies :

- Quarkus

```shell
choco install quarkus
```

- Angular

```shell
npm install -g @angular/cli
```

- Maven
- PostgreSQL

Données :
Imdb Dataset

Environnement local :

* Pour lancer les conteneurs (à la racine du projet) :
  L'extension -d permet de le lancer en tâche de fond

```shell
docker-compose up -d
```

* Pour lancer le back se rendre dans le répertoire backend-imdb et lancer :

```shell
quarkus dev
```

* Pour lancer le front se rendre dans le répertoire frontend-imdb et lancer :

```shell
ng serve
```
