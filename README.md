# Spass

Simple and fast password utility built in Java.

Generate secure passwords directly from the terminal and check password strength.

## Features

- Generate random secure passwords
- Check password strength
- Simple CLI interface
- Lightweight
- Built with Java + Maven

---

## Installation

### Clone the repository

```bash
git clone https://github.com/yourusername/spass.git
cd spass
```

### Build the project

```bash
mvn package
```

---

## Usage

### Generate password

```bash
java -jar target/spass-0.0.3.jar generate 32
```

Example:

```bash
spass generate 32
```

Output:

```text
A8x!kL2@pQ9#sT7$zW1%
```

---

### Check password strength

```bash
java -jar target/spass-0.0.3.jar check myPassword123
```

Output:

```text
Weak password.
```

or

```text
Strong password.
```

---


## Technologies

- Java 21
- Maven

---

## Project Structure

```text
src/
└── main/
    └── java/
        └── dev/
            └── morgan/
                └── spass/
                    ├── Main.java
                    ├── service/
                    └── ui/
```

---

## Future Ideas

- Copy password directly to clipboard
- Configurable character sets
- Password entropy calculation
- Save encrypted passwords
- Interactive terminal UI

---
