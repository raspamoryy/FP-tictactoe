# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information
Name: Muhammad Fauzy Setia Nugraha
Student ID: 5026251011
Class: A

## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing.
The application includes login, game statistics, and Top 5 scorer
feature.

## Features
- Login using database
- Play Tic-Tac-Toe using Swing GUI
- Record wins, losses, draws, and score
- Display personal statistics
- Display Top 5 scorers using JTable

## Database
Database used: MySQL

## How to Run
1. Create the database.
2. Import schema.sql.
3. Open the Java project.
4. Add JDBC driver.
5. Configure DatabaseManager.java.
6. Run Main.java.

## Class Explanation
Main: The Main class is the starting point of the application. It is responsible for launching the program and displaying the login page when the game starts.

DatabaseManager: The DatabaseManager class handles the connection between the Java application and the MySQL database. It allows the program to access and update player data stored in the database.

Player: The Player class represents a player in the game. It stores player information such as username, wins, losses, draws, and score that can be used throughout the application.

PlayerService: The PlayerService class manages operations related to player data. It is used for login validation, updating game statistics, and retrieving player information from the database.

GameLogic: The GameLogic class contains the core rules of the Tic Tac Toe game. It manages player moves, checks winning conditions, determines draw situations, and handles the computer's moves.

LoginFrame: The LoginFrame class provides the login interface for users. It allows players to enter their username and password before accessing the main menu.

MainMenuFrame: The MainMenuFrame class serves as the main navigation page after a successful login. From this menu, players can start a new game, view their statistics, check the leaderboard, or exit the application.

GameFrame: The GameFrame class displays the Tic Tac Toe game board and manages user interaction during gameplay. It also communicates with the game logic and updates player statistics after each match.

StatisticsFrame: The StatisticsFrame class displays the current player's performance data, including total wins, losses, draws, and score. This allows players to track their progress over time.

TopScorersFrame: The TopScorersFrame class shows the leaderboard of the highest-scoring players. It retrieves player rankings from the database and displays the top performers in the game.

## Screenshots
### Login Page

![Login](screenshots/login.png)

### Main Menu

![Main Menu](screenshots/mainmenu.png)

### Gameplay

![Gameplay](screenshots/gameplay.png)

### Statistics

![Statistics](screenshots/statistics.png)

### Top Scorer

![Top Scorer](screenshots/topscorer.png)

## Video Link
YouTube: 