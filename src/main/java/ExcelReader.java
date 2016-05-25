import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.roberto.excelsql.model.Field;

public class ExcelReader implements Reader {

	private File excelFile;
	private Integer sheetIndex;

	public ExcelReader(File excelFile, Integer sheetIndex) {
		this.excelFile = excelFile;
		this.sheetIndex = sheetIndex;
	}

	@Override
	public List<Row<Field<?>>> allRows() {

		List<Row<Field<?>>> rows = new ArrayList<Row<Field<?>>>();

		SheetWrapper sheetWrapper = new PoiWrapper(excelFile).getSheetWrapper(sheetIndex);
		Integer rowsCount = sheetWrapper.rowsCount();
		for (int rowIndex = 0; rowIndex < rowsCount; rowIndex++) {
			RowWrapper rowWrapper = sheetWrapper.getRow(rowIndex);
			if (rowWrapper != null) {
				rows.add(new Row<Field<?>>(rowWrapper.getIndex(), rowWrapper.getFields()));
			}
		}

		return rows;
	}

}
