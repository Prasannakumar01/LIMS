package dataproviderspractise;

import java.util.ArrayList;
import java.util.Iterator;

public class Array {
public static void main(String[] args) {
	
	
ArrayList<String> al=new ArrayList<String>();
al.add( "krishna");
al.add( "anirudh");
Iterator<String> result=al.iterator();
while(result.hasNext()) {
	System.out.println(result);

}

	
}
}
	

