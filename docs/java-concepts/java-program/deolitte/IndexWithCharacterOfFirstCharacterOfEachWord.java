public class IndexWithCharacterOfFirstCharacterOfEachWord{
  public static void main(String[] args) {
        String str="i love my work";
        String [] arr=str.split(" ");
        for(int i=0;i<arr.length;i++){
            String str1=arr[i];
            char ch=str1.charAt(0);
            int index=str.indexOf(ch);
            System.out.println("character :"+ch+"|| Index :"+index);
        }
    }
}

/*
OUTPUT:-
character :i|| Index :0
character :l|| Index :2
character :m|| Index :7
character :w|| Index :10
*/
