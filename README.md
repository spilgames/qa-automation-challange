# Spil QA automation challenge application

## Requirements
This is a payment API. It has one method buyCoins where you can calculate the required amount in EUR what you need to pay to buy SpilCoins.   
It supports three payment provider: PAYPAL, CREDITCARD, IDEAL.   

1. You can only pay with PAYPAL over 20 EUR but there is no extra fee.
2. You can pay with IDEAL any amount but it costs 1 EUR, if you pay more than 25 EUR there is no fee.
3. You can pay with CREDITCARD but the fee is 2%, if you pay more than 25 EUR the fee is 1% and over 50 EUR there is no fee.

The price of the SpilCoin is based on the amount you buy. Till 5 it is 0.5 each, over this till 10 it costs 0.4 each, over this till 20 it costs 0.3 each, over this till 40 it costs 0.2 each, over this till 60 it costs 0.15 each, over this it costs 0.1 each.

## To start the application:
1. run: mvn clean install jetty:run
2. visit: http://localhost:8080/service/buyCoins/method=METHOD&amount=AMOUNT
| Where method can be PAYPAL, CREDITCARD, IDEAL 
| and amount is an integer

## Example calls
* http://localhost:8080/service/buyCoins/?method=CREDITCARD&amount=120
* http://localhost:8080/service/buyCoins/?method=PAYPAL&amount=46
* http://localhost:8080/service/coins/?&amount=120

## Response format
{"payment": {"amount":[CALCULATED AMOUNT]}}   
{"payment": {"error":"[ERROR MESSAGE]"}}
