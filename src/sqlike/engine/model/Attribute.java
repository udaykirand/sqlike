package sqlike.engine.model;

public abstract class Attribute<T> extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Class<T> type;
	
	public Attribute(String name, Class<T> type) {
		this.name = name;
		this.type = type;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract boolean validate(Object value) throws Exception;

}
