package com.junitstringutility;

public class StringUtility {
    
    
    public boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }

   
    public String toUpperCase(String str) {
        return (str == null) ? null : str.toUpperCase();
    }
}
