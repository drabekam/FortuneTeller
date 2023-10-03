import javax.swing.SwingUtilities;

public class FortuneTellerViewer {


    public static void main(String[] args) {
        ////while do research i saw that other people were using this and they said that it is needed to load all gui related items and that
        //// it will technically work with out it but as we write more advanced things some things might not wokr so when calling the instacne it is better to get in the habit of using it.
        SwingUtilities.invokeLater(() -> {
            //creating an instance
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });

    }
}
