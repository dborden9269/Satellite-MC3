/**
 *
 * @author Octavio Gutierrez
 */
public class Satellite {
    
    private static final double EARTH_MASS = 5.97 *(Math.pow(10, 24));
    private static final double GRAVITY = 6.67 *(Math.pow(10, -11));
    private double distance;
    private double ax;
    private double ay;
    private double x;
    private double y;
    private double vx;
    private double vy;
    
    /**
     * @return the EARTH_MASS
     */
    public static double getEarthMass() {
        return EARTH_MASS;
    }

    /**
     * @return the GRAVITY
     */
    public static double getGravity() {
        return GRAVITY;
    }

    public Satellite() {
       
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the vx
     */
    public double getVx() {
        return vx;
    }

    /**
     * @param vx the vx to set
     */
    public void setVx(double vx) {
        this.vx = vx;
    }

    /**
     * @return the vy
     */
    public double getVy() {
        return vy;
    }

    /**
     * @param vy the vy to set
     */
    public void setVy(double vy) {
        this.vy = vy;
    }
    
    public void setTime(int t){
        setX(getX() + (getVx()*t));
        setY(getY() + (getVy()*t));
        setVx(getVx() + (getAx()*t));
        setVy(getVy() + (getAy()*t));
    }

    /**
     * @return the distance
     */
    public double getDistance() {
        return (Math.sqrt(Math.pow(getX() , 2)+ Math.pow(getY() , 2)));
    }

    /**
     * @return the ax
     */
    public double getAx() {
        return (-getGravity())*getEarthMass()*(getX()/(Math.pow(getDistance(),3)));
    }

    /**
     * @return the ay
     */
    public double getAy() {
        return (-getGravity())*getEarthMass()*(getY()/(Math.pow(getDistance(),3)));
    }
    
    
    
}
