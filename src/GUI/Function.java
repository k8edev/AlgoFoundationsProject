package GUI;

import java.lang.reflect.Method;

public class Function {
	private Method iterative; 
	private Method recursive;
	private String name; 
	
	public Function(Method iterative, Method recursive, String name) {
		this.setIterative(iterative); 
		this.setRecursive(recursive); 
		this.setName(name); 
	}

	public Method getIterative() {
		return iterative;
	}

	public void setIterative(Method iterative) {
		this.iterative = iterative;
	}

	public Method getRecursive() {
		return recursive;
	}

	public void setRecursive(Method recursive) {
		this.recursive = recursive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
