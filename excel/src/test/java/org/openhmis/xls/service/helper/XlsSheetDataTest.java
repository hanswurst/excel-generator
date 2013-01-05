package org.openhmis.xls.service.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.openhmis.xls.service.helper.XlsRowData;
import org.openhmis.xls.service.helper.XlsSheetData;

public class XlsSheetDataTest {

    private static final String DEFAULT_SHEET_NAME = "defaultSheetName";

    private XlsSheetData sheetData;
    private XlsSheetData sheetDataConstructorInit;
    private XlsRowData xlsRowData0;
    private XlsRowData xlsRowData1;

    @Before
    public void setUp() {
        xlsRowData0 = new XlsRowData(Arrays.asList("row00", "row01"));
        xlsRowData1 = new XlsRowData(Arrays.asList("ro10", "row11"));
        sheetData = new XlsSheetData(DEFAULT_SHEET_NAME);
        sheetDataConstructorInit = new XlsSheetData(DEFAULT_SHEET_NAME, Arrays.asList(xlsRowData0, xlsRowData1));
    }

    @Test
    public void sheetDataConstructorInitShouldContainTwoEntriesAndHaveSheetName() throws Exception {
        assertEquals(sheetDataConstructorInit.size(), 2);
        assertEquals(DEFAULT_SHEET_NAME, sheetDataConstructorInit.getSheetName());
    }

    @Test
    public void sheetDataShouldContainTwoEntriesAndHaveSheetName() throws Exception {
        sheetData.addData(xlsRowData0);
        sheetData.addData(xlsRowData1);
        assertEquals(sheetData.size(), 2);
        assertEquals(DEFAULT_SHEET_NAME, sheetData.getSheetName());
    }
}
