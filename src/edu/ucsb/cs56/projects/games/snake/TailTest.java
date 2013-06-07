package edu.ucsb.cs56.projects.games.snake;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/** Test class for Tail
@author Sam Dowell
@version 05/08/2013
@see Tail
*/

public class TailTest {
    /** Test case for default constructor
	@see Tail
    */
    @Test
    public void test_DefaultConstructor(){
	Tail t = new Tail();
	assertEquals(50,t.getX());
	assertEquals(50,t.getY());
	assertEquals(15,t.getWidth());
	assertEquals(15,t.getHeight());
    }
    /** Test case for two arg constructor
	@see Tail
    */
    @Test
    public void test_TwoArgConstructor(){
	Tail t = new Tail(85, 46);
	assertEquals(85, t.getX());
	assertEquals(46, t.getY());
	assertEquals(15,t.getWidth());
	assertEquals(15, t.getHeight());
    }
    /** Test case for four arg constructor
	@see Tail
    */
    @Test
    public void test_FourArgConstructor(){
	Tail t = new Tail(115, 85, 25, 25);
	assertEquals(115,t.getX());
	assertEquals(85,t.getY());
	assertEquals(25, t.getWidth());
	assertEquals(25, t.getHeight());
    }
    /** Test case for setPos()
	@see Tail
    */
    @Test
    public void test_setPos(){
	Tail t = new Tail();
	t.setPos(42, 87);
	assertEquals(42, t.getX());
	assertEquals(87, t.getY());
    }
    /** Test case for getX()
	@see Tail
    */
    @Test
    public void test_getX(){
	Tail t = new Tail(54, 92, 20, 20);
	assertEquals(54, t.getX());

    }
    /** Test case for getY()
	@see Tail
    */
    @Test
    public void test_getY(){
	Tail t = new Tail (44, 63, 25, 25);
	assertEquals(63, t.getY());

    }
    /** Test case for getWidth()
	@see Tail
    */
    @Test
    public void test_getWidth(){
	Tail t = new Tail(35, 24, 18, 23);
	assertEquals(18, t.getWidth());
    }
    /** Test case for getHeight()
	@see Tail
    */
    @Test
    public void test_getHeight(){
	Tail t = new Tail(35, 24, 18, 23);
	assertEquals(23, t.getHeight());

    }


}
