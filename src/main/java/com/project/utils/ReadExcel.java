package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	static Workbook workbook = null;

	/**
	 * opens a workbook to read data
	 * 
	 * @param path
	 * @throws Exception
	 */
	public void getWorkbook(String path) throws Exception {

		File file = new File(path);

		String extn = getExtension(path);

		InputStream is = new FileInputStream(file);

		if (extn.equalsIgnoreCase("xls")) {

			workbook = new HSSFWorkbook(is);

		} else if (extn.equalsIgnoreCase("xlsx")) {

			workbook = new XSSFWorkbook(is);
		}

//		workbook = WorkbookFactory.create(file);
	}

	/**
	 * 
	 * @param path -
	 * @return
	 */
	private String getExtension(String path) {

		if (path.contains(".")) {
			String extn = path.substring(path.indexOf(".") + 1);
			System.out.println(extn);
			return extn;
		}

		return null;
	}

	/**
	 * 
	 * @param sheet
	 * @param rowNumber
	 * @return
	 * @throws Exception
	 */
	public String[][] getRow(Sheet sheet, int rowNumber) throws Exception {

		String[][] data = new String[6][8];

//		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNumber);

		int columnCount = row.getLastCellNum();

		for (int i = 0; i < columnCount; i++) {
			Cell cell = row.getCell(i);
			String cellValue = null;
			if (cell == null) {
				System.out.println("null");
				break;
			} else if (cell.getCellType() == CellType.NUMERIC) {
				cellValue = String.valueOf(cell.getNumericCellValue());
				System.out.print(cellValue + " : ");
			} else if (cell.getCellType() == CellType.BLANK) {
				System.out.println(" cell is blank");
				break;
			} else if (cell.getCellType() == CellType.BOOLEAN) {
				cellValue = String.valueOf(cell.getBooleanCellValue());
				System.out.print(cellValue + " : ");
			} else {
				cellValue = cell.getStringCellValue();
				System.out.print(cellValue + " : ");
			}
			data[0][i] = cellValue;
		}

		return data;
	}

	public List<Map<String, String>> getAllDataIntoMapList(String path, String sheetName) throws Exception {

		List<Map<String, String>> allData = new ArrayList<Map<String, String>>();

		Map<Integer, String> headerMap = new HashMap<Integer, String>();

		getWorkbook(path);
		Sheet sheet = workbook.getSheet(sheetName);

		getHeaderMap(headerMap, sheet);
		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {

			Row row = sheet.getRow(i);
			int columnCount = row.getLastCellNum();
			Map<String, String> data = new HashMap<String, String>();
			for (int j = 0; j < columnCount; j++) {
				Cell cell = row.getCell(j);
				String cellValue = getCellValue(cell);

				data.put(headerMap.get(j), cellValue);
			}
			allData.add(data);
		}

		return allData;
	}

	/**
	 * 
	 * @param headerMap
	 * @param sheet
	 */
	private void getHeaderMap(Map<Integer, String> headerMap, Sheet sheet) {

		Row row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		for (int j = 0; j < columnCount; j++) {
			Cell cell = row.getCell(j);
			String cellValue = getCellValue(cell);			
			headerMap.put(j, cellValue);
		}

	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	public String evaluateFormual(Cell cell) {

		FormulaEvaluator evalutor = workbook.getCreationHelper().createFormulaEvaluator();
		
		return getCellValue(cell);
	}

	private String getCellValue(Cell cell) {
		
		String cellValue = null;
		
		if (cell == null) {
			System.out.println("null");
			return null;
		} else if (cell.getCellType() == CellType.NUMERIC) {
			cellValue = String.valueOf(cell.getNumericCellValue());
			System.out.print(cellValue + " : ");
		} else if (cell.getCellType() == CellType.BLANK) {
			System.out.println(" cell is blank");
			return null;
		} else if (cell.getCellType() == CellType.BOOLEAN) {
			cellValue = String.valueOf(cell.getBooleanCellValue());
			System.out.print(cellValue + " : ");
		} else if (cell.getCellType() == CellType.FORMULA) {
			cellValue = evaluateFormual(cell);
			System.out.print(cellValue + " : ");
		} else {
			cellValue = cell.getStringCellValue();
			System.out.print(cellValue + " : ");
		}

		return cellValue;
	}
}
