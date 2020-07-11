import java.util.LinkedList;
import java.util.Queue;

public class Heap {
	private MyCustomer[] heapArray;
	private int maxSize;
	public int currentSize;
			
    
	  public Heap(int maxHeapSize){
		currentSize = 0;
		maxSize = maxHeapSize;
		heapArray = new MyCustomer[maxSize];
	  }
	
	  public boolean Insert(MyCustomer cust){
		int position = 0;
		
		if (currentSize == maxSize)
		    return false;
		
		position = IsInto(cust.name); 
		
		if (position > 0)
		    addPurchases(cust, position);
		else
		{
		    heapArray[currentSize] = cust;
		    bubbleUp(currentSize++);
		}
		return true;
	   }
	
	  public String Root(){
	      return (heapArray[0].getName() + ", with a total of " + heapArray[0].getPaid() + " euros spent.");
	  }
	 
	  private int IsInto(String myname){
		if (currentSize > 0){
		    for (int m = 0; m < currentSize; m++){       	
		        if (heapArray[m].getName().equals(myname))
		            return m;
		    }
		}
			return 0;
	  }
	
	  private boolean isGreater (int k1, int k2) {
		return k1 > k2 ;
	  }  

	  private void bubbleUp (int k) {
		  while (k > 0 && isGreater (heapArray[k].paid, heapArray[(k-1)/2].paid)) {
				swap (k, (k-1)/2);
				k = (k-1)/2;
		  }
	   }
		
	  private void addPurchases(MyCustomer cust, int position){

		heapArray[position].paid  = cust.paid + heapArray[position].getPaid();
		bubbleUp(position);
 
	  }
      
	  private void printSpaces(int son) {
		  for (int j = 0; j < son; j++){
			  System.out.print('\u0020');
		  }
	  }  
	  
	  private void swap (int k1, int k2) {
		assert (k1 >= 0 && k2 >= 0 && k1 < currentSize && k2 <= currentSize);
			
		MyCustomer temp = heapArray[k1];
		heapArray[k1] = heapArray[k2];
		heapArray[k2] = temp;
	  }

	  public void printHeap() {
		  
		boolean hasChildrenIzq, hasChildrenDer, sameLevel;
		int i, rows;

		final MyCustomer root = heapArray[0];
		
		final Queue<MyCustomer> queue = new LinkedList<>();
		queue.add(root);
		
		sameLevel = false;
		
		i = 0;
		rows = 0;
		while (!queue.isEmpty()) {

			hasChildrenIzq = false;
			hasChildrenDer = false;
				
			if (queue.size()> 0) {
				MyCustomer x = queue.remove();
										
				if (sameLevel == false){ //only one level
					printSpaces((currentSize - i ) - rows);
					System.out.println(x.paid);
					rows++;
                } else 
                {
					sameLevel = false; //same level
					printSpaces((currentSize) - rows);
					System.out.print(x.paid);
					x = queue.remove();
					printSpaces((rows + i));
					System.out.println(x.paid);
					rows++;
				}
					
				if (heapArray[(2*i)+1] != null) { //Returns the left child node
					hasChildrenIzq = true;
					x = heapArray[(2*i)+1];
					queue.add(x);
				}
					
				if (heapArray[(2*i)+2] != null) { //Returns the right child node
					hasChildrenDer = true;
					x = heapArray[(2*i)+2];
					queue.add(x);
				}
					
				if (hasChildrenIzq == true) {
					if (hasChildrenDer == false) {
					    printSpaces(rows);
					    System.out.println('\u2199');	// print left arrow
					    	
                    } else 
                    {
					    printSpaces((currentSize * 2) - rows);
					    System.out.print('\u2199');	// print left arrow
					    printSpaces(2);
					    System.out.println('\u2198');	// print right arrow
					    sameLevel = true;
					    rows++;
					    //System.out.println(" ------ ");
					}
                }	
            } 
		i++;
		}

	}
}
