package org.NewaInsurance_GenrericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains the File utilities to fetch projectEnviconfiguration,
 * Databaseserverconfiguration,Filepathconfiguration path from the property
 * file.
 * 
 * @author Prasanna
 *
 */
public class FileUtilities {

	/**
	 * This method is able to fetch the path of the configuration files
	 * 
	 * @param key
	 * @return value
	 * @throws IOException
	 */

	public String getFilepathfromProperties(String key) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./configurations/Filepathconfiguration.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties pobj = new Properties();
		try {
			pobj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = pobj.getProperty(key);

		return value;
	}

	/**
	 * This is used to fetch the data from the configuration folder based on the key
	 * and will generate the value.
	 * 
	 * @param filepath
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String getdatafromProjectEnvconfig(String key) throws IOException {

		FileInputStream fis = new FileInputStream(IconstantUtitlity.projectEnviconfigpath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		
		return value;

	}
	public String getDatafromDbaseconfig(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IconstantUtitlity.Databaseserverconfigpath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		
	}
	
	
	

}
