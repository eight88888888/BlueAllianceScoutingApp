package grabber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BlueAllianceConnection {
	final String URL_BEGINNING = "https://www.thebluealliance.com/api/v2/", ID_HEADER = "?X-TBA-App-Id=frc5016:scout:v1";//Each request will start with this
	String currentEventCode;
	int currentTeam;
	HttpURLConnection conn;
	
	public BlueAllianceConnection(){
		
	}
	
	public String[] getEventTeamList(String eventCode){
		
	}
	
	public String[] getEventMatches(){//Gets list of matches and results
		
	}
	public String blueAllianceGet(String address){
		String response = "-1";
		try{	
			URL url = new URL(URL_BEGINNING + address + ID_HEADER);//This is the URL that it will connect to
			conn = (HttpURLConnection) url.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");//Workaround to make it look like this is a browser
			response =  Integer.toString(conn.getResponseCode());//ServerCode
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			response = br.readLine();//Data from Server
		}catch (Exception e) {
			System.out.println("Connection Error: " + response);
			response = "-1";
		}
		
		return response;
		//If response is -1 then there was an error
		
	}
	
	
}
