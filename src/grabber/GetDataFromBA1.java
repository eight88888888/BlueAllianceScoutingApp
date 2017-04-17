package grabber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class GetDataFromBA1 {
	
	static URL urlConn;
	static HttpURLConnection conn;
	
	static String urlBegining = "http://www.thebluealliance.com/api/v2/team/frc254";
	//static String urlBegining = "https://www.thebluealliance.com/api/v2/status";
	
	public static void main(String[] args){
		try {//Try to connect
			urlConn = new URL(urlBegining);
			conn = (HttpURLConnection) urlConn.openConnection();
			conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			System.out.println(br.readLine());
			
			br.close();
			conn.disconnect();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
