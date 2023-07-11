package insurancePractice;



import org.NewaInsurance_GenrericUtilities.DatabaseUtilities;


public class InsertDataIntoDatabase {

	public static void main(String[] args) throws Throwable {
		DatabaseUtilities dlib= new DatabaseUtilities();
		try {
			
			dlib.connectDB();
			String Query = "Insert into project values('TS_PROJ_1659','visa','22/01/2020','Capgen','In Progress','4')";
			dlib.executeUpdate(Query);
		
		} finally {
		dlib.closeDB();
		}

	}

}
