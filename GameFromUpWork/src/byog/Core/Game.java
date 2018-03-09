package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;

import java.awt.event.*;
import java.io.*;
import java.util.Random;

import byog.TileEngine.World;
import byog.TileEngine.WorldBSP;

import javax.swing.*;

import java.awt.*;

public class Game {
    public static Random random = new Random();

    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    private static final int WIDTH = 80;
    private static final int HEIGHT = 34;
    private static final int WINDOW_WIDTH = 80;
    private static final int WINDOW_HEIGHT = 34;
    private JButton newGame;
    private JButton loadGame;
    private JButton quit;
    private JLabel theGame;
    private JLabel seed;
    private JTextField smallField;


    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public void playWithKeyboard() {

        JFrame frame = new JFrame("THE GAME");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        Container container = frame.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(new Color(0, 0, 0));

        frame.getContentPane().add(panel);

        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        panel.setBackground(new Color(0, 0, 0));
        newGame = CreateButton("New Game(N)");
        loadGame = CreateButton("Load Game(L)");
        quit = CreateButton("Quit(Q)");
        theGame = new JLabel("THE GAME");
        theGame.setFont(new Font("Clalibri", Font.PLAIN, 80));
        theGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewGame();
                frame.setVisible(false);
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SystemExit();
                frame.setVisible(false);
            }
        });

        newGame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();

                if (key == 'n' || key == 'N') {
                    NewGame();
                    frame.setVisible(false);

                }
                if (key == 'q' || key == 'Q') {
                    SystemExit();
                    frame.setVisible(false);
                }
                if (key == 'l' || key == 'L') {
                    int save = 0;
                    try {
                        save = ReadSave();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    TETile[][] finalWorldFrame = null;
                    World world = new World();
                    world.setSeed(save);

                    TERenderer ter = new TERenderer();
                    ter.initialize(WINDOW_WIDTH, WINDOW_HEIGHT);

                    finalWorldFrame = world.buildMap(WIDTH, HEIGHT);

                    ter.renderFrame(finalWorldFrame);
                    frame.setVisible(false);
                }
            }
        });


        container.add(theGame);
        container.add(newGame);
        container.add(loadGame);
        container.add(quit);


        frame.pack();

        frame.setVisible(true);
        panel.setVisible(true);


    }

    private JButton CreateButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0, 0, 0));
        button.setFont(new Font("Calibri", Font.PLAIN, 30));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        return button;
    }

    private void NewGame() {
        JFrame frameSetRooms = new JFrame("Seed:");
        frameSetRooms.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panelSetRooms = new JPanel();
        panelSetRooms.setBackground(new Color(0, 0, 0));
        seed = new JLabel("Seed:");
        seed.setFont(new Font("Calibri", Font.PLAIN, 30));
        smallField = new JTextField(3);
        panelSetRooms.add(seed);
        panelSetRooms.add(smallField);
        frameSetRooms.getContentPane().add(panelSetRooms);
        frameSetRooms.setVisible(true);
        panelSetRooms.setVisible(true);
        frameSetRooms.pack();


        smallField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TETile[][] finalWorldFrame = null;
                //World world = new World();
                WorldBSP worldBSP = new WorldBSP();
                try {
                    //WorldBSP.setSeed(Integer.parseInt(smallField.getText()));
                    seedWrite(Integer.parseInt(smallField.getText()));
                } catch (NumberFormatException k) {
                    JOptionPane.showMessageDialog(smallField, "Must be an integer!");
                    NewGame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                TERenderer ter = new TERenderer();
                ter.initialize(WINDOW_WIDTH, WINDOW_HEIGHT);

                //finalWorldFrame = world.buildMap(WIDTH, HEIGHT);
                finalWorldFrame = worldBSP.createLeafs(WIDTH, HEIGHT);


                ter.renderFrame(finalWorldFrame);
                frameSetRooms.setVisible(false);
                panelSetRooms.setVisible(false);
            }
        });


    }

    private void SystemExit() {
        System.exit(0);
    }


    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     *
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] playWithInputString(String input) throws IOException {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().
        TETile[][] finalWorldFrame = null;
        World world = new World();

        if (input.equals("L") || input.equals("l")) {
            int seed = ReadSave();
            world.setSeed(seed);
        } else {
            char[] str = input.toCharArray();
            StringBuilder sb = new StringBuilder();

            for (char i : str) {
                boolean isDigit = Character.isDigit(i);
                if (isDigit) {
                    sb.append(i);
                }
            }


            try {
                if (sb.length() == 0) {
                    world.setSeed(Integer.parseInt(input));
                    seedWrite(Integer.parseInt(input));
                } else {
                    world.setSeed(Integer.parseInt(sb.toString()));
                    seedWrite(Integer.parseInt(sb.toString()));
                }
            } catch (NumberFormatException k) {
                // System.out.println("Must be an Integer!");
            }
        }


        TERenderer ter = new TERenderer();
        ter.initialize(WINDOW_WIDTH, WINDOW_HEIGHT);
        finalWorldFrame = world.buildMap(WIDTH, HEIGHT);
        ter.renderFrame(finalWorldFrame);
        return finalWorldFrame;

    }

    private Integer ReadSave() throws IOException {
        String filePatch = "D:\\JavaRush_new\\JavaRushTasks\\GameFromUpWork\\src\\byog\\Core\\save";
        FileReader reader = new FileReader(filePatch);
        int c = 0;
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            c = reader.read();
            sb.append((char) c);
        }
        reader.close();

        return Integer.parseInt(sb.toString());
    }

    public void seedWrite(int i) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("D:\\JavaRush_new\\JavaRushTasks\\GameFromUpWork\\src\\byog\\Core\\save"));
        fileWriter.write(String.valueOf(i));
        fileWriter.flush();
        fileWriter.close();
    }
}
