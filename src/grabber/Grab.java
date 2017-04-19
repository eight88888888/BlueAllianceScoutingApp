package grabber;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Grab {
	
	public static String[] getNumericElements(String raw, String key){
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
		return out.toArray(new String[out.size()]);
		
	}
	
	public static String getNextNumericalElement(String raw){
		String nextElement = "";
		char partOfString = 'a'; 
		int index = 0;
		while(partOfString != ','){
			partOfString = raw.charAt(index);//the next char in the string
			if(Character.isDigit(partOfString) || partOfString == '.'){//Only add to string if the char is a number or decimal
				nextElement += String.valueOf(partOfString);
			}
			index++;
		}
		System.out.println("NextElement " + nextElement);
		return nextElement;
		
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
