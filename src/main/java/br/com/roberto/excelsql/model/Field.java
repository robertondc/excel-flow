package br.com.roberto.excelsql.model;

public class Field<T> {

	private Integer index;

	private FieldType type;

	private T value;

	public enum FieldType {
		TIMESTAMP, NUMBER, TEXT;
	}

	public Field(Integer index, FieldType type, T value) {
		this.index = index;
		this.type = type;
		this.value = value;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public FieldType getType() {
		return type;
	}

	public void setType(FieldType type) {
		this.type = type;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Field [index=" + index + ", type=" + type + ", value=" + value + "]";
	}
	
	
}
