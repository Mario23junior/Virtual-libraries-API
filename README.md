<p align="center"><img src="logo/logo.gif" width = "833px" height="433px"></p>

<h1 align="center"> Virtual libraries API</h1>

<h3 align="center">
API REST de código aberto para dados de consulta de  pesquisa  as informações nelas contidadas com o objetivo de estabelecer resultados relevantes <a href="https://solarsystem.nasa.gov/" target="_blank">Nasa</a>
 <a href="https://www.iau2006.org/"usando como base organizacional um sistema de CRUD
<p align="center">
 
<a href="https://app.travis-ci.com/Mario23junior/solar-system-api.svg?branch=main" target="_blank"> [![Build Status](https://app.travis-ci.com/Mario23junior/solar-system-api.svg?branch=main)](https://app.travis-ci.com/Mario23junior/solar-system-api.svg?branch=main)
<a href="https://en.wikipedia.org/wiki/Representational_state_transfer"><img src="https://img.shields.io/badge/interface-REST-brightgreen.svg?longCache=true&style=flat-square" target="_blank"></a>
</p>
  
## Primeiro execute o maven 

## 🚀 Começando

Algums parametros de ação são necessarios para a execução
### 📋 Pré-requisitos
 
* [Java11](http://www.dropwizard.io/1.0.2/docs/)
* [Spring boot](https://spring.io/projects/spring-boot)
* [H2](https://www.h2database.com/html/main.html)
* [Swagger](https://swagger.io/)
* [openJDK](https://maven.apache.org/)
* [Heroku](https://www.heroku.com/free)

 
### 🔧 Instalação 🛠️ 

Uma série de exemplos passo-a-passo que informam o que você deve executar para ter um ambiente de desenvolvimento em execução.

Diga como essa etapa será:

```
java -jar target/digitalLibrary-0.0.1-SNAPSHOT.jar

```
 
 ###  Documentação  
```
http://localhost:8080/swagger-ui/index.html
```


## Uso

```
http://localhost:8080/v1/api/listall/
```

## Resultado dos dados da API

 ```json
 
 [
   {
      "id":1,
      "image":"https://m.media-amazon.com/images/I/81jdJ94mSbL.jpg",
      "name":"Java®: Como Programar",
      "author":"Paul Deitel, Harvey Deite",
      "edition":10,
      "publishingCompany":"Pearson Universidades",
      "propriedadesDto":[
         {
            "id":2,
            "page":968,
            "isbn":8543004799,
            "theme":"Computação"
         }
      ],
      "publicacaoDto":[
         {
            "id":3,
            "coverType":"Capa comum",
            "publicationDate":"24/06/2016",
            "dimensoes":"28 x 20.8 x 3.8cm"
         }
      ]
   }
]
```
 
## 📄 Licença
 
Este projeto está sob a licença (GNU GPLv3) - [GNU GPLv3.md](https://www.gnu.org/licenses/gpl-3.0.pt-br.html)
