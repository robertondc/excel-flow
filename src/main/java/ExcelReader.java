import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
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

		Iterator<RowWrapper> iterator = new ExcelIterator(excelFile, sheetIndex).iterator();

		while (iterator.hasNext()) {
			//acabar com o iterator
			//utilizar o sheet wrapper para pegar o nomero de linhas
			//faezr um for para o rowrapper
			//fazer teste dos wrappers
			
			RowWrapper rowWrapper = iterator.next();
			if (rowWrapper != null) {
				List<Field<?>> fields = rowWrapper.getFields();
				if (fields.size() > 0) {
					rows.add(new Row<Field<?>>(rowWrapper.getIndex(), fields));
				}
			}
		}

		return rows;
	}

}
