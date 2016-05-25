import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class ExcelReaderTest {

	File excelFile;
	
	@Before
	public void before(){
		excelFile = MyFileUtils.getResourceFile("excel-all-formats-test.xlsx");
	}
	
	@Test
	public void testDontSkipEmptyLines() {
		
		PoiWrapper poiWrapper = new PoiWrapper(excelFile);
		
		SheetWrapper firstSheet = poiWrapper.getSheetWrapper(0);
		
		RowWrapper headerRow = firstSheet.getRow(0);
		assertEquals("Column A", headerRow.getFields().get(0).getValue());
		
		RowWrapper emptyRow = firstSheet.getRow(5);
		assertEquals("", emptyRow.getFields().get(0).getValue());
		
		RowWrapper lastRow = firstSheet.getRow(8);
		assertEquals(7.0, lastRow.getFields().get(0).getValue());
		
	}

	
}
