package sqlike.engine.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sqlike.engine.exception.TableNameExists;
import sqlike.engine.factories.TableFactory;
import sqlike.engine.model.Attribute;
import sqlike.engine.model.Table;

public class TableService {
	
	private Map<String, Table> tables = new HashMap<>();
	
	public Table createTable(String name, List<Attribute<?>> attributes) throws TableNameExists {
		Table table = tables.get(name);
		if(table != null) {
			throw new TableNameExists(name);
		}
		
		table = TableFactory.createTable(name, attributes, null);
		tables.put(name, table);
		return table;
	}
	
	public boolean deleteTable(String name) throws Exception {
		Table table = tables.get(name);
		if(table == null) {
			throw new Exception("Table doesn't exist");
		}
		
		tables.remove(name);
		table.invalidateRows();
		return true;
	}
	
	public Table getTable(String name) {
		return tables.get(name);
	}
	
}
