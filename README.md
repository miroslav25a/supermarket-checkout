# Supermarket Checkout
Does a supermarket checkout for a given basket and applies all given discounts.

## Motivation
Elsevier Mendeley and Policy Expert coding exercise

## Installation
For local development:

mvn clean install
## Tests

For unit tests:

    mvn test

* Note I: In Eclipse you can run all the tests by right-clicking on the project and selecting Run As->JUnit Test. 
* Note II: run single test in the terminal:  mvn -Dtest=TestName test

## Usage
1. open terminal
2. cd to supermarket-checkout project direcotry
3. mvn clean install
4. java -jar -Dapple.awt.UIElement="true" target/supermarket-checkout-0.0.1.jar <<full path to basket.json>> <<full path to discounts.json>> -h 

* Note I: example basket.json location: /supermarket-checkout/src/main/resources/basket.json 
* Note II: example discounts.json location: /supermarket-checkout/src/main/resources/discounts.json
* Note III: example of java command with file paths : java -jar -Dapple.awt.UIElement="true" target/supermarket-checkout-0.0.1.jar workspace/supermarket-checkout/src/main/resources/basket.json workspace/supermarket-checkout/src/main/resources/discounts.json -h
* Note IV: example of java command for Policy Expert: java -jar -Dapple.awt.UIElement="true" target/supermarket-checkout-0.0.1.jar workspace/supermarket-checkout/src/main/resources/policy-expert-basket.json workspace/supermarket-checkout/src/main/resources/policy-expert-discounts.json -h

## Add Discounts
To add new discounts, edit discounts.json file and add to the list:
{
	"type": "TWO_FOR_PRICE",
	"amount": 1.50,
	"itemNamesOrTypes": [
		"Apple"
	]
}	
