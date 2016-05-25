import java.io.File;
import java.util.List;

import br.com.roberto.excelsql.model.Field;

public class Main {
	
	public static void main(String[] args) {
		
		File file = MyFileUtils.getResourceFile("excel-all-formats-test.xlsx");
		
		List<Row<Field<?>>> rows = new ExcelReader(file, 0).allRows();
		
		System.out.println(rows);
				
//		Schema schema = new SchemaDiscoverer(inputSource).discover();
//			
//		SqlFactory sqlFactory = new SqlFactory(schema);
//		
//		String createTable = sqlFactory.getCreateTableSql();
//		
//		SqlEngine sqlEngine = new SqlEngine("mysqlurl");
//		
//		sqlEngine.startConnection();
//		
//		sqlEngine.createTable(createTableSql);
//		
//		SqlBatch sqlBatch = new SqlBatch(sqlEngine, schema);
//		
//		sqlBatch.insertRowsFrom(inputSource);
//		
//		sqlEngine.endConnection();
		
	}
	
}
