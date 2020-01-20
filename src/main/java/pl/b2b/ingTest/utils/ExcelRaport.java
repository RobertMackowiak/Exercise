package pl.b2b.ingTest.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;


public class ExcelRaport {

    private static FileInputStream excelFile;
    private static XSSFWorkbook excelWorkbook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;

    public static void writeToExcel(String path, String sheet, String name, String surname, String adress, String amount, String title, boolean result){
        try {
            excelFile = new FileInputStream(path);
            excelWorkbook = new XSSFWorkbook(excelFile);
            excelSheet = excelWorkbook.getSheet(sheet);
            int excelLastRow = excelSheet.getLastRowNum()+1;  //pierwszy pusty rząd
            excelRow = excelSheet.createRow(excelLastRow);  //tworzy pustą linijkę
            excelCell = excelRow.createCell(0);
            excelCell.setCellValue(name);
            excelCell = excelRow.createCell(1);
            excelCell.setCellValue(surname);
            excelCell = excelRow.createCell(2);
            excelCell.setCellValue(adress);
            excelCell = excelRow.createCell(3);
            excelCell.setCellValue(amount);
            excelCell = excelRow.createCell(4);
            excelCell.setCellValue(title);
            excelCell = excelRow.createCell(5);
            if (result){
                excelCell.setCellValue("Pozytywny");
            }else{
                excelCell.setCellValue("Negatywny");
            }

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            excelWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            excelWorkbook.close();
            excelFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}