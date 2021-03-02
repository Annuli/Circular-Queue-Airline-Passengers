package CircularQueueProject;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		
		final int MAX_NUMBER_IN_QUEUE = 3;		
		int userChoice = 0;
		String name = "";
		String[] passenger = new String[MAX_NUMBER_IN_QUEUE + 1];
		
		Scanner keyboard = new Scanner(System.in);
		
		CircularQueue_BOOKED passBookings = new CircularQueue_BOOKED(MAX_NUMBER_IN_QUEUE);
		CircularQueue_WAITING passWaiting = new CircularQueue_WAITING(MAX_NUMBER_IN_QUEUE);

		do
		{
			System.out.println("Menu");
			System.out.println("========");
			System.out.println("1. Add Passenger");
			System.out.println("2. Delete Passenger");
			System.out.println("3. Show Passengers");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			userChoice = keyboard.nextInt();
			
			switch(userChoice) {
			
				// Add a passenger
				case 1:					
					if(!passBookings.isFull()) {
						System.out.print("Enter name: ");
						name = keyboard.next();
						passBookings.enqueue(name);
					}
												
					else if(passBookings.isFull() && (!passWaiting.isFull())) {	
						System.out.print("Enter name: ");
						name = keyboard.next();
						passWaiting.enqueue(name);
						System.out.println("Sorry. Plane fully booked. Adding " + name + " to waiting list");
						
					} else 																					
						System.out.println("Sorry. Plane and waiting list fully booked. Try later");				
					break;
					
				// Delete a passenger	
				case 2:
					if(passBookings.isFull() && !passWaiting.isEmpty()) {
						passBookings.dequeue();
						passenger = passWaiting.front();					
						passBookings.enqueue(passenger[0]);
						passWaiting.dequeue();
						System.out.println("Adding " + passenger[0] + " from waiting list");
					}
					else if(!passBookings.isEmpty() && passWaiting.isEmpty())
						passBookings.dequeue();
									
					else
						System.out.println("No passengers to delete");			
					break;
					
				// Show passengers	
				case 3:
					if(!passBookings.isEmpty() && passWaiting.isEmpty()) { 
						System.out.println("Booked Passengers");
						System.out.println("=================");
						
						passenger = passBookings.front();	
						for(int x = 0; x < MAX_NUMBER_IN_QUEUE + 1; x++) {
							if(passenger[x] == null)
								continue;
							else
								System.out.println(passenger[x]);
						}					
						System.out.println("No passengers on waiting list");						
					} 
					
					else if(!passBookings.isEmpty() && !passWaiting.isEmpty() ){
						System.out.println("Booked Passengers");
						System.out.println("=================");
						passenger = passBookings.front();	
						for(int x = 0; x < MAX_NUMBER_IN_QUEUE + 1; x++) {
							if(passenger[x] == null)
								continue;
							else
								System.out.println(passenger[x]);
						}	
						System.out.println("Waiting list");
						System.out.println("=================");
						passenger = passWaiting.front();	
						for(int x = 0; x < MAX_NUMBER_IN_QUEUE + 1; x++) {
							if(passenger[x] == null)
								continue;
							else
								System.out.println(passenger[x]);
						}
					}
					else
						System.out.println("No passengers");
					break;
					
				// End of program
				case 4:
					System.exit(0);
				
				default:
					System.out.println("Invalid entry");
					break;		
				
			} // Switch Statement
		} while(userChoice != 4);
		
	} // end main
} // end class
