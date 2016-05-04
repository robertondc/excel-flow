package br.com.roberto.excelsql;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelToCsv {
	
	private File excelFile;
	
	private static Logger logger = Logger.getLogger(ExcelToCsv.class.getName());
	
	public ExcelToCsv(File excelFile) {
		this.excelFile = excelFile;
	}
	
	private void writeAsCSV(Sheet sheet, String csvPath) throws Exception {
		PrintWriter writer = new PrintWriter(csvPath, "UTF-8");
		Row row = null;
		Integer headerColumnsSize = null;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			StringBuilder rowCSVBuilder = new StringBuilder("");
			for (int j = 0; j < row.getLastCellNum(); j++) {
				String cellValue = null;
				if (row.getCell(j) == null) {
					cellValue = "null";
				} else {
					cellValue = row.getCell(j).toString().trim();
				}
				if (cellValue.equals("") || cellValue.equalsIgnoreCase("#N/A")) {
					cellValue = "null";
				}
				rowCSVBuilder.append(cellValue + (j == (row.getLastCellNum() - 1) ? "" : ","));
			}
			String rowString = rowCSVBuilder.toString();

			boolean onlyNullColumns = true;

			for (String column : rowString.split(",")) {
				if (column != null) {
					String cleanColumn = column.trim();
					if (!cleanColumn.equalsIgnoreCase("") && !cleanColumn.equalsIgnoreCase("null")) {
						onlyNullColumns = false;
						break;
					}
				}
			}

			if (onlyNullColumns) {
				continue;
			}

			int currentRowColumnSize = rowString.split(",").length;
			if (headerColumnsSize == null) {
				headerColumnsSize = currentRowColumnSize;
			}
			if (currentRowColumnSize < headerColumnsSize) {
				int missingColsSize = headerColumnsSize - currentRowColumnSize;
				for (int missingColIndex = 0; missingColIndex < missingColsSize; missingColIndex++) {
					rowCSVBuilder.append(",null");
				}
			}
			logger.log(Level.INFO, "Appending line in CSV: " + rowCSVBuilder);
			writer.println(rowCSVBuilder);
		}
		writer.close();
	}


	public void parse(File csvFile) {
		InputStream excelInput = null;
		try {
			excelInput = new FileInputStream(excelFile);
			Workbook wb = WorkbookFactory.create(excelInput);
			Sheet firstSheet = wb.getSheetAt(0);
			writeAsCSV(firstSheet, csvFile.getAbsolutePath());
		} catch (Exception ex) {
			logger.log(Level.SEVERE, null, ex);
		} finally {
			try {
				excelInput.close();
			} catch (Exception ex) {
				logger.log(Level.SEVERE, null, ex);
			}
		}
	}
	
}
