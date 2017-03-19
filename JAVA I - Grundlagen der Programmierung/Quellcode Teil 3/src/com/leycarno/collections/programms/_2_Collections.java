package com.leycarno.collections.programms;

import com.leycarno.collections.models.Car;

import java.util.*;

public class _2_Collections {

    public void run() {
        this.arrayListDemo();
        this.hashSetDemo();
        this.hashMapDemo();
        this.collectionConverterDemo();
    }

    /** ************************************************************
     * simple demo of the collection typ "list"
     */
    private void arrayListDemo() {
        ArrayList list = new ArrayList();	            // init the list
        // *** BONUS: "static initialisation": ***
        Car myCar = new Car() {{ setType("Opel"); setFuelMax(45); setFuel(3); }};   // create a cars...
        list.add(myCar);    // ...and add to the list
        list.add(myCar);    // .. twice!
        System.out.println("\nArrayList @Start:    " + list);

        int length = list.size();		    // returns the length of 2
        list.remove(0);			            // delete/removes the first car
        System.out.println("ArrayList @remove:   " + list);

        Car car = (Car) list.get(0);	    // the second car is now on the first position
        list.clear();				        // delete/remove all cars
        System.out.println("ArrayList @clear:    " + list);

        boolean empty = list.isEmpty();	    // true - all cars are destroyed
        System.out.println("ArrayList @isEmpty:  " + empty);
    }

    /** ************************************************************
     * simple demo of the collection typ "set"
     */
    private void hashSetDemo() {
        HashSet set = new HashSet();	// init the set
        // *** BONUS: "static initialisation": ***
        Car myCar = new Car() {{ setType("Opel"); setFuelMax(45); setFuel(3); }};   // create a cars...
        set.add(myCar);    // ...and add to the list
        set.add(myCar);    // .. twice? NO! The set knows the car already!!!
        System.out.println("\nHashSet @Start:         " + set);

        Car yourCar = new Car() {{ setType("Golf"); setFuelMax(64); setFuel(7); }};   // create ANOTHER cars...
        set.add(yourCar);    // ...and add to the list - new car, that works with the set...
        System.out.println("HashSet @add:           " + set); // ...but you will see, there is another order!


        int i = 0; // just for output...

        // how to loop a set with an iterator (works with a list too)
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Car currentCar = (Car) it.next();
            System.out.println("HashSet @iterator[" + i++ + "]:   " + currentCar);
        }
    }

    /** ************************************************************
     * simple demo of the collection typ "map"
     */
    private void hashMapDemo() {
        HashMap<String, Car> map;		    // init the map
        map = new HashMap <>();             // short version of "map = new HashMap <String, Car>();"

        map.put("Steffen", new Car());	    // new car with the key "Steffen"
        map.put("Lykka", new Car());		// new car with the key "Lykka"
        map.put("Lykka", new Car());		// Lykka got another car (destroys/overrides the old one)
        System.out.println("\nHashMap @Start:   " + map);

        // just for output...
        int i = 0;
        String[] carTypes = { "Golf", "Opel" };

        // the iterator of maps is a little different
        for (Map.Entry e : map.entrySet()) {
            String key = (String) e.getKey();		// access to the key
            Car currentCar = (Car) e.getValue();	// access to the value = the car

            // what are these cars? just fill with some interesting values
            map.get(key).setType(key + "'s " + carTypes[i++]);              // you can access the entry like this
            currentCar.setFuelMax((int)(30 + (float) Math.random() * 30));  // or use the given value in the loop
            currentCar.setFuel((int)(3 + (float) Math.random() * 3));
        }

        System.out.println("HashMap @end:     " + map);
    }

    /** ************************************************************
     * BONUS: demo for collection to array and verse vice...
     */
    private void collectionConverterDemo() {
        // IMPORTANT: the set needs to know the type of his values
        // therefore the expression:   HashSet<Car>   analog to the definition of a HashMaps
        HashSet<Car> set = new HashSet();

        // create two cars...
        Car car1 = new Car() {{ setType("Opel"); setFuelMax(45); setFuel(3); }};
        Car car2 = new Car() {{ setType("Golf"); setFuelMax(64); setFuel(7); }};
        set.add(car1);
        set.add(car2);
        System.out.println("\nConverter - HashSet @Start:   " + set);

        // make the set to an ordinary array
        Car[] array = set.toArray(new Car[set.size()]);
        System.out.println("Converter - HashSet @toArray: " + array);   // practical this is an array...

        // add all values of an array (back) to a set:
        HashSet backToSet = new HashSet<>();
        Collections.addAll(backToSet, array);
        System.out.println("Converter - HashSet @End:     " + backToSet);
    }
}
