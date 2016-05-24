import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PoiWrapper {

	private File excelFile;

	public PoiWrapper(File excelFile) {
		this.excelFile = excelFile;
	}

	public SheetWrapper sheetWrapper(Integer sheetIndex) {
		Sheet poiSheet = getPoiSheet(sheetIndex);
		return new SheetWrapper(poiSheet);
	}

	private Sheet getPoiSheet(Integer sheetIndex) {
		InputStream excelInput = null;
		try {
			excelInput = new FileInputStream(excelFile);
			Workbook workBook = WorkbookFactory.create(excelInput);
			Sheet sheet = workBook.getSheetAt(sheetIndex);
			return sheet;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			try {
				excelInput.close();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
	}

}
