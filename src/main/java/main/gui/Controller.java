package main.gui;


import org.apache.poi.ss.usermodel.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;

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
                outputArea.setText("Download Link:\n" + fileLocation);
            } else if (e.getActionCommand().equals("Create")) {
                System.out.println("Create clicked");
                String FILE_NAME = fileField.getText();
                Workbook workbook = WorkbookFactory.create(new File(FILE_NAME));

                // Retrieving the number of sheets in the Workbook
                System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

                DataFormatter dataFormatter = new DataFormatter();
                // 1. You can obtain a sheetIterator and iterate over it
                Iterator<Sheet> sheetIterator = workbook.sheetIterator();
                System.out.println("Retrieving Sheets using Iterator");
                while (sheetIterator.hasNext()) {
                    Sheet sheet = sheetIterator.next();
                    if (sheet.getSheetName().equalsIgnoreCase("Schedule")) {
                        System.out.println("=> " + sheet.getSheetName());
                        Iterator<Row> rowIterator = sheet.rowIterator();
                        while (rowIterator.hasNext()) {
                            Row row = rowIterator.next();
                            // Now let's iterate over the columns of the current row
                            Iterator<Cell> cellIterator = row.cellIterator();
                            cellIterator.next();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                String cellValue = dataFormatter.formatCellValue(cell);
                                System.out.print(cellValue + "\t");
                            }
                            System.out.println();
                        }
                    }
                }

                // Closing the workbook
                workbook.close();
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
