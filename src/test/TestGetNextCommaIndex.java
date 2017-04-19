package test;

public class TestGetNextCommaIndex {
	public static void main(String[] args){
		String input = ",ajd,fhkjhalkdshfkljahsdflk;";
		int commaIndex = 0;
		char stringCharacter = 'a';//arbritruary letter
		while(stringCharacter != ','){
			stringCharacter = input.charAt(commaIndex);
			if(stringCharacter != ',')
				commaIndex++;
		}
		System.out.println(commaIndex);
	}
}
