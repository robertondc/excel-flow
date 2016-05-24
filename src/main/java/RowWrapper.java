import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.roberto.excelsql.model.Field;
import br.com.roberto.excelsql.model.Field.FieldType;

public class RowWrapper {

	private Row poiRow;

	public RowWrapper(Row poiRow) {
		this.poiRow = poiRow;
	}

	public List<Field<?>> getFields() {

		List<Field<?>> fields = new ArrayList<Field<?>>();

		for (int columnIndex = 0; columnIndex < poiRow.getLastCellNum(); columnIndex++) {
			Cell cell = poiRow.getCell(columnIndex);
			if (cell != null) {
				FieldType fieldType = parseExcelCellType(cell);
				if (fieldType.equals(FieldType.NUMBER)) {
					fields.add(parseExcelDouble(cell));
				} else if (fieldType.equals(FieldType.TIMESTAMP)) {
					fields.add(parseExcelDate(cell));
				} else {
					fields.add(parseExcelText(cell));
				}
			}
		}

		return fields;
	}

	private Field<String> parseExcelText(Cell cell) {
		return new Field<String>(cell.getColumnIndex(), FieldType.TEXT, cell.getStringCellValue());
	}

	private Field<Date> parseExcelDate(Cell cell) {
		return new Field<Date>(cell.getColumnIndex(), FieldType.TIMESTAMP, cell.getDateCellValue());
	}

	private Field<Double> parseExcelDouble(Cell cell) {
		return new Field<Double>(cell.getColumnIndex(), FieldType.NUMBER, cell.getNumericCellValue());
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

	public Integer getIndex() {
		return poiRow.getRowNum();
	}

}
