# Vets Api

Uma api rest que provê informações ao VetsApp.

## Requisitos
- JDK 8

## Como rodar
É necessário ter a JDK 11 ou JRE instalado para rodar a aplicação.

Abra o console dentro da pasta raíz do projeto e insira o comando a seguir:


```bash
mvnw spring-boot:run
 ```

Quando aparecer a mensagem abaixo no console, significa que a api carregou com sucesso
e está aberta aguardando uma requisição.

```bash
"-------------------------------- O sistema foi carregado --------------------------------"
```

---
## Rotas

Agora acesse localhost:8080/ para acessar os recursos da Api. 

Segue abaixo as rotas disponíveis, onde estão representadas por método /recurso,
onde o "recurso" informado deve ser acessado em localhost:8080/recurso e método entende-se
os métodos http GET,POST,PUT,DELETE.

### `GET` /location
Retorna as clínicas mais próximas de acordo com a localização enviada.
Deve-se enviar um arquivo JSON como corpo da requisição conforme o exemplo abaixo,
e será retornado uma array de objetos JSON com as clínicas mais próximas.

```JSON
/* Corpo da requisição */
{
    "latitude": -23.7075796,
    "longitude": -46.7951825,
    "raio": 8000
}
```
Também é possível acessar via query params, com os parâmetros lat, lng ou raio. 

Caso o raio não seja informado será utilizado o valor padrão de 8000.

Exemplo caso esteja rodando localmente:

```
localhost/location?lat=-23.7075796&lng=-46.7951825&raio=8000
```

Exemplo de resposta:
```JSON
[
  {
    "formattedAddress": null,
    "geometry": {
      "bounds": null,
      "location": {
        "lat": -23.6508475,
        "lng": -46.7567901
      },
      "locationType": null,
      "viewport": {
        "northeast": {
          "lat": -23.6494695697085,
          "lng": -46.7554677697085
        },
        "southwest": {
          "lat": -23.6521675302915,
          "lng": -46.7581657302915
        }
      }
    },
    "name": "Clinica Veterinária e Pet Shop Animacão",
    "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
    "placeId": "ChIJb_UYAd1TzpQRvu_qIBP8R7A",
    "scope": "GOOGLE",
    "rating": 3.3,
    "types": [
      "veterinary_care",
      "health",
      "point_of_interest",
      "store",
      "establishment"
    ],
    "openingHours": {
      "openNow": true,
      "periods": null,
      "weekdayText": null,
      "permanentlyClosed": null
    },
    "photos": null,
    "vicinity": "Estrada de Itapecerica, 2543 - Capao Redondo, São Paulo",
    "permanentlyClosed": false,
    "userRatingsTotal": 43,
    "businessStatus": "OPERATIONAL"
  }
]
```

### `GET` /details
Retorna os dados detalhados de uma clínica conforme o id enviado pela rota de requisição.
O parâmetro id deve informar o Id da clínica que pode ser obtido na rota location.
<br>
Deve-se ser acessada por localhost:8080/details?id=InsiraOIdAqui 

