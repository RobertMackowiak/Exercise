package pl.b2b.utils;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Object[]> dataProviderFromExcel(String path){
        List<Object[]> data = new ArrayList<>();

        try {
            setExcelFile(path);

        for(int rowNum = 1;rowNum<=excelWSheet.getLastRowNum();rowNum++){
            String name = getCellData(rowNum,0);
            String surname = getCellData(rowNum,1);
            String adres = getCellData(rowNum,2);
            String cashAmount = getNumericCellData(rowNum,3);
            String title = getCellData(rowNum,4);

            Object ob[]={name,surname,adres,cashAmount,title};
            data.add(ob);
        }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

//    public static String[][] getDataFromExcelToProvider(String path){
//        String[][] tablice = null;
//        try {
//            setExcelFile(path);
//            for(int rowNum = 1;rowNum<=excelWSheet.getLastRowNum();rowNum++){
//                String name = getCellData(rowNum,0);
//                String surname = ExcelData.getCellData(1,1);
//                String adres = ExcelData.getCellData(1,2);
//                String cashAmount = ExcelData.getNumericCellData(1,3);
//                String title = ExcelData.getCellData(1,4);
//
////                Object ob[]={name,surname,adres,cashAmount,title};
////                data.add(ob);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return tablice;
//    }

    public static void closeFiles(){
        try {
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
