package com.interviewprep.leetcode.medium.stringtointeger;

public class FirstApproach {

	public static void main(String[] args) {

		FirstApproach fa = new FirstApproach();
		//int strToInt = fa.myAtoi("-91283472332");
		//int strToInt = fa.myAtoi("3.14159");
		int strToInt = fa.myAtoi("words and 987");
		//int strToInt = fa.myAtoi(".1");
		//int strToInt = fa.myAtoi("+1");
		//int strToInt = fa.myAtoi("  -042");
		//int strToInt = fa.myAtoi("+-12");

		System.out.println(strToInt);
	}



	public int myAtoi(String s) {

		int strToInt = 0;

		s = s.strip();
		int len = s.length();	
		StringBuilder str = new StringBuilder();
		boolean isNeg = false;

		for(int i=0; i<len; i++) {

			Character c = s.charAt(i);

			if(i == 0 &&  (c == '-'  ||  c == '+') ) {

				// if '-' is the first char then turn the flag to true
				if(c == '-')
					isNeg = true;

				continue;
			}

			// if char is digit then append to string
			if(Character.isDigit(c)  ) {

				str = str.append( Character.toString(c) );
				continue;
			}

			// if char is not a digit then break
			if(!Character.isDigit(c) ) {

				break;
			}

		} // endfor


		// convert string to integer
		if(!str.isEmpty()) {
			try {
				strToInt = Integer.valueOf(str.toString());
			}
			// if val is too large for int then return the min / max int val
			catch(NumberFormatException nfe) {

				if(isNeg)
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;
			}

		}

		// if flag is true then multiply by -1
		if(isNeg) {
			strToInt = strToInt * -1;
		}

		return strToInt;
	}	

}
