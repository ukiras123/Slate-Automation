package main.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Kiran on 3/5/18.
 */
public class SlateGUI extends JFrame {

    protected JComboBox envDropDown;

    protected JComboBox createDropDown;

    protected JTextField fileField;

    protected JTextArea outputArea;

    protected JButton downloadBtn;

    protected JButton createBtn;

    private JLabel envLab,fileLab,createChoiceLab;

    public SlateGUI() {
        super("SLATE");
        getContentPane().setLayout(null);
        setSize(500,350);

        envLab = new JLabel("Env");
        envLab.setBounds(75, 28, 40, 25);
        getContentPane().add(envLab);

        String[] envOption = { "Local", "QA", "Stg"};
        envDropDown = new JComboBox(envOption);
        envDropDown.setBounds(165, 29, 102, 25);
        getContentPane().add(envDropDown);

        createChoiceLab = new JLabel("Choose An Option");
        createChoiceLab.setBounds(75, 102, 153, 25);
        getContentPane().add(createChoiceLab);

        String[] selectionOption = { "Create All", "Create Schedule"};
        createDropDown = new JComboBox(selectionOption);
        createDropDown.setBounds(215, 101, 201, 25);
        getContentPane().add(createDropDown);

        fileLab = new JLabel("File Path");
        fileLab.setBounds(75, 65, 78, 25);
        getContentPane().add(fileLab);

        fileField = new JTextField("/Users/kgautam/Desktop/Template.xlsx");
        fileField.setBounds(165, 64, 251, 25);
        getContentPane().add(fileField);

        outputArea = new JTextArea("");
        outputArea.setBounds(75, 203, 341, 92);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        outputArea.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        getContentPane().add(outputArea);

        createBtn = new JButton("Create Data");
        createBtn.setBounds(165, 149, 153, 25);
        createBtn.setActionCommand("Create");
        getContentPane().add(createBtn);

        downloadBtn = new JButton("Download Template");
        downloadBtn.setBounds(263, 27, 153, 25);
        downloadBtn.setActionCommand("Download");
        getContentPane().add(downloadBtn);

        setVisible(true);
        setResizable(false);
    }

}
