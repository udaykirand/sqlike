package sqlike.engine.service;

import java.util.Map;

import sqlike.engine.model.Attribute;
import sqlike.engine.model.Row;
import sqlike.engine.model.Table;

public class InsertService {
	
	TableService tableService = new TableService();
	
	public boolean addRow(String tableName, Map<Attribute<?>, Object> attributes) {
		Table table = tableService.getTable(tableName);
		/*
		 * for(Constraint constraint : table.getConstraints()) { constraint.execute(); }
		 */
		
		Row row = new Row(attributes);
		table.addRow(row);
		
		return true;
	}

}
