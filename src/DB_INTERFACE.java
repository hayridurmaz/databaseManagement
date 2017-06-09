import java.util.*;

import oracle.net.aso.p;

public class DB_INTERFACE {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		DBConnector dbConnector = new DBConnector();
		int input, inputIn;

		while (true) {
			System.out.println("***Main Menu***");
			System.out.println("(1)Insert");
			System.out.println("(2)Update");
			System.out.println("(3)Delete");
			System.out.println("(4)List");
			System.out.println("(5)Exit");

			input = scan.nextInt();
			if (input == 1) {
				System.out.println("(1)Insert Company");
				System.out.println("(2)Insert Planes");
				System.out.println("(3)Insert Flight");
				System.out.println("(4)Insert Airport");
				System.out.println("(5)Insert Crew");
				System.out.println("(6)Insert Passengers");
				System.out.println("(7)Insert Ticket");
				System.out.println("(8)Insert Works");
				System.out.println("(9)Insert Booking");
				System.out.println("(10)Turn back");
				inputIn = scan.nextInt();
				if (inputIn == 1) {
					System.out.println("**New Company**");
					System.out.println("Name:");
					scan.nextLine();
					String name = scan.nextLine();
					System.out.println("Office_No:");
					String Office_No = scan.next();
					System.out.println("Office_Phone:");
					String Office_Phone = scan.next();
					dbConnector.Insert("COMPANY", name, Office_No, Office_Phone);
				}

				else if (inputIn == 2) {
					System.out.println("**New Plane**");
					System.out.println("Plane_Name:");
					scan.nextLine();
					String Plane_Name = scan.nextLine();
					System.out.println("Code:");
					String Code = scan.nextLine();
					System.out.println("Type:");
					String Type = scan.nextLine();
					System.out.println("Comp_Name:");
					String Comp_Name = scan.nextLine();
					dbConnector.Insert("PLANES", Plane_Name, Code, Type, Comp_Name);
				} else if (inputIn == 3) {
					System.out.println("**New Flight**");
					System.out.println("Flight_No:");
					String Flight_No = scan.next();
					System.out.println("Date(DD/MM/YYYY)");
					String Date = scan.next();
					System.out.println("Dep_Airport_Name:");
					scan.nextLine();
					String Dep_Airport_Name = scan.nextLine();
					System.out.println("Dest_Airport_Name:");
					String Dest_Airport_Name = scan.nextLine();
					System.out.println("Plane_Name:");
					String Plane_Name = scan.nextLine();
					dbConnector.Insert("FLIGHT", Flight_No, Date, Dep_Airport_Name, Dest_Airport_Name, Plane_Name);
				} else if (inputIn == 4) {
					System.out.println("**New Airport**");
					System.out.println("Airport_Name:");
					scan.nextLine();
					String Airport_Name = scan.nextLine();
					System.out.println("City:");
					String City = scan.nextLine();
					dbConnector.Insert("AIRPORT", Airport_Name, City);
				} else if (inputIn == 5) {
					System.out.println("**New Crew**");
					System.out.println("Crew_ID:");
					scan.nextLine();
					String Crew_ID = scan.nextLine();
					System.out.println("Crew_Name:");
					String Crew_Name = scan.nextLine();
					System.out.println("Crew_Surname:");
					String Crew_Surname = scan.nextLine();
					System.out.println("Salary: ");
					String salary = scan.nextLine();
					dbConnector.Insert("CREW", Crew_ID, Crew_Name, Crew_Surname, salary);

				} else if (inputIn == 6) {
					System.out.println("**New Passenger**");
					System.out.println("Passenger_Id:");
					String Passenger_Id = scan.next();
					System.out.println("Passenger_Name");
					scan.nextLine();
					String Passenger_Name = scan.nextLine();
					System.out.println("Birth_Date:(DD/MM/YYYY)");
					String Birth_Date = scan.next();
					System.out.println("Sex: (M/F)");
					scan.nextLine();
					String Sex = scan.nextLine();
					dbConnector.Insert("PASSENGERS", Passenger_Id, Passenger_Name, Birth_Date, Sex);
				} else if (inputIn == 7) {
					System.out.println("**New Ticket**");
					System.out.println("Ticket_Id:");
					String Ticket_Id = scan.next();
					System.out.println("Price");
					String Price = scan.next();
					System.out.println("Class:(business or economy)");
					String Class = scan.next();
					System.out.println("Seat_No:");
					String Seat_No = scan.next();
					dbConnector.Insert("TICKET", Ticket_Id, Price, Class, Seat_No);
				} else if (inputIn == 8) {
					System.out.println("**New Work**");
					System.out.println("Crew_Id:");
					String Crew_Id = scan.next();
					System.out.println("Flight_No");
					String Flight_No = scan.next();
					dbConnector.Insert("WORKS", Crew_Id, Flight_No);
				} else if (inputIn == 9) {
					System.out.println("**New Booking**");
					System.out.println("Booking ID:");
					String bid = scan.next();
					System.out.println("FNumber:");
					String FNumber = scan.next();
					System.out.println("PId");
					String PId = scan.next();
					System.out.println("TId:");
					String TId = scan.next();
					dbConnector.Insert("BOOKING", bid, FNumber, PId, TId);
				} else
					continue;
			}

			else if (input == 2) {
				System.out.println("(1)Update Company");
				System.out.println("(2)Update Planes");
				System.out.println("(3)Update Flight");
				System.out.println("(4)Update Airport");
				System.out.println("(5)Update Crew");
				System.out.println("(6)Update Passengers");
				System.out.println("(7)Update Ticket");
				System.out.println("(8)Update Works");
				System.out.println("(9)Update Booking");
				System.out.println("(10)Turn back");
				inputIn = scan.nextInt();
				if (inputIn == 1) {
					System.out.println("**Update Company**");
					System.out.println("Old Name:");
					scan.nextLine();
					String oname = scan.nextLine();
					System.out.println("New Name:");
					String nname = scan.next();
					System.out.println("Office_No:");
					String Office_No = scan.next();
					System.out.println("Office_Phone:");
					String Office_Phone = scan.next();
					dbConnector.Update("COMPANY", "NAME", nname, "OFFICE_NO", Office_No, "OFFICE_PHONE", Office_Phone,
							"where", "NAME", oname);
				} else if (inputIn == 2) {
					System.out.println("**Update Plane**");
					System.out.println("Old Plane Name:");
					String oldname = scan.next();
					System.out.println("New Plane_Name:");
					scan.nextLine();
					String Plane_Name = scan.nextLine();
					System.out.println("Code:");
					String Code = scan.next();
					System.out.println("Type:");
					String Type = scan.next();
					System.out.println("Comp_Name:");
					scan.nextLine();
					String Comp_Name = scan.nextLine();
					dbConnector.Update("PLANES", "Plane_Name", Plane_Name, "CODE", Code, "TYPE", Type, "COMP_NAME",
							Comp_Name, "where", "Plane_Name", oldname);

				} else if (inputIn == 3) {
					System.out.println("**Update Flight**");
					System.out.println("Flight_No:");
					String Flight_No = scan.next();
					System.out.println("Date");
					String Date = scan.next();
					System.out.println("Dep_Airport_Name:");
					scan.nextLine();
					String Dep_Airport_Name = scan.nextLine();
					System.out.println("Dest_Airport_Name:");
					String Dest_Airport_Name = scan.nextLine();
					System.out.println("Plane_Name:");
					String Plane_Name = scan.nextLine();
					dbConnector.Update("FLIGHT", "WHEN", Date, "DEP_AIRPORT_NAME", Dep_Airport_Name,
							"DEST_AIRPORT_NAME", Dest_Airport_Name, "PLANE_NAME", Plane_Name, "where", "FLIGHT_NO",
							Flight_No);

				} else if (inputIn == 4) {
					System.out.println("**Update Airport**");
					System.out.println("Old Airport Name:");
					scan.nextLine();
					String oName = scan.nextLine();
					System.out.println("New Airport_Name:");
					String Airport_Name = scan.nextLine();
					System.out.println("City:");
					String City = scan.nextLine();
					dbConnector.Update("AIRPORT", "AIRPORT_NAME", Airport_Name, "CITY", City, "where", "AIRPORT_NAME",
							oName);
				} else if (inputIn == 5) {
					System.out.println("**Update Crew**");
					System.out.println("Crew_ID:");
					scan.nextLine();
					String Crew_ID = scan.nextLine();
					System.out.println("Crew_Name:");
					String Crew_Name = scan.next();
					System.out.println("Crew Surname:");
					String surname = scan.next();
					System.out.println("Salary: ");
					String salary = scan.next();
					dbConnector.Update("CREW", "CREW_NAME", Crew_Name, "SURNAME", surname, "SALARY", salary, "where",
							"CREW_ID", Crew_ID);
				} else if (inputIn == 6) {
					System.out.println("**Update Passenger**");
					System.out.println("Passenger_Id:");
					String Passenger_Id = scan.next();
					System.out.println("Passenger_Name");
					scan.nextLine();
					String Passenger_Name = scan.nextLine();
					System.out.println("Birth_Date:");
					String Birth_Date = scan.next();
					System.out.println("Sex:");
					String Sex = scan.next();
					dbConnector.Update("PASSENGERS", "PASSENGER_NAME", Passenger_Name, "BIRTH_DATE", Birth_Date, "Sex",
							Sex, "where", "PASSENGER_ID", Passenger_Id);
				} else if (inputIn == 7) {
					System.out.println("**Update Ticket**");
					System.out.println("Ticket_Id:");
					String Ticket_Id = scan.next();
					System.out.println("Price");
					String Price = scan.next();
					System.out.println("Class:");
					String Class = scan.next();
					System.out.println("Seat_No:");
					String Seat_No = scan.next();
					dbConnector.Update("TICKET", "PRICE", Price, "CLASS", Class, "SEAT_NO", Seat_No, "where",
							"TICKET_ID", Ticket_Id);
				} else if (inputIn == 8) {
					System.out.println("**Update Work**");
					System.out.println("Old Crew_Id:");
					String oldCrew_Id = scan.next();
					System.out.println("Old Flight_No");
					String oldFlight_No = scan.next();
					System.out.println("New Crew_Id:");
					String newCrew_Id = scan.next();
					System.out.println("New Flight_No");
					String newFlight_No = scan.next();
					dbConnector.Update("WORKS", "CREW_ID", newCrew_Id, "FLIGHT_NO", newFlight_No, "where", "CREW_ID",
							oldCrew_Id, "FLIGHT_NO", oldFlight_No);

				} else if (inputIn == 9) {
					System.out.println("**Update Booking**");
					System.out.println("Booking ID:");
					String bid = scan.next();
					System.out.println("FNumber:");
					String FNumber = scan.next();
					System.out.println("PId");
					String PId = scan.next();
					System.out.println("TId:");
					String TId = scan.next();
					dbConnector.Update("BOOKING", "FNUMBER", FNumber, "PID", PId, "TID", TId, "where", "BID", bid);
				} else
					continue;
			} else if (input == 3) {
				System.out.println("(1)Delete Company");
				System.out.println("(2)Delete Planes");
				System.out.println("(3)Delete Flight");
				System.out.println("(4)Delete Airport");
				System.out.println("(5)Delete Crew");
				System.out.println("(6)Delete Passengers");
				System.out.println("(7)Delete Ticket");
				System.out.println("(8)Delete Works");
				System.out.println("(9)Delete Booking");
				System.out.println("(10)Turn back");
				inputIn = scan.nextInt();
				if (inputIn == 1) {
					System.out.println("**Delete Company**");
					System.out.println("Name:");
					scan.nextLine();
					String name = scan.nextLine();
					dbConnector.Delete("COMPANY", "NAME", name);
				} else if (inputIn == 2) {
					System.out.println("**Delete Plane**");
					System.out.println("Plane_Name:");
					scan.nextLine();
					String Plane_Name = scan.nextLine();
					dbConnector.Delete("PLANES", "PLANE_NAME", Plane_Name);

				} else if (inputIn == 3) {
					System.out.println("**Delete Flight**");
					System.out.println("Flight_No:");
					String Flight_No = scan.next();
					dbConnector.Delete("FLIGHT", "FLIGHT_NO", Flight_No);

				} else if (inputIn == 4) {
					System.out.println("**Delete Airport**");
					System.out.println("Airport_Name:");
					scan.nextLine();
					String Airport_Name = scan.nextLine();
					dbConnector.Delete("AIRPORT", "AIRPORT_NAME", Airport_Name);
				} else if (inputIn == 5) {
					System.out.println("**Delete Crew**");
					System.out.println("Crew_ID:");
					String Crew_ID = scan.next();
					dbConnector.Delete("CREW", "CREW_ID", Crew_ID);
				} else if (inputIn == 6) {
					System.out.println("**Delete Passenger**");
					System.out.println("Passenger_Id:");
					String Passenger_Id = scan.next();
					dbConnector.Delete("PASSENGERS", "PASSENGER_ID", Passenger_Id);
				} else if (inputIn == 7) {
					System.out.println("**Delete Ticket**");
					System.out.println("Ticket_Id:");
					String Ticket_Id = scan.next();
					dbConnector.Delete("TICKET", "TICKET_ID", Ticket_Id);
				} else if (inputIn == 8) {
					System.out.println("**Delete Work**");
					System.out.println("Crew_Id:");
					String Crew_Id = scan.next();
					System.out.println("Flight_No");
					String Flight_No = scan.next();
					dbConnector.Delete("WORKS", "CREW_ID", Crew_Id, "FLIGHT_NO", Flight_No);

				} else if (inputIn == 9) {
					System.out.println("**Delete Booking**");
					System.out.println("Booking ID:");
					String bid = scan.next();
					dbConnector.Delete("BOOKING", "BID", bid);
				} else
					continue;
			} else if (input == 4) {
				System.out.println("(1)List Company");
				System.out.println("(2)List Planes");
				System.out.println("(3)List Flight");
				System.out.println("(4)List Airport");
				System.out.println("(5)List Crew");
				System.out.println("(6)List Passengers");
				System.out.println("(7)List Ticket");
				System.out.println("(8)List Works");
				System.out.println("(9)List Booking");
				System.out.println("(10)Turn back");
				inputIn = scan.nextInt();
				if (inputIn == 1) {
					System.out.println("**Companies**");
					dbConnector.List("COMPANY");
				} else if (inputIn == 2) {
					System.out.println("**Planes**");
					dbConnector.List("PLANES");

				} else if (inputIn == 3) {
					System.out.println("**Flights**");
					dbConnector.List("FLIGHT");
				} else if (inputIn == 4) {
					System.out.println("**Airports**");
					dbConnector.List("AIRPORT");
				} else if (inputIn == 5) {
					System.out.println("**Crews**");
					dbConnector.List("CREW");
				} else if (inputIn == 6) {
					System.out.println("**Passengers**");
					dbConnector.List("PASSENGERS");
				} else if (inputIn == 7) {
					System.out.println("**Tickets**");
					dbConnector.List("TICKET");
				} else if (inputIn == 8) {
					System.out.println("**Works**");
					dbConnector.List("WORKS");
				} else if (inputIn == 9) {
					System.out.println("**Bookings**");
					dbConnector.List("BOOKING");
				} else
					continue;
			} else
				break;
		}
		System.out.println("Goodbye!");
	}

}
