import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class SheetWrapper {

	private Sheet poiSheet;

	public SheetWrapper(Sheet poiSheet) {
		this.poiSheet = poiSheet;
	}

	public Integer rowsCount() {
		return poiSheet.getLastRowNum();
	}

	public RowWrapper getRow(int currentIndex) {
		Row poiRow = poiSheet.getRow(currentIndex);
		return poiRow == null ? null : new RowWrapper(poiRow);
	}

}
