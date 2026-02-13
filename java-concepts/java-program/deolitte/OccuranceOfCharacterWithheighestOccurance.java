import java.util.*;
class OccuranceOfCharacterWithheighestOccurance {
    public static void main(String[] args) {
        String str="hashedin";
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        
        Set <Character> keys=map.keySet();
        int count=0;
        for(Character k:keys){
            if (map.get(k)>count){
                count=map.get(k);
            }
        }
       for(Character k:keys){
            if (map.get(k)==count){
                 System.out.println("key :"+k+"|count:"+count);
                 break;
            }
        }
    }
}
