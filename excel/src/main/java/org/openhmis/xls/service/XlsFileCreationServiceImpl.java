package org.openhmis.xls.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openhmis.xls.service.XlsFileCreationService;
import org.openhmis.xls.service.XlsSheetPopulationService;
import org.openhmis.xls.exception.XlsFileNotWrittenException;
import org.openhmis.xls.service.helper.XlsSheetData;

public class XlsFileCreationServiceImpl implements XlsFileCreationService{

    private final static String FILE_SUFFIX = ".xls";

    private String fileName;
    private HSSFWorkbook workbook;
    private XlsSheetPopulationService xlsSheetPopulationService;

    public XlsFileCreationServiceImpl(String fileName) {
        this.fileName = fileName;
        this.xlsSheetPopulationService = new XlsSheetPopulationService();
    }

    public File createXlsFileWithMultipleSheets(List<XlsSheetData> sheetData) throws XlsFileNotWrittenException {
        workbook = new HSSFWorkbook();
        for (XlsSheetData singelSheetData : sheetData) {
            HSSFSheet sheet = createNewSheet(singelSheetData.getSheetName());
            xlsSheetPopulationService.writeSheet(sheet, singelSheetData);
        }
        return writeToFile();
    }

    public File createXlsFileWithSingleSheet(XlsSheetData sheetData) throws XlsFileNotWrittenException {
        List<XlsSheetData> sheetDataList = addSingleSheetToList(sheetData);
        return createXlsFileWithMultipleSheets(sheetDataList);
    }

    private List<XlsSheetData> addSingleSheetToList(XlsSheetData sheetData) {
        List<XlsSheetData> sheetDataList = new ArrayList<XlsSheetData>(1);
        sheetDataList.add(sheetData);
        return sheetDataList;
    }

    private File writeToFile() throws XlsFileNotWrittenException {
        File xlsFile = new File(fileName + FILE_SUFFIX);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(xlsFile);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            return xlsFile;
        } catch (FileNotFoundException e) {
            String exceptionMessage = "File with name <" + fileName + FILE_SUFFIX + "> not found";
            xlsFile.delete();
            throw new XlsFileNotWrittenException(exceptionMessage, e);
        } catch (IOException e) {
            String exceptionMessage =  "Error writing file <" + fileName + FILE_SUFFIX + ">";
            xlsFile.delete();
            throw new XlsFileNotWrittenException(exceptionMessage, e);
        }
    }

    private HSSFSheet createNewSheet(String sheetName) {
        return workbook.createSheet(sheetName);
    }

}
