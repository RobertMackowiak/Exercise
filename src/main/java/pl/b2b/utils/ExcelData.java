package pl.b2b.utils;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelData {

    private static XSSFSheet excelWSheet;
    private static XSSFWorkbook excelWBook;
    private static XSSFCell cell;
    private static XSSFRow row;
    private static FileInputStream excelFile;

    public static void setExcelFile(String Path) throws Exception {
        try {
            // Open the Excel file
            excelFile = new FileInputStream(Path);
            // Access the required test data sheet
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheetAt(0);
        } catch (Exception e){
            throw (e);
        }
    }

    public static String getCellData(int RowNum, int ColNum) throws Exception{

        try{
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            String cellData = cell.getStringCellValue();
            return cellData;
        }catch (Exception e){
            return"";
        }
    }

    public static String getNumericCellData(int RowNum, int ColNum) throws Exception{

        try{
            cell = excelWSheet.getRow(RowNum).getCell(ColNum);
            double cellData = cell.getNumericCellValue();
            return String.valueOf(cellData);
        }catch (Exception e){
            return "";
        }
    }

    public static void closeFiles(){
        try {
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
