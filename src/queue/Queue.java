package queue;

public class Queue<T> {
	private int rear;
	private int front;
	private final int size;
	private Object[] arr;
	
	public Queue(){
		this(10);
	}
	
	public Queue(int size){
		if(size<=0){
			throw new RuntimeException("size can not be zero");
		}
		rear = 0;
		front = 0;
		this.size = size;
		arr = new Object[size];
		
	}
	public void enqueue(T element){
		/*if(front){
			throw new StackOverflowError("Queue is full");
		}
		arr[++top] = element;*/
	}
	
	public T dequeue(){
		if(front==rear){
			throw new RuntimeException("Queue is empty");
		}
		@SuppressWarnings("unchecked")
		T  e = (T) arr[front];
		arr[front++] = null;
		front = front%size;
		return e;
		
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("[");
		for(int i=front;i<size+rear;i++){
			sb.append(arr[i].toString());
			sb.append(",");
		}
		if(rear!=-1){
			sb.append(arr[rear].toString());
		}
		sb.append("]");
		
		return sb.toString();
	}
	

}
