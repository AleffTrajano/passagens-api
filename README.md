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


POST: http://{HOST}:{PORTA}/viajantes

"cpfCnpj": "1234",
  "dataNascimento": "1990-10-10",
  "documento": {
    "numeroDocumento": "123123",
    "tipoDocumento": "PASSPORT"
  },
  "email": "viajante@gmail.com",
  "login": "test",
  "senha": "test",
  "nome": "VIAJANTE TEST",
  "sexo": "M",
  "telefone": {
    "ddd": 11,
    "nomeContato": "teste",
    "numero": 89980998
  }
  
  

Agora é o momento de realizar a geração da reserva (order)


POST: http://{HOST}:{PORTA}/flights/order/{viajante} - Onde o viajante é o id do cadastro

Para exemplo utilizar o arquivo createOrder.txt como body da requisição


Response:
"data": {
    "type": "flight-order",
    "id": "eJzTd9f39QlxtTAGAAs9AkM%3D",
    "associatedRecords": [
	...
	]

Além da resposta é armezado dados relevantes em nossa base de dados como id, preco e data da reserva.

A partir agora para consultar as reservas é necessário realizar o login como ADMIN ou Viajante acessando a url de login para obter o token

GET: http://{HOST}:{PORTA}/reservas

Parametros:
inicio: 2020-11-01 00:00:00
fim: 2020-11-30 23:59:59
viajanteId: 3

[
  {
    "id": 1,
    "orderId": "eJzTd9f39QlxtTAGAAs9AkM%3D",
    "price": 100,
    "viajanteId": 3,
    "dataHora": "2020-11-06T20:12:41",
    "status": "PP"
  }
]


