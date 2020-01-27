package sqlike.engine.model;

public interface Constraint {
	
	public void setAttribute(Attribute<?> attribute);
	
	public boolean execute();

}
