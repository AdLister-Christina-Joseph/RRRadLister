package com.codeup.adlister.util;

import org.mindrot.jbcrypt.BCrypt;

public class Password {
    private static final int ROUNDS = 12;

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

    public static void main(String[] args) {
        String pw = "password"; //request.getParameter in the servlet
        System.out.println(Password.hash(pw));
        String hash = "$2a$12$mgWGm2O17W.qKTyamw5DS.HGYk6KPKOnq6.H1IDLd.z1YwB65KveG"; //store THIS in the db
        System.out.println(Password.check(pw, hash));

        System.out.println(Password.hash(pw));
        System.out.println(Password.hash(pw));
        System.out.println(Password.hash(pw)); //this will hash it 3 times, and is therefore different each time, so a salt is applied each time
    }
}
