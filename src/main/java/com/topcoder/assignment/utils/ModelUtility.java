/*
 * Copyright (C) Topcoder 2020. All Rights Reserved.
 */

package com.topcoder.assignment.utils;

import com.topcoder.assignment.model.Incoming;
import com.topcoder.assignment.model.Outgoing;
import java.util.Collections;
import java.util.List;

/**
 * @author Vinod
 * This will be the utility class that does the data transformation.
 */

public class ModelUtility {

    /**
     * This method will transform the Incoming data into Outgoing data as request.
     * @param incoming data to be transformed
     * @return outgoing data that has been transformed
     */
    public static Outgoing transform(Incoming incoming){
        Outgoing outgoing = new Outgoing();
        outgoing.setId(incoming.getId());
        outgoing.setFindDuplicates(findDuplicates(incoming.getFindDuplicates()));
        outgoing.setWhiteSpacesGalore(removeSpaceWithoutReplace(incoming.getWhiteSpacesGalore()));
        outgoing.setValidateMeOnlyIActuallyShouldBeABoolean(incoming.getValidateMeOnlyIActuallyShouldBeABoolean());
        outgoing.setNumbersMeetNumbers(incoming.getNumbersMeetNumbers());
        outgoing.setLargestNumbersMeetNumbers(getLargestNumber(incoming.getNumbersMeetNumbers()));
        return outgoing;
    }

    /**
     * This method will get the largest number in the given List
     * @param numbersMeetNumbers List of numbers
     * @return largest number
     */
    private static Integer getLargestNumber(List<Integer> numbersMeetNumbers){
        return Collections.max(numbersMeetNumbers);
    }

    /**
     * This method will remove the spaces in the given string.
     * As request this method is not using the Replace() method.
     * @param input String that needs to be transformed
     * @return String that has been trimmed of the White spaces
     */
    private static String removeSpaceWithoutReplace(String input){
        StringBuilder result = new StringBuilder();
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
        }
        return result.toString();
    }

    /**
     * This method will find all the characters that is repeating in the given String
     * @param input String that needs to be transformed
     * @return String that has the characters that are repeating in the given input String
     */
    private static String findDuplicates(String input){
        StringBuilder result = new StringBuilder();
        while (input.length() > 0) {
            int initialLength = input.length();
            char ch = input.charAt(0);
            input = input.replace(ch + "","");
            if(initialLength - input.length() > 1){
                result.append(ch);
            }
        }
        return result.toString();
    }
}
