import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class ExcelValidationTest {
    final int CONTENT_FIRST_ROW_COUNT = 4;
    private Workbook workbook;

    @Before
    public void setUp() throws Exception {
        FileInputStream fis = new FileInputStream("src/test/resources/test.xlsx");
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void readTest() {
        Sheet firstSheet = workbook.getSheetAt(0);
        double firstCellValue = firstSheet.getRow(1).getCell(0).getNumericCellValue();
        assertEquals("Это текст первой ячейки", firstCellValue);
    }

    @Test
    public void isEmptyTest() {
        Sheet firstSheet = workbook.getSheetAt(0);
        assertTrue(hasContent(firstSheet));
        Sheet secondSheet = workbook.getSheetAt(1);
        assertFalse(hasContent(secondSheet));
    }

    private boolean hasContent(Sheet sheet) {
        for (Row row : sheet) {
            int rowInSheetCount = row.getRowNum() + 1;
            if (rowInSheetCount > CONTENT_FIRST_ROW_COUNT) {
                return true;
            }
        }
        return false;
    }

    @Test(expected = Exception.class)
    public void validateColumnCount() throws Exception {
        Sheet firstSheet = workbook.getSheetAt(0);
        int minColumnCount = 3;

        for (Row row : firstSheet) {
            int rowInSheetCount = row.getRowNum() + 1;
            if (rowInSheetCount > CONTENT_FIRST_ROW_COUNT) {
                int actualColumnCount = row.getLastCellNum();
                if (actualColumnCount < minColumnCount) {
                    String message = String.format("Not enough columns in '%d' row. Must be '%d'. Got '%d'.",
                            rowInSheetCount, minColumnCount, actualColumnCount);
                    System.out.println(message);
                    throw new Exception(message);
                }
            }
        }
    }
}
