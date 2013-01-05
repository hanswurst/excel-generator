package org.openhmis.xls.service.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.openhmis.xls.service.helper.XlsRowData;

public class XlsRowDataTest {

    private XlsRowData rowData;
    private XlsRowData rowDataConstructorInit;
    private String rowData00;
    private String rowData01;

    @Before
    public void setUp() {
        rowData00 = "row00";
        rowData01 = "row01";
        rowData = new XlsRowData();
        rowDataConstructorInit = new XlsRowData(Arrays.asList(rowData00, rowData01));
    }

    @Test
    public void rowDataConstructorInitShouldContainTwoEntries() throws Exception {
        assertEquals(rowDataConstructorInit.size(), 2);
    }

    @Test
    public void rowDataShouldContainTwoEntries() throws Exception {
        rowData.addData(rowData00);
        rowData.addData(rowData01);
        assertEquals(rowData.size(), 2);
    }
}
