
public class Queue {

	private int rear, front;
	private Object[] elements;
	
	public Queue(int capacity) {
		elements = new Object[capacity];
		rear= -1 ;
		front = 0;
	}
	
	public void enqueue(Object data) {										// ekleme metodu
		if(isFull()) {
			System.out.println("Queue is overflow");
		}
		else {
			rear++;
			elements[rear]=data;
		}
	}
	
	public Object dequeue() {												// çýkarma metodu
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			Object retData = elements[front];
			elements[front]= null;										// [A][A][A] ---> [N][A][A]
			front++;
			return retData;
		}
	}
	
	public Object peek() {												// en öndekine bakma metodu		
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			return elements[front];
		}
			
	}
	
	public boolean isFull() {
		return (rear+1 == elements.length);
	}
	
	public boolean isEmpty() {
		return (rear < front); 			
	}
		
	public int size() {
		return rear-front+1;
	}
	
	
}
