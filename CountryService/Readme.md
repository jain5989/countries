# European Country Service

### Introduction
This project includes the Spring boot based project which has API's for giving the information of european countries .

There are two types of api :

```
GET
/countries/

Response :
{
  "countries": [
    {
      "name": "Finland",
      "country_code": "FI"
    },
    {
      "name": "XX",
      "country_code": "XX"
    }
  ]
}

```

```
GET
/countries/{name}

Response : 
{
   "name":"Finland",
   "country_code":"FI",
   "capital":"Helsinki",
   "population":5491817,
   "flag_file_url":"<url to the flag file>"
}
```

These end point has basic authentication with user name and pwd

Just For test purpose
```
username : admin 
password : admin
```

This project has following module ::
```
controller : 
There is one controller CountryController which exposed 2 end points mentioned above 
model : Model has contry which will send response , country response , convertor
sercurity: Security Config will take care of user name and pwd
service : CountryConsumerService and it's implementation which consumes end points from here : https://restcountries.eu/
CountryServiceApplication : Spring boot starter class
```

Swagger UI :

http://localhost:8080/swagger-ui/#/


Run via:
mvn spring-boot:run