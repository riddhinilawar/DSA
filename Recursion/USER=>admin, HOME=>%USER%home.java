// "static void main" must be defined in a public class.

/*
Given map {X=>123, Y=456}
Input: %X%_%Y%
Output: 123_456
Given map {USER=>admin, HOME=>/%USER%/home} Input: I am %USER% My home is %HOME% Output: I am admin My home is /admin/home
USER= bob
HOME= /home/%USER% should be substituted as : /home/bob ex2:
home/ %USER% -> /home/bob
Hello %USER% -> Hello bob!
ex3:
The user %USER% is at 50%% -> The user bob is at 50%
*/
public class Main {
    public static void main(String[] args) {
        
        HashMap<String,String> map = new HashMap<>();
        map.put("USER","admin");
        map.put("HOME","/%USER%/home");
        
        String inpStr=" I am %USER% My home is %HOME%";
        
        for(String keyMap:map.keySet()){
            String str=map.get(keyMap);
            map.put(keyMap,helper(keyMap,map));
        }
        
        StringBuilder sb = new StringBuilder();
        String arr[]=inpStr.split("%");
        
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" "+arr[i].length());
            // if(i==0 || i==arr.length-1){
            //     sb.append(arr[i]);
            // }
            if(map.containsKey(arr[i])){
                sb.append(map.get(arr[i]));
            }
            else{
                sb.append(arr[i]);
            }
        }
        
        System.out.println(sb.toString()+" "+map);
        
    }
    public static String helper(String key,HashMap<String,String> map){
            System.out.println("key:: "+key);
            
            if(map.containsKey(key)==false){
                return key;
            }
        
            String str=map.get(key);
            if(str.indexOf('%')==-1){
                return str;
            }
        
            System.out.println("str:: "+str);
            
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(c!='%'){
                    sb.append(c);
                    continue;
                }
                if(c=='%' && i!=str.length()-1 && str.charAt(i+1)=='%'){
                    sb.append("%");
                    i++;
                    continue;
                }
                
                StringBuilder sbsub=new StringBuilder();
                int j=0;
                for(j=i+1;j<str.length();j++){
                    char cc=str.charAt(j);
                    if(cc=='%'){
                        break;
                    }
                    else{
                        sbsub.append(cc);
                    }
                }

                String keyy=sbsub.toString();                
                String getValue=helper(keyy,map);
                sb.append(getValue);
                i=j;
            }
        map.put(key,sb.toString());
        return sb.toString();
    }
}
