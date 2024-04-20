import. java.util.Scanner;
public class PlayfairCipher{
  private char [][] matrix=new char[5][5];

  public PlayfairCipher(String key)
  {
    //Hiqni cdo karakter pa shkronje nga celsi
    key=key.replaceAll("[^a-zA-Z]","").toUpperCase();

    //Incializo matricen
    int row=0,col=0;
    for(int i=0;i<key.length();i++)
      {
      char c=key.charAt(i);
      if(c=='J')
      {
        c='I';  //Zvendesoje J me I
      }
      if (!contains(c)){
        matrix[row][row]=c;
        col++;
        if (col==5){
row++;
          col=0;
        }
      }
    }
    //Mbushe pjesen e tjeter te matrices me shkronjat e mbetuar te alfabetit por jo te perseritura
    char currentchar='A';
    for(int i = row;i<5;i++)
      {
        for(int j=col;j<5;j++)
          {
            while (key.indexOf(currentChar) !=-1 ||  currentChar=='J')
              {
currentChar++;
              }
            matrix[i][j] = currentChar;
            currentChar++;
          }
      col =0;
      }
  }
    private boolean contains(char c)
      {
      for(int row=0; row<5; row++){
      for(int col=0; col<5 ;col++)
        {
          if(matrix [row][col] == c)
          {
            return true;
          }
        } 
    } 
        return false;}

  public String encrypt (String plaintext){  
    //hiqi krej karakteret e panevojeshme dhe konvertoji shkronjat ne Uppercase
    palintext=plain.text.replaceAll("[^a-zA-Z]","").toUpperCase();
    
  
    // Shtoni një X midis shkronjave të njëpasnjëshme identike nëse është e nevojshme
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
  
  // Enkriptoni çiftet e shkronjave duke përdorur matricën
   // Enkriptoni çiftet e shkronjave duke përdorur matricën
        StringBuilder ciphertext = new StringBuilder();
          for (int i = 0; i < sb.length(); i += 2) {
              char a = sb.charAt(i);
              char b = sb.charAt(i + 1);
              int row1 = -1, col1 = -1, row2 = -1, col2 = -1;
              for (int row = 0; row < 5; row++) {
                  for (int col = 0; col < 5; col++) {
                      if (array[row][col] == a) {
                          row1 = row;
                          col1 = col;
                      } else if (array[row][col] == b) {
                          row2 = row;
                          col2 = col;
                      }
                  }
              }
              if (row1 == row2) {
                  // I njëjti rresht
                  ciphertext.append(matrix[row1][(col1 + 1) % 5]);
                  ciphertext.append(matrix[row2][(col2 + 1) % 5]);
              } else if (col1 == col2) {
                  //  E njëjta kolonë
                  ciphertext.append(matrix[(row 1 + 1) % 5][col1]);
                  ciphertext.append(matrix[(row2 + 1) % 5][col2]);
              } other {
                  // Drejtkëndësh
                  ciphertext.append(matrix[row1][col2]);
                  ciphertext.append(matrix[row2][col1]);
              }
          }

          return encodedText.toString();
      }

   public String decrypt(String ciphertext) {
        // Largoj karakterat e panevojshem dhe konvertoj ne uppercase
        ciphertext = ciphertext.replaceAll("[^a-zA-Z]", "").toUpperCase();

        // Dekripto letter pairs duke perdorur matricen
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
                // rreshti i njejte
                plaintext.append(matrix[row1][(col1 + 4) % 5]);
                plaintext.append(matrix[row2][(col2 + 4) % 5]);
            } else if (col1 == col2) {
                // kolona e njejte
                plaintext.append(matrix[(row1 + 4) % 5][col1]);
                plaintext.append(matrix[(row2 + 4) % 5][col2]);
            } else {
                // Rectangle
                plaintext.append(matrix[row1][col2]);
                plaintext.append(matrix[row2][col1]);
            }
        }

        return plaintext.toString();
    }
  
public static void main(String[]args){
  Scanner scanner = new Scanner(System.in);
  System.out.print("Enter the key: ");
  String plaintext = scanner.nextLine();

  //Enkriptimi
  PlayfairCipher encryptCipher = new PlayfairCipher(key);
  String ciphertext = encryptCipher.encrypt(plaintext);
  System.out.printl("Ciphertext: " + ciphertext);

  // Shfaq matricën kryesore
  System.out.printl("\nKey Square:")
    encryptCipher.displayMatrix();

  //Dekriptimi
  PlayfairCipher decryptCipher = new PlayfairCipher(key);
  String decryptedPlaintext = decryptCipher.decrypt(ciphertext);
    System.out.printl("Decrypted plaintext: " + decryptedPlaintext);
 
  
}
    
      
    
  
