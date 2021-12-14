///*
//package com.binod.encryptionanddecryption;
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//import java.io.IOException;
//
//public class Sample {
//
//    private static String encode(String str) throws IOException{
//        BASE64Encoder encoder = new BASE64Encoder();
//        str = new String(encoder.encodeBuffer(str.getBytes()));
//        return str;
//    }
//
//    private static String decode(String str) {
//        BASE64Decoder decoder = new BASE64Decoder();
//        try {
//            str = new String(decoder.decodeBuffer(str));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str;
//    }
//
//
//    public static void main(String[] args) throws IOException {
//
//            String plaintext = "xyw6k5sr8hpmk455";
//
//            System.out.println("Plain text:       " + plaintext);
//
//            String encrypted = encode(plaintext);
//            System.out.println("Encrypted String: " + encrypted);
//
//            String decrypted = decode(encrypted);
//            System.out.println("Decrypted String: " + decrypted);
//        }
//}*/
