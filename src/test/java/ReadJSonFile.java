
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/* 
 *   This program reads the data from the JSON file and write data in to the text document
 *   Parameters need to pass for the below function 
 *   
 *   lisArray.forEach(listObj -> getDetails((JSONObject)listObj , "vctSubscription") 
 *   the above data takes info from the header  , so if you have more headers them you need to 
 *   provide in this description
 * 
 *   You also need to provide the JSONFile Paths and Text Document Path 
 *   the text document will be created with the timestamp
 * 
 */

public class ReadJSonFile {
	
	public void readJsonFile() {
		JSONParser jsonParser = new JSONParser();
		
		try {
		FileReader reader = new FileReader("JSONFilePath//testFile.json");
		Object objParser = jsonParser.parse(reader);
		JSONArray lisArray =  (JSONArray) objParser;
		lisArray.forEach(listObj -> getDetails((JSONObject)listObj , "vctSubscription"));
		lisArray.forEach(listObj -> getDetails((JSONObject)listObj , "eisSubscription"));
		lisArray.forEach(listObj -> getDetails((JSONObject)listObj , "misSubscription"));}
		catch(Exception e) {
			System.out.println("The Error Message is " + e.getMessage());
			e.printStackTrace();
		  }
		}
	
	public void getDetails(JSONObject listObj , String objName)  {
		ArrayList<Object> writeList =  new ArrayList<Object>();
		JSONObject objJSon = (JSONObject) listObj.get(objName);
		long releifClaimed = (Long) objJSon.get("releifClaimed");
		String dateOfInvestMent = (String) objJSon.get("dateOfInvestMent");
		String name = (String) objJSon.get("name");
		long amountInvested = (Long) objJSon.get("amountInvested");
		String uniqueInvestmentRef = (String) objJSon.get("uniqueInvestmentRef");
		
		writeList.add(releifClaimed);
		writeList.add(dateOfInvestMent);
		writeList.add(name);
		writeList.add(amountInvested);
		writeList.add(uniqueInvestmentRef);
		
		writeDataToFile(writeList);
			}
	
	public void writeDataToFile(ArrayList<Object> writeData) {
		System.out.println(writeData.size());
		for(int h=0;h<writeData.size();h++) {
			System.out.println(writeData.get(h).toString());
		}
		
		try {
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter("TextDataOutPutPath\\myData_"+ReadJSonFile.getTimeStamp()+".txt",true));
		writer.append("|");
		for( int i=0;i<writeData.size();i++) {
		writer.append(writeData.get(i).toString());
		writer.append("|");}
		writer.append("\n");
		writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public static String getTimeStamp() {
		Date d =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
		String dd = sdf.format(d);
		return dd;
		
	}
	
	public static void main(String ar[]) {
		ReadJSonFile readJSon =  new ReadJSonFile();
		readJSon.readJsonFile();
	}

}
