package grabber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class SyncEvent {
	
	HttpURLConnection conn;
	
	String eventUrl = "http://www.thebluealliance.com/api/v2/event/2017", header = "?X-TBA-App-Id=frc5016:scout:v1";
	public ArrayList<String> nonParsedTeamNumberList = new ArrayList<String>();
	
	public SyncEvent(String eventCode) {
		// TODO Auto-generated constructor stub
		String response = "";
		boolean connected;
		try{	
			URL url = new URL(eventUrl + eventCode + "/teams" + header);
			conn = (HttpURLConnection) url.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");//Workaround to make it look like this is a browser
			response =  Integer.toString(conn.getResponseCode());//ServerCode
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			response = br.readLine();//Data from Server
			connected = true;
			
		}catch (Exception e) {
			response += "failed";
			connected = false;
		}
		
		if(connected){
			for(int teamNumberIndex = 0; teamNumberIndex != -1;){//This sorts  out the teamnumber and puts it in an array
				//System.out.println("teamNumberIndex: " + teamNumberIndex);
				response = response.substring(teamNumberIndex);//Cuts off every before "team_number"
				response = response.substring(getNextCommaIndex(response));//Cuts off "team_number"
				teamNumberIndex = response.indexOf("team_number");//Find the key of "team_number" the element will be next to it
				if(teamNumberIndex != -1){//will be -1 if nothing is found
					String nextElement = getNextNumbericalElement(response.substring(teamNumberIndex, response.length()));
					nonParsedTeamNumberList.add(nextElement);
				}
			}
		}
			//System.out.println(response);
	}
	
	String getNextNumbericalElement(String input){
		//Should probluly do something else, it used to also add a 
		String nextElement = "";
		char partOfString = 'a';//arbritruary letter, note cant be a comma and shouldnt be a number 
		int index = 0;
		while(partOfString != ','){
			partOfString = input.charAt(index);//the next char in the string
			if(Character.isDigit(partOfString)){
				nextElement += String.valueOf(partOfString);
			}
			index++;
		}
		System.out.println("NextElement " + nextElement);
		return nextElement;
		
	}
	
	int getNextCommaIndex(String input){//Gets the index of the next comma

		//Since the the indexOf function gets the index at the beginning If I erase all the
		int commaIndex = 0;
		char stringCharacter = 'a';//arbritruary letter
		while(stringCharacter != ','){
			stringCharacter = input.charAt(commaIndex);
			if(stringCharacter != ',')
				commaIndex++;
		}
		return commaIndex;
		
	}
	
	
	public static void main(String[] args){
		SyncEvent syncEvent = new SyncEvent("nyli");
		System.out.println(syncEvent.nonParsedTeamNumberList);
	}
}
