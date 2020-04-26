package com.nriagudubem.learnings.ReversePolishNotation;

import javax.swing.tree.TreeNode;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {

    public double evalRPN(String[] tokens) {
        List<String> operators = initializeOperators();
        if (tokens.length < 3 || operators.contains(tokens[0])) {
            throw new IllegalArgumentException("invalid number of tokens/ operator cannot start the sequence");
        }

        Stack<Double> items = new Stack<>();
        for (String token : tokens) {
            if (!operators.contains(token)) {
                Double operand = Double.parseDouble(token);
                items.push(operand);
            } else {
                Double firstOperand;
                Double secondOperand;
                Double newOperand;
                switch (token) {
                    case "+":
                        firstOperand = items.pop();
                        secondOperand = items.pop();
                        newOperand = firstOperand + secondOperand;
                        items.push(newOperand);
                        break;
                    case "-":
                        firstOperand = items.pop();
                        secondOperand = items.pop();
                        newOperand = firstOperand - secondOperand;
                        items.push(newOperand);
                        break;
                    case "*":
                        System.out.println("am i here?");
                        firstOperand = items.pop();
                        secondOperand = items.pop();
                        newOperand = firstOperand * secondOperand;
                        items.push(newOperand);
                        break;
                    case "/":
                        firstOperand = items.pop();
                        secondOperand = items.pop();
                        newOperand = firstOperand / secondOperand;
                        items.push(newOperand);
                        break;
                    default:
                        throw new IllegalArgumentException("operand type not supported!");
                }
            }
        }
        System.out.println(items.size()+"size");
        return items.pop();
    }

    private List<String> initializeOperators() {
        List<String> operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        return operators;
    }
}
