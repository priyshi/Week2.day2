package sunsep12;

public class RemoveDuplicate {
	
	/*Pseudo code 
	 
	 * a) Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";		
	 * b) Initialize an integer variable as count	  
	 * c) Split the String into array and iterate over it 
	 * d) Initialize another loop to check whether the word is there in the array
	 * e) if it is available then increase and count by 1. 
	 * f) if the count > 1 then replace the word as "" 
	 
	 * g) Displaying the String without duplicate words	
	 */

	public static void main(String[] args) {
		
		String text = "We learn java basics as part of java sessions in java week1";
		System.out.println("Before removing duplicates : " + text);

		String[] splitStr = text.split(" ");
		String[] Stringpri = new String[splitStr.length];

		System.out.print("After Removing duplicates  : ");
		for (int i = 0; i < splitStr.length; i++) {
			if (Stringpri[i] != "0") {
				for (int j = i + 1; j < splitStr.length; j++) {
					if (splitStr[i].equals(splitStr[j])) {
						Stringpri[j] = "0";
					}
				}
				Stringpri[i] = splitStr[i];
				System.out.print(Stringpri[i] + " ");
			}
		}
	}

}
