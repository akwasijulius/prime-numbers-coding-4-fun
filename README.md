# Prime numbers

A RESTful service that calculates and returns all the prime numbers up to an including a number provided.

Example

The REST call should look like  http://your.host.com/primes/10  and should return JSON content:
{

  “Initial”:  “10

  “Priimes”: [2,3,5,7]

}

## Solution

The soloution was written with Java 8 / Maven / Spring Boot (version 2.0.1)

### Build and Run

Maven:

```sh
mvn clean package spring-boot:run
```

### Usage

Test the `prime` endpoint and get a json response:

```sh
curl -X GET "http://localhost:8080/primes/17" -H "accept: application/json"
```

You receive the following JSON response, 

```json
{
  "Initial": 17,
  "Primes": [2,3,5,7,11,13,17]
}
```

Test the `prime` endpoint and get an xml response:

```sh
curl -X GET "http://localhost:8080/primes/17" -H "accept: application/xml"
```

You receive the following XML response, 

```xml
<PrimeDto>
  <Initial>17</Initial>
  <Primes>
    <Primes>2</Primes>
    <Primes>3</Primes>
    <Primes>5</Primes>
    <Primes>7</Primes>
    <Primes>11</Primes>
    <Primes>13</Primes>
    <Primes>17</Primes>
  </Primes>
</PrimeDto>
```

