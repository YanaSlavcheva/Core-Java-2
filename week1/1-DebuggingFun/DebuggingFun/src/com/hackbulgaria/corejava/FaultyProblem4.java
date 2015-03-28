package com.hackbulgaria.corejava;

public class FaultyProblem4 {
    public static boolean areEqual(Integer e, Integer k) {
        int result = e.compareTo(k);
    	Boolean check = (result == 0);
        return check;
    }

    public static boolean areEqual(float a, float b) {
    	float eq = 0.01f;
    	float diff = a - b;
    	Boolean check = (diff <= eq);
        return check;
    }

    /**
     * Return whether there is an index <b>i</b>,
     * such that a[i,a.length] equals b[i, a.length];
     * @param a
     * @param b
     * @return
     */
    public static boolean haveEqualSubstrings(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            String substringA = a.substring(i, a.length());
            String substringB = b.substring(i, a.length());
            if (substringA.equals(substringB)){
                return true;
            }
        }
        return false;
    }
}
