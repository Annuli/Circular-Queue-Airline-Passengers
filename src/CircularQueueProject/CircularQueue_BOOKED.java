package CircularQueueProject;

import java.util.Arrays;

public class CircularQueue_BOOKED {

	private int front;
	private int rear;
	private String queueArray[];
	
	CircularQueue_BOOKED(int maxSize) {
		queueArray = new String[maxSize + 1];
		front = maxSize; // (maxSize + 1) - 1
		rear = maxSize;  // (maxSize + 1) - 1
	}

	// Add passenger's name to the queue
	public void enqueue(String name) {
		if(rear == queueArray.length - 1) {	
			rear = (rear + 1) % queueArray.length;
			queueArray[rear] = name;
		} else {									
			rear++;
			queueArray[rear] = name;
		}	
	}
	
	// Changes the front variable
	public void dequeue() {
						
		if(front != rear) {			
			if(front == (queueArray.length) - 1)
				front = 0;
			else
				front++;
		}
		else {
			front = queueArray.length - 1;
			rear = queueArray.length - 1;
		}
	}
	
 	// Returns the value of each element, front to rear, in the array
	public String[] front() {									
		String[] passengers = new String[queueArray.length];
		int dequeuedFront = -1;
		int counter = 0;
		
		int x = front;	
		while(x != rear) { 
			dequeuedFront = (x + 1) % queueArray.length;
			
			if(x == (queueArray.length - 1)) {
				passengers[counter] = (queueArray[dequeuedFront]);
				x = 0;
			}
			else {
				passengers[counter] = (queueArray[dequeuedFront]);
				x++;	
			}
			counter++;
		}
		return passengers;
	}	
	
	// Check if the array is empty
	public boolean isEmpty() {
		if(front == rear)
			return true;
		return false;
	}
	
	// Check if array is full
	public boolean isFull() {
		if((rear + 1) % queueArray.length == front)
			return true;
		return false;
	}
	
	// Display the queue
	public void displayBookedQueue() {
		
		// Start front = [0] and rear = rear + 1; queueArray starts at -1
		for(int i = 0; i < rear+1; ++i)
			System.out.print(queueArray[i]);
	}

} // end class
