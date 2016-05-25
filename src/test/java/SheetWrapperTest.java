import static org.junit.Assert.*;

import java.io.File;

import org.junit.*;

public class SheetWrapperTest {
	
	File excelFile;
	
	@Before
	public void before(){
		excelFile = MyFileUtils.getResourceFile("excel-all-formats-test.xlsx");
	}
	
	@Test
	public void testRowsCount() {
		PoiWrapper poiWrapper = new PoiWrapper(excelFile);
		
		SheetWrapper firstSheet = poiWrapper.getSheetWrapper(0);
		//Apache POI eventually consider empty rows in row count 
		assertTrue(firstSheet.rowsCount() >= 9);
	}
	
	@Test
	public void testSheetName(){
		PoiWrapper poiWrapper = new PoiWrapper(excelFile);
		
		SheetWrapper firstSheet = poiWrapper.getSheetWrapper(0);
	 
		assertEquals(firstSheet.getSheetName(), "Plan1");
	}
	
	
	@Test
	public void testGetRow(){
		PoiWrapper poiWrapper = new PoiWrapper(excelFile);
		
		SheetWrapper firstSheet = poiWrapper.getSheetWrapper(0);
		RowWrapper firstRow = firstSheet.getRow(0);
		
		assertTrue(firstRow.getIndex() == 0);
	}

}
