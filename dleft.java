import java.util.*;
import java.io.*;
public class dleft{
  static Map<String,Integer> hmap = new HashMap<>();
  static int tablesize;
  static int flow;
  static int segment;
  static int[] s = new int[segment];
  static int[] table;
  static int split;

  public static void main(String[] args) throws IOException{
    try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of flows: ");
        flow = sc.nextInt();
        System.out.println("Enter the number of table entries: ");
        tablesize = sc.nextInt();
        System.out.println("Enter the number of segments: ");
        segment = sc.nextInt();
        s = new int[segment];
        table = new int[tablesize];
        split = tablesize/segment;
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
          //System.out.println("f-"+num + " " + i);
          hmap.put("f-"+num,hmap.getOrDefault("f-"+num,0)+1);
          for(int j = 0;j < s.length;j++){
              if(table[(split*j)+(hindex(num,j)%split)] == 0 || table[(split*j)+(hindex(num,j)%split)] == num){
                  table[(split*j)+(hindex(num,j)%split)] = num;
                  break;
              }
          }
          i += 1;
        }
        int res = filledentries();
        BufferedWriter bwriter = new BufferedWriter(new FileWriter("dleft.txt"));
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

  public static int hindex(int val, int count) {
    return (val^s[count])%tablesize;
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
    for(int i=0; i < segment; i++)
      s[i]=(int) r.nextInt(range) + low;
  }
}
