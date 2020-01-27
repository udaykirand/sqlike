package rp.sqlike.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import sqlike.engine.exception.TableNameExists;
import sqlike.engine.model.Attribute;
import sqlike.engine.model.IntegerAttribute;
import sqlike.engine.model.Row;
import sqlike.engine.model.StringAttribute;
import sqlike.engine.model.Table;
import sqlike.engine.service.TableService;

public class FinalTest {
	
	private TableService tableService;
	final String tableName = "TEST_TABLE";
	
	@Before
	public void setup() throws TableNameExists {
		tableService = new TableService();
		createTestTable(tableName);
	}
	
	@Test
	public void createTableTest() throws TableNameExists {
		List<Attribute<?>> attributes = new ArrayList<>();
		attributes.add(new IntegerAttribute("INT_COL"));
		attributes.add(new StringAttribute("STRING_COL"));

		Table table = tableService.createTable("TEST_CREATE_TABLE", attributes);
		assertEquals(table.getName(), "TEST_CREATE_TABLE");

	}
	
	@Test
	public void addRowTest() {
		Table table = tableService.getTable(tableName);
		Map<Attribute<?>, Object> attributes = new HashMap<>();
		attributes.put(new IntegerAttribute("INT_COL"), 100);
		attributes.put(new StringAttribute("STRING_COL"), "ABC");
		Row row = new Row(attributes);
		table.addRow(row);
	}
	
	@Test(expected = RuntimeException.class)
	public void addRowTestFail() {
		Table table = tableService.getTable(tableName);
		Map<Attribute<?>, Object> attributes = new HashMap<>();
		attributes.put(new IntegerAttribute("INT_COL"), 100);
		attributes.put(new StringAttribute("STRING_COL"), "ABCAAC");
		Row row = new Row(attributes);
		table.addRow(row);
	}
	
	private void createTestTable(String name) throws TableNameExists {
		List<Attribute<?>> attributes = new ArrayList<>();
		attributes.add(new IntegerAttribute("INT_COL"));
		attributes.add(new StringAttribute("STRING_COL"));
		tableService.createTable(name, attributes);
	}
	
	public void testGetRow() {
		
	}

}
