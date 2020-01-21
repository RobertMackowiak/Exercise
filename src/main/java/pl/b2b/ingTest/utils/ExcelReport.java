package pl.b2b.ingTest.utils;

import org.apache.poi.xssf.usermodel.*;
import pl.b2b.ingTest.utils.ExcelData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelReport {

    private static FileInputStream excelFile;
    private static XSSFWorkbook excelWorkbook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;

    public static void writeToExcel(String path, String sheet, String name, String surname, String address, String amount, String title, boolean result) {
        List<String> listToExcel = new ArrayList<>();
        listToExcel.add(name);
        listToExcel.add(surname);
        listToExcel.add(address);
        listToExcel.add(amount);
        listToExcel.add(title);

        if (result) {
            listToExcel.add("POZYTYWNY");
        } else {
            listToExcel.add("NEGATYWNY");
        }

        try {
            excelFile = new FileInputStream(path);
            excelWorkbook = new XSSFWorkbook(excelFile);
            excelSheet = excelWorkbook.getSheet(sheet);
            int excelLastRow = excelSheet.getLastRowNum() + 1;
            excelRow = excelSheet.createRow(excelLastRow);
            for(int i = 0; i<listToExcel.size();i++) {
                excelCell = excelRow.createCell(i);
                excelCell.setCellValue(listToExcel.get(i));
//            excelCell = excelRow.createCell(0);
//            excelCell.setCellValue(name);
//            excelCell = excelRow.createCell(1);
//            excelCell.setCellValue(surname);
//            excelCell = excelRow.createCell(2);
//            excelCell.setCellValue(address);
//            excelCell = excelRow.createCell(3);
//            excelCell.setCellValue(amount);
//            excelCell = excelRow.createCell(4);
//            excelCell.setCellValue(title);
//            excelCell = excelRow.createCell(5);
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