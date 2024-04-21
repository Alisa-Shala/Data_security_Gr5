import java.util.Scanner;

public class PlayfairCipher {
    private char[][] matrix = new char[5][5];

    public PlayfairCipher(String key) {
        // largo karakteret e pa nevojshem dhe kthej ne uppercase
        key = key.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // Initialize the matrix
        int row = 0, col = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == 'J') {
                c = 'I';  // zevendeso J me I
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

        // Mbushe matricen me karakterat e mbetur
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

    public String encrypt(String plaintext) {
        // Heki char e panevojshem
        plaintext = plaintext.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // Nese mbet veq ni shkronj shtoje si X
        StringBuilder sb = new StringBuilder();
        sb.append(plaintext.charAt(0));
        for (int i = 1; i < plaintext.length(); i++) {
            char prev = sb.charAt(sb.length() - 1);
            char curr = plaintext.charAt(i);
            if (prev == curr) {
                sb.append('X');
            }
            sb.append(curr);
        }
        if (sb.length() % 2 != 0) {
            sb.append('X');
        }

        // Encrypt shkronjat si cift (dy nga dy)
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < sb.length(); i += 2) {
            char a = sb.charAt(i);
            char b = sb.charAt(i + 1);
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
                // nese gjenden ne rresht te njejte
                ciphertext.append(matrix[row1][(col1 + 1) % 5]);
                ciphertext.append(matrix[row2][(col2 + 1) % 5]);
            } else if (col1 == col2) {
                // nese gjenden ne kolon te njejte
                ciphertext.append(matrix[(row1 + 1) % 5][col1]);
                ciphertext.append(matrix[(row2 + 1) % 5][col2]);
            } else {
                // nese formojne katerkendesh
                ciphertext.append(matrix[row1][col2]);
                ciphertext.append(matrix[row2][col1]);
            }
        }

        return ciphertext.toString();
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

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        
        PlayfairCipher encryptCipher = new PlayfairCipher(key);
        String ciphertext = encryptCipher.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);

        
        System.out.println("\nKey Square:");
        encryptCipher.displayMatrix();
    }
}
    
      
    
  
