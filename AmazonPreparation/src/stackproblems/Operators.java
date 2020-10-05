/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackproblems;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Operators {

    //valid supported operators
    static String operator[] = {"+", "-", "*", "/", "^"};

    public Operators(String[] operator) {
        //this.operator = operator;
    }

    public static boolean isOparetor(String op) {

        for (String s : operator) {
            if (s.equals(op)) {
                return true;
            }
        }
        return false;
    }

    public static int getOperatorPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

}
