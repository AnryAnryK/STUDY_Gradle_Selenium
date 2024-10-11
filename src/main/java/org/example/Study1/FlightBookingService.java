package org.example.Study1;

public class FlightBookingService {

	private int bookingsCount;


	public void bookingFlight(int id, Customer customer)
	{
		bookingsCount++;
		System.out.println("Количество созданных броней: ("+id+ ") "+customer.getFullName());
	}
	public void cancelBooking(int id)
	{
		if (bookingsCount ==0){
			System.out.println("Броней нет. Не делать ничего. ");
		} else {
		bookingsCount--;
        System.out.println("Бронь отменена: ("+id+ ")");
		}
	}

	public void TotalBookingCount()
	{
		System.out.println("Актуальное общее количество броней : (" + bookingsCount+ ")");
}
}

