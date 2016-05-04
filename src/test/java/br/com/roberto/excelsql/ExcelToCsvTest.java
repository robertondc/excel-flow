package br.com.roberto.excelsql;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

public class ExcelToCsvTest{
	
	@Test
	public void allColumnsFulfilled() throws Exception {
				
		File excelFile = fileFromResource("all-columns-fulfilled.xlsx");
		
		ExcelToCsv excelToCsv = new ExcelToCsv(excelFile);
		
		File csvExpectedFile = fileFromResource("all-columns-fulfilled.csv");
		
		File csvFile = File.createTempFile("all-columns-fulfilled-test",".csv");
		
		excelToCsv.parse(csvFile);
		
		String csvExpectedString = FileUtils.readFileToString(csvExpectedFile, "UTF-8");
		String csvFileString = FileUtils.readFileToString(csvFile, "UTF-8");
		
		Assert.assertEquals(csvExpectedString, csvFileString);
		
	}
	
	private File fileFromResource(String fileName){
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}

}
