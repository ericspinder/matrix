package dev.inward.matrix.datum.fact.operational;

import java.util.HashMap;

public class Bag<T> {
    private HashMap<T,Integer> map;

    public Bag(){
        this.map = new HashMap<T,Integer>();
    }

    /****
     * Method to add item x of type T to Bag
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
     * Method to get frequency of item x with type T in Bag
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
     * Method to get most frequent item x with type T in Bag
     * where x is not null and if more than one item is the most
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
            // frequent item
            Integer largestFrequency = new Integer(0);
            //Also initialise a variable to store the key with the largest frequency
            T largestKey = null;

            //Iterate through the keys in the bag/map
            for(T key : map.keySet()){
                //Store the current item frequency
                Integer currentFrequency = map.get(key);
                //If the current is greater than the largest
                if(currentFrequency > largestFrequency){
                    //Set the largest frequency to the current frequency
                    largestFrequency = currentFrequency;
                    //And set the largest key to the current key
                    largestKey = key;
                }
            }
            //Return the largest key
            return largestKey;
        }
    }
}
