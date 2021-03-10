/**
 * 
 */
package model.Dao;

import java.util.ArrayList;

import model.Bean.BookingVisitBean;
import model.Bean.PatientBean;

/**
 * This interface provides the operations that can be performed by a Data Access Object (DAO) that accesses objects of type Booking visit.
 * @see BookingVisitBean
 * @author Tamburello Martina
 *
 */
public interface BookingDAO {
	
	/**
	 * Inserts a new booking.
	 * @param booking : booking to insert.
	 * @return true if it entered the booking, false otherwise.
	 */
	public boolean insertBooking(BookingVisitBean booking);
	
	/**
	 * Returns the booking with the specified code.
	 * @param booking_code : code of the booking to search.
	 * @return BookingVisitBean if it founds booking, null if doesn't exists.
	 */
	public BookingVisitBean returnBookingByKey(String booking_code);
	
	/**
	 * Cancels the booking with the specified code.
	 * @param booking_code : code of the booking to delete.
	 * @return BookingVisitBean if it cancels booking, false otherwise.
	 */
	public boolean deleteBooking(String booking_code);

	/**
	 * Returns the booking list for the specified patient.
	 * @param patient : the patient for whom to search for the bookings made.
	 * @return a list of bookings or null if the patient has not made bookings.
	 */
	public ArrayList<BookingVisitBean> getBookingList(PatientBean patient); 
	
}
