/**
 * This class sorts NearEarthObjects by their diameters
*/

import java.util.Comparator;
public class DiameterComparator implements java.util.Comparator<NearEarthObject> {
    public int compare(NearEarthObject o1, NearEarthObject o2) {
        if(o1.getAverageDiameter() > o2.getAverageDiameter()){
            return 1;
        }else if(o1.getAverageDiameter() == o2.getAverageDiameter()){
            return 0;
        }
        return -1;
    }
}
