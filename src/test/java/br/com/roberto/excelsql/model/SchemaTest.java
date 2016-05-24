package br.com.roberto.excelsql.model;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.roberto.excelsql.model.Field.FieldType;

public class SchemaTest {

	@Test
	public void testFieldsAsInsertionOrder() {
		
		Schema schema = new Schema();
		Field field1 = new Field(0, FieldType.TEXT, "nome_produto");
		Field field2 = new Field(1, FieldType.NUMBER, "preco_produto");
		Field field3 = new Field(2, FieldType.TIMESTAMP, "data_compra");
		
		schema.addField(field1);
		schema.addField(field2);
		schema.addField(field3);
		
		List<Field> expected = Arrays.asList(new Field[]{field1,field2,field3});
		
		assertEquals(schema.getFields(), expected);
		
		
	}

}
