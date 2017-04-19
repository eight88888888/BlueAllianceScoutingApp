package grabber;

import java.net.HttpURLConnection;

public class BlueAllianceConnection {
	final String urlBegining = "https://www.thebluealliance.com/api/v2/";//Each request will start with this
	String currentEventCode;
	int currentTeam;
	HttpURLConnection conn;
	
	public BlueAllianceConnection(){}
	
	public void setEvent(String eventCode){
		//If is already downloaded, then sync via last modified header
	}
	
	public int[][] getMatches(){
		//Return a table of the matches for the selected event
	}
	
	public int[] getRanks(){
		//Return an array of the current ranks for the selected event
	}
	
	public int[][] getTeam(){
		
	}
	
	public int[][] getOPR(){
		
	}
	
	
}
