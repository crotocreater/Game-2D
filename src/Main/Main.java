package Main;

import GamePakage.GamePanell;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Game 2D");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); // cho phep thay doi kich co window

        GamePanell gamePanell = new GamePanell();
        window.add(gamePanell);

        window.pack(); // tại sao lại có cái này ???

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanell.startGameThread();
    }
}