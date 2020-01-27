package sqlike.engine.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Table extends BaseModel {
	
	private static final long serialVersionUID = 1L;

	List<Attribute<?>> attributes = new ArrayList<>(); 
	
	Set<Constraint> constraints = new HashSet<>();
	
	List<Row> rows = new ArrayList<>();
	
	public void addConstraint(Constraint constraint) {
		constraints.add(constraint);
	}
	
	public Set<Constraint> getConstraints() {
		return constraints;
	}
	
	public List<Attribute<?>> getAttributes() {
		return attributes;
	}
	
	public void addAttribute(Attribute<?> attribute) {
		attributes.add(attribute);
	}
	
	public boolean addRow(Row row) {
		return rows.add(row);
	}
	
	public List<Row> getRows() {
		return rows;
	}
	
	public void invalidateRows() {
		rows = null;
	}
	
	
}
