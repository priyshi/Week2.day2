package sunsep12;

public class SumOfDigitsFromStrings {
	/*
	 * Method 1
	 * Pseudo Code
	 
	 * Declare a String text with the following value
		String text = "Tes12Le79af65";
	   Declare a int variable sum
		int sum = 0;
	 * b) Now, convert the String into array
	 * c) Iterate over the array and get each character
	 * d) Using Character.getNumericValue(), Change the char into int
	 * e) Add the values to sum & print
	 * 
	 */

	public static void main(String[] args) {
		
		String text = "Tes12Le79af65";
		int sum=0;
		char[] chArr=text.toCharArray();
		for (int i = 0; i <chArr.length; i++) {
		   int p= Character.getNumericValue(chArr[i]);
		   if(Character.isDigit(chArr[i])) {
			    sum=sum+p;
			      }
		 	
		}
		
		 System.out.println(+sum);		 

	}

}
