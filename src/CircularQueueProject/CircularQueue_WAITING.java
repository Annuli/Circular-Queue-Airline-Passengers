package CircularQueueProject;

import java.util.Arrays;

public class CircularQueue_WAITING {

	private int front;
	private int rear;
	private String queueArray[];
	
	CircularQueue_WAITING(int maxSize) {
		queueArray = new String[maxSize + 1];
		front = maxSize; // (maxSize + 1) - 1
		rear = maxSize;  // (maxSize + 1) - 1
	}
	
	// Add passenger's name to the queue
	public void enqueue(String name) {
		if(rear == queueArray.length - 1) {			 // Wrap the rear of the queue to the front
			rear = (rear + 1) % queueArray.length;
			queueArray[rear] = name;
		} else {									// Add the name to the queue
			rear++;
			queueArray[rear] = name;
		}	
	}
	
	// Changes the front variable
	public void dequeue() { // Need to reset 'front' and 'rear' of BOTH queues to their default values when the BOOKED array is is empty
						
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
			//System.out.println(dequeuedFront);  // Reflects where in the queue the display starts
			
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
	public void displayWaitingQueue() {
		
		// Start front = [0] and rear = rear + 1; queueArray starts at -1
		for(int i = 0; i < rear+1; ++i)
			System.out.print(queueArray[i]);
	}
} // end class
