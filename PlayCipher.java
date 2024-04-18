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
    
  
    
  
    
      
    
  
