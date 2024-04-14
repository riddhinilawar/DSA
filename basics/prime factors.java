public static void allprime(int n,HashMap<Integer,ArrayList<Integer>>map,int st){
        while(n%2==0){
            map.put(2,map.getOrDefault(2,new ArrayList<>()));
            ArrayList<Integer>temp=map.get(2);
            temp.add(st);
            map.put(2,temp);
            n/=2;
        }
        for(int i=3; i<=Math.sqrt(n); i+=2){
            while(n%i==0){
                map.put(i,map.getOrDefault(i,new ArrayList<>()));
                ArrayList<Integer>temp=map.get(i);
                temp.add(st);
                map.put(i,temp);
                n/=i;
            }
        }
        if(n>2){
            map.put(n,map.getOrDefault(n,new ArrayList<>()));
            ArrayList<Integer>temp=map.get(n);
            temp.add(st);
            map.put(n,temp);
        }
    }
