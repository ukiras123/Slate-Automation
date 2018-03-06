package main.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kiran on 3/5/18.
 */
public class Controller extends SlateGUI implements ActionListener {

    public Controller() {
        super();
        createBtn.addActionListener(this);
        downloadBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("Download")) {
                System.out.println("Download clicked");
                String fileLocation = "https://docs.google.com/spreads heets/d/1W4Dukbthf67u8awWuk3OMEy13k6SQ9 bLdzvKSs5hQSY/edit?usp=sharing";
                outputArea.setText("Download Link:\n"+fileLocation);
            } else if (e.getActionCommand().equals("Create")) {
                System.out.println("Create clicked");
            }
        } catch (Exception ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
