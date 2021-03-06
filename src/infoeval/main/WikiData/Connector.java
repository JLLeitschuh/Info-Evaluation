package infoeval.main.WikiData;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import infoeval.main.mysql.Row;

/**
 * @author Netanel
 * @author osherh
 * @author Moshiko - moving to Row class , to make it WORK.
 * @since 19-04-2017 [[SuppressWarningsSpartan]]
 */
public class Connector {
	private final DataSource datasource;

	public Connector() throws SQLException, ClassNotFoundException, IOException {
		try {
			datasource = new DataSource();
			initializeConnectionPool();
		} catch (Exception e) {
			throw e;
		}
	}

	public void initializeConnectionPool() throws IOException {
		PoolProperties p = new PoolProperties();
		p.setUrl("jdbc:mysql://104.168.147.218/infoeval");
		p.setUsername("ieftw");
		p.setPassword("Ie!xuJR");
		p.setDriverClassName("com.mysql.jdbc.Driver");
		// validating the Connection from the pool before returning them to the
		// caller
		p.setTestOnBorrow(true);
		// validating the Connection before borrowing it from the pool
		p.setValidationQuery("SELECT 1");
		// number of ms to wait before throwing an exception if no connection is
		// available
		p.setMaxWait(10000);
		datasource.setPoolProperties(p);
	}

	public Connection getConnection() throws SQLException, IOException, ClassNotFoundException /* ,NamingException */ {
		return datasource.getConnection();
	}

	public int runUpdate(final String query) throws SQLException, ClassNotFoundException, IOException {
		Connection conn = getConnection();
		Statement st = conn.createStatement();
		int res = st.executeUpdate(query);
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();
		return res;
	}

	public ArrayList<Row> runQuery(final String query) throws SQLException, ClassNotFoundException, IOException {
		ResultSet rs;
		Connection conn = getConnection();
		Statement st = conn.createStatement();
		rs = st.executeQuery(query);
		ArrayList<Row> table = new ArrayList<Row>();

		if (rs != null) {
			Row.formTable(rs, table);
			rs.close();
		}
		if (st != null)
			st.close();
		if (conn != null)
			conn.close();
		return table;
	}

	public ArrayList<Row> runQuery(final String query, final Object[] inputs)
			throws SQLException, ClassNotFoundException, IOException {
		Connection conn = getConnection();
		ArrayList<Row> table = new ArrayList<Row>();
		PreparedStatement ps = conn.prepareStatement(query);
		for (int ¢ = 1; ¢ <= inputs.length; ++¢)
			ps.setObject(¢, inputs[¢ - 1]);
		ResultSet rs = ps.executeQuery();

		// Creating an arraylist of table entries:

		if (rs != null) {
			Row.formTable(rs, table);
			rs.close();
		}

		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();

		return table;
	}

	public int runUpdate(final String query, final Object[] inputs)
			throws SQLException, ClassNotFoundException, IOException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		for (int ¢ = 1; ¢ <= inputs.length; ++¢)
			ps.setObject(¢, inputs[¢ - 1]);
		int res = ps.executeUpdate();
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
		return res;
	}

	public void clearBasicInfoTable() throws SQLException, ClassNotFoundException, IOException {
		runUpdate("DELETE FROM basic_info");
	}

	public void clearWikiIdTable() throws SQLException, ClassNotFoundException, IOException {
		runUpdate("DELETE FROM WikiID");
	}

	// close all connections stored in the pool, associated with this datasource
	public void close() throws SQLException {
		if (datasource != null)
			datasource.close();
	}
}