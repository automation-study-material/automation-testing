public class StringWithCharacterAdd {
public static void main(String[] args) {
  String s="a4B2c1";
  // output :aaaaBBc
  String output="";
  for(int i=0;i<s.length();i++){
      char ch=s.charAt(i);
      if(Character.isLetter(ch)){
          int count=Character.getNumericValue(s.charAt(i+1));
          for(int j=0;j<count;j++){
                 output+=ch;
            }
       }  
    }
System.out.println(output);
}
}
