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
		if(front==rear && arr[front]!=null){
			throw new RuntimeException("Queue is full");
		}
		arr[rear++] = element;
		rear = rear%size;
	}
	
	public T dequeue(){
		if(isEmpty()){
			throw new RuntimeException("Queue is empty");
		}
		@SuppressWarnings("unchecked")
		T  e = (T) arr[front];
		arr[front++] = null;
		front = front%size;
		return e;
		
	}
	
	public boolean isEmpty(){
		if(front==rear && arr[front]==null){
			return true;
		}
		return false;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("[");
		if(front<rear){
			for(int i=front;i<rear-1;i++){
				sb.append(arr[i].toString());
				sb.append(",");
			}
		}
		else if(front==rear && arr[front]!=null){
			for(int i=front;i<size;i++){
				sb.append(arr[i].toString());
				sb.append(",");
			}
			for(int i=0;i<rear-1;i++){
				sb.append(arr[i].toString());
				sb.append(",");
			}
		}
		if(arr[rear-1]!=null){
			sb.append(arr[rear-1].toString());
		}
		sb.append("]");
		
		return sb.toString();
	}
	

}
