package service;

import dao.GenericDao;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Kiran on 3/5/18.
 */
public abstract class Service {
    public abstract GenericDao getRequestBody();

    public static boolean updateExcel(Map<Integer, String> rowAndCode, String excelFile, String sheetName) {
        try {

            FileInputStream file = new FileInputStream(excelFile);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName);

            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font font = workbook.createFont();
            font.setColor(IndexedColors.BLACK.getIndex());
            style.setFont(font);

            Iterator it = rowAndCode.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                Row row = sheet.getRow((Integer) pair.getKey());
                Cell cell = row.getCell(0);
                if (cell == null)
                    cell = row.createCell(1);
                cell.setCellType(CellType.STRING);
                cell.setCellValue((String) pair.getValue());
                cell.setCellStyle(style);
            }
            file.close();

            // Write the output to the file
            FileOutputStream fileOut = new FileOutputStream(excelFile);
            workbook.write(fileOut);
            fileOut.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error during excell file update: " + e.getMessage());
            return false;
        }
    }
}
