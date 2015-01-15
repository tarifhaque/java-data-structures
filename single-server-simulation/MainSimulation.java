/* * * * * * * * * * * * * * * * * * * * * 
 * A simulation of a single server system. 
 * 
 * Tarif Haque
 * Last revised 14 Jan 2015 
 * * * * * * * * * * * */

import java.util.*;


public class MainSimulation {

    private class Customer {
        double arrivalTime, departureTime, serveTime;;
    }

    double[] interarrivalTimes = {0.4, 1.2, 0.5, 1.7, 0.2,1.6, 0.2, 1.4, 1.9};
    double[] serviceTimes = {2.0, 0.7, 0.2, 1.1, 3.7, 0.6};

    Queue<Customer> customerQueue;

    /* System state variables */
    boolean serverStatus; // busy = true; idle = false
    int queueLength;   
    double simulationClock;

    public static void main(String[] args) {
      System.out.println("Hello simulation!");
    }

}
