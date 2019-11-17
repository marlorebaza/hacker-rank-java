package com.marlo.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5_SHA256 {
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner s = new Scanner(System.in);
		String algorithm = s.nextLine();
		String value = s.nextLine();
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hash = digest.digest(value.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        System.out.println(sb.toString());
        s.close();
	}

}
