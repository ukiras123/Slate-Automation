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
        if (e.getActionCommand().equals("Download")) {
            System.out.println("Download clicked");
        } else if (e.getActionCommand().equals("Create")) {
            System.out.println("Create clicked");
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
