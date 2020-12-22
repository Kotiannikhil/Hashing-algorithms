import java.util.*;
import java.io.*;
public class multihashing{
  static Map<String,Integer> hmap = new HashMap<>();
  static int tablesize;
  static int flow;
  static int hash;
  static int[] s;
  static int[] table;
  public static void main(String[] args) throws IOException{
    try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of flows: ");
        flow = sc.nextInt();
        System.out.println("Enter the number of table entries: ");
        tablesize = sc.nextInt();
        System.out.println("Enter the number of hashes: ");
        hash = sc.nextInt();
        s = new int[hash];
        table = new int[tablesize];
        randomgenerator();
        int i = 1;
        int min = 1;
        int max = Integer.MAX_VALUE;
        while(i <= flow){
          Random var = new Random();
          int num = var.nextInt(max - min) + min;
          if(hmap.containsKey("f-"+num)){
            i -= 1;
            continue;
          }
          hmap.put("f-"+num,hmap.getOrDefault("f-"+num,0)+1);
          for(int j = 0;j < s.length;j++){
            if(table[hindex(num,j)] == 0 || table[hindex(num,j)] == num){
                table[hindex(num,j)] = num;
                break;
            }
          }
          i += 1;
        }
        int res = filledentries();
        BufferedWriter bwriter = new BufferedWriter(new FileWriter("multihashing.txt"));
        bwriter.write("The number of flows in the hash table are: "+String.valueOf(res)+"\n");
        bwriter.write("The list of table entries is: \n"+Arrays.toString(table));
        //System.out.println(res);
        //System.out.println(hmap.size());
        //System.out.println(Arrays.toString(table));
        bwriter.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  public static int hindex(int val,int position){
    return (val^s[position])%tablesize;
  }

  public static int filledentries() {
    int count=0;
    for(int i=0; i<table.length; i++) {
      if(table[i] != 0)
        count++;
    }
    return count;
  }

  public static void randomgenerator() {
    int low = 1, high = tablesize;
    Random r = new Random();
    int range = (high - low) + 1;
    for(int i=0; i<hash; i++)
      s[i]=(int) r.nextInt(range) + low;
  }
}
