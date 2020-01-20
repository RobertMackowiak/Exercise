package pl.b2b.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//pobieranie danych z Exela (apache poi )
public class ExelData {
    private static XSSFWorkbook exelWorkbook; // cały arkusz kalkulacyjny
    private static XSSFSheet exelSheet; // zakładki w arkuszu
    private static XSSFRow exelRow;
    private static XSSFCell exelCell;
    private static FileInputStream exelFile;

    // Lapanie wszystkich wyjątków (Exeptions)
    public static void openExel(String path, String sheet1) {
        try {
            exelFile = new FileInputStream(path);
            exelWorkbook = new XSSFWorkbook(exelFile); // tworzymy obiekt exela
            exelSheet = exelWorkbook.getSheet(sheet1); // otwieramy arkusz
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getCellData(int rowNum, int collumnNum) {
        exelCell = exelSheet.getRow(rowNum).getCell(collumnNum);
        return exelCell.getStringCellValue();
    }

    public static String getNumericCellData(int rowNum, int collumnNum) {
        exelCell = exelSheet.getRow(rowNum).getCell(collumnNum);
        return String.valueOf(exelCell.getNumericCellValue());
    }

    public static void closeFile() {
        try {
            exelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object[]> getAllDataExcel(String path, String sheet1) {
        List<Object[]> lista = new ArrayList<>();
        openExel(path, sheet1);
        for (int i = 1; i <= exelSheet.getLastRowNum(); i++) {
            String name = ExelData.getCellData(i, 0);
            String surname = ExelData.getCellData(i, 1);
            String address = ExelData.getCellData(i, 2);
            String cash = ExelData.getNumericCellData(i, 3);
            String title = ExelData.getCellData(i, 4);
            Object ob[] = {name, surname, address, cash, title};
            lista.add(ob);
                    }

        return lista;
    }
}
