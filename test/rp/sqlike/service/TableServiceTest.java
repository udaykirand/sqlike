package rp.sqlike.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sqlike.engine.exception.TableNameExists;
import sqlike.engine.model.Attribute;
import sqlike.engine.model.IntegerAttribute;
import sqlike.engine.model.StringAttribute;
import sqlike.engine.model.Table;
import sqlike.engine.service.TableService;

public class TableServiceTest {

	TableService tableService;

	@Before
	public void setup() {
		tableService = new TableService();
	}

	@Test
	public void createTableTest() throws TableNameExists {
		List<Attribute<?>> attributes = new ArrayList<>();
		attributes.add(new IntegerAttribute("INT_COL"));
		attributes.add(new StringAttribute("STRING_COL"));

		Table table = tableService.createTable("TEST_TABLE", attributes);
		assertEquals(table.getName(), "TEST_TABLE");

	}

	@Test
	public void deleteTableTest() throws Exception {
		String tableName = "DELETE_TABLE_TEST";
		createTestTable(tableName);
		tableService.deleteTable(tableName);
		assertNull(tableService.getTable("TEST_TABLE"));
	}
	
	private void createTestTable(String name) throws TableNameExists {
		List<Attribute<?>> attributes = new ArrayList<>();
		attributes.add(new IntegerAttribute("INT_COL"));
		attributes.add(new StringAttribute("STRING_COL"));
		tableService.createTable(name, attributes);
	}

}
