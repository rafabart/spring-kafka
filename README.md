Projeto demo mensageria com Spring, Kafka e Docker.

Usando:

* Kafka
* JDK 11
* Springboot 2.2.1
* IntelliJ
* Rest
* Lombok
* Zookeeper
* Gradle
* Docker

Subindo uma stack de containers docker com Kafka e Zookeeper usando o arquivo docker-compose.yml do projeto:
```
  docker-compose up
 ```


Este projeto possui uma aplicação producer(publica mensagens no kafka) e uma aplicação consumer (consome mensagens no kafka).
Após subir ambas aplicações, os andpoints de envio de mensagem podem receber requisições:

1) Andpoint
Usando o Postman para manda uma mensagem simples:

URL: http://localhost:8080/orders

Verbo: POST usando JSON
```
{
  "message":"Sua mensagem aqui"
}
```

2) Andpoint
Usando o Postman para manda uma entidade:

URL: http://localhost:8080/orders/record

Verbo: POST usando JSON
```
{  
	"identifier":"001",
	"customer":"Jaimes",
	"value": 10000
}
```

As mensagens podem serem vistas no log da api consumer.
