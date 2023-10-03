import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FortuneTellerFrame extends JFrame {

    //declaring the class variables

    private List<String> fortunes;
    private int previousFortuneIndex;
    private JLabel titleLabel;
    private JTextArea fortuneTextArea;
    private JButton fortuneButton;
    private JButton quitButton;

    //creating an image icon here, so it can be called later

    ImageIcon fortuneTellerImageIcon = new ImageIcon(new ImageIcon("/Users/andrewdrabek/School/Programming 2/FortuneTeller/src/high-angle-hands-holding-container.jpg")
            .getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));

    // The above code was something that i found to make the image be a certain dimension as when i first showed the image it was massive

    public FortuneTellerFrame() {

        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        //Creating the array list

        fortunes = new ArrayList<>();
        fortunes.add("You will meet a new friend today");
        fortunes.add("You will have a great day");
        fortunes.add("all the luck is yours");
        fortunes.add("You wont step on a crack and break your mothers back");
        fortunes.add("You will get an A on that test");
        fortunes.add("Your fortune will be awesome");
        fortunes.add("Your day will be something");
        fortunes.add("You will find a dollar");
        fortunes.add("You will win the loterry");
        fortunes.add("your life is going to be awesome");
        fortunes.add("You are goiing to join the NBA");
        fortunes.add("You are going to join the NFL");


        previousFortuneIndex = -1; // this is for the part of the assignment that needs to track the fortunes that have been given out

        //creating the different components

        JLabel imageLabel = new JLabel(fortuneTellerImageIcon);
        titleLabel = new JLabel("Fortune Teller");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));// was getting an error here and when looked up examples i needed to create new font but could also define it earlier either worked

        fortuneTextArea = new JTextArea(10,40);
        fortuneTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);

        fortuneButton = new JButton("Read My Fortune!");
        fortuneButton.setFont(new Font("Arial", Font.PLAIN, 18));

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.PLAIN, 18));

        //Java 8 lambda expressions that are used for the actions on the buttons

        fortuneButton.addActionListener(e -> generateFortune());
        quitButton.addActionListener(e -> System.exit(0));

//adding the image to the panel
        JPanel topPanel = new JPanel();
        topPanel.add(imageLabel);
        topPanel.add(titleLabel);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.add(fortuneButton);
        ButtonPanel.add(quitButton);
        add(ButtonPanel, BorderLayout.SOUTH);

    }

    private void generateFortune()
    {
        //Generate the index for the fortune and that is what I create the previoud fortune index in the class variables section

        int randomIndex;

        do {
            randomIndex = new Random().nextInt(fortunes.size());
        }
        while (randomIndex == previousFortuneIndex);

        String fortune = fortunes.get(randomIndex);
        fortuneTextArea.append(fortune + "\n");
        previousFortuneIndex = randomIndex;
    }



}
