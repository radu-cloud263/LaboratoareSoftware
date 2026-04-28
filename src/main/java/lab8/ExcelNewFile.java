package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelNewFile {

    public static void main(String[] args) {
        String inputFileName = "laborator8_input.xlsx";
        String outputFileName = "laborator8_output2.xlsx";
        generateOutputWithAverage(inputFileName, outputFileName);
    }

    public static void generateOutputWithAverage(String inputPath, String outputPath) {

        try (FileInputStream fis = new FileInputStream(new File(inputPath));
             Workbook inputWorkbook = new XSSFWorkbook(fis);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet inputSheet = inputWorkbook.getSheetAt(0);
            Sheet outputSheet = outputWorkbook.createSheet("Rezultate");

            int rowNum = 0;
            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(rowNum++);
                int lastCellNum = 0;


                for (int i = 0; i < inputRow.getLastCellNum(); i++) {
                    Cell inputCell = inputRow.getCell(i);
                    Cell outputCell = outputRow.createCell(i);

                    if (inputCell != null) {
                        copyCellValue(inputCell, outputCell);
                    }
                    lastCellNum = i;
                }


                Cell averageCell = outputRow.createCell(lastCellNum + 1);

                if (inputRow.getRowNum() == 0) {

                    averageCell.setCellValue("Media");
                } else {

                    double sum = 0;
                    int count = 0;


                    for (int i = lastCellNum; i > lastCellNum - 3; i--) {
                        Cell c = inputRow.getCell(i);
                        if (c != null && c.getCellType() == CellType.NUMERIC) {
                            sum += c.getNumericCellValue();
                            count++;
                        }
                    }

                    if (count > 0) {
                        averageCell.setCellValue(sum / count);
                    }
                }
            }


            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                outputWorkbook.write(fos);
                System.out.println("Fișierul " + outputPath + " a fost generat.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void copyCellValue(Cell oldCell, Cell newCell) {
        switch (oldCell.getCellType()) {
            case STRING:
                newCell.setCellValue(oldCell.getStringCellValue());
                break;
            case NUMERIC:
                newCell.setCellValue(oldCell.getNumericCellValue());
                break;
            case BOOLEAN:
                newCell.setCellValue(oldCell.getBooleanCellValue());
                break;
            case FORMULA:
                newCell.setCellFormula(oldCell.getCellFormula());
                break;
            default:
                break;
        }
    }
}