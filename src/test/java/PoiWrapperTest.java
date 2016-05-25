import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class PoiWrapperTest {

	private File excelFile;

	@Before
	public void before(){
		excelFile = MyFileUtils.getResourceFile("excel-all-formats-test.xlsx");
	}
	
	@Test
	public void testGetSheet() {
		
		PoiWrapper poiWrapper = new PoiWrapper(excelFile);
		SheetWrapper firstSheet = poiWrapper.getSheetWrapper(0);
		assertEquals(firstSheet.getSheetName(), "Plan1");

	}

}
