package stack;

public class Stack<T> {
	private int top;
	private final int size;
	private Object[] arr;
	
	public Stack(){
		this(10);
	}
	
	public Stack(int size){
		if(size<=0){
			throw new RuntimeException("size can not be zero");
		}
		top = -1;
		this.size = size;
		arr = new Object[size];
		
	}
	public void push(T element){
		if(top==size-1){
			throw new StackOverflowError("Stack is full");
		}
		arr[++top] = element;
	}
	
	public T pop(){
		if(top==-1){
			throw new RuntimeException("Stack is empty");
		}
		@SuppressWarnings("unchecked")
		T  e = (T) arr[top];
		arr[top--] = null;
		return e;
		
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("[");
		for(int i=0;i<top;i++){
			sb.append(arr[i].toString());
			sb.append(",");
		}
		if(top!=-1){
			sb.append(arr[top].toString());
		}
		sb.append("]");
		
		return sb.toString();
	}
	

}
