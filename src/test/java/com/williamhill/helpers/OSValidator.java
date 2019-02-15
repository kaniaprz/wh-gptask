package com.williamhill.helpers;

public class OSValidator {

    /**
     * Helper which read load system properties and set operation system
     */

    private static String OS = System.getProperty("os.name").toLowerCase();

    public static String getOS() {
        if(isWindows()){
            System.out.println("Tests executed in " + OS);
            return "windows";
        }
        else if(isMac()){
            System.out.println("Tests executed in " + OS);
            return OS;
        }
        else if(isUnix()){
            System.out.println("Tests executed in " + OS);
            return OS;
        }
        return null;

    }

    private static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    private static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    private static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }
}
