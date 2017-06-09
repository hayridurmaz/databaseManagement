import java.sql.*;

public class DBConnector {
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@//Hayri-Durmaz:1521/XE";

	static final String USER = "HAYRI";
	static final String PASS = "database";
	Connection conn;

	public DBConnector() {
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected.");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

	}

	public static boolean isNumeric(String str) {
		try {
			int i = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean Insert(String... args) {

		try {
			Statement stmt = null;
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO " + args[0] + " VALUES (";
			for (int i = 1; i < args.length - 1; i++) {
				if (isNumeric(args[i])) {
					sql = sql + args[i] + ", ";
				} else
					sql = sql + "'" + args[i] + "', ";
			}
			if (isNumeric(args[args.length - 1])) {
				sql += args[args.length - 1] + ")";
			} else
				sql += "'" + args[args.length - 1] + "')";
			System.out.println("Executed query:");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			stmt.close();
			rs.close();
			System.out.println("Excecuted succesfully.");
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Couldnt executed succesfully.");
			return false;
		}

	}

	public boolean Update(String... args) {
		try {
			Statement stmt = null;
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "UPDATE " + args[0] + " SET ";
			int i;
			for (i = 1; i < args.length; i += 2) {
				if (args[i].equals("where")) {
					sql = sql.substring(0, sql.lastIndexOf(","));
					sql += " WHERE ";
					break;
				}
				if (isNumeric(args[i + 1])) {
					sql = sql + " " + args[i] + " = " + args[i + 1] + ", ";
				} else
					sql = sql + " " + args[i] + "= '" + args[i + 1] + "', ";
			}
			for (int j = i + 1; j < args.length - 1; j += 2) {
				if (isNumeric(args[j + 1])) {
					sql += " " + args[j] + " = " + args[j + 1];
				} else
					sql += " " + args[j] + " = '" + args[j + 1] + "'";
			}

			System.out.println("Executed query:");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			stmt.close();
			rs.close();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	public boolean Delete(String... args) {
		try {
			Statement stmt = null;
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "DELETE FROM " + args[0] + " WHERE";
			for (int i = 1; i < args.length; i += 2) {
				if (isNumeric(args[i + 1])) {
					sql += " " + args[i] + " = " + args[i + 1];
				} else
					sql += " " + args[i] + "= '" + args[i + 1] + "' ";
				if (i != args.length - 2) {
					sql += ",";
				}

			}
			System.out.println("Executed query:");
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			stmt.close();
			rs.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean List(String... args) {

		try {
			Statement stmt = null;
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM " + args[0];
			ResultSet rs = stmt.executeQuery(sql);
			if (args[0].equalsIgnoreCase("AIRPORT")) {
				while (rs.next()) { // Retrieve by column name
					String Name = rs.getString("AIRPORT_NAME");
					String CITY = rs.getString("CITY");

					// Display values System.out.print("ID: " + id);
					System.out.print("Airport Name: " + Name);
					System.out.println(", City: " + CITY);
				}
			} else if (args[0].equalsIgnoreCase("BOOKING")) {
				while (rs.next()) { // Retrieve by column name
					int bid = rs.getInt("BID");
					int fNumber = rs.getInt("FNUMBER");
					int pid = rs.getInt("PID");
					int tid = rs.getInt("TID");

					// Display values
					System.out.print("Booking ID: " + bid);
					System.out.print(", Flight Number: " + fNumber);
					System.out.print(", Plane ID: " + pid);
					System.out.println(", Ticket ID: " + tid);
				}
			} else if (args[0].equalsIgnoreCase("COMPANY")) {
				while (rs.next()) { // Retrieve by column name
					String name = rs.getString("NAME");
					int officeNo = rs.getInt("OFFICE_NO");
					String oPhone = rs.getString("OFFICE_PHONE");

					// Display values
					System.out.print("Company Name: " + name);
					System.out.print(", Office No: " + officeNo);
					System.out.println(", Office Phone: " + oPhone);
				}
			} else if (args[0].equalsIgnoreCase("CREW")) {
				while (rs.next()) { // Retrieve by column name
					int id = rs.getInt("CREW_ID");
					String name = rs.getString("CREW_NAME");
					String surname = rs.getString("SURNAME");
					int salary = rs.getInt("SALARY");

					// Display values
					System.out.print("Crew ID: " + id);
					System.out.print(", Name: " + name);
					System.out.print(", Surname: " + surname);
					System.out.println(", Salary: " + salary);
				}
			} else if (args[0].equalsIgnoreCase("FLIGHT")) {
				while (rs.next()) { // Retrieve by column name
					int id = rs.getInt("FLIGHT_NO");
					String depName = rs.getString("DEP_AIRPORT_NAME");
					String destName = rs.getString("DEST_AIRPORT_NAME");
					String planeName = rs.getString("PLANE_NAME");

					// Display values
					System.out.print("Flight No: " + id);
					System.out.print(", Deperature: " + depName);
					System.out.print(", Destination: " + destName);
					System.out.println(", Plane Name: " + planeName);
				}
			} else if (args[0].equalsIgnoreCase("PASSENGERS")) {
				while (rs.next()) { // Retrieve by column name
					int id = rs.getInt("PASSENGER_ID");
					String name = rs.getString("PASSENGER_NAME");
					String date = rs.getString("BIRTH_DATE");
					String sex = rs.getString("SEX");

					// Display values
					System.out.print("Passenger ID: " + id);
					System.out.print(", Name: " + name);
					System.out.print(", Birth Date: " + date);
					System.out.println(", Sex: " + sex);
				}
			} else if (args[0].equalsIgnoreCase("PLANES")) {
				while (rs.next()) { // Retrieve by column name
					String name = rs.getString("PLANE_NAME");
					String code = rs.getString("CODE");
					String type = rs.getString("TYPE");
					String company = rs.getString("COMP_NAME");

					// Display values
					System.out.print("Name: " + name);
					System.out.print(", Code: " + code);
					System.out.print(", Type: " + type);
					System.out.println(", Company: " + company);
				}
			} else if (args[0].equalsIgnoreCase("TICKET")) {
				while (rs.next()) { // Retrieve by column name
					int id = rs.getInt("TICKET_ID");
					String price = rs.getString("PRICE");
					String Class = rs.getString("CLASS");
					String seat = rs.getString("SEAT_NO");

					// Display values
					System.out.print("Ticket ID: " + id);
					System.out.print(", Price: " + price);
					System.out.print(", Class: " + Class);
					System.out.println(", Seat No: " + seat);
				}
			} else if (args[0].equalsIgnoreCase("WORKS")) {
				while (rs.next()) { // Retrieve by column name
					int cid = rs.getInt("CREW_ID");
					String fno = rs.getString("FLIGHT_NO");

					// Display values
					System.out.print("Crew ID: " + cid);
					System.out.println(", Flight No: " + fno);
				}
			} else {
				System.err.println("Wrong table name");
			}
			stmt.close();
			rs.close();
			return true;
		} catch (SQLException e) {
			System.err.println("Wrong table name");
			e.printStackTrace();
			return false;
		}

	}
	//
	// public static void main(String[] args) {
	// Connection conn = null;
	// Statement stmt = null;
	// try {
	// // STEP 2: Register JDBC driver
	// Class.forName(JDBC_DRIVER);
	//
	// // STEP 3: Open a connection
	// System.out.println("Connecting to database...");
	// conn = DriverManager.getConnection(DB_URL, USER, PASS);
	//
	// // STEP 4: Execute a query
	// System.out.println("Creating statement...");
	// stmt = conn.createStatement();
	// String sql;
	// sql = "SELECT * FROM FLIGHT";
	// ResultSet rs = stmt.executeQuery(sql);
	//
	// // STEP 5: Extract data from result set
	//
	// while (rs.next()) { // Retrieve by column name int id =
	// rs.getInt("FLIGHT_NO");
	// String depName = rs.getString("DEP_AIRPORT_NAME");
	// String destName = rs.getString("DEST_AIRPORT_NAME");
	// String planeName = rs.getString("PLANE_NAME");
	//
	// // Display values System.out.print("ID: " + id);
	// System.out.print(", Deperature: " + depName);
	// System.out.print(", Destination: " + destName);
	// System.out.println(", Plane Name: " + planeName);
	// }
	//
	// // STEP 6: Clean-up environment
	// rs.close();
	// stmt.close();
	// conn.close();
	// } catch (SQLException se) {
	// // Handle errors for JDBC
	// se.printStackTrace();
	// } catch (Exception e) {
	// // Handle errors for Class.forName
	// e.printStackTrace();
	// } finally {
	// // finally block used to close resources
	// try {
	// if (stmt != null)
	// stmt.close();
	// } catch (SQLException se2) {
	// } // nothing we can do
	// try {
	// if (conn != null)
	// conn.close();
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } // end finally try
	// } // end try
	// System.out.println("Goodbye!");
	// }// end main

}
