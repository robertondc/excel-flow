package br.com.roberto.excelsql;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import br.com.roberto.excelsql.model.Schema.FieldType;

public class SchemaDiscoverer {

	private static Logger logger = Logger.getLogger(SchemaDiscoverer.class.getName());

	private File excelFile;

	public SchemaDiscoverer(File excelFile) {
		this.excelFile = excelFile;
	}

	public Map<Integer, String> discoverHeaderNames() {

		Sheet firstSheet = getExcelSheet(0);

		Map<Integer, String> headerNames = new HashMap<Integer, String>();

		Row row = firstSheet.getRow(0);
		for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {
			Cell cell = row.getCell(columnIndex);
			if (cell != null) {
				String cellContent = cell.toString();
				headerNames.put(columnIndex, cellContent);
			}
		}

		logger.log(Level.INFO, "Header names discovered: " + headerNames);

		return headerNames;

	}

	private Sheet getExcelSheet(Integer sheetIndex) {
		InputStream excelInput = null;
		try {
			excelInput = new FileInputStream(excelFile);
			Workbook workBook = WorkbookFactory.create(excelInput);
			Sheet sheet = workBook.getSheetAt(sheetIndex);
			return sheet;
		} catch (Exception ex) {
			logger.log(Level.SEVERE, null, ex);
			throw new RuntimeException(ex);
		} finally {
			try {
				excelInput.close();
			} catch (Exception ex) {
				logger.log(Level.SEVERE, null, ex);
				throw new RuntimeException(ex);
			}
		}
	}

	public Map<Integer, FieldType> discoverColumnTypes() {

		Sheet firstSheet = getExcelSheet(0);

		Map<Integer, FieldType> columnTypes = new HashMap<Integer, FieldType>();

		Row row = firstSheet.getRow(1);
		for (int columnIndex = 0; columnIndex < row.getLastCellNum(); columnIndex++) {
			Cell cell = row.getCell(columnIndex);
			if (cell != null) {
				columnTypes.put(columnIndex, parseExcelCellType(cell));
			}
		}

		logger.log(Level.INFO, "Column types discovered: " + columnTypes);

		return columnTypes;

	}

	private FieldType parseExcelCellType(Cell cell) {
		FieldType fieldType = null;
		if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				fieldType = FieldType.TIMESTAMP;
			} else {
				fieldType = FieldType.NUMBER;
			}
			
		} else {
			fieldType = FieldType.TEXT;
		}
		return fieldType;
	}

}
