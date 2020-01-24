package pl.b2b.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ExcelRaport {

    private static XSSFWorkbook excelWorkbook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;
    private static FileInputStream excelFile;


    public static void writeToExcel(String path, String sheet, String name, String surname, String address, String value, String title, boolean result) {

        List<String> listToExcel = new ArrayList<>();
        listToExcel.add(name);
        listToExcel.add(surname);
        listToExcel.add(address);
        listToExcel.add(value);
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
            int excelLastRow = excelSheet.getLastRowNum() + 1; //wybór wiersza do którego będziemy zapisywać
            excelRow = excelSheet.createRow(excelLastRow);

            for(int i = 0; i<listToExcel.size(); i++){
                excelCell = excelRow.createCell(i);
                excelCell.setCellValue(listToExcel.get(i));
            }

//            excelCell = excelRow.createCell(0);
//            excelCell.setCellValue(name);
//            excelCell = excelRow.createCell(1);
//            excelCell.setCellValue(surname);
//            excelCell = excelRow.createCell(2);
//            excelCell.setCellValue(address);
//            excelCell = excelRow.createCell(3);
//            excelCell.setCellValue(value);
//            excelCell = excelRow.createCell(4);
//            excelCell.setCellValue(title);
//            excelCell = excelRow.createCell(5);
            if (result) {
                excelCell.setCellValue("Pozytywny");
            } else {
                excelCell.setCellValue("Negatywny");
            }

            FileOutputStream fileOutputStream = new FileOutputStream(path);
            excelWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            excelWorkbook.close();
            excelFile.close();

        } catch (Exception e) { // wykrywa wszystkie wyjątki
            e.printStackTrace();
        }

    }


}
