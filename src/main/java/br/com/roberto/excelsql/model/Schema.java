package br.com.roberto.excelsql.model;

import java.util.Map;

public class Schema {

	private Map<Integer, FieldType> columnTypes;
	private Map<Integer, String> columnNames;

	public enum FieldType {
		TIMESTAMP, NUMBER, TEXT;
	}

	public Map<Integer, FieldType> getColumnTypes() {
		return columnTypes;
	}

	public void setColumnTypes(Map<Integer, FieldType> columnTypes) {
		this.columnTypes = columnTypes;
	}

	public Map<Integer, String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(Map<Integer, String> columnNames) {
		this.columnNames = columnNames;
	}

}
