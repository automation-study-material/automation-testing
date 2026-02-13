class HelloWorld {
    public static void main(String[] args) {
       String str = "A#B%C" ;
      //Input - A#B%C
      //Output - C#B%A
      char[]chArray=str.toCharArray();
      int i=0; int j=chArray.length-1;
      while(i<j){
          if(!Character.isAlphabetic(chArray[i])){
              ++i;
          }
          if(!Character.isAlphabetic(chArray[j])){
              --j;
          }
          char temp=chArray[i]; 
          chArray[i]=chArray[j];
          chArray[j]=temp;
          ++i;
          --j;
      }
      String revserse=String.valueOf(chArray);
    }
}
