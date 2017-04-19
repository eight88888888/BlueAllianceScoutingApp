package grabber;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.awt.List;

public class Grab {
	
	public static int[] getNumericElements(String raw, String key){
		List<String> out = new ArrayList<String>();
		int index = 0;
		boolean runonce = false;
		
		while(index != -1){
			index = raw.indexOf(key);
			raw = raw.substring(index);
			if(runonce){
				raw = raw.substring(getNextCommaIndex(raw));
			}
			getNextNumericalElement(raw);
			if(index != -1){
				
			}
		}
		return out.toArray(new int[out.size()]);
		
	}
	
	public static int[] getElementNum(String raw, String key){
		int[] out;
		
		return out;
	}
	
	public static double getNextNumericalElement(String raw){
		String nextElement = "";
		char partOfString = 'a'; 
		int index = 0;
		while(partOfString != ','){
			partOfString = raw.charAt(index);//the next char in the string
			if(Character.isDigit(partOfString)){
				nextElement += String.valueOf(partOfString);
			}
			index++;
		}
		System.out.println("NextElement " + nextElement);
		return nextElement;
		
	}
	
	public static String getNextInput(){
		
	}
	
	public static int getNextCommaIndex(String input){//Gets the index of the next comma
		int commaIndex = 0;
		char stringCharacter = 'a';//arbritruary letter
		while(stringCharacter != ','){
			stringCharacter = input.charAt(commaIndex);
			if(stringCharacter != ',')
				commaIndex++;
		}
		return commaIndex;
		
	}
	

}
