package org.openhmis.xls.service;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openhmis.xls.service.helper.XlsRowData;
import org.openhmis.xls.service.helper.XlsSheetData;

public class XlsSheetPopulationService {

    private static final int ROW_INDEX_START = 0;

    public HSSFSheet writeSheet(HSSFSheet sheet, XlsSheetData sheetData) {
        writeRows(sheet, sheetData);
        return sheet;
    }

    private void writeRows(HSSFSheet sheet, XlsSheetData sheetData) {
        int rowIndex = ROW_INDEX_START;
        for (XlsRowData dataRow : sheetData.getAllData()) {
            writeRow(sheet, dataRow, rowIndex);
            rowIndex++;
        }
    }

    private void writeRow(HSSFSheet sheet, XlsRowData rowData, int rowIndex) {
        HSSFRow row = sheet.createRow(rowIndex);
        int cellIndex = 0;
        for (String rowEntry : rowData.getAllData()) {
            HSSFCell cell = row.createCell(cellIndex);
            cell.setCellValue(rowEntry);
            cellIndex++;
        }
    }
}
