/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipdesign;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Board {
    
    List<List<LocationOnBoard>> boradLocation;

    public Board() {
        
        boradLocation = new ArrayList<>();
        for(int i=0; i<10; i++)
        {
            List<LocationOnBoard> row = new ArrayList<>();
            for(int j=0; j<10; j++)
            {
                LocationOnBoard l = new LocationOnBoard(i, j);
                row.add(l);
            }
            this.boradLocation.add(row);
        }
    }
    
    public LocationOnBoard getBoardLoaction(int x, int y){
        return boradLocation.get(x).get(y);
    }
    
}
