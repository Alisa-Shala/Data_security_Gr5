import java.util.Scanner;

public class PlayfairCipher {
    private char[][] matrix = new char[5][5];

    public PlayfairCipher(String key) {
        // Largoj karakterat e panevojshem dhe kthej ne uppercase
        key = key.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // Inicializimi i matrices
        int row = 0, col = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == 'J') {
                c = 'I';  // Zevendeso  J me I
            }
            if (!contains(c)) {
                matrix[row][col] = c;
                col++;
                if (col == 5) {
                    row++;
                    col = 0;
                }
            }
        }

        // Mbushe matricen me shkronjat e mbetura te alfabetit
        char currentChar = 'A';
        for (int i = row; i < 5; i++) {
            for (int j = col; j < 5; j++) {
                while (key.indexOf(currentChar) != -1 || currentChar == 'J') {
                    currentChar++;
                }
                matrix[i][j] = currentChar;
                currentChar++;
            }
            col = 0;
        }
    }

    private boolean contains(char c) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (matrix[row][col] == c) {
                    return true;
                }
            }
        }
        return false;
    }
    public String decrypt(String ciphertext) {
        //Largoj char e panevojshem
        ciphertext = ciphertext.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // Decrypt shkronjat qift dy nga dy
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i += 2) {
            char a = ciphertext.charAt(i);
            char b = ciphertext.charAt(i + 1);
            int row1 = -1, col1 = -1, row2 = -1, col2 = -1;
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (matrix[row][col] == a) {
                        row1 = row;
                        col1 = col;
                    } else if (matrix[row][col] == b) {
                        row2 = row;
                        col2 = col;
                    }
                }
            }
            if (row1 == row2) {
                // nese ndodhen ne same row
                plaintext.append(matrix[row1][(col1 + 4) % 5]);
                plaintext.append(matrix[row2][(col2 + 4) % 5]);
            } else if (col1 == col2) {
                // nese ndodhen ne kolonen e njejt
                plaintext.append(matrix[(row1 + 4) % 5][col1]);
                plaintext.append(matrix[(row2 + 4) % 5][col2]);
            } else {
                // nese formojne katerkendesh
                plaintext.append(matrix[row1][col2]);
                plaintext.append(matrix[row2][col1]);
            }
        }

        return plaintext.toString();
    }

    public void displayMatrix() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the key: ");
        String key = scanner.nextLine();

        
        System.out.println("\nKey Square:");
        PlayfairCipher encryptCipher = new PlayfairCipher(key);
        encryptCipher.displayMatrix();

        System.out.print("Enter the ciphertext: ");
        String ciphertext = scanner.nextLine();

        
        PlayfairCipher decryptCipher = new PlayfairCipher(key);
        String decryptedPlaintext = decryptCipher.decrypt(ciphertext);
        System.out.println("Decrypted plaintext: " + decryptedPlaintext);
    }
}
