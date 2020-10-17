## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [EndPoints](#EndPoints)

## General info
This project is simple mobile-e-shop-axiom Demo for task about interview at Axiom telecom Company.

## Technologies
Project is created with:
* Java version: 8
* Spring Boot version: 2.1.10.RELEASE
* lombok
* Spring Data JPA
	
## Setup
To run this project, import it locally using any IDE and 

* make maven install to update all maven dependancies and build executable jar file 
* you can go to this Class  MobileShopDemo.java and run SpringBootApplication 
*  or from cmd you can directly go to the target folder which maven generates and open cmd in this path 
* type java -jar {type jar full name } and run 

## EndPoints
Project is Exposed these API's with:

** get list of Mobile handset :**  http://localhost:8080/mobiles/list <br />
** get list of Mobile handset By id :**  http://localhost:8080/mobiles/search?id=27999 <br />
** get list of Mobile handset By brand:**  http://localhost:8080/mobiles/search?brand=Apple <br />
** get list of Mobile handset By phone :**  http://localhost:8080/mobiles/search?phone=Wi-Fi <br />
** get list of Mobile handset By picture :**  http://localhost:8080/mobiles/search?picture=gsmarena <br />
** get list of Mobile handset By sim :**  http://localhost:8080/mobiles/search?sim=No <br />
** get list of Mobile handset By resolution :**  http://localhost:8080/mobiles/search?resolution=768 x 1024 pixels <br />
** get list of Mobile handset By announceDate :**  http://localhost:8080/mobiles/search?announceDate=2012 <br />
** get list of Mobile handset By priceEur :**  http://localhost:8080/mobiles/search?priceEur=200 <br />
** get list of Mobile handset By audioJack :**  http://localhost:8080/mobiles/search?audioJack=Yes <br />
** get list of Mobile handset By gps : ** http://localhost:8080/mobiles/search?gps=No <br />
** get list of Mobile handset By battery :**  http://localhost:8080/mobiles/search?battery=Li-Po 4490 mAh battery (16.7 Wh) <br />
** get list of Mobile handset By id and brand :**  http://localhost:8080/mobiles/search?id=27999&brand=Apple <br />
** get list of Mobile handset By phone and picture :**  http://localhost:8080/mobiles/search?phone=Wi-Fi&picture=gsmarena <br />
** get list of Mobile handset By sim and resolution :**  http://localhost:8080/mobiles/search?sim=No&resolution=768 x 1024 pixels <br />
** get list of Mobile handset By announceDate and priceEur :**  http://localhost:8080/mobiles/search?announceDate=2012&priceEur=200 <br />
** get list of Mobile handset By audioJack and gps :**  http://localhost:8080/mobiles/search?audioJack=Yes&gps=No  <br />
** get list of Mobile handset By battery and priceEur :**  http://localhost:8080/mobiles/search?battery=Li-Po 4490 mAh battery (16.7 Wh)&priceEur=200  <br />


and any combination of parameters needed ... 


Thanks and Best Regards