package pl.b2b.utils;

import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.List;

public class ExcelRaport {
    public void writeToExcelPositive(String name,String surname, String adress, String cash, String title){

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
            int nextRow = lastRowNum+1;
            row = sheet.createRow(nextRow);

            //Tworzy nowe komórki i przypisuje im wartości
            cell = row.createCell(0);
            cell.setCellValue(name);

            cell = row.createCell(1);
            cell.setCellValue(surname);

            cell = row.createCell(2);
            cell.setCellValue(adress);

            cell = row.createCell(3);
            cell.setCellValue(cash);

            cell = row.createCell(4);
            cell.setCellValue(title);

            cell = row.createCell(5);
            cell.setCellValue("POZYTYWNY");


            FileOutputStream os = new FileOutputStream(file);
            book.write(os);
            os.close();
            book.close();
            fis.close();
//            dataList.clear();


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToExcelNegative(){
        try{
            File file = new File("C://Users//B2B//Desktop//TestReport.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            XSSFRow row = sheet.getRow(lastRowNum);
            XSSFCell cell = row.getCell(0);
//            int testNumer = (int)cell.getNumericCellValue()+1;
            int nextRow = lastRowNum+1;
            row = sheet.createRow(nextRow);
//            cell = row.createCell(0);
//            cell.setCellValue(testNumer);
            cell = row.createCell(5);
            cell.setCellValue("NEGATYWNY");
            FileOutputStream os = new FileOutputStream(file);
            book.write(os);
            os.close();
            book.close();
            fis.close();
        }catch(Exception e){e.printStackTrace();}
    }
}