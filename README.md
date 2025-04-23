# TicTacToe 5x5 (JavaFX)

A simple JavaFX application that implements a 5x5 TicTacToe game.  
The first player to place **five** of their marks (`X` or `O`) in a row — horizontally, vertically, or diagonally — wins.

## 🧠 Features
- JavaFX GUI with a 5x5 board
- Click-based turn system for `X` and `O`
- Win condition: 5 in a row
- Disables board when game is over

## 📁 File Structure
TicTacToe5x5/ ├── README.md ├── TicTacToe.java ├── run.bat ├── lib/ │ ├── javafx.controls.jar │ ├── javafx.base.jar │ └── javafx.graphics.jar

![screenshotsgame-preview png](https://github.com/user-attachments/assets/e416f4e8-f1dc-4e93-a9cc-c8f492c33272)



## 🛠 How to Run

1. Make sure JavaFX is set up on your system (Java 17 + JavaFX 17 JARs in `lib/`).
2. Double-click `run.bat`, or use the command line:

```bash
javac --module-path lib --add-modules javafx.controls TicTacToe.java
java --module-path lib --add-modules javafx.controls TicTacToe

