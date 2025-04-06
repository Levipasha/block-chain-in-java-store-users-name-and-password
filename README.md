# 🔐 Simple Blockchain User Registry in Java

This project demonstrates a basic blockchain implementation in Java where user credentials (name and password) are stored in blocks linked via cryptographic hashes.

## 🛠️ Features

- Custom `Block` class with:
  - Name
  - Password
  - Previous Hash
  - SHA-256 Hash of the block data
- Genesis block initialization
- Dynamic user input to add blocks
- Chain integrity via hash linking
- SHA-256 hashing using `MessageDigest`
- Display of entire blockchain in a readable format

## 🧱 How Blockchain Works Here

Each new user creates a block. That block:
1. Stores the user's `name` and `password`.
2. Inherits the `hash` of the previous block.
3. Generates its own `hash` using SHA-256 on combined data.

This ensures tampering with one block breaks the chain — demonstrating the power of blockchain.

## 🚀 Getting Started

### Prerequisites
- Java installed (JDK 8 or above)
- Any Java IDE (e.g., IntelliJ IDEA, Eclipse) or terminal

### Run the Project

```bash
# Compile
javac Helloworld.java

# Run
java abbu.Helloworld
How many users do you want to add? 2
Enter details for User 1
Name: Alice
Password: 1234
Enter details for User 2
Name: Bob
Password: abcd

=== Blockchain ===
Block 0
Name: Genesis
Password: 0000
Previous Hash: 0
Hash: <some hash>

Block 1
Name: Alice
Password: 1234
Previous Hash: <Genesis hash>
Hash: <some hash>

Block 2
Name: Bob
Password: abcd
Previous Hash: <Alice's hash>
Hash: <some hash>
✅ Future Improvements
Password hashing with salt for better security

Chain validation check to detect tampering

Timestamp for each block

File I/O to persist the blockchain

GUI interface or web version

👨‍💻 Author
Name: Abbu

Project Type: Educational / Practice

Language Used: Java

