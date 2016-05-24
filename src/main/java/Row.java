import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.roberto.excelsql.model.Field;

public class Row<T> {
	
	private List<T> itens = new ArrayList<T>();
	private Integer index;

	public Row(Integer index, List<T> fields) {
		this.index = index;
		this.itens.addAll(fields);
	}
	
	public Row(Integer index) {
		this.index = index;
	}
	
	public void addItem(T item){
		this.itens.add(item);
	}
	
	public List<T> getItems(){
		return Collections.unmodifiableList(itens);
	}
	
	public Integer getIndex(){
		return index;
	}

	@Override
	public String toString() {
		return "Row [itens=" + itens + ", index=" + index + "]";
	}
	
}
