/**
 * This class named NeoDatabase which will contain and manage the NearEarthObject records which have been downloaded from the online dataset.
*/

import big.data.*;
import java.util.Date;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DecimalStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import big.data.DataSource;
public class NeoDatabase {
    public static final String API_KEY = null;
    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";
    ArrayList<NearEarthObject> nearEarthObjects;

    /**
     * This is the default constructor
     */
    public NeoDatabase(){
        nearEarthObjects = new ArrayList<NearEarthObject>();
    }

    /**
     * Builds a query URL given a page number.
     * @param pageNumber
     *  Integer ranging from 0 to 715 indicating the page the user wishes to load.
     * @return
     *  a string url
     * @throws IllegalArgumentException
     * If pageNumber is not in the valid range.
     */
    public String buildQueryURL(int pageNumber) throws IllegalArgumentException{
        if(pageNumber < 0 || pageNumber > 715){
            throw new IllegalArgumentException("pageNumber is not in the valid range.");
        }
        return (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY);
    }

    /**
     * Opens a connection to the data source indicated by queryURL and adds all NearEarthObjects found in the dataset.
     * @param queryURL
     * String containing the URL requesting a dataset from the NASA NeoW service
     * @throws IllegalArgumentException
     * If queryURL is null or cound not be resolved by the server.
     */
    public void addAll(String queryURL) throws IllegalArgumentException{
        if(queryURL == null){
            throw new IllegalArgumentException("queryURL is null");
        }
        DataSource ds = DataSource.connectJSON(queryURL);
        ds.load();
        try{
            NearEarthObject[] nearEarthObjectArr = ds.fetchArray(
                "NearEarthObject",
                "near_earth_objects/neo_reference_id",
                "near_earth_objects/name",
                "near_earth_objects/absolute_magnitude_h",
                "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min",
                "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max",
                "near_earth_objects/is_potentially_hazardous_asteroid",
                "near_earth_objects/close_approach_data/epoch_date_close_approach",
                "near_earth_objects/close_approach_data/miss_distance/kilometers",
                "near_earth_objects/close_approach_data/orbiting_body"
            );
            for(int i = 0; i < nearEarthObjectArr.length; i++){
                nearEarthObjects.add(nearEarthObjectArr[i]);
            }
        }catch(Exception e){
            throw new IllegalArgumentException("Could not be resolved by the server.");
        }
        
    }

    /**
     * Sorts the database using the specified Comparator of NearEarthObjects.
     * @param comp
     * Comparator of NearEarthObjects which will be used to sort the database.
     * @throws IllegalArgumentException
     * If comp is null.
     */
    public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException{
        if(comp == null){
            throw new IllegalArgumentException("comp is null");
        }
        Collections.sort(nearEarthObjects, comp);
    }

    /**
     * This method prints a table
     */
    public void printTable(){
        System.out.println("  ID   |           Name            | Mag. | Diameter | Danger | Close Date | Miss Dist | Orbits");
        System.out.println("================================================================================================");
        for(int i = 0; i < nearEarthObjects.size(); i++){
            NearEarthObject currentObj = nearEarthObjects.get(i);
            int id = currentObj.getReferenceID();
            String name = currentObj.getName();
            double mag = currentObj.getAbsoluteMagnitude();
            double diameter = currentObj.getAverageDiameter();
            boolean danger = currentObj.getIsDangerous();
            int month = currentObj.getClosestApproachDate().getMonth()+1;
            int date = currentObj.getClosestApproachDate().getDate();
            int year = Integer.parseInt(currentObj.getClosestApproachDate().toString().substring(currentObj.getClosestApproachDate().toString().length()-4));
            double decimals = new BigDecimal(currentObj.getMissDistance()).doubleValue();
            String missDis = "" + Math.round(decimals);
            String orbits = currentObj.getOrbitingBody();
            System.out.println(String.format("%-7s  %-26.26s  %-4.1f    %-4.3f     %-5s    %02d-%02d-%04d   %-8.8s    %-7s", id, name, mag, diameter, danger, month, date, year, missDis, orbits));
        }
    }
}
