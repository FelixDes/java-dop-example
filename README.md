# Java DOP example
Fine-grained access resolution system implemented in __Java 21__ with new Java __DOP__ (Data Oriented Programming) features

Project was used at [Joker conference talk](https://jokerconf.com/en/talks/c2214c26c900415fb48c5862248e3b94/?referer=%2Fschedule%2Fdays%2F) as an example

## Usage

1) Run with: 
```shell
./gradlew bootRun
```
2) Then open [swagger page](http://localhost:8080/swagger-ui.html)

## Points of interest
- [CompositeAccessResolutionService](src/main/java/com/jug/joker/javadopexample/service/CompositeAccessResolutionService.java)
- [Entity tree walker](src/main/java/com/jug/joker/javadopexample/service/EntityWalkerService.java)
- [Default users](src/main/java/com/jug/joker/javadopexample/config/SecurityConfig.java)