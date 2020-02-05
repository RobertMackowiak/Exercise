package pl.b2b.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExeclRaport {
    private static XSSFWorkbook exelWorkbook; // cały arkusz kalkulacyjny
    private static XSSFSheet exelSheet; // zakładki w arkuszu
    private static XSSFRow exelRow;
    private static XSSFCell exelCell;
    private static FileInputStream exelFile;

    public static void wrihtToExcell (String path, String sheet, String name, String surname, String address, String cash, String title, boolean result){
        try {
            List<String> lista = new ArrayList<>();
            lista.add(name);
            lista.add(surname);
            lista.add(address);
            lista.add(cash);
            lista.add(title);
            if (result){
                lista.add("Pozytywny");

            }else {
                lista.add("Negatywny");
            }
            exelFile = new FileInputStream(path);
            exelWorkbook = new XSSFWorkbook(exelFile); // tworzymy obiekt exela
            exelSheet = exelWorkbook.getSheet(sheet); // otwieramy arkusz
            int exelLastRow = exelSheet.getLastRowNum() + 1; //puste miejsce w exelu gdzie możemy zapisać dane testowe
            exelRow = exelSheet.createRow(exelLastRow);
            for (int i = 0; i < lista.size(); i++){

                exelCell = exelRow.createCell(i);
                exelCell.setCellValue(lista.get(i));
            }

//            exelRow = exelSheet.createRow(exelLastRow);
//            exelCell = exelRow.createCell(0);
//            exelCell.setCellValue(name);
//            exelCell =exelRow.createCell(1);
//            exelCell.setCellValue(surname);
//            exelCell = exelRow.createCell(2);
//            exelCell.setCellValue(address);
//            exelCell =exelRow.createCell(3);
//            exelCell.setCellValue(cash);
//            exelCell = exelRow.createCell(4);
//            exelCell.setCellValue(title);
//            exelCell = exelRow.createCell(5);


            FileOutputStream fileOutputStream = new FileOutputStream(path);
                exelWorkbook.write(fileOutputStream);
                fileOutputStream.close();
                exelWorkbook.close();
                exelFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
