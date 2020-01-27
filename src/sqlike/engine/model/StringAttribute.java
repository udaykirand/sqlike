package sqlike.engine.model;

public class StringAttribute extends Attribute<String> {

	public StringAttribute(String name) {
		super(name, String.class);
	}

	private static final long serialVersionUID = 1L;
	
	private Class<String> type = String.class;

	public Class<String> getType() {
		return type;
	}

	@Override
	public boolean validate(Object value) throws Exception {
		if(value.toString().length() > 20) {
			throw new Exception();
		}
		return value.toString().length() <= 20;
	}
	
}
