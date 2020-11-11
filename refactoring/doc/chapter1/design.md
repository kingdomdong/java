## [PlantUML](https://plantuml.com/class-diagram)

### movie rental


```java

// How to generate the following image horizontally?
@startuml
class Movie {
  {field} priceCode:int
}

class Rental {
  {field} dsysRented:int
}

class Customer {
  {method} statement()
}

Movie "1" <-- "*" Rental : contains

Rental "1" <-- "*" Customer : contains
@enduml
```

![PlantUML diagram](http://www.plantuml.com/plantuml/png/LOw_2i8m48VtUueZameTN8j3eREBRn1w9mRoHtfNGKBUtGOhZLlu-BvVRX2riox1m-Ij25xJop5cGCntnvuAFcStyPY8UnUryi3wI5IWmDRSEAhrVn79MofcgjMkZeje2ZnZRfPGr2g7LJySg_gzmPmDNheEpSdyVkXnIkl3HG7OK6FjuuqtSAGb-0y0)



