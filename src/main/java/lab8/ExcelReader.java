package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) {
        String fileName = "laborator8_input.xlsx";
        readExcel(fileName);
    }

    public static void readExcel(String filePath) {
        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(file)) {


            Sheet sheet = workbook.getSheetAt(0);


            for (Row row : sheet) {
                for (Cell cell : row) {
                    String value = "";

                    switch (cell.getCellType()) {
                        case STRING:
                            value = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            double num = cell.getNumericCellValue();
                            if (num == (long) num) {
                                value = String.valueOf((long) num);
                            } else {
                                value = String.valueOf(num);
                            }
                            break;
                        default:
                            value = "";
                    }
                    System.out.printf("%-12s", value);
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Eroare la citire: " + e.getMessage());
            e.printStackTrace();
        }
    }
}