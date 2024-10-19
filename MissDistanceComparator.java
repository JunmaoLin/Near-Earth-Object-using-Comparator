/**
 * This class compare the reference id of NearEarthObject
*/

import java.util.Comparator;
public class MissDistanceComparator implements java.util.Comparator<NearEarthObject> {
    public int compare(NearEarthObject o1, NearEarthObject o2) {
        if(o1.getMissDistance() > o2.getMissDistance()){
            return 1;
        }
        else if(o1.getMissDistance() == o2.getMissDistance()){
            return 0;
        }
        else return -1;
    }
}
