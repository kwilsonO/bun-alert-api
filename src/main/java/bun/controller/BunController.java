package bun.controller;

import bun.data.Store;
import bun.model.Bun;
import com.google.maps.GeoApiContext;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BunController {

    @Autowired
    private GeoApiContext geoApiContext;

    /**
     * the data store
     */
    @Autowired
    @Qualifier("memoryStore")
    private Store<Bun, LatLng> store;

    @RequestMapping("/healthz")
    public String healthz() {
        return "The bunnies are all healthy!";
    }

    @RequestMapping(value = "/bun", method = RequestMethod.POST)
    public ResponseEntity<String> addBunByAddress(@RequestBody Bun bun){

        store.add(bun);

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/bun", method = RequestMethod.GET)
    public List<Bun> getAllBuns(){
        return store.getAll();
    }
}
