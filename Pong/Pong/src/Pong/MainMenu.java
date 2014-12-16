package Pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MainMenu extends JFrame {

    int screenWidth = 250;
    int screenHeight = 150;

    int buttonWidth = 100;
    int buttonHeight = 40;

    JButton Play;
    JButton Quit;
    JCheckBox twoPlayer;

    JFrame frame;

    public MainMenu() {
        addButtons();
        addActions();

        //placing buttons
        getContentPane().setLayout(null);
        Play.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth, buttonHeight); // Position the Play button
        Quit.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth, buttonHeight); // Position the Quit button
        twoPlayer.setBounds((screenWidth - buttonWidth) / 2, 95, buttonWidth * 2, buttonHeight); // Position the twoPlayer checkbox

        // Adding buttons
        getContentPane().add(Play); // Add the button to the JFrame
        getContentPane().add(Quit); // Add the button to the JFrame
        getContentPane().add(twoPlayer); // Add the checkbox to the JFrame

        // JFrame stuff
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(screenWidth, screenHeight);
        setTitle("Pong Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    private void addButtons() {
        Play = new JButton("Play");
        Quit = new JButton("Quit");
        twoPlayer = new JCheckBox("Two Players?");

    }

    //addActions to buttons
    private void addActions() {

        //create listener to respond to user clicking "Play"
        Play.addActionListener(new ActionListener() { // Take Play button, add new actionlistener
            public void actionPerformed(ActionEvent e) { // Turn the action performed into a variable for usage
                dispose();  //get rid of menu once play is clicked
                
                
//                //experiment /////////////////
//                if(Game.gameOver){
//                Game.stop();
//                }
//                /////////////////////////////
                
                Game game = new Game();

                if (twoPlayer.isSelected()) {
                    game.ai.isTwoPlayer = true;
                } else {
                    game.ai.isTwoPlayer = false;
                }

                game.start();
            }
        });// Play button

        Quit.addActionListener(new ActionListener() { // Take Quit button, add new actionlistener
            public void actionPerformed(ActionEvent e) { // Turn the action performed into a variable for usage
                System.exit(0); // Shut down the program
            }
        });// Quit button

    }

}
