package classes;

import java.util.ArrayList;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		SLLStack<Character> stack = new SLLStack<Character>();
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isLetter(c))
				if(Character.isUpperCase(c))
					stack.push(c);
				else if (stack.isEmpty())
					return false;
				else {
					char t = stack.top();
					if (t == Character.toUpperCase(c))
						stack.pop();
					else
						return false;
				}
			else
				return false;
		}
		return stack.isEmpty();
	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
			throws StringIsNotSymmetricException {
		ArrayList<String> string = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isUpperCase(c)) {
				string.add("<");
				string.add(Character.toString(c));
			}
			else if (Character.isLowerCase(c)) {
				string.add(Character.toString(c));
				string.add(">");
			}
		}
		return string.toString();
	}

}
