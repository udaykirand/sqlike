package sqlike.engine.exception;

public class TableNameExists extends Exception {

	public TableNameExists(String name) {
		super("Table name exists: " + name);
	}

	private static final long serialVersionUID = 1L;

}
