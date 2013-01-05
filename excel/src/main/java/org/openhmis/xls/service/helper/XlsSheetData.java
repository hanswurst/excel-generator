package org.openhmis.xls.service.helper;

import java.util.ArrayList;
import java.util.List;

public class XlsSheetData {

    private List<XlsRowData> sheetData;
    private String sheetName;

    public XlsSheetData(String sheetName) {
        this.sheetName = sheetName;
        sheetData = new ArrayList<XlsRowData>();
    }

    public XlsSheetData(String sheetName, List<XlsRowData> rowData) {
        this.sheetName = sheetName;
        sheetData = new ArrayList<XlsRowData>();
        sheetData.addAll(rowData);
    }

    public List<XlsRowData> getAllData() {
        return sheetData;
    }

    public void addData(XlsRowData rowData) {
        sheetData.add(rowData);
    }

    public int size() {
        return getAllData().size();
    }

    public String getSheetName() {
        return sheetName;
    }
}
