package sunsep12;

public class ReverseString {
	// Here is the input
	//String test = "feeling good";

	// Build the logic to find the count of each
	/* Pseudo Code: 1
		a) Convert the String to character array
		b) Traverse through each character (using loop in reverse direction)
		c) Print the character (without newline -> like below
		   System.out.print(ch);
	*/	
	/* Pseudo Code: 2
	a) Find the length of the string
	b) Traverse through each index from length-1 -> 0 (using loop in reverse direction)
	c) Find the character of the String using its index
	*/
	
	public static void main(String[] args) {
		String test = "feeling good";
		 String reverse="";
		//String to char array conversion
				char[] chArr1 = test.toCharArray();
				
				// size of the array 
				int lengthArr = chArr1.length;
				System.out.println("Length of an Array:" + lengthArr);

				// access all the elements of an array
				 for (int i = chArr1.length-1; i>=0; i--) {
					 reverse = reverse+chArr1[i];
					}
					
		       System.out.println("Reversed String : "+reverse);	
	}

}
