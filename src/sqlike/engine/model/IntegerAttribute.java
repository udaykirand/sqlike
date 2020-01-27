package sqlike.engine.model;

public class IntegerAttribute extends Attribute<Integer> {

	private static final long serialVersionUID = 1L;
	
	public IntegerAttribute(String name) {
		super(name, Integer.class);
	}


	@Override
	public boolean validate(Object value) throws Exception {
		if(((Integer) value).intValue() < -1024 && ((Integer) value).intValue() > 1024) {
			throw new Exception();
		}
		return true;
	}

	
	
}
