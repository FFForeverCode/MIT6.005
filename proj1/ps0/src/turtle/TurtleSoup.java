/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.util.List;
import java.util.ArrayList;


public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle     the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {

        for (int i = 0; i < 4; i++) {
            turtle.forward(sideLength);
            turtle.turn(90);
        }
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        return (sides - 2) * 180.0 / sides;
    }

    /**
     * Determine number of sides given the size of interior angles of a regular
     * polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see
     * java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {

        return (int) Math.ceil(360.0 / (180.0 - angle));
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to
     * draw.
     * 
     * @param turtle     the turtle context
     * @param sides      number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        double angle = calculateRegularPolygonAngle(sides);
        for (int i = 0; i < sides; i++) {
            turtle.forward(sideLength);
            turtle.turn(angle);
        }

    }

    /**
     * Given the current direction, current location, and a target location,
     * calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in
     * the direction of
     * the target point (targetX,targetY), given that the turtle is already at the
     * point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be
     * expressed in
     * degrees, where 0 <= angle < 360.
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX       current location x-coordinate
     * @param currentY       current location y-coordinate
     * @param targetX        target point x-coordinate
     * @param targetY        target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateHeadingToPoint(double currentHeading,
            int currentX, int currentY,
            int targetX, int targetY) {
        double res = calculateAngle(currentHeading, currentX, currentY, targetX, targetY);
        if (res < 0) {
            res = 360 + res;
        }
        return res;

    }
    /**
     * 获得转动的度数
     * 
     * 
     * @param currentHeading  海龟此时的方向角度
     * @param currentX 海龟此时的x
     * @param currentY 海龟此时的y
     * @param targetX 目标的x
     * @param targetY 目标的Y
     * @return 返回海龟指向目标时度数的改变 以顺时针为正数 逆时针为负数
     */
    public static double calculateAngle(double currentHeading,
    int currentX, int currentY,
    int targetX, int targetY){
        double res = 0.0;
        double X = targetX - currentX;
        double Y = targetY - currentY;
        double L_2 = Math.pow(X, 2) + Math.pow(Y, 2);
        double L = Math.sqrt(L_2);
        double _sin = X / L;
        _sin = Math.asin(_sin);
        double angle = Math.toDegrees(_sin);
        if (targetX >= 0 && targetY >= 0) {
            res = angle - currentHeading;
        } else if (targetX < 0 && targetY > 0) {
            angle = 360 + angle;
        } else {
            angle = 180 - angle;
        }
        return res=angle-currentHeading;

    }


    /**
     * Given a sequence of points, calculate the heading adjustments needed to get
     * from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0
     * degrees).
     * For each subsequent point, assumes that the turtle is still facing in the
     * direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of
     *         points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
        List<Double> res =new ArrayList<>();
        int size = xCoords.size();
        double  angle = 0.0;
        for(int i = 0;i < size-1;i++){
            double _angle = calculateHeadingToPoint(angle,xCoords.get(i)
            ,yCoords.get(i),xCoords.get(i+1),yCoords.get(i+1));
            res.add(_angle);
            angle = angle + _angle;
            int cnt = (int)Math.floor(angle/360);
            angle-=360*cnt;
        }
        return res;

    
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a
     * turtle. For this
     * function, draw something interesting; the complexity can be as little or as
     * much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
        turtle.color(PenColor.RED);
        List<Integer>X = new ArrayList<>();
        List<Integer>Y = new ArrayList<>();
        List<Integer>roads = new ArrayList<>();
        X.add(0);Y.add(0);
        X.add(140);Y.add(0);roads.add(140);
        X.add(140);Y.add(50);roads.add(50);
        X.add(180);Y.add(50);roads.add(40);
        X.add(180);Y.add(-100);roads.add(150);
        X.add(140);Y.add(-100);roads.add(40);
        X.add(140);Y.add(0);roads.add(50);
        X.add(0);Y.add(0);roads.add(140);
        X.add(0);Y.add(50);roads.add(50);
        List<Double>angles = calculateHeadings(X, Y);
        for(int i = 0;i<X.size()-1;i++){
            turtle.turn(angles.get(i));
            turtle.forward(roads.get(i));
        }

    }



    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        drawSquare(turtle, 40);
        drawPersonalArt(turtle);

        // draw the window
        turtle.draw();
    }

}
