# passagens-api
API - Para Gerenciamento de Passagens Aereas

Ao iniciar  a aplicação pela classe PassagensApiApplication sera realizada a criação das tabelas de dominio
e a inclusão de 2 perfis de acesso ADIM e USER, além da inclusão do Usuário MASTER (admin:admin).


Voce pode validar a autenticação do usuaário MASTER atraves da documentação: {HOST}:{PORTA}/swagger-ui.html

POST: http://{HOST}:{PORTA}/login
{
  "senha": "admin",
  "usuario": "admin"
}

Response:

{
  "login": "admin",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInNjb3BlcyI6IlJPTEVfQURNSU4iLCJpYXQiOjE2MDQ3MDI4MjEsImV4cCI6MTYwNDcwNjQyMX0.cAY_X-VnqogmYFDZ3E2v4YKC_1qhGT7R8gAWQAQE1gc",
  "userId": 1
}

Se preferir está disponível a inclusão dos viajantes (clientes) ou consulta dos voos pela API

VOSS
 
POST: http://{HOST}:{PORTA}/flights
{
	"originLocationCode" : "NYC",
	"destinationLocationCode" : "PAR",
	"departureDate" : "2020-12-01" ,
	"returnDate" : "2020-12-06",
	"adults" : "1",
	"max":"2"
}

Response:

"data": [
    {
      "response": null,
      "deSerializationClass": null,
      "type": "flight-offer",
      "id": "1",
      "source": "GDS",
      "instantTicketingRequired": false,
      "nonHomogeneous": false,
      "oneWay": false,
      "lastTicketingDate": "2020-11-06",
      "numberOfBookableSeats": 3,
      "itineraries": [
	  
	  ...
]


Para prosseguir na iteração da API é necessário realizar o cadastro do viajante:


