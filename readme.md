# [JA] PROJEKT 1
## Letecká pošta
- mezi městy států
- načíst z csv/xml souboru balíky - kde jsou a kam mají jít (oboje města)
- algoritmus pro hledání cest (najít nějakou knihovnu)
    - pro každý balík spočítat kolik hopů bude potřebovat do cíle (nemusí to být to nejlepší, prostě nějaký počet)
- mapa světa - [https://restcountries.com/](https://restcountries.com/) - endpoint na hlavní město a seznam sousedů státu, vrací json
- testy - Spock framework (groovy)
- gradle, knihovny

### Prerekvizity
Docker  
Java JDK 17+ Temurin

### Setup
Go to project folder
```
docker-compose up
run Letecka-Posta application
```
In shell
```
shell:>insert-countries
```

# [JA] PROJEKT 2
## Framework pro webovou aplikaci
- vytvorit system, kde se nadefinuje kus kodu, ktery se provola, kdyz uzivatel neco udela
- provolani jednoduche databazove dotazy
- dependenci injection
- service (dependenci injection)
- vytvořit jednoduchý framework
- lombok
- reflexe
- servlet api, někde poslouchá na portu?
- jednoduchá databázová věc - napojení - jdbc connection, username, password, driver
- jdbc template
- celé propojit, udělat jeden controller
- nejde o to naimplementovat systém, ale vytvořit ten framework

# [JA] PROJEKT 3
## Jednoducha rest aplikace ve springu
- s aspoň jednou operáciou Create, Update, Delete, Read. Tiež pridať nejakú biznis logiku alebo niečo čo sme robili v posledných cvikách (monitoring...).
- napojeno na databazi
- muzeme si zkusit i pripojit keycloak nebo cokoliv, co jsme zkouseli na cvicenich od zadani druheho

### Prerekvizity
Docker  
Java JDK 17+ Temurin

### Setup
Go to project folder
```
docker-compose up
run Projekt3 application
```
