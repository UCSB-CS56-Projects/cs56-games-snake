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
 * 12/16/2011
 */

public class Stopwatch {

    private long myStarttime;    // in milliseconds
    private long myStoptime;
    private boolean isTiming;
    /**
	Constructor
    */
    public Stopwatch() {
        myStarttime = 0;
        myStoptime = 0;
        isTiming = false;
    }
    /**
	Start the stopwatch
    */
    public void start() {
        // starts the clock by getting system time
        myStarttime = System.currentTimeMillis();
        isTiming = true;
    }
    /**
	pause the stopwatch
    */
    public void stop() {
        // stops the clock by getting the system time
        if (isTiming) {
            myStoptime = System.currentTimeMillis() - myStarttime;
            isTiming = false;
        }
    }
    /** 
	Resume the stopwatch from where it was last paused
    */
    public void unpause() {
        myStarttime = System.currentTimeMillis() - myStoptime;
        isTiming = true;
    }
    /**
	@return number of hours of current stopwatch if timing, otherwise returns hours in last recorded time
    */
    public int getHour() {
        // returns the hours of the current time (if not timing)
        if (!isTiming) {
            return (int) (myStoptime / 3600000);
        } else {
            return (int) (System.currentTimeMillis() - myStarttime) / 3600000;
        }
    }
    /**
	@return number of minutes in current stopwatch time
    */
    public int getMinutes() {
        // returns the minutes of the current time (if not timing)
        if (!isTiming) {
            return (int) (((System.currentTimeMillis() - myStarttime) % 3600000) / 60000);
        } else {
            return (int) (((System.currentTimeMillis() - myStarttime) % 3600000) / 60000);
        }
    }
    /** 
	@return number of seconds in current stopwatch time
    */
    public int getSeconds() {
        // returns the seconds of the current time (if not timing)
        if (!isTiming) {
            return (int) (((System.currentTimeMillis() - myStarttime) % 60000) / 1000);
        } else {
            return (int) (((System.currentTimeMillis() - myStarttime) % 60000) / 1000);
        }
    }
    /** 
	@return number of milliseconds in current stopwatch time
    */
    public int getMillis() {
        // returns the millis of the current time (if not timing)
        if (!isTiming) {
            return (int) ((System.currentTimeMillis() - myStarttime) % 1000);
        } else {
            return (int) ((System.currentTimeMillis() - myStarttime) % 1000);
        }
    }
    /**
	@return formatted string of current time in form hours:minutes:seconds.millis
    */
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
