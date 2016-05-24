package br.com.roberto.excelsql.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Schema {

	List<Field> fields = new ArrayList<Field>();    
	
	public void addField(Field field){
		fields.add(field);
	}
	
	public List<Field> getFields(){
		return Collections.unmodifiableList(fields);
	}
	
}
