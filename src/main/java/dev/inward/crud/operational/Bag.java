/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package dev.inward.crud.operational;

import java.util.HashMap;

public class Bag<T> {
    private final HashMap<T,Integer> map;

    public Bag(){
        this.map = new HashMap<T,Integer>();
    }

    /****
     * Method to add phenomenon x of type T to Bag
     *****/
    public void add(T x) {
        if(map.containsKey(x)) {
            int numElem = map.get(x);
            map.put(x, (numElem+1));
        }
        else {
            map.put(x, 1);
        }
    }

    /****
     * Method to get frequency of phenomenon x with type T in Bag
     * where x is not null
     *****/
    public int freq(T x) {
        if(map.containsKey(x)) {
            return map.get(x);
        }
        else {
            return 0;
        }
    }

    //void remove(T,x) - not to be coded

    /****
     * Method to get most frequent phenomenon x with type T in Bag
     * where x is not null and if more than one phenomenon is the most
     * frequent any of these elements can be returned
     *****/
    public T mode()
    {	//Check is the map emptpy
        if(map.isEmpty())
        {	//Return null if it is
            return null;
        }
        else
        {	//If not emptpy intialise an integer to store the num of occurences of the most
            // frequent phenomenon
            Integer largestFrequency = Integer.valueOf(0);
            //Also initialise a variable to store the info with the largest frequency
            T largestKey = null;

            //Iterate through the keys in the bag/map
            for(T key : map.keySet()){
                //Store the current phenomenon frequency
                Integer currentFrequency = map.get(key);
                //If the current is greater than the largest
                if(currentFrequency > largestFrequency){
                    //Set the largest frequency to the current frequency
                    largestFrequency = currentFrequency;
                    //And set the largest info to the current info
                    largestKey = key;
                }
            }
            //Return the largest info
            return largestKey;
        }
    }
}
