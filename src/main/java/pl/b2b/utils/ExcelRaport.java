package pl.b2b.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelRaport {
    public void writeToExcelPositive(String name, String surname, String adress, String cash, String title, boolean result) {
        List<String> listaDanych = new ArrayList<>();
        listaDanych.add(name);
        listaDanych.add(surname);
        listaDanych.add(adress);
        listaDanych.add(cash);
        listaDanych.add(title);
        if (result) {
            listaDanych.add("Pozytywny");
        } else {
            listaDanych.add("Negatywny");
        }


        try {
            File file = new File("C://Users//B2B//Desktop//TestReport.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);

            //Pobiera ostatni zapisany wiersz
            int lastRowNum = sheet.getLastRowNum();

            //Pobiera numer ostatniego testu
            XSSFRow row = sheet.getRow(lastRowNum);
            XSSFCell cell = row.getCell(0);
//            int testNumer = (int)cell.getNumericCellValue()+1;

            //Tworzy nowy wiersz
            int nextRow = lastRowNum + 1;
            row = sheet.createRow(nextRow);

            for (int i = 0; i < listaDanych.size(); i++) {
                cell = row.createCell(i);
                cell.setCellValue(listaDanych.get(i));
            }

            FileOutputStream os = new FileOutputStream(file);
            book.write(os);
            os.close();
            book.close();
            fis.close();
//            dataList.clear();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}