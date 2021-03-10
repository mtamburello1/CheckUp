package model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import model.Bean.BookingVisitBean;
import model.Bean.DoctorBean;
import model.Bean.PatientBean;
import model.Dao.BookingDAO;

/**
 * This class implements the BookingDAO interface, using the DataBase as persistence manager.
 * @author Tamburello Martina
 * @see BookingDAO
 */
public class DbBookingDAO implements BookingDAO{

	/** Query for new booking. */
	private static final String InsertBookingSQL = "INSERT INTO bookingVisit (booking_code, doctor, patient, booking_day, booking_hour, booking_type, carried_out) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
	/** Query for query to fetch a booking. */
	private static final String ReturnBookingByKeySQL = "SELECT * FROM ((bookingVisit JOIN (user as userDoctor) ON doctor=userDoctor.fiscal_code) JOIN user AS userPatient on patient=userPatient.fiscal_code) WHERE booking_code = ?";
	/** Query for delete booking. */
	private static final String DeleteBookingSQL = "DELETE FROM bookingVisit WHERE booking_code = ?";
	/** Query for view booking's list. */
	private static final String SelectBookingsForPatientSQL = "SELECT booking_code, user_name, surname, fiscal_code, booking_day, booking_hour, booking_type, carried_out  FROM (bookingVisit JOIN user ON doctor=fiscal_code) WHERE patient = ? ORDER BY booking_day";


	/**
	 * Insert a new booking.
	 * @param booking : booking to insert.
	 * @return true if it entered the booking, false otherwise.
	 */
	@Override
	public boolean insertBooking(BookingVisitBean booking) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		if(booking != null) {
			try {
				con = DbConnection.getConnection(); 
				preparedStatement = con.prepareStatement(InsertBookingSQL, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, booking.getBooking_code());
				preparedStatement.setString(2, booking.getDoctor().getFiscal_code());
				preparedStatement.setString(3, booking.getPatient().getFiscal_code());
				preparedStatement.setObject(4, booking.getBooking_day());
				preparedStatement.setTime(5, booking.getBooking_hour());
				preparedStatement.setString(6, booking.getBooking_type());
				preparedStatement.setBoolean(7, booking.isCarried_out());
				preparedStatement.execute();
				result = preparedStatement.getGeneratedKeys();
				con.close();
				if (result != null) {
					return true;
				} else {
					return false;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return false;
	}


	/**
	 * Returns the booking with the specified code.
	 * @param booking_code : code of the booking to search.
	 * @return BookingVisitBean if it founds booking, null if doesn't exists.
	 */
	@Override
	public BookingVisitBean returnBookingByKey(String booking_code) {

		BookingVisitBean booking;
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		if(booking_code != null) {
			try {
				con = DbConnection.getConnection(); 
				preparedStatement = con.prepareStatement(ReturnBookingByKeySQL);
				preparedStatement.setString(1, booking_code);
				result = preparedStatement.executeQuery();


				if (result.first()) {
					DoctorBean doctor = new DoctorBean(result.getString("userDoctor.fiscal_code"), result.getString("userDoctor.user_name"), result.getString("userDoctor.surname"), result.getString("userDoctor.email"), result.getString("userDoctor.specialization"));
					PatientBean patient = new PatientBean(result.getString("userPatient.fiscal_code"), result.getString("userPatient.user_name"), result.getString("userPatient.surname"), result.getDate("userPatient.birth_date"), result.getString("userPatient.birth_place"), result.getString("userPatient.residence"), result.getInt("userPatient.phone_number"), result.getString("userPatient.email"));
					booking = new BookingVisitBean(result.getString("booking_code"), patient, doctor, result.getDate("booking_day"), result.getTime("booking_hour"), result.getString("booking_type"), result.getBoolean("carried_out"));
					con.close();
					return booking;
				}
			} 

			catch (SQLException e) {

				e.printStackTrace();

			} 
		}
		return null;
	}

	/**
	 * Cancels the booking with the specified code.
	 * @param booking_code : code of the booking to delete.
	 * @return BookingVisitBean if it cancels booking, false otherwise.
	 */
	@Override
	public boolean deleteBooking(String booking_code) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		if(booking_code != null) {
			try {
				con = DbConnection.getConnection(); 
				preparedStatement = con.prepareStatement(DeleteBookingSQL);
				preparedStatement.setString(1,booking_code);
				preparedStatement.execute();
				con.close();

				return true;	

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Returns the booking list for the specified patient.
	 * @param patient : the patient for whom to search for the bookings made.
	 * @return a list of bookings or null if the patient has not made bookings.
	 */
	@Override
	public ArrayList<BookingVisitBean> getBookingList(PatientBean patient) {
		ArrayList<BookingVisitBean> bookings = new ArrayList<BookingVisitBean>();
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		if(patient != null) {
			try {
				con = DbConnection.getConnection();       
				preparedStatement = con.prepareStatement(SelectBookingsForPatientSQL);
				preparedStatement.setString(1, patient.getFiscal_code());
				preparedStatement.execute();
				result = preparedStatement.getResultSet();

				while (result.next()) {
					DoctorBean doctor = new DoctorBean();
					doctor.setUser_name(result.getString(2));
					doctor.setSurname(result.getString(3));
					doctor.setFiscal_code(result.getString(4));
					BookingVisitBean booking = new BookingVisitBean(result.getString(1), patient, doctor, result.getDate(5), result.getTime(6), result.getString(7), result.getBoolean(8));
					bookings.add(booking);
				}  
				con.close();
				return bookings;
			} 

			catch (SQLException e) {
				e.getMessage();        
			} 
		}

		return null;
	}


}
