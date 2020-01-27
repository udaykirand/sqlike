package sqlike.engine.model;

import java.util.HashMap;
import java.util.Map;

public class Row extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	private Map<Attribute<?>, Object> rowData = new HashMap<>();
	
	public Row(Map<Attribute<?>, Object> rowData) {
		rowData.forEach((k, v) -> {
			try {
				k.validate(v);
			} catch (Exception e) {
				throw new RuntimeException();
			}
		});
		rowData.putAll(rowData);
	}
	
	
	public void addRow(Map<Attribute<?>, Object> attributes) {
		attributes.forEach((k, v) -> {
			try {
				k.validate(v);
			} catch (Exception e) {
				throw new RuntimeException();
			}
		});
		rowData.putAll(attributes);
	}
	
	public Map<Attribute<?>, Object> getAllRows() {
		return rowData;
	}
	
}
