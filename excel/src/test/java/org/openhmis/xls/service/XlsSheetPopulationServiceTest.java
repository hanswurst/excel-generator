package org.openhmis.xls.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openhmis.xls.service.helper.XlsRowData;
import org.openhmis.xls.service.helper.XlsSheetData;

public class XlsSheetPopulationServiceTest {

    private static final String DEFAULT_SHEET_NAME = "defaultSheetName";

    private static final String HEAD_ENTRY_A = "headA";
    private static final String HEAD_ENTRY_B = "headB";
    private static final String HEAD_ENTRY_C = "headC";

    private static final String DATA_ROW1A = "dataRow1A";
    private static final String DATA_ROW1B = "dataRow1B";
    private static final String DATA_ROW1C = "dataRow1C";
    private static final String DATA_ROW2A = "dataRow2A";
    private static final String DATA_ROW2B = "dataRow2B";
    private static final String DATA_ROW2C = "dataRow2C";

    private XlsSheetPopulationService xlsSheetPopulationService;
    private HSSFSheet testSheet;
    private XlsSheetData sheetData;
    private HSSFWorkbook workbook;

    @Before
    public void setUp() {
        xlsSheetPopulationService = new XlsSheetPopulationService();
        workbook = new HSSFWorkbook();
        testSheet = workbook.createSheet();

        XlsRowData dataRow0 = new XlsRowData(Arrays.asList(HEAD_ENTRY_A, HEAD_ENTRY_B, HEAD_ENTRY_C));
        XlsRowData dataRow1 = new XlsRowData(Arrays.asList(DATA_ROW1A, DATA_ROW1B, DATA_ROW1C));
        XlsRowData dataRow2 = new XlsRowData(Arrays.asList(DATA_ROW2A, DATA_ROW2B, DATA_ROW2C));

        sheetData = new XlsSheetData(DEFAULT_SHEET_NAME, Arrays.asList(dataRow0, dataRow1, dataRow2));
    }

    @Test
    public void shouldCreateSheetWithHeaderRowAndDataRows() throws Exception {
        HSSFSheet sheet = xlsSheetPopulationService.writeSheet(testSheet, sheetData);
        assertEquals(sheet.getRow(0).getCell(0).getStringCellValue(), HEAD_ENTRY_A);
        assertEquals(sheet.getRow(0).getCell(1).getStringCellValue(), HEAD_ENTRY_B);
        assertEquals(sheet.getRow(0).getCell(2).getStringCellValue(), HEAD_ENTRY_C);
        assertEquals(sheet.getRow(1).getCell(0).getStringCellValue(), DATA_ROW1A);
        assertEquals(sheet.getRow(1).getCell(1).getStringCellValue(), DATA_ROW1B);
        assertEquals(sheet.getRow(1).getCell(2).getStringCellValue(), DATA_ROW1C);
        assertEquals(sheet.getRow(2).getCell(0).getStringCellValue(), DATA_ROW2A);
        assertEquals(sheet.getRow(2).getCell(1).getStringCellValue(), DATA_ROW2B);
        assertEquals(sheet.getRow(2).getCell(2).getStringCellValue(), DATA_ROW2C);
    }
}
