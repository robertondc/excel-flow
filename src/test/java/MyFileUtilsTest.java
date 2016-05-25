import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class MyFileUtilsTest {

	@Test
	public void testGetResourseFile() {
		String expectedFileName = "excel-all-formats-test.xlsx";
		
		File resourceFile = MyFileUtils.getResourceFile(expectedFileName);
		
		assertEquals(expectedFileName, resourceFile.getName());
	}
	
}
