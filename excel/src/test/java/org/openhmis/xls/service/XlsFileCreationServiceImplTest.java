package org.openhmis.xls.service;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openhmis.xls.service.helper.XlsSheetData;

public class XlsFileCreationServiceImplTest {

    private static final String FILE_NAME = "testXLS";
    private static final String DEFAULT_SHEET_NAME_1 = "defaultSheetName1";
    private static final String DEFAULT_SHEET_NAME_2 = "defaultSheetName2";

    private XlsFileCreationService xlsFileCreationServiceSingle;
    private XlsFileCreationService xlsFileCreationServiceMultiple;
    private XlsSheetData sheetData1;
    private XlsSheetData sheetData2;
    private File testFileSingleSheet;
    private File testFileMultipleSheet;

    @Before
    public void setUp() throws Exception {
        xlsFileCreationServiceSingle = new XlsFileCreationServiceImpl(FILE_NAME + "1");
        xlsFileCreationServiceMultiple = new XlsFileCreationServiceImpl(FILE_NAME + "2");
        sheetData1 = new XlsSheetData(DEFAULT_SHEET_NAME_1);
        sheetData2 = new XlsSheetData(DEFAULT_SHEET_NAME_2);
    }

    @Test
    public void shouldWriteFileForSingleSheet() throws Exception {
        testFileSingleSheet = xlsFileCreationServiceSingle.createXlsFileWithSingleSheet(sheetData1);
        assertTrue(testFileSingleSheet.exists());
        testFileSingleSheet.delete();
    }

    @Test
    public void shouldWriteFileForMultilpeSheet() throws Exception {
        List<XlsSheetData> sheetData = new ArrayList<XlsSheetData>(2);
        sheetData.add(sheetData1);
        sheetData.add(sheetData2);
        testFileMultipleSheet = xlsFileCreationServiceMultiple.createXlsFileWithMultipleSheets(sheetData);
        assertTrue(testFileMultipleSheet.exists());
        testFileMultipleSheet.delete();
    }

}
