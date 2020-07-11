public class MyProgram {
	
public static void main(String[]args)
    {
	   
        Heap theHeap = new Heap(100); 
        int payment = 0;
        String name = "";
        String s = "4,Valeria\n20,Gonzalo\n17,Valeria\n22,Angélica\n5,Gonzalo\n9,Valeria";
        
        String[] words = s.split("\n");
        for (String word:words) 
        {
            String[] others = word.split(",");
            for (int m = 0; m < others.length; m++)
            {
                if (m % 2 == 0)
                    payment = Integer.parseInt(others[m]); //insert customer payment
                else
                    name = others[m]; //insert customer name
            }
            
	        MyCustomer newCustomer = new MyCustomer(name, payment);
            theHeap.Insert(newCustomer);
            
            
        }
       
       System.out.println(" ");
       theHeap.printHeap();
       System.out.println("<------>");
       
       System.out.println(" ");
       System.out.print("The awarded customer is --> " + theHeap.Root());
    }
}
