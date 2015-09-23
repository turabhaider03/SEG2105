/**
 * This class contains instances of coordinates in polar format.  
 * It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Turab Haider
 * @author Nikhil Peri
 * @ Version 1
 */
public class PointP {
	//Instance variables ************************************************

	  
	  /**
	   * Contains the current value of RHO.
	   */
	  private double Rho;
	  
	  /**
	   * Contains the current value of THETA.
	   */
	  private double Theta;
		
	  
	  //Constructors ******************************************************

	  public PointP(double Rho, double Theta)
	  {
	    
	    this.Rho = Rho;
	    this.Theta = Theta;
	    
	  }
		
	  
	  //Instance methods **************************************************
	  
	  /**
	   * Converts to Cartesian coordinates and returns X-value
	   */
	 
	  public double getX()
	  {
	    
	      return (Math.cos(Math.toRadians(Theta)) * Rho);
	  }
	  
	  /**
	   * Converts to Cartesian coordinates and returns Y-value
	   */
	  
	  public double getY()
	  {
	    
	      return (Math.sin(Math.toRadians(Theta)) * Rho);
	  }
	  
	  /**
	   * Returns Rho
	   */
	 
	  public double getRho()
	  {
	     
	      return Rho;
	 
	  }
	  
	  /**
	   * Returns Theta
	   */
	  
	  public double getTheta()
	  {
	    
	      return Theta;
	    
	  }
	  

	  /**
	   * Calculates the distance in between two points using the Pythagorean
	   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	   *
	   * @param pointA The first point.
	   * @param pointB The second point.
	   * @return The distance between the two points.
	   */
	  public double getDistance(PointP pointB)
	  {
	    // Obtain differences in X and Y, sign is not important as these values
	    // will be squared later.
	    double deltaX = getX() - pointB.getX();
	    double deltaY = getY() - pointB.getY();
	    
	    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	  }

	  /**
	   * Rotates the specified point by the specified number of degrees.
	   * Not required until E2.30
	   *
	   * @param point The point to rotate
	   * @param rotation The number of degrees to rotate the point.
	   * @return The rotated image of the original point.
	   */
	  public PointP rotatePoint(double rotation)
	  {
	    double radRotation = Math.toRadians(rotation);
	    double X = getX();
	    double Y = getY();
	        
	    return new PointP(
	      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
	      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	  }

	  /**
	   * Returns information about the coordinates.
	   *
	   * @return A String containing information about the coordinates.
	   */
	  public String toString()
	  {
	    return "Stored as " + ("Polar [" + getRho() + "," + getTheta() + "]") + "\n";
	  }




}
