package org.example;

import jdk.jfr.FlightRecorder;
import org.example.Study1.Customer;
import org.example.Study1.FlightBookingService;

import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args) {

	Customer customer1 = new Customer("Анри ", "Анриевич");
	Customer customer2 = new Customer("Петро ", "Петрович");

	FlightBookingService flightBookingService = new FlightBookingService();
	flightBookingService.bookingFlight(1, customer1);
	flightBookingService.bookingFlight(2, customer2);
	flightBookingService.cancelBooking(2);
	flightBookingService.TotalBookingCount();

//    Массивы

//    int[] array = new int  []  {1, 2, 3};
//    for (int i = 0; i<=array.length; i++) {    // если так написать - i<=array.length - и так вывести - System.out.println(array[i]);, то будет ошибка !!  (= нельзя здесь писать !)
//        System.out.println(array[i]);
//    }
//    int[] array2 = new int  []  {1, 2, 3};
//    for (int i2 = 0; i2<array2.length; i2++) {
//        System.out.println(array[i2]);
//    }

    // Коллекции
    // List<String> string = new ArrayList<>();
}
}
