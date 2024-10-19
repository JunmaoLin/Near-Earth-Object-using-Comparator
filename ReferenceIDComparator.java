/**
 * This class compare the reference id of NearEarthObject
*/

import java.util.Comparator;

public class ReferenceIDComparator implements Comparator<NearEarthObject>{
    public int compare(NearEarthObject o1, NearEarthObject o2) {
        if(o1.getReferenceID() > o2.getReferenceID()){
            return -1;
        }else if(o1.getReferenceID() == o2.getReferenceID()){
            return 0;
        }
        return 1;
    }
}