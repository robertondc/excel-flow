package br.com.roberto.excelsql;

import static br.com.roberto.excelsql.model.Schema.FieldType.NUMBER;
import static br.com.roberto.excelsql.model.Schema.FieldType.TEXT;
import static br.com.roberto.excelsql.model.Schema.FieldType.TIMESTAMP;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.roberto.excelsql.model.Schema.FieldType;

public class SchemaDiscoverTest {

	@Test
	public void discoverColumnNames() {

		File excelFile = fileFromResource("all-columns-fulfilled.xlsx");

		SchemaDiscoverer schemaDiscoverer = new SchemaDiscoverer(excelFile);

		Map<Integer, String> expectedcolumnNames = new HashMap<Integer, String>();

		expectedcolumnNames.put(0, "Column A");
		expectedcolumnNames.put(1, "Column B");
		expectedcolumnNames.put(2, "Column C");
		expectedcolumnNames.put(3, "Column D");
		expectedcolumnNames.put(4, "Column E");
		expectedcolumnNames.put(5, "Column F");
		expectedcolumnNames.put(6, "Column G");
		expectedcolumnNames.put(7, "Column H");

		Map<Integer, String> headerNames = schemaDiscoverer.discoverHeaderNames();

		Assert.assertTrue(expectedcolumnNames.equals(headerNames));

	}

	@Test
	public void discoverColumnTypes() {

		File excelFile = fileFromResource("all-columns-fulfilled.xlsx");

		SchemaDiscoverer schemaDiscoverer = new SchemaDiscoverer(excelFile);

		Map<Integer, FieldType> expectedColumnTypes = new HashMap<Integer, FieldType>();

		expectedColumnTypes.put(0, NUMBER);
		expectedColumnTypes.put(1, TIMESTAMP);
		expectedColumnTypes.put(2, NUMBER);
		expectedColumnTypes.put(3, TEXT);
		expectedColumnTypes.put(4, NUMBER);
		expectedColumnTypes.put(5, NUMBER);
		expectedColumnTypes.put(6, TEXT);
		expectedColumnTypes.put(7, TIMESTAMP);
		
		Map<Integer, FieldType> columnTypes = schemaDiscoverer.discoverColumnTypes();

		Assert.assertTrue(expectedColumnTypes.equals(columnTypes));

	}

	private File fileFromResource(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}

}

