package infoeval.test.mysqlTest;

import infoeval.main.mysql.SqlRunner;
import infoeval.main.mysql.Row;
import infoeval.main.mysql.TableEntry;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * 
 * @author Moshe
 * @author osherh
 * @Since 12-05-2017
 *
 */

/*
 * ATTENTION ! When you want to test this class , remove the @Ignore attributes.
 * I added it since the connector tries to read from the config.xml file which
 * won't be uploaded to GitHub and it causes travisCI to fail. like moshiko did
 * in the connectorTest it's relevant here too
 * 
 * @osherh
 */
public class SqlRunnerTest {
	static SqlRunner querun;

	/**
	 * [[SuppressWarningsSpartan]]
	 * 
	 * @throws Exception
	 */

	@BeforeClass
	public static void initRunner() throws Exception {
		querun = new SqlRunner();
	}

	@AfterClass
	public static void close() {
		querun.close();
	}

	@Ignore
	@Test
	public void TestClearSerializedQueries() throws Exception {
		querun.clearSerializedQueries();
	}

	@Ignore
	@Test
	public void getBornInPlaceBeforeYearTest() throws Exception {
		for (TableEntry te : querun.getBornInPlaceBeforeYear("Canada", "1970")) {
			java.sql.Date birthDate = te.getBirthDate();
			String birthPlace = te.getBirthPlace();
			SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
			String birthYear = formatYear.format(birthDate);
			int bYear = Integer.parseInt(birthYear);
			assert bYear < 1970;
			assert birthPlace.contains("Canada");
		}
	}

	@Ignore
	@Test
	public void getDifferentDeathPlaceTest() throws Exception {
		for (TableEntry ¢ : querun.getDifferentDeathPlace())
			assertNotEquals(¢.getBirthPlace(), ¢.getDeathPlace());
	}

	@Ignore
	@Test
	public void getSameOccupationCouplesTest() throws Exception {
		for (TableEntry ¢ : querun.getSameOccupationCouples())
			assertEquals(¢.getOccupation(), ¢.getSpouseOccupation());
	}

	@Ignore
	@Test
	public void getSameBirthPlaceCouplesTest() throws Exception {
		for (TableEntry te : querun.getSameBirthPlaceCouples()) {
			String sName = te.getSpouseName(),
					checkBirthPlaceQuery = "SELECT birthPlace FROM basic_info WHERE name=? LIMIT 1";
			Object[] inp = new Object[1];
			inp[0] = sName;
			ArrayList<Row> res = querun.runQuery(checkBirthPlaceQuery, inp);
			Row row = res.get(0);
			assertEquals(te.getBirthPlace(), (String) row.row.get(0).getValue().cast(row.row.get(0).getKey()));
		}
	}

	@Ignore
	@Test
	public void getOccupationBetweenYearsTest() throws Exception {
		for (TableEntry te : querun.getOccupationBetweenYears("1840", "1920", "Politician")) {
			assertEquals(te.getOccupation(), "Politician");
			java.sql.Date birthDate = te.getBirthDate();
			SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");
			String birthYear = formatYear.format(birthDate);
			int bYear = Integer.parseInt(birthYear);
			assert bYear >= 1840;
			java.sql.Date deathDate = te.getDeathDate();
			formatYear.format(deathDate);
			assert Integer.parseInt(birthYear) <= 1920;
		}
	}

	@Ignore
	@Test
	public void getSpouselessBetweenYearsTest() throws Exception {
		for (TableEntry ¢ : querun.getSpouselessBetweenYears("1900", "1980"))
			assertEquals(¢.getSpouseName(), "No Spouse Name");
	}
}
