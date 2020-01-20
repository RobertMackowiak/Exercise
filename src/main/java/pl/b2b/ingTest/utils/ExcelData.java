package pl.b2b.ingTest.utils;

        import org.apache.poi.xssf.usermodel.XSSFCell;
        import org.apache.poi.xssf.usermodel.XSSFRow;
        import org.apache.poi.xssf.usermodel.XSSFSheet;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;


public class ExcelData {
    private static FileInputStream excelFile;
    private static XSSFWorkbook excelWorkbook;
    private static XSSFSheet excelSheet;
    private static XSSFRow excelRow;
    private static XSSFCell excelCell;

    public static void openExcel(String path, String sheet){
        try {
            excelFile = new FileInputStream(path);
            excelWorkbook = new XSSFWorkbook(excelFile);
            excelSheet = excelWorkbook.getSheet(sheet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getCellData(int rowNum, int columnNum){
        excelCell = excelSheet.getRow(rowNum).getCell(columnNum);
        return excelCell.getStringCellValue();

    }
    public static String getNumCellData(int rowNum, int columnNum){
        excelCell = excelSheet.getRow(rowNum).getCell(columnNum);
        return String.valueOf(excelCell.getNumericCellValue());
    }
    public static void closeFile(){
        try {
            excelFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Object[]> getAllDataExcel(String path, String sheet){
        List<Object[]> lista = new ArrayList<>();
        openExcel(path, sheet);
        for (int i = 1; i <= excelSheet.getLastRowNum(); i++){
            String name = getCellData(i,0);
            String surname = getCellData(i,1);
            String address = getCellData(i,2);
            String amount = getNumCellData(i,3);
            String title = getCellData(i,4);
            Object ob[] = {name, surname, address, amount, title};
            lista.add(ob);
        }
        return lista;
    }

}
