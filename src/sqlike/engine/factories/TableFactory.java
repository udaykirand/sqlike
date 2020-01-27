package sqlike.engine.factories;

import java.util.List;
import java.util.UUID;

import sqlike.engine.model.Attribute;
import sqlike.engine.model.Constraint;
import sqlike.engine.model.Table;

public class TableFactory {

	public static Table createTable(String name, List<Attribute<?>> attributes, List<Constraint> constraints) {
		Table table = new Table();
		table.setId(UUID.randomUUID().toString());
		table.setName(name);
		table.getAttributes().addAll(attributes);
		if (constraints != null) {
			table.getConstraints().addAll(constraints);
		}
		return table;
	}

}