Exemplo de resposta:
```JSON
{
    "addressComponents": [
        {
            "longName": "2543",
            "shortName": "2543",
            "types": [
                "STREET_NUMBER"
            ]
        },
        {
            "longName": "Estrada de Itapecerica",
            "shortName": "Estr. de Itapecerica",
            "types": [
                "ROUTE"
            ]
        },
        {
            "longName": "Jardim Nova Germania",
            "shortName": "Jardim Nova Germania",
            "types": [
                "SUBLOCALITY_LEVEL_1",
                "SUBLOCALITY",
                "POLITICAL"
            ]
        },
        {
            "longName": "São Paulo",
            "shortName": "São Paulo",
            "types": [
                "ADMINISTRATIVE_AREA_LEVEL_2",
                "POLITICAL"
            ]
        },
        {
            "longName": "São Paulo",
            "shortName": "SP",
            "types": [
                "ADMINISTRATIVE_AREA_LEVEL_1",
                "POLITICAL"
            ]
        },
        {
            "longName": "Brasil",
            "shortName": "BR",
            "types": [
                "COUNTRY",
                "POLITICAL"
            ]
        },
        {
            "longName": "05835-005",
            "shortName": "05835-005",
            "types": [
                "POSTAL_CODE"
            ]
        }
    ],
    "adrAddress": "<span class=\"street-address\">Estr. de Itapecerica, 2543</span> - <span class=\"extended-address\">Capao Redondo</span>, <span class=\"locality\">São Paulo</span> - <span class=\"region\">SP</span>, <span class=\"postal-code\">05835-005</span>, <span class=\"country-name\">Brasil</span>",
    "formattedAddress": "Estr. de Itapecerica, 2543 - Capao Redondo, São Paulo - SP, 05835-005, Brasil",
    "formattedPhoneNumber": "(11) 5511-5650",
    "geometry": {
        "bounds": null,
        "location": {
            "lat": -23.6508475,
            "lng": -46.7567901
        },
        "locationType": null,
        "viewport": {
            "northeast": {
                "lat": -23.6494695697085,
                "lng": -46.7554677697085
            },
            "southwest": {
                "lat": -23.6521675302915,
                "lng": -46.7581657302915
            }
        }
    },
    "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/shopping-71.png",
    "internationalPhoneNumber": "+55 11 5511-5650",
    "name": "Clinica Veterinária e Pet Shop Animacão",
    "openingHours": {
        "openNow": true,
        "periods": [
            {
                "open": {
                    "day": "SUNDAY",
                    "time": "00:00:00"
                },
                "close": {
                    "day": "SATURDAY",
                    "time": "23:59:00"
                }
            }
        ],
        "weekdayText": [
            "segunda-feira: Atendimento 24 horas",
            "terça-feira: Atendimento 24 horas",
            "quarta-feira: Atendimento 24 horas",
            "quinta-feira: Atendimento 24 horas",
            "sexta-feira: Atendimento 24 horas",
            "sábado: 00:00 – 23:59",
            "domingo: Atendimento 24 horas"
        ],
        "permanentlyClosed": null
    },
    "photos": null,
    "placeId": "ChIJb_UYAd1TzpQRvu_qIBP8R7A",
    "scope": null,
    "plusCode": {
        "globalCode": "588M86XV+M7",
        "compoundCode": "86XV+M7 Capao Redondo, São Paulo - SP, Brasil"
    },
    "permanentlyClosed": false,
    "userRatingsTotal": 43,
    "altIds": null,
    "priceLevel": null,
    "rating": 3.3,
    "reviews": [
        {
            "aspects": null,
            "authorName": "Gustavo Pancas",
            "authorUrl": "https://www.google.com/maps/contrib/115709778989571177076/reviews",
            "language": "pt",
            "profilePhotoUrl": "https://lh3.googleusercontent.com/a-/AOh14GjgHcSV-31tieRdSH_qCSyyndPBgXLSQsoXxnUq8E8=s128-c0x00000000-cc-rp-mo",
            "rating": 1,
            "relativeTimeDescription": "na última semana",
            "text": "Péssimo lugar levei meu pet para banho e tosa 2 vezes as duas ele voltou com um hematoma no olho, levei a primeira vez em outro veterinário para avaliar me falou que era um hematoma até pensei que as vezes foi sem querer poderia ter acontecido. Hoje levei ele de novo quando cheguei em casa a surpresa ele estava com um hematoma enorme estava até roxo levei no veterinário lá mesmo, me falaram que poderia ser stress meu cachorro foi duas vezes em outros pet shop antes de passar lá de novo e voltou normal! Se desse para postar foto aqui mostraria como o meu pet ficou estou decepcionado.\namanhã irei fazer um b.o",
            "time": "2021-03-28T02:39:08Z"
        },
        {
            "aspects": null,
            "authorName": "Luciana Jesus de Amorim",
            "authorUrl": "https://www.google.com/maps/contrib/102393700987180729865/reviews",
            "language": "pt",
            "profilePhotoUrl": "https://lh6.googleusercontent.com/-ITb86Has1iM/AAAAAAAAAAI/AAAAAAAAAAA/AMZuucl8U6ZISf7Fets9ON2sbkHnWScllA/s128-c0x00000000-cc-rp-mo/photo.jpg",
            "rating": 5,
            "relativeTimeDescription": "2 meses atrás",
            "text": "Hoje foi meu primeiro contato e atendimento na animacao, levei minha gatinha, ela sofreu um acidente e o atendimento da unidade de Itapecerica foi incrível, a Vet Bianca foi muito atenciosa, prestativa e muito humanizada com a gatinha e toda a situação. Obrigada!!! Voltarei com certeza.",
            "time": "2021-01-23T03:33:43Z"
        },
        {
            "aspects": null,
            "authorName": "Vitor Franco",
            "authorUrl": "https://www.google.com/maps/contrib/114896981727467827492/reviews",
            "language": "pt",
            "profilePhotoUrl": "https://lh3.googleusercontent.com/a-/AOh14GhHRg8Iwai0aSZoSRmOgpWx31MzsikkckIeOHitFhU=s128-c0x00000000-cc-rp-mo",
            "rating": 1,
            "relativeTimeDescription": "10 meses atrás",
            "text": "PÉSSIMO! O veterinário errou a injeção e DEIXOU MINHA GATA ALEIJADA. E AINDA POR CIMA NÃO FIZERAM NADA. Essa clínica é uma máfia de arrancar dinheiro E MALTRATOS A ANIMAIS! Nunca levem seus animais, é morte ou maltratos na certa. LUGAR PODRE! Deixaram minha gata toda suja, mijada, esperando pra fazer cirurgia. SÓ SERVE PRA ARRANCAR DINHEIRO. IMUNDOS",
            "time": "2020-05-13T20:03:07Z"
        },
        {
            "aspects": null,
            "authorName": "carolina rodrigues",
            "authorUrl": "https://www.google.com/maps/contrib/109366608601645033621/reviews",
            "language": "pt",
            "profilePhotoUrl": "https://lh3.googleusercontent.com/a-/AOh14GjsVEnt72Ml9OIOtVZvskvpUdNbx83OSuIpiNvSAA=s128-c0x00000000-cc-rp-mo",
            "rating": 1,
            "relativeTimeDescription": "3 meses atrás",
            "text": "Muito Caro todos os procedimentos.",
            "time": "2020-12-19T22:10:33Z"
        },
        {
            "aspects": null,
            "authorName": "Deza Castro",
            "authorUrl": "https://www.google.com/maps/contrib/116873211905591935895/reviews",
            "language": "pt",
            "profilePhotoUrl": "https://lh3.googleusercontent.com/a-/AOh14GiceCY4vY8bomQGXjdgfyv_UtLfVqPTzS-2tugdPJc=s128-c0x00000000-cc-rp-mo",
            "rating": 5,
            "relativeTimeDescription": "um ano atrás",
            "text": "Sou cliente já tem um tempo.. Equipe do petshop muito atenciosa..Doutor Pedro excelente médico, baita experiência, super indico, já salvou meu cachorro umas três vezes da morte.",
            "time": "2020-01-03T18:52:22Z"
        }
    ],
    "types": [
        "VETERINARY_CARE",
        "HEALTH",
        "POINT_OF_INTEREST",
        "STORE",
        "ESTABLISHMENT"
    ],
    "url": "https://maps.google.com/?cid=12702398433108619198",
    "utcOffset": -180,
    "vicinity": "Estrada de Itapecerica, 2543 - Capao Redondo, São Paulo",
    "website": null,
    "htmlAttributions": [],
    "businessStatus": "OPERATIONAL"
}
```
---
## Tecnologias usadas
- Java
- Spring Web
- Spring Boot
- Maven
- Testes Unitários (MockMVC e Junit 4)  
- Google Cloud Platform
 - Google Nearby Search
 - Google Places Details
- Google Cloud Platform
- Herokku (Cloud Deploy/CI)
- CORS
