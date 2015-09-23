import java.util.Random;

public class PointPerformanceTest {
	public static void main(String[] args){
		int nPoints = 10000000;
		long startTime;
		long stopTime;
		long elapsedTime;
		
		Random random = new Random();
		
		PointCP[] randomPointsCP = new PointCP[nPoints];
		PointP[] randomPointsP = new PointP[nPoints];
		
		//time to make n PontCP objects
	    	startTime = System.currentTimeMillis();
	    	for(int i = 0; i < nPoints; i++){
	    		randomPointsCP[i] = new PointCP('C', random.nextDouble(), random.nextDouble());
	    	}
	    	stopTime = System.currentTimeMillis();
	    	elapsedTime = stopTime - startTime;
	    	System.out.println("The time to create "+ nPoints + " PointCP objects is: " + elapsedTime + " ms");
	    
	    	//time to make n PointP objects
	    	startTime = System.currentTimeMillis();
	    	for(int i = 0; i < nPoints; i++){
	    		randomPointsP[i] = new PointP(random.nextDouble(), random.nextDouble());
	    	}
	    	stopTime = System.currentTimeMillis();
	    	elapsedTime = stopTime - startTime;
	    	System.out.println("The time to create "+ nPoints + " PointP objects is: " + elapsedTime + " ms\n");
	    
	    	//time to get n PointCP Cartesian Coordinates
	    	startTime = System.currentTimeMillis();
	    	for(int i = 0; i < nPoints; i++){
	    		randomPointsCP[i].getX();
	    		randomPointsCP[i].getY();
		 }
	    	stopTime = System.currentTimeMillis();
	    	elapsedTime = stopTime - startTime;
	    	System.out.println("The time to get "+ nPoints + " cartesian coordinates (PointCP) is : " + elapsedTime + " ms");
	    
		 //time to get n PointCP Polar Coordinates
	    	startTime = System.currentTimeMillis();
	    	for(int i = 0; i < nPoints; i++){
	    		randomPointsCP[i].getRho();
	    		randomPointsCP[i].getTheta();
	    	}
	    	stopTime = System.currentTimeMillis();
	    	elapsedTime = stopTime - startTime;
	    	System.out.println("The time to get "+ nPoints + " polar coordinates (PointCP) is : " + elapsedTime + " ms\n");
	
		//time to get n PointP Cartesian Coordinates
		startTime = System.currentTimeMillis();
		for(int i = 0; i < nPoints; i++){
    			randomPointsP[i].getX();
    			randomPointsP[i].getY();
    		}
    		stopTime = System.currentTimeMillis();
    		elapsedTime = stopTime - startTime;
    		System.out.println("The time to get "+ nPoints + " cartesian coordinates (PointP) is : " + elapsedTime + " ms");
    
		 //time to get n PointP Polar Coordinates
	    	startTime = System.currentTimeMillis();
    		for(int i = 0; i < nPoints; i++){
    			randomPointsP[i].getRho();
    			randomPointsP[i].getTheta();
    		}
    		stopTime = System.currentTimeMillis();
    		elapsedTime = stopTime - startTime;
    		System.out.println("The time to get "+ nPoints + " polar coordinates (PointP) is : " + elapsedTime + " ms\n");
    
   	}
}
