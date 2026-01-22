
import java.util.Scanner;
import java.util.Random; 

public class ValidateurCLI {

    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        boolean continuer = true;

        String logo = """
              _____                      
             / ____|                     
            | (___  _ __   __ _ ___ ___  
             \\___ \\| '_ \\ / _` / __/ __| 
             ____) | |_) | (_| \\__ \\__ \\ 
            |_____/| .__/ \\__,_|___/___/ 
                   | |                   
                   |_|                   
        """;

        System.out.println(logo);
        System.out.println("=== BIENVENUE AU SYSTÈME DE SÉCURITÉ ===");

        while (continuer) {
            System.out.println("\nOptions:");
            System.out.println("1. Valider un nouveau mot de passe");
            System.out.println("2. Créer un nouveau mot de passe (Gerar)");
            System.out.println("3. Quitter le programme");
            System.out.print("Choisissez une option: ");

            int choix = lecteur.nextInt();
            lecteur.nextLine();

            if (choix == 1) {
                System.out.print("Entrez votre mot de passe: ");
                String motDePasse = lecteur.nextLine();

                if (estFort(motDePasse)) {
                    System.out.println("RÉSULTAT: Mot de passe FORT ! ✅");
                } else {
                    System.out.println("RÉSULTAT: Mot de passe FAIBLE... ❌");
                    System.out.println("Conseil: Utilisez 8 caractères, des majuscules, chiffres et spéciaux.");
                }
            } 
            else if (choix == 2) {
                System.out.print("Longueur de la senha (tamanho): ");
                int taille = lecteur.nextInt();
                String novaSenha = genererMdp(taille);
                System.out.println("NOUVEAU MOT DE PASSE: " + novaSenha);
            } 
            else if (choix == 3) {
                continuer = false;
                System.out.println("Au revoir !");
            } 
            else {
                System.out.println("Option invalide, réessayez.");
            }
        }
        lecteur.close();
    }

    
    public static String genererMdp(int tamanho) {
        Random random = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        String resultado = "";
        
        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(caracteres.length());
            resultado += caracteres.charAt(indice);
        }
        return resultado;
    }

    public static boolean estFort(String mdp) {
        if (mdp.length() < 8) return false;

        boolean aMajuscule = false;
        boolean aChiffre = false;
        boolean aSpecial = false;

        for (int i = 0; i < mdp.length(); i++) {
            char c = mdp.charAt(i);
            if (Character.isUpperCase(c)) aMajuscule = true;
            else if (Character.isDigit(c)) aChiffre = true;
            else if (!Character.isLetterOrDigit(c)) aSpecial = true;
        }
        return aMajuscule && aChiffre && aSpecial;
    }
}