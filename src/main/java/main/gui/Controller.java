package main.gui;

import dao.schedule.Schedule;
import dao.schedule.ScheduleSegment;
import org.apache.poi.ss.usermodel.*;
import service.ScheduleService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
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
                String fileLocation = "https://docs.google.com/spreadsheets/d/1W4Dukbthf67u8awWuk3OMEy13k6SQ9bLdzvKSs5hQSY/edit?usp=sharing";
                outputArea.setText("Download Link:\n" + fileLocation);
            } else if (e.getActionCommand().equals("Create")) {
                System.out.println("Create clicked");
                HashMap<Integer, String> rowAndScheduleCode = new HashMap<Integer, String>();
                Schedule schedule = new Schedule();
                String FILE_NAME = fileField.getText();

                if (fileField.getText() != null && !fileField.getText().equalsIgnoreCase("")) {
                    Workbook workbook = WorkbookFactory.create(new File(FILE_NAME));
                    // Retrieving the number of sheets in the Workbook
                    System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets");
                    DataFormatter dataFormatter = new DataFormatter();
                    // 1. You can obtain a sheetIterator and iterate over it
                    Iterator<Sheet> sheetIterator = workbook.sheetIterator();
                    System.out.println("Retrieving Sheets using Iterator");
                    while (sheetIterator.hasNext()) {
                        Sheet sheet = sheetIterator.next();
                        System.out.println("SheetName: "+sheet.getSheetName());
                        if (sheet.getSheetName().equalsIgnoreCase("Schedule")) {
                            int readRow = 1;
                            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                                Row row = sheet.getRow(rowIndex);
                                if (readRow == 1) {
                                    if (row != null) {
                                        Cell cell1 = row.getCell(1);
                                        Cell cell2 = row.getCell(2);
                                        Cell cell4 = row.getCell(4);
                                        String description = dataFormatter.formatCellValue(cell1);
                                        String repeatLastSegmentIndefinitely = dataFormatter.formatCellValue(cell2);
                                        String segmentsValue = dataFormatter.formatCellValue(cell4);

                                        schedule.setDescription(description);
                                        schedule.setRepeatLastSegmentIndefinitely(Boolean.parseBoolean(repeatLastSegmentIndefinitely));

                                        String[] segmentToken = segmentsValue.split(",");
                                        for (String segmentNumber : segmentToken) {
                                            ScheduleSegment segment = new ScheduleSegment();
                                            segment.setSegmentNumber(Integer.parseInt(segmentNumber));
                                            schedule.getScheduleSegments().add(segment);
                                        }
                                        System.out.println(description);
                                        System.out.println(repeatLastSegmentIndefinitely);
                                        System.out.println(segmentsValue);
                                    }
                                } else {
                                    Cell cell4 = row.getCell(4);
                                    String cell4Value = dataFormatter.formatCellValue(cell4);
                                    System.out.println(cell4Value);
                                    if (!cell4Value.equalsIgnoreCase("n/a")) {
                                        if (readRow == 2) {
                                            String[] segmentToken = cell4Value.split(",");
                                            for (int i = 0; i < segmentToken.length; i++) {
                                                schedule.getScheduleSegments().get(i).getTimepoint().setForm(segmentToken[i]);
                                            }
                                        } else if (readRow == 3) {
                                            String[] segmentToken = cell4Value.split(",");
                                            for (int i = 0; i < segmentToken.length; i++) {
                                                schedule.getScheduleSegments().get(i).getTimepoint().setDays(segmentToken[i]);
                                            }
                                        } else if (readRow == 4) {
                                            String[] segmentToken = cell4Value.split(",");
                                            for (int i = 0; i < segmentToken.length; i++) {
                                                schedule.getScheduleSegments().get(i).getTimepoint().setOrdinals(segmentToken[i]);
                                            }
                                        } else if (readRow == 5) {
                                            String[] segmentToken = cell4Value.split(",");
                                            for (int i = 0; i < segmentToken.length; i++) {
                                                schedule.getScheduleSegments().get(i).getTimepoint().setMonths(segmentToken[i]);
                                            }
                                        } else if (readRow == 6) {
                                            String[] segmentToken = cell4Value.split(",");
                                            for (int i = 0; i < segmentToken.length; i++) {
                                                schedule.getScheduleSegments().get(i).setIncrement(Integer.parseInt(segmentToken[i]));
                                            }
                                        } else if (readRow == 7) {
                                            String[] segmentToken = cell4Value.split(",");
                                            for (int i = 0; i < segmentToken.length; i++) {
                                                schedule.getScheduleSegments().get(i).setOccurrences(Integer.parseInt(segmentToken[i]));
                                            }
                                        }
                                    }
                                }
                                readRow++;
                                if (readRow == 8) {
                                    String scheduleCode = ScheduleService.createSchedule("QA",schedule);
                                    outputArea.setText(scheduleCode);
                                    rowAndScheduleCode.put(rowIndex-6,scheduleCode);
                                    readRow = 1;
                                }
                            }
                        }
                    }
                    workbook.close();
                }
                boolean updateSuccess = ScheduleService.updateExcel(rowAndScheduleCode, FILE_NAME, "Schedule");

                outputArea.setText(outputArea.getText()+"\nFile Update: "+updateSuccess);
            }
        } catch (Exception ex) {
            outputArea.setText(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}
