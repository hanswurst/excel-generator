package org.openhmis.xls.service.helper;

import java.util.ArrayList;
import java.util.List;

public class XlsRowData {

    private List<String> rowData;

    public XlsRowData() {
        rowData = new ArrayList<String>();
    }

    public XlsRowData(List<String> rowEntries) {
        rowData = new ArrayList<String>();
        rowData.addAll(rowEntries);
    }

    public List<String> getAllData() {
        return rowData;
    }

    public void addData(String data) {
        rowData.add(data);
    }

    public int size() {
        return getAllData().size();
    }
}
