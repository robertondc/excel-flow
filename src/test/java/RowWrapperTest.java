import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.roberto.excelsql.model.Field;
import br.com.roberto.excelsql.model.Field.FieldType;

public class RowWrapperTest {

	File excelFile;
	
	@Before
	public void before(){
		excelFile = MyFileUtils.getResourceFile("excel-all-formats-test.xlsx");
	}
	
	@Test
	public void testGetIndex() {
		PoiWrapper poiWrapper = new PoiWrapper(excelFile);
		
		SheetWrapper firstSheet = poiWrapper.getSheetWrapper(0);
		
		RowWrapper firstRow = firstSheet.getRow(0);
		
		assertTrue(firstRow.getIndex() == 0);
	}
	
	@Test
	public void testFieldsTypes() {

		PoiWrapper poiWrapper = new PoiWrapper(excelFile);
		
		SheetWrapper firstSheet = poiWrapper.getSheetWrapper(0);
		
		RowWrapper secondRow = firstSheet.getRow(2); //header row (0) skiped because all values has the same type
		
		List<Field<?>> columns = secondRow.getFields();
		
		assertEquals(FieldType.NUMBER, columns.get(0).getType()); //column a
		assertEquals(FieldType.TIMESTAMP, columns.get(1).getType()); //column b
		assertEquals(FieldType.NUMBER, columns.get(2).getType()); //column c
		assertEquals(FieldType.TEXT, columns.get(3).getType()); //column d
		assertEquals(FieldType.NUMBER, columns.get(4).getType()); //column e
		assertEquals(FieldType.NUMBER, columns.get(5).getType()); //column f
		assertEquals(FieldType.TEXT, columns.get(6).getType()); //column g
		assertEquals(FieldType.TIMESTAMP, columns.get(7).getType()); //column h
		assertEquals(FieldType.TEXT, columns.get(8).getType()); //column i
	}
	
	@Test
	public void testFieldsTypesValues() {

		PoiWrapper poiWrapper = new PoiWrapper(excelFile);
		
		SheetWrapper firstSheet = poiWrapper.getSheetWrapper(0);

		RowWrapper secondRow = firstSheet.getRow(7);
		
		List<Field<?>> columns = secondRow.getFields();
		
		assertEquals(7.0, columns.get(0).getValue()); //column a
		assertEquals(MyDateUtils.parseDate("05/10/2016", "MM/dd/yyyy"), columns.get(1).getValue()); //column b
		assertEquals(10000000.0, columns.get(2).getValue()); //column c
		assertEquals("Pinha do brejo, Magnólia", columns.get(3).getValue()); //column d
		assertEquals(100000000.0, columns.get(4).getValue()); //column e
		assertEquals(100000.0, columns.get(5).getValue()); //column f
		assertEquals("Carambola", columns.get(6).getValue()); //column g
		assertEquals(MyDateUtils.parseDate("05/10/2016 16:16:16", "MM/dd/yyyy HH:mm:ss"), columns.get(7).getValue()); //column h
		assertEquals("", columns.get(8).getValue()); //column i
	}
	
	@Test
	public void testFieldsIndex() {

		PoiWrapper poiWrapper = new PoiWrapper(excelFile);
		
		SheetWrapper firstSheet = poiWrapper.getSheetWrapper(0);
		
		RowWrapper secondRow = firstSheet.getRow(0);
		
		List<Field<?>> columns = secondRow.getFields();
		
		assertTrue(0 == columns.get(0).getIndex()); //column a
		assertTrue(1 == columns.get(1).getIndex()); //column b
		assertTrue(2 == columns.get(2).getIndex()); //column c
		assertTrue(3 == columns.get(3).getIndex()); //column d
		assertTrue(4 == columns.get(4).getIndex()); //column e
		assertTrue(5 == columns.get(5).getIndex()); //column f
		assertTrue(6 == columns.get(6).getIndex()); //column g
		assertTrue(7 == columns.get(7).getIndex()); //column h
		assertTrue(8 == columns.get(8).getIndex()); //column i
	}

}
