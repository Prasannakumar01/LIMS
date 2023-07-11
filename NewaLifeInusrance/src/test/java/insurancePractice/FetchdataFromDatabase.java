package insurancePractice;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.NewaInsurance_GenrericUtilities.DatabaseUtilities;

public class FetchdataFromDatabase {
	

	public static void main(String[] args) throws SQLException, IOException   {
		String Project_Name="visa";
		DatabaseUtilities dlib=new DatabaseUtilities();
		try {
			dlib.connectDB();
			String query="Select*from project";
			ResultSet rs=dlib.executeQuery(query);
		
			boolean flag=false;
			while(rs.next()) {
				String value=rs.getString(4)+" " +rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(5);
				if(value.equalsIgnoreCase(Project_Name)) {
					System.out.println( Project_Name+":--->project has been created.");
					flag=true;
					break;	
				}}
				if(!flag) {
					System.out.println("project not created.");
				
			}
			
			
		}finally {
			dlib.closeDB();
		}
	}

}
