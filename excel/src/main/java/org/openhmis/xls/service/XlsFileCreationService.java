package org.openhmis.xls.service;

import java.io.File;
import java.util.List;

import org.openhmis.xls.exception.XlsFileNotWrittenException;
import org.openhmis.xls.service.helper.XlsSheetData;

public interface XlsFileCreationService {

    File createXlsFileWithSingleSheet(XlsSheetData sheetData) throws XlsFileNotWrittenException;
    File createXlsFileWithMultipleSheets(List<XlsSheetData> sheetData) throws XlsFileNotWrittenException;

}