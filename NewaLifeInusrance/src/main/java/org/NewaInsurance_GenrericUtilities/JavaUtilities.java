package org.NewaInsurance_GenrericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/***
 * In this class essential java utilities are present
 * @author prasanna
 *
 */
public class JavaUtilities {                                                                     
	Random random=new Random();
	Date Dobj = new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
	
	/**
	 * This method is used to get the random numbers within the limit of 4000 numbers
	 * @return
	 */
	public int getRandomNumber() {
		int randomint=random.nextInt(4000);
		return randomint;
	}
	
	/**
	 * this method is used to get the system date format into the [MM-dd-yyyy] format
	 * @return String
	 */
	
	 public String getDate() {
		String date=sdf.format(Dobj);
		 return date;
	 }
	 
	 /**
	  * This method is used to get the required date in the sepecific format of [MM-dd-yyyy]
	  * @param numdays
	  * @return 
	  */
	 public String getDate(int numdays) {
		 Calendar cal= Calendar.getInstance();
				 cal.add(Calendar.DATE, numdays);
				 Date date=cal.getTime();
				 String reqdate=sdf.format(date);
		return reqdate;
	 }
	 
	 /*
	  *  This method  is used to get the date in specified format
	  */
	 
	 public String getSystemdatainFormat() {
		 String date[]=Dobj.toString().split(" ");
		 String month=date[1];
		 String date1=date[2];
		 String time=date[3].replace(":","-");
		 String year=date[5];
		 String finaldate=date1+" "+month+" "+year+" "+time;
		 return finaldate;
	 }
	 


}
