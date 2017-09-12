# Unit Testing Exercises

Using the completed solutions from the class design homework assignment, you'll be writing unit tests to verify all of the functionality is working.
The classes have been documented so that the expected outcomes and requirements should be well known.

It will be up to you to write unit tests against each class to determine if actual outcomes match the expected outcomes.

The classes below should be tested.


## Homework Assignment

Things to look/test for

* does the correct letter grade get returned?
* what happens when an incorrect value is given for total marks?


## Fruit Tree

Things to look/test for

* is the correct result returned when the `PickFruit` method is called?
* is it possible to pick more fruit than exists on the fruit tree?


## Employee

Things to look/test for

* is the annual salary correct after receiving a raise?
* is it possible to give a non-negative raise amount?


## Airplane

Things to look/test for

* is it possible to overbook seats?
* is the count for available seats accurate?
* is the count accurate after successfully booking a seat?    


## Smart Phone

Things to look/test for

* does the battery return to 100% after recharging?
* are there any methods that change the state of the object when repeatedly called?
* is it possible to spend too much time on a call that there isn't enough battery power remaining?
* what happens if we dial a 7-digit number and not a 10 digit number?


## Television        
    
Things to look/test for

* are there boundaries on the volume limits?
* does the volume correctly reset when turning the tv on?
* are there unexpected side effects when changing the channel, turning it on/off, raising/lowering volume?
    
    
## Elevator

Things to look/test for

* unintended side effects when calling methods
* moving between floors when the doors are open
* going up past the ceiling