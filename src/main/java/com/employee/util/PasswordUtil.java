
package com.employee.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // Password ko hash karna
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Entered password ko stored hash se verify karna
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
