# Country Service

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

Controller : There is one controller CountryController which exposed 2 end points mentioned above 
Model : Model has contry which will send response , country response , convertor
Security: Security Config will take care of user name and pwd
Service : CountryConsumerService and it's implementation which consumes end points from here : https://restcountries.eu/
CountryServiceApplication : Spring boot starter class

Idea was to use change Spring Reactive API so output was changed to flux .
For using functional programming we should use routers and handlers instead of controller but as for this test just Controller is used .


Swagger UI :

http://localhost:8080/swagger-ui/#/


Run via inside CountryService module:
mvn spring-boot:run
