package cn.h.beeclub.common.util.excel;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import cn.h.beeclub.common.util.excel.domain.ExcelHeader;

public class ExcelUtils {

	
	
	public static Workbook newWB(int rowAccessWindowSize) {
		Workbook wb = new SXSSFWorkbook(rowAccessWindowSize);
		return wb;
	}
	
	public static Workbook newWB() {
		Workbook wb = new SXSSFWorkbook();
		return wb;
	}
	
	public static Sheet newSheet(Workbook wb, String sheetName) {
		if(sheetName == null) {
			return wb.createSheet();
		}
		return wb.createSheet(sheetName);
	}
	
	private static void writeSimpleHeader(Sheet sheet, List<ExcelHeader> headers) {
		Row row = sheet.createRow(0);
		int column = 0;
		for(ExcelHeader header : headers) {
			Cell cell = row.createCell(column++, CellType.STRING);
			cell.setCellValue(header.getTitle());
		}
	}
	
	private static void writeSimpleListData(Sheet sheet, List<ExcelHeader> headers,List<Map<String,Object>> listData) {
		int rownum = 1;
		for(Map<String,Object> rowData : listData) {
			int column = 0;
			Row row = sheet.createRow(rownum++);
			for(ExcelHeader header : headers) {
				Cell cell = row.createCell(column);
				cell.setCellValue((String)rowData.get(header.getProperty()));
			}
		}
	}
	
	public static Workbook generateSimpleWB(String sheetName,List<ExcelHeader> headers, List<Map<String,Object>> listData) {
		Workbook wb = newWB();
		Sheet sheet = newSheet(wb, sheetName);
		writeSimpleHeader(sheet, headers);
		writeSimpleListData(sheet, headers, listData);
		return wb;
	}

}