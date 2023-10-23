package com.example.common;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataProvider {
    private String excelFilePath;
    private Sheet sheet;

    public ExcelDataProvider(String excelFilePath) throws IOException {
        this.excelFilePath = excelFilePath;
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = WorkbookFactory.create(inputStream);
        sheet = workbook.getSheetAt(0);
        inputStream.close();
    }

    public String getCellValue(int row, int column) {
        Row r = sheet.getRow(row);
        Cell cell = r.getCell(column);
        return cell.toString();
    }
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }
}