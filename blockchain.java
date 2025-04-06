package abbu;

import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

class Block {
    public String name;
    public String password;
    public String previousHash;
    public String hash;

    public Block(String name, String password, String previousHash) {
        this.name = name;
        this.password = password;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        try {
            String input = previousHash + name + password;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPassword: " + password +
               "\nPrevious Hash: " + previousHash + "\nHash: " + hash;
    }
}

public class Helloworld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Block> blockchain = new ArrayList<>();

        // Genesis Block
        Block genesis = new Block("Genesis", "0000", "0");
        blockchain.add(genesis);

        // Input for additional blocks
        System.out.print("How many users do you want to add? ");
        int numUsers = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        Block previousBlock = genesis;

        for (int i = 1; i <= numUsers; i++) {
            System.out.println("Enter details for User " + i);
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            Block newBlock = new Block(name, password, previousBlock.hash);
            blockchain.add(newBlock);
            previousBlock = newBlock;
        }

        // Display blockchain
        System.out.println("\n=== Blockchain ===");
        for (int i = 0; i < blockchain.size(); i++) {
            System.out.println("Block " + i);
            System.out.println(blockchain.get(i));
            System.out.println("-----------------------------");
        }

        scanner.close();
    }
}
