package org.testng.utilities;

import jxl.Sheet;
import jxl.Workbook;
import org.testng.propertymgr.PropertyManager;

import java.io.File;
import java.util.Properties;

/**
 * Purpose: Defines a helper class for reading data from excel sheet.
 * @author Firoj Shaik
 *
 */
public class ExcelRead {

    private final static Properties excelRelativePath = new PropertyManager()
            .loadPropertyFile("application.properties");
    private static String[][] storage;

    /**
     * Method to read test data from excel sheet.
     * @param sheetName
     * @return String Array 
     */
    public static String[][] readTestData(String sheetName) {

        try {
            File excelFile = new File(
                    excelRelativePath.getProperty("excelPath"));
            Workbook workbook = Workbook.getWorkbook(excelFile);
            Sheet sheet = workbook.getSheet(sheetName);
            int col = sheet.getColumns();
            int row = sheet.getRows();

            storage = new String[row - 1][col];

            for (int i = 1; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // getCell(int column, int row)
                    // Returns the cell specified at this row and at this
                    // column.
                    storage[i - 1][j] = sheet.getCell(j, i).getContents();
                    System.out.println(storage[i - 1][j]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return storage;
    }
}