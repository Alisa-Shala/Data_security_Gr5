import. java.util.Scanner;
public class PlayfairCipher{
  private char [][] matrix=new char[5][5];

  public PlayfairCipher(String key)
  {
    //Hiqni cdo karakter pa shkronje nga celsi
    key=key.replaceAll("[^a-zA-Z]","").toUpperCase();

    //Incializo matricen
    int row=0,col=0;
    for(int i=0;i<key.length();i++(
      {
      char c=key.charAt(i);
      if(c=='J')
      {
        c='I';
      }
      if (!contains(c)){
        matrix[row][row]=c;
        col++;
        if (col==5){
row++;
          col=0;
        }}}
    
  
