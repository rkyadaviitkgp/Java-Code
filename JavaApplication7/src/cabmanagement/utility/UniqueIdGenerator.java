/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabmanagement.utility;

import java.util.UUID;

/**
 *
 * @author rajeshkumar.yadav
 */
public class UniqueIdGenerator {
    
    public static String generateUniqueId(){
        return UUID.randomUUID().toString();
    }
}
