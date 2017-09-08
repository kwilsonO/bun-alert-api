package bun.data;

import bun.model.Bun;
import com.google.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An in memory store which stores all the data in an array list. Provide a
 * different implementation if you want data persistence.
 *
 * @author ranjan github.com/MasonPD
 * @author kwilsono
 *
 */
public class MemoryStore implements Store<Bun, LatLng> {

    /**
     * logger
     */
    private static final Logger LOG = Logger.getLogger(MemoryStore.class.getName());

    /**
     * the list for storing data
     */
    private final List<Bun> data = new ArrayList<>();

    /**
     * get the shop nearest to a geocode
     */
    @Override
    public Bun get(LatLng geocode) {
        Bun nearestBun = findNearest(geocode);
        return nearestBun;
    }

    /**
     * get all the registered buns
     */
    @Override
    public List<Bun> getAll() {
        return data;
    }

    /**
     * register a Bun
     */
    @Override
    public Bun add(Bun item) {
        data.add(item);
        return item;
    }

    /**
     * Find the bun nearest to this geocode
     *
     * @param geocode
     * @return
     */
    public Bun findNearest(LatLng geocode) {
        // customer latitude and longitude
        double lat1 = geocode.lat;
        double lon1 = geocode.lng;
        // hold the nearest distance found till now
        double nearestDist = -1;
        // hold the reference to the nearest shop found till now
        Bun nearestBun = null;
        for (Bun bun : data) {
            // latitude and longitude of the shop to compare
            double lat2 = bun.getBunLatitude();
            double lon2 = bun.getBunLongitude();
            // distance to the shop in comparison
            double dist = Util.haversine(lat1, lon1, lat2, lon2);
            // if the shop in comparison is nearer than the previous shop or if
            // it is the first shop
            if (dist < nearestDist || nearestDist == -1) {
                nearestBun = bun;
                nearestDist = dist;
                LOG.log(Level.INFO, " Shop " + nearestBun.getBunName() + " found at " + nearestDist + " KM");
            }
        }
        return nearestBun;
    }
}
