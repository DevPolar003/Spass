package dev.morgan.spass.service;

import java.util.Random;

public final class PasswordGeneratorService {

  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";

  private PasswordGeneratorService() {
  }

  public static String generate(int length) {

    Random random = new Random();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < length; i++) {
      int index = random.nextInt(CHARACTERS.length());
      result.append(CHARACTERS.charAt(index));
    }

    return result.toString();
  }
}
