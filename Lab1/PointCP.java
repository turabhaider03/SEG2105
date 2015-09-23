// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in either polar and
 * cartesian format.  
 * 
 * @author Turab Haider
 * @author Nikhil Peri
 */
public class PointCP
{
  //Instance variables ************************************************
  //Contains the current value of RHO
  private double Rho;
  
  // Contains the current value THETA 
  private double Theta;
	
  //Contains the current value of x
  private double xCoord;
  
  //Contains the current value of y
  private double yCoord;
  
  //Constructors ******************************************************

  /**
   * Constructs a pointCP object, and stores as polar and coordinate.
   */
  public PointCP(char type, double xOrRho, double yOrTheta)
  {
    if(type == 'C'){
    	this.xCoord = xOrRho;
    	this.yCoord = yOrTheta;
    	
    	this.Rho = (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
    	this.Theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
    } else if (type == 'P') {
    	this.Rho = xOrRho;
    	this.Theta = yOrTheta;
    	
    	this.xCoord = (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
    	this.yCoord = (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    } else {
    	throw new IllegalArgumentException();
    }
  }
	
  
  //Instance methods **************************************************
  public double getX()
  {
	  return xCoord;
  }
  
  public double getY()
  {
	  return yCoord;
  }
  
  public double getRho()
  {
	  return Rho;
  }
  
  public double getTheta()
  {
	  return Theta;
  }
  
  public double getDistance(PointCP pointB)
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
  public PointCP rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP('C',
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
    return "Cartesian  (" + getX() + "," + getY() + ")"
       + ":Polar [" + getRho() + "," + getTheta() + "]" + "\n";
  }
}