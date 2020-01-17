package pl.b2b.IngTest.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelData {

    private static XSSFWorkbook excelWorkbook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;
    private static FileInputStream excelFile;

    public static void openExcel(String path, String sheet){
        try {
            excelFile = new FileInputStream(path);
            excelWorkbook = new XSSFWorkbook(excelFile);
            excelSheet = excelWorkbook.getSheet(sheet);
        } catch (Exception e) { // wykrywa wszystkie wyjątki
            e.printStackTrace();
        }
    }

    public static String getCellData(int rowNum, int columnNum){
        excelCell = excelSheet.getRow(rowNum).getCell(columnNum);
        return excelCell.getStringCellValue();

    }

    public static String getNumericCellData(int rowNum, int columnNum){
        excelCell = excelSheet.getRow(rowNum).getCell(columnNum);
        return String.valueOf(excelCell.getNumericCellValue()); //zamiana double na string

    }

    public static void closeFile(){
        try {
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
