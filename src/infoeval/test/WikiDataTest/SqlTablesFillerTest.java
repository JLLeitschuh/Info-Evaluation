package infoeval.test.WikiDataTest;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map.Entry;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import infoeval.main.WikiData.Connector;
import infoeval.main.WikiData.SqlTablesFiller;
import infoeval.main.mysql.Row;

/**
 * @authors osherh , Moshe
 * @since 20-05-2017
 */

public class SqlTablesFillerTest {
	private final int ENTRIES_NUM = 10000;
	static SqlTablesFiller filler;

	@BeforeClass

	public static void init() throws IOException, ClassNotFoundException, SQLException, ParseException {
		filler = new SqlTablesFiller();
		// filler.createTables();
		// filler.fillBasicInfoTable();
		// filler.fillWikiIdTable();
		// filler.close();
	}

	@AfterClass

	public static void close() throws ClassNotFoundException, IOException, SQLException {
		filler.close();
	}

	@Ignore
	@Test
	@SuppressWarnings("rawtypes")
	public void basicInfoTableSizeTest() throws Exception {
		Row row = new Connector().runQuery("SELECT COUNT(*) FROM basic_info").get(0);
		Entry<Object, Class> col = row.row.get(0);
		assertEquals(ENTRIES_NUM - 1, (long) col.getValue().cast(col.getKey()));
	}

	@SuppressWarnings("rawtypes")
	@Ignore
	@Test
	public void wikiIdTableSizeTest() throws Exception {
		Row row = new Connector().runQuery("SELECT COUNT(*) FROM WikiID").get(0);
		Entry<Object, Class> col = row.row.get(0);
		assertEquals(ENTRIES_NUM, (long) col.getValue().cast(col.getKey()));
	}

	@Ignore
	@Test
	public void IndexTest() throws Exception {
		// filler.dropIndex();
		filler.addIndexBasicInfo();
		filler.addIndexWikiID();

	}

}
