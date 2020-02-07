package com.csstreamer.utils;

public class Messages {
	
	/* REPLACE SYSTEM.OUT.PRINTLN WITH METHOD THAT DISPLAY MESSAGE TO END USER */
	
    private static boolean validation = true;

    public static void addErrorMessage(String msg) {
    	System.out.println(msg);
    }

    public static void addErrorMessage(Exception ex, String defaultMsg) {
    	System.out.println(defaultMsg + " : " +  ex.getMessage());
    }

    public static void addSuccessMessage(String msg) {
    	System.out.println(msg);
    }

    public static void addShortSuccessMessage(String msg) {
    	System.out.println(msg);
    }

    public static boolean isValidation() {
        return validation;
    }

    public static boolean isValidationFailed(){
        return !validation;
    }

    public static void setValidation(boolean resultValidation){
        validation = resultValidation;
    }

}
