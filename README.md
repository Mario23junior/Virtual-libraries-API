<p align="center"><img src="/resources/logo/digital-library.gif" width = "833px" height="433px"></p>

<h1 align="center"> Virtual libraries API</h1>

<h4 align="center">
Objetivo desta API e promover uma interface bem definida para garantir que a
interação entre as aplicações e sistemas seja íntegra. Neste contexto temos a
aplicação da arquitetura REST em conjunto com outras tecnologias para sistemas
distribuidos como HTTP e JSON, para construção de APIs que promovem
comunicação e troca de dados maneira simples e rápida.
<p align="center">
 
  [![Virtual libraries build](https://github.com/Mario23junior/Virtual-libraries-API/actions/workflows/Maven.yml/badge.svg?branch=main)](https://github.com/Mario23junior/Virtual-libraries-API/actions/workflows/Maven.yml)
<a href="https://en.wikipedia.org/wiki/Representational_state_transfer"><img src="https://img.shields.io/badge/interface-REST-brightgreen.svg?longCache=true&style=flat-square" target="_blank"></a>
</p>
  
## Primeiro execute o maven 

## 🚀 Começando

Algums parametros de ação são necessarios para a execução
### 📋 Pré-requisitos
 
* [Java17](http://www.dropwizard.io/1.0.2/docs/)
* [Spring boot](https://spring.io/projects/spring-boot)
* [H2](https://www.h2database.com/html/main.html)
* [OpenAPI](https://www.openapis.org/)
* [openJDK](https://maven.apache.org/)
 
 
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
