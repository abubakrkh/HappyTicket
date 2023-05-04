package com.example.myapplication;

public class Algorithm {
    public boolean isHappyTicket(String input) {
        int inputInt = Integer.parseInt(input);

        int s1 = 0, s2 = 0, del = 100000;
        for (int i = 0; i < 6; i++) {
            if ((inputInt / del) % 2 == 0) {
                s1 = s1 + inputInt / del % 10;
                del = del / 10;
            } else {
                s2 = s2 + inputInt / del % 10;
                del = del / 10;
            }
        }
        return s1 == s2;
    }

    public int nextHappyTicket(String input) {
        int inputInt = Integer.parseInt(input);
        int count = 0;
        while (!isHappyTicket(Integer.toString(inputInt))) {
            inputInt++;
            count++;
        }
        return inputInt;
    }
}
