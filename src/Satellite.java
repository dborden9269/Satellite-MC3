/**  @author Octavio Gutierrez */
/**  modified by Kevin Twitty 1/23/2014
 * 
 */
public class Satellite { 
   private static final double EARTH_MASS = 5.97 *(Math.pow(10, 24));
   private static final double GRAVITY = 6.67 *(Math.pow(10, -11));
   private static final double EARTH_RADIUS = 6378137;  //Earths Radius in meters
   private double distance, ax, ay, x, y, vx, vy, altitude;
 
  //Default Constuctor
  public Satellite() {
     
  }
   public Satellite(double x, double y, double vx, double vy){
      this.x = x;
      this.y = y;
      this.vx = vx;
      this.vy = vy;
   }

    //  @return the EARTH_MASS
     public static double getEarthMass() {
        return EARTH_MASS;
     }

     // @return the GRAVITY 
     public static double getGravity() {
        return GRAVITY;
     } 

     // @return the x
     public double getX() { 
        return x;
     }
  
    // @param x the x to set
    public void setX(double x) {
      this.x = x;
    }
 
    // @return the y
    public double getY() {
       return y;
    } 
 
   // @param y the y to set
   public void setY(double y) { 
      this.y = y;
   }
 
   // @return the vx
   public double getVx() { 
      return vx;
      }
   
   // @param vx the vx to set
   public void setVx(double vx) { 
      this.vx = vx; 
   }
 
   // @return the vy
   public double getVy() { 
      return vy;
   }
 
   // @param vy the vy to set
   public void setVy(double vy) { 
      this.vy = vy;
   }
   //Moves satellite with passage of a small time (t)
   public void simulate(int t){ 
      setX(getX() + (getVx()*t));
      setY(getY() + (getVy()*t));
      setVx(getVx() + (getAx()*t));
      setVy(getVy() + (getAy()*t));
      setAltitude();
      if (isCrashed()){
         setVx(0);
         setVy(0);
         throw new IllegalArgumentException("I Crashed!");
      }
   }  
   // @return the distance
   public double getDistance() {
      return (Math.sqrt(Math.pow(getX() , 2)+ Math.pow(getY() , 2))); 
   }
   // Set altitude
   private void setAltitude(){
      altitude = getDistance() - EARTH_RADIUS;
   }
   // @return satellite's altitude
   public double getAltitude(){
      return altitude;
   }
   
   // @return the ax
   public double getAx() {
      return (-getGravity())*getEarthMass()*(getX()/(Math.pow(getDistance(),3))); 
   }

   // @return the ay
   public double getAy() {
      return (-getGravity())*getEarthMass()*(getY()/(Math.pow(getDistance(),3)));
   }  
   // @return True if Salelite Crashed (Altitude is less then or equal to 0)
   public boolean isCrashed(){
      return (getAltitude() <= 0);
   }
   
   //redundant
   // @returns values of x, ,y ,vx, and vy in a string.
   /*
   @Override public String toString(){
      StringBuilder  result = new StringBuilder();
      String NEW_LINE = System.getProperty("line.separator");
      
      result.append("X Value: " + getX() + NEW_LINE);      
      result.append("Y Value: " + getY() + NEW_LINE);
      result.append("VX Value: " + getVx() + NEW_LINE);
      result.append("Vy Value: " + getVy() + NEW_LINE);
      return result.toString();
   }
   * */
}