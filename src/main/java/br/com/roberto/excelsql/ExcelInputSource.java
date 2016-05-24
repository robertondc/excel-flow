package br.com.roberto.excelsql;

import java.io.File;

public class ExcelInputSource implements InputSource{

	private File file;

	public ExcelInputSource(File file) {
		this.file = file;
	}

}
