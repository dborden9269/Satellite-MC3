/**
 *
 * @author Octavio Gutierrez
 */
public class SatelliteDriver {

    public static void main(String[] args) {
        //default values of Canada's Alouette I Satelite Launched in 1962
        Satellite dibit = new Satellite();
        dibit.setX(7392000);
        dibit.setY(0);
        dibit.setVx(0);
        dibit.setVy(7349);
        dibit.simulate(5);
        
        for (int x = 1; x < 115; x++) {
            dibit.simulate(x);
            System.out.println("Altitude: " + dibit.getAltitude()
                    + "\tx: " + dibit.getX()
                    + "\ty: " + dibit.getY()
                    + "\tvx: " + dibit.getVx()
                    + "\tvy: " + dibit.getVy());
            //ToDo: Need to simulate print outs every 60 seconds for time entered by user
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

