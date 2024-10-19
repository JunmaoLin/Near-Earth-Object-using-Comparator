import java.util.Date;

/**
 * This class represents a record in the database of asteroids currently tracked by NASA.
*/

public class NearEarthObject{
    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;

    /**
     * Default Constructor.
     * @param referenceID
     * Unique the ID of the NEO.
     * @param name
     * Unique name of the asteroid or orbital body.
     * @param absoluteMagnitude
     * Absolute brightness of the asteroid or orbital body in the sky.
     * @param minDiameter
     * Estimated minimum diameter of the asteroid or orbital body in kilometers. 
     * @param maxDiameter
     * Estimated maximum diameter of the asteroid or orbital body in kilometers.
     * @param isDangerous
     * Boolean value indicating whether the astroid or orbital body is a potential impact threat.
     * @param closestDateTimestamp
     * Unix timestamp representing the date of closest approach.
     * @param missDistance
     * Distance in kilometers at which the asteroid or orbital body will pass by the Earth on the date of it's closest approach.
     * @param orbitingBody
     * Planet or other orbital body which this NEO orbits.
     */
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter, double maxDiameter, boolean isDangerous, long closestDateTimestamp, double missDistance, String orbitingBody){
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.averageDiameter = (maxDiameter + minDiameter)/2;
        this.isDangerous = isDangerous;
        this.closestApproachDate = new Date(closestDateTimestamp);
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
    }

    /**
     * This is the setter method for referenceID
     * @param referenceID
     *  an int
     */
    public void setReferenceID(int referenceID){
        this.referenceID = referenceID;
    }

    /**
     * This is the setter method for name.
     * @param name
     *  A string 
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * This is the setter method for absoluteMagnitude
     * @param absoluteMagnitude
     *  A double 
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude){
        this.absoluteMagnitude = absoluteMagnitude;
    }

    /**
     * This is the setter method for averageDiameter
     * @param averageDiameter
     * a double
     */
    public void setAverageDiameter(double averageDiameter){
        this.averageDiameter = averageDiameter;
    }

    /**
     * This is the setter method for isDangerous
     * @param isDangerous
     * a boolean
     */
    public void setIsDangerous(boolean isDangerous){
        this.isDangerous = isDangerous;
    }


    /**
     * This is the setter method for closestApproachDate
     * @param closestApproachDate
     *  a Date
     */
    public void setClosestApproachDate(Date closestApproachDate){
        this.closestApproachDate = closestApproachDate;
    }

    /**
     * This is the setter method for missDistance
     * @param missDistance
     *  A double 
     */
    public void setMissDistance(double missDistance){
        this.missDistance = missDistance;
    }

    /**
     * This is the setter method for orbitingBody
     * @param orbitingBody
     *  a String
     */
    public void setOrbitingBody(String orbitingBody){
        this.orbitingBody = orbitingBody;
    }

    /**
     * This is the getter for referenceID
     * @return
     *  an int
     */
    public int getReferenceID(){
        return this.referenceID;
    }

    /**
     * This is the setter for name
     * @return
     *  a String
     */
    public String getName(){
        return this.name;
    }

    /**
     * This is the getter for absoluteMagnitude
     * @return
     *  a double
     */
    public double getAbsoluteMagnitude(){
        return this.absoluteMagnitude;
    }

    /**
     * This is the getter for averageDiameter
     * @return
     *  a double 
     */
    public double getAverageDiameter(){
        return this.averageDiameter;
    }

    /**
     * This is the getter for isDangerous
     * @return
     *  a boolean 
     */
    public boolean getIsDangerous(){
        return this.isDangerous;
    }

    /**
     * This is the getter for closestApproachDate
     * @return
     *  a Date 
     */
    public Date getClosestApproachDate(){
        return this.closestApproachDate;
    }

    /**
     * This is the getter for missDistance
     * @return
     *  a double 
     */
    public double getMissDistance(){
        return this.missDistance;
    }

    /**
     * This is the getter for orbitingBody
     * @return
     *  a String 
     */
    public String getOrbitingBody(){
        return this.orbitingBody;
    }
}