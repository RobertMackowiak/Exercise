package pl.b2b.bankIng.utils;

import org.apache.poi.xssf.usermodel.*;


import java.io.*;
import java.util.List;

public class ExcelRaport {

    private static FileInputStream excelFile;
    private static XSSFWorkbook excelWorkbook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;

    public static void writeToExcel(String path, String sheet, String name, String surname, String address, String amount, String title, boolean result) {
        try {
            excelFile = new FileInputStream(path);
            excelWorkbook = new XSSFWorkbook(excelFile);
            excelSheet = excelWorkbook.getSheet(sheet);
            int excelLastRow = excelSheet.getLastRowNum() + 1;
            excelRow = excelSheet.createRow(excelLastRow);
            excelCell = excelRow.createCell(0);
            excelCell.setCellValue(name);
            excelCell = excelRow.createCell(1);
            excelCell.setCellValue(surname);
            excelCell = excelRow.createCell(2);
            excelCell.setCellValue(address);
            excelCell = excelRow.createCell(3);
            excelCell.setCellValue(amount);
            excelCell = excelRow.createCell(4);
            excelCell.setCellValue(title);
            excelCell = excelRow.createCell(5);
            if (result) {
                excelCell.setCellValue("POZYTYWNY");
            } else {
                excelCell.setCellValue("NEGATYWNY");
            }
            FileOutputStream fileOutputString = new FileOutputStream(path);
            excelWorkbook.write(fileOutputString);
            fileOutputString.close();
            excelWorkbook.close();
            excelFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}