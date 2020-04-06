# Tic-Tac-Toe
Tic tac toe is a fun and easy to play game.

Rules:
  - The first player will draws an X and the second player draws an O.
  - You can draw only on empty places.
  - The first player that has three in a row horizontally, vertically and diagonaly wins.
  - If all  nine squares are filled it's a draw.

How to play:
  - The game will ask for a row and column number
  - When both fields are filled in, press submit or enter
  - An X or an O will be drawn on the given field ( The game automatically knows what to draw)
  - If you submit a wrong number, character or the place is already in use the game will let you know and you can re enter a row and   
    column number
    
# How to run program
1. Pull the project
2. Open the project in your prefered IDE
3. Compile and run the project 
4. Go to localhost http://localhost:8080/start in browser and enjoy the game
( Error: localhost is already in use might pop up then go to you resources folder under the main folder in your IDE. Then open "application.properties" and set the following sentence in the file;" server.port=8081 " save and recompile program. If everthing done correctly got to http://localhost:8081/start)

# Run tests
1. Open test directory in your IDE
2. Right click on Java driectory and run all tests (if using Intellij right click run all tests with coverage)

# Technologies used
- Maven 4.0.0
- Java 11
- Spring boot 2.2.6
- JUnit 5
- Thymeleaf

# IDE
- Intellij
