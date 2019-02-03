# CrazyDevelopers
## Overview
This project creates a flexible data base according to every user's needs. 
It includes 5 classes and 2 test classes:

-Main2 which includes the main method to run the programm

-Functions which contains necessary functions for our database

-Menu that contains all the menus needed for the program

-ArrayListLine that is used as a whole different  line in our database

-Exceptions that checks whether an Exception is thrown or not

-FunctionsTest and ExceptionsTest that check methods of their target classes.

The executable jar is attached to master branch.
## Execution
As soon as you run the programm, there is a menu for the user to enter number of tables and features and give names to them.
After tables and features are initialized the user can choose between 6 choices(add, show, delete, change data, print relational 
model and save the database on a file).

Specifically:

-Choice 1(add data): User enters number of table and the value he wishes to add a new field to the database.

-Choice 2(show data): The programm prints the name of tables, features and all the fields that user has entered until that moment.

-Choice 3(delete data): User wishes to delete a field from the data base. He enters the number of table and line 
this field is located.

-Choice 4(change data): User has the opportunity to choose between changing a whole line or a spesific itme of that field.
Either way user enters number of table and line he wishes to change the value of, but in the second case another entry is 
necessary, the number of the specific feauture.

-Choice 5(print relational model): The programm prints the relational model for the data base that user has created.

-Choice 6(save data base on a file): The programm ends with this choice and the data base is saved into a file on your pc.
User enters the name of the file he wishes to save the data base into and chooses the path of the file.
He has the opportunity to enter his own path or save it to the default one(C:\Users/Public\)

Of course, the Exceptions class catches if any exception is thrown because of a user's fault. For instance, the programm demands integer numbers for lines and columns for the database and a number less than the array length. If the user does not follow these rules the programm throws NotIntegerException or ArrayOutOfBoundsExceptions respectively. In order for the programm to work properly and continue without any problem Exception class forces the user to obey the rules.

## Members
* [Konstantinos Zois](https://github.com/kzois)
* [Nefeli-Andriani Theodosi](https://github.com/ntheodosi)
* [Maria Karageorgiou](https://github.com/KarageorgiouMaria)
* [Dimitra Karadima](https://github.com/dimitra-karadima)
* [Stefanos Kypritidis](https://github.com/stef4k)
* [Iwanna Mourtzaki](https://github.com/iwannamourtzaki)
* [Angeliki Ouzounaki](https://github.com/angelikiouzounaki)
* [Konstantina Stavraka](https://github.com/konastav)
