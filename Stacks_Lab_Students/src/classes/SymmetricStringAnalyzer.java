package classes;

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
		SLLStack<Character> stack = new SLLStack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isLetter(c)) {
				if(Character.isUpperCase(c)) {
					stack.push(c);
				}
				else if(stack.isEmpty()) {
					return false;
				}
				else {
					char t = stack.top();
					if(t == Character.toUpperCase(c)) {
						stack.pop();
					}
					else {
						return false;
					}
				}
			}
			else {
				return false;
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		SLLStack<Character> stack = new SLLStack<>();	
		String result = "";
		if(this.isValidContent()) {
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(Character.isUpperCase(c)) {
					stack.push(c);
					result = result + "<" + Character.toString(c);
					
				}
				else {
					char t = stack.top();
					if(t == Character.toUpperCase(c)) {
						stack.pop();
						result = result + Character.toString(c) + ">";
					}
					
				}
				
			}
			return result;
		}
		else {
			throw new StringIsNotSymmetricException();
		}
		
	}

}
