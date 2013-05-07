package edu.ucsb.cs56.projects.games.snake;
/*
 * The stop watch class will allow a program to start and stop a stopwatch as
 * well as return the stopwatch as a string, a total ms's, or the hour, min, and 
 * seconds separately.
 * 
 * The System.currentTimeMillis() returns the number of milliseconds since 
 * January 1, 1970
 * Complete the methods below:
 */

/* Sam Dowell
 * Period 2
 * 12/16/2011
 */

public class Stopwatch {

    private long myStarttime;    // in milliseconds
    private long myStoptime;
    private boolean isTiming;

    public Stopwatch() {
        myStarttime = 0;
        myStoptime = 0;
        isTiming = false;
    }

    public void start() {
        // starts the clock by getting system time
        myStarttime = System.currentTimeMillis();
        isTiming = true;
    }

    public void stop() {
        // stops the clock by getting the system time
        if (isTiming) {
            myStoptime = System.currentTimeMillis() - myStarttime;
            isTiming = false;
        }
    }
    public void unpause() {
        myStarttime = System.currentTimeMillis() - myStoptime;
        isTiming = true;
    }
    public int getHour() {
        // returns the hours of the current time (if not timing)
        if (!isTiming) {
            return (int) (myStoptime / 3600000);
        } else {
            return (int) (System.currentTimeMillis() - myStarttime) / 3600000;
        }
    }

    public int getMinutes() {
        // returns the minutes of the current time (if not timing)
        if (!isTiming) {
            return (int) (((System.currentTimeMillis() - myStarttime) % 3600000) / 60000);
        } else {
            return (int) (((System.currentTimeMillis() - myStarttime) % 3600000) / 60000);
        }
    }

    public int getSeconds() {
        // returns the seconds of the current time (if not timing)
        if (!isTiming) {
            return (int) (((System.currentTimeMillis() - myStarttime) % 60000) / 1000);
        } else {
            return (int) (((System.currentTimeMillis() - myStarttime) % 60000) / 1000);
        }
    }

    public int getMillis() {
        // returns the millis of the current time (if not timing)
        if (!isTiming) {
            return (int) ((System.currentTimeMillis() - myStarttime) % 1000);
        } else {
            return (int) ((System.currentTimeMillis() - myStarttime) % 1000);
        }
    }

    public String toString() {
        // returns a string of the time in hours:minutes:seconds.millis
        String seconds = "";
        String minutes = "";
        String hours = "";
        if (this.getSeconds() < 10){
        seconds = "0";
        }
        if (this.getMinutes() < 10){
            minutes = "0";
        }
        if (this.getHour() < 10){
            hours = "0";
        }
        return hours + this.getHour() + ":" + minutes + this.getMinutes() + ":" + seconds + this.getSeconds() /*+ "." + this.getMillis()*/;
    }
}
