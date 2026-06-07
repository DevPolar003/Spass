package dev.morgan.spass.service;

public final class PasswordStrengthService {

  private PasswordStrengthService() {
  }

  public static boolean isStrong(String password) {

    if (password.length() < 8) {
      return false;
    }

    boolean hasUpper = false;
    boolean hasDigit = false;
    boolean hasSpecial = false;

    for (int i = 0; i < password.length(); i++) {

      char c = password.charAt(i);

      if (Character.isUpperCase(c)) {
        hasUpper = true;
      } else if (Character.isDigit(c)) {
        hasDigit = true;
      } else if (!Character.isLetterOrDigit(c)) {
        hasSpecial = true;
      }
    }

    return hasUpper && hasDigit && hasSpecial;
  }
}
