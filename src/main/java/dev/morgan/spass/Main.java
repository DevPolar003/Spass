package dev.morgan.spass;

import dev.morgan.spass.service.PasswordGeneratorService;
import dev.morgan.spass.service.PasswordStrengthService;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(
    name = "spass",
    mixinStandardHelpOptions = true,
    version = "spass 0.0.3",
    description = "Simple password utility.",
    subcommands = {
        Main.GenerateCommand.class,
        Main.CheckCommand.class
    }
)
public class Main implements Runnable {

  public static void main(String[] args) {

    int exitCode = new CommandLine(new Main())
        .execute(args);

    System.exit(exitCode);
  }

  @Override
  public void run() {
    System.out.println("Use --help for usage.");
  }

  @Command(
      name = "generate",
      description = "Generate a secure password."
  )
  static class GenerateCommand implements Runnable {

    @Parameters(index = "0",
        description = "Password length")
    int length;

    @Override
    public void run() {

      String password =
          PasswordGeneratorService.generate(length);

      System.out.println(password);
    }
  }

  @Command(
      name = "check",
      description = "Check password strength."
  )
  static class CheckCommand implements Runnable {

    @Parameters(index = "0",
        description = "Password to validate")
    String password;

    @Override
    public void run() {

      boolean strong =
          PasswordStrengthService.isStrong(password);

      if (strong) {
        System.out.println("Strong password.");
      } else {
        System.out.println("Weak password.");
      }
    }
  }
}