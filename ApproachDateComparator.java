/**
 * This class sorts NearEarthObjects by their approach date
*/

import java.util.Comparator;
public class ApproachDateComparator implements java.util.Comparator<NearEarthObject> {
    public int compare(NearEarthObject o1, NearEarthObject o2) {
        return o1.getClosestApproachDate().compareTo(o2.getClosestApproachDate());
    }
}