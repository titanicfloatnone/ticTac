#Design Report

##Introduction
Included in this report is the design framework for our implementation of the game Tic-Tac-Toe.
##Classes

![Class Diagram](https://github.com/titanicfloatnone/ticTac/blob/markdownFiles/docs/ClassDiagram.png)

##Coding Rules
###HTML


###Java
Below are listed the various coding rules when writing our Java code
* All classes have Pascalcasing
* All functions, function parameters and member variables have camelCasing
* Stroustrup style is used for curly braces
* The code follows good Object orientation
* The business logic is written with test-driven development
* Member variables are private

##Design
The initial design revolved around creating an entity class Square and making the tic-tac-toe board an array of such squares inside the business layer. The business layer takes care of any interpretation and manipulations of the board state which the front end retrieves and displays. The game is hosted on a web server through Heroku. When a particular square is pressed the UI forwards that information back to the business layer by ...ALEX SKIFADU HERNA... which processes the information and sends back the current board state as a Json string. The UI then displays the board state retrieved. After a winner has been found the Business layer simply stops updating the board no matter the move.