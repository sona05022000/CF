package com.cf;

import java.util.HashMap;

class DateClass {

	private int date;

	private int month;

	private int year;

	public DateClass(int date, int month, int year) {

		this.date = date;

		this.month = month;

		this.year = year;

	}

	public int getDate() {

		return date;

	}

	public int getMonth() {

		return month;
	}

	public int getYear() {

		return year;

	}

}

public class Assignment3Q4 {

	public String getEmployee(HashMap<DateClass, String> dob, String employeeName) {

		int date = 0, month = 0, year = 0;

		for (DateClass date1 : dob.keySet()) {

			if (dob.get(date1).equals(employeeName)) {

				date = date1.getDate();

				month = date1.getMonth();

				year = date1.getYear();

			}

		}

		for (DateClass date1 : dob.keySet()) {

			int tempDate = date1.getDate();

			int tempMonth = date1.getMonth();

			int tempYear = date1.getYear();

			if (tempDate == date && tempMonth == month && tempYear != year && !(dob.get(date1).equals(employeeName))) {

				return "getEmployee method failed! As two employees are having same date and month";

			}
		}
		return "Employee: " + employeeName + " is returned successfully";
	}

	public static void main(String[] args) {

		DateClass date1 = new DateClass(05, 05, 2004);
		DateClass date2 = new DateClass(12, 03, 2002);
		DateClass date3 = new DateClass(05, 05, 2006);
		DateClass date4 = new DateClass(23, 04, 2005);
		HashMap<DateClass, String> dob = new HashMap<>();

		dob.put(date1, "venkata");

		dob.put(date2, "shiva");

		dob.put(date3, "aiyar");

		dob.put(date4, "naga");

		Assignment3Q4 obj = new Assignment3Q4();

		System.out.println(obj.getEmployee(dob, "venkata"));
		System.out.println(obj.getEmployee(dob, "aiyar"));
		System.out.println(obj.getEmployee(dob, "naga"));
		System.out.println(obj.getEmployee(dob, "shiva"));

	}

}