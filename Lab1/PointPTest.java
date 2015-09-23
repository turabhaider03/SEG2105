
	import java.io.*;

	/**
	 * This class prompts the user for a set of coordinates, and then 
	 * converts them from polar to cartesian.
	 *
	 * @author Turab Haider
	 * @author Nikhil Peri

	 */
public class PointPTest {
	

	
	  //Class methods *****************************************************

	  /**
	   * This method is responsible for the creation of the PointP
	   * object.  
	  
	   */
	  public static void main(String[] args)
	  {
	    PointP point;

	    System.out.println("Test for Design 2");

	    // Check if the user input coordinates from the command line
	    // If he did, create the PointP object from these arguments.
	    // If he did not, prompt the user for them.
	    try
	    {
	      point = new PointP(Double.valueOf(args[1]).doubleValue(), 
	        Double.valueOf(args[2]).doubleValue());
	    }
	    catch(Exception e)
	    {
	      // If we arrive here, it is because either there were no
	      // command line arguments, or they were invalid
	      if(args.length != 0)
	        System.out.println("Invalid arguments on command line");

	      try
	      {
	        point = getInput();
	      }
	      catch(IOException ex)
	      {
	        System.out.println("Error getting input. Ending program.");
	        return;
	      }
	    }
	    System.out.println("\nYou entered:\n" + point);
	    
	    
	    
	    System.out.println("\nConversion into Cartesian Coordinates:\n" + "[" + point.getX() + ", " + point.getY() + "]");
	  }

	  /**
	   * This method obtains input from the user and verifies that
	   * it is valid.  When the input is valid, it returns a PointP
	   * object.

	   */
	  private static PointP getInput() throws IOException
	  {
	    byte[] buffer = new byte[1024];  //Buffer to hold byte input
	    boolean isOK = false;  // Flag set if input correct
	    String theInput = "";  // Input information
	    
	    //Information to be passed to the constructor
	    char coordType = 'A'; // Temporary default, to be set to P or C
	    double a = 0.0;
	    double b = 0.0;

	    // Allow the user to enter the three different arguments
	    for (int i = 1; i < 3; i++)
	    {
	      while (!(isOK))
	      {
	        isOK = true;  //flag set to true assuming input will be valid
	          
	        // Prompt the user
	          System.out.print("Enter the value of " 
	            + (coordType == 'C' 
	              ? (i == 1 ? "X " : "Y ")
	              : (i == 1 ? "Rho " : "Theta ")) 
	            + "using a decimal point(.): ");


	        // Get the user's input      
	       
	        // Initialize the buffer before we read the input
	        for(int k=0; k<1024; k++)
	        	buffer[k] = '\u0020';        
	             
	        System.in.read(buffer);
	        theInput = new String(buffer).trim();
	        
	        // Verify the user's input
	        try
	        {
	            //Convert the input to double values
	            if (i == 1)
	              a = Double.valueOf(theInput).doubleValue();
	            else
	              b = Double.valueOf(theInput).doubleValue();
	        }
	        catch(Exception e)
	        {
	        	System.out.println("Incorrect input");
	        	isOK = false;  //Reset flag as so not to end while loop
	        }
	      }

	      //Reset flag so while loop will prompt for other arguments
	      isOK = false;
	    }
	    //Return a new PointCP object
	    return (new PointP(a, b));
	  }
	


}
