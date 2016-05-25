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

	public RowWrapper getRow(int rowIndex) {
		Row poiRow = poiSheet.getRow(rowIndex);
		return poiRow == null ? null : new RowWrapper(poiRow);
	}
	
	public String getSheetName(){
		return poiSheet.getSheetName();
	}

}
