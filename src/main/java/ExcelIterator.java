import java.io.File;
import java.util.Iterator;

public class ExcelIterator implements Iterable<RowWrapper> {

	private File excelFile;
	private Integer sheetIndex;

	public ExcelIterator(File excelFile, Integer sheetIndex) {
		this.excelFile = excelFile;
		this.sheetIndex = sheetIndex;
	}

	@Override
	public Iterator<RowWrapper> iterator() {
		Iterator<RowWrapper> iterator = new Iterator<RowWrapper>() {

			SheetWrapper sheetWrapper = new PoiWrapper(excelFile).sheetWrapper(sheetIndex);
			Integer rowsCount = sheetWrapper.rowsCount();

			private int currentIndex = 0;

			@Override
			public boolean hasNext() { 
				return currentIndex < (rowsCount-1);
			}

			@Override
			public RowWrapper next() {
				RowWrapper rowWrapper = sheetWrapper.getRow(currentIndex);
				currentIndex = currentIndex + 1;
				return rowWrapper;
			}

		};

		return iterator;
	}

}
