import java.util.*;
import java.io.*;
class Main{


  static LinkedHashMap<String,List<String>> hm = new LinkedHashMap<String, List<String>>();
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String csvFile = "apparel.csv";
    String line="";
    System.out.println("Enter the min support: ");
    int support = sc.nextInt(); 
    System.out.println("Enter minimum confidence: ");
    int conf=sc.nextInt();
    System.out.println("The data retrieved is: ");
    String[] ApparelName = new String[]{"tshirt","jeans","skirt","shirt","pants","shoes","slippers"};
    BufferedReader br = null;
    try {
           br = new BufferedReader(new FileReader(csvFile));
           while ((line = br.readLine()) != null) {
             List<String> a = new ArrayList<String>();
               String[] apparel = line.split(",");
               for(int i=1;i<ApparelName.length+1;i++){
                 if(apparel[i].equals("1")){
                   a.add(ApparelName[i-1]);
                 }
               }
             hm.put(apparel[0], a);
           }


       } catch (IOException e) {
           e.printStackTrace();
       }


       for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
       System.out.println(entry.getKey()+" : "+entry.getValue());
    }
    // FOR C1 COMPUTING
    System.out.println("\n -- C1 --");


    System.out.println("Item\tSupport");
    for(int i=0;i<ApparelName.length;i++){
      System.out.println(ApparelName[i]+ "\t "+computeSupport(ApparelName[i]));
    }
    System.out.println("After removing Items less than min support");
    ArrayList<String> al1 = new ArrayList<String>();
    for(int i=0;i<ApparelName.length;i++){
      if(computeSupport(ApparelName[i]) < support){}
      else{
        System.out.println(ApparelName[i]+ "\t "+computeSupport(ApparelName[i]));
        al1.add(ApparelName[i]);
      }
    }
    // FOR C2 COMPUTING
    System.out.println("\n -- C2 --");
    for(int i=0;i<al1.size()-1;i++){
      for(int j=i+1;j<al1.size();j++){
        System.out.print("\n"+al1.get(i)+ ", "+al1.get(j));
        System.out.print("\t "+computeSupport(al1.get(i), al1.get(j)));


      }
    }
    System.out.print("\nAfter removing Items less than min support");
    ArrayList<String> al2 = new ArrayList<String>();
    String arra[][] = new String[al1.size()][2];
    int c=0;
    for(int i=0;i<al1.size();i++){
      for(int j=i+1;j<al1.size();j++){
        if(computeSupport(al1.get(i), al1.get(j)) < support){}
        else{
          System.out.print("\n"+al1.get(i)+ ", "+al1.get(j));
          System.out.print("\t "+computeSupport(al1.get(i), al1.get(j)));
          arra[c][0] = al1.get(i); arra[c][1] = al1.get(j);
          c++;
        }
      }
    }


    String ar1[][]=new String[c][2];
    for(int i=0;i<c;i++){
      ar1[i][0] = arra[i][0];
      ar1[i][1] = arra[i][1]; 
    }
    System.out.println();
    // FOR C3 COMPUTE


    System.out.println(" -- C3 --");
    String arrc3[][] = new String[8][3];int c1=0;
    for(int i=0;i<ar1.length-1;i++){
      for(int j=i+1;j<ar1.length;j++){
        if( ((ar1[i][0]).equals(ar1[j][0])) || ((ar1[i][1]).equals(ar1[j][0])) || ((ar1[i][1]).equals(ar1[j][1])) || ((ar1[i][0]).equals(ar1[j][1])) ){
          
          if((ar1[i][0]).equals(ar1[j][0])){
            //System.out.println(ar1[i][0] + ", " +ar1[i][1]+ ", " +ar1[j][1]);
            arrc3[c1][0] = ar1[i][0]; arrc3[c1][1] = ar1[i][1]; arrc3[c1][2] = ar1[j][1];
          }
          else if((ar1[i][0]).equals(ar1[j][1])){
            //System.out.println(ar1[i][0] + ", " +ar1[i][1]+ ", " +ar1[j][0]);
            arrc3[c1][0] = ar1[i][0]; arrc3[c1][1] = ar1[i][1]; arrc3[c1][2] = ar1[j][0];
          }
          else if((ar1[i][1]).equals(ar1[j][0])){
            //System.out.println(ar1[i][0] + ", " +ar1[i][1]+ ", " +ar1[j][1]);
            arrc3[c1][0] = ar1[i][0]; arrc3[c1][1] = ar1[i][1]; arrc3[c1][2] = ar1[j][1];
          }
          else if((ar1[i][1]).equals(ar1[j][1])){
            //System.out.println(ar1[i][0] + ", " +ar1[i][1]+ ", " +ar1[j][0]);
            arrc3[c1][0] = ar1[i][0]; arrc3[c1][2] = ar1[i][1]; arrc3[c1][1] = ar1[j][0];
          }
          else{}
            c1++;
        }
      }
    }
    int count=0;
    String ax="",bx="",cx="";
    int supp=0;
    //REMOVING DUPLICATES
    for(int i=0;i<c1-1;i++){
      for(int j=i+1;j<c1;j++){
        if(arrc3[i][0].equals(arrc3[j][0]) && arrc3[i][1].equals(arrc3[j][1]) && arrc3[i][2].equals(arrc3[j][2])) {
          if(count<1){
            ax = arrc3[i][0]; bx = arrc3[i][1]; cx = arrc3[j][2];
            System.out.print(arrc3[i][0] + ", " +arrc3[i][1]+ ", " +arrc3[j][2]);
            supp= computeSupport(arrc3[i][0], arrc3[i][1], arrc3[i][2]);
            System.out.print("\t "+computeSupport(arrc3[i][0], arrc3[i][1], arrc3[i][2]));
          }
          count++;
        }
        
      }
    }
    Map<String, Float> h = new HashMap<String, Float>();
    h.put(ax +" ^ " +bx +" -> " +cx, (float)((float)supp/(float)computeSupport(ax,bx))*100);
    h.put(ax +" ^ " +cx +" -> " +bx, (float)((float)supp/(float)computeSupport(ax,cx))*100);
    h.put(bx +" ^ " +cx +" -> " +ax, (float)((float)supp/(float)computeSupport(bx,cx))*100);
    h.put(ax +" -> " +bx +" ^ " +cx, (float)((float)supp/(float)computeSupport(ax))*100);
    h.put(bx +" -> " +ax +" ^ " +cx, (float)((float)supp/(float)computeSupport(bx))*100);
    h.put(cx +" -> " +ax +" ^ " +bx, (float)((float)supp/(float)computeSupport(cx))*100);


    System.out.println("\n\nAssociation rules\t\tSupport\tConfidence\tConfidence %");
    System.out.println(ax +" ^ " +bx +" -> " +cx +"\t\t" +supp +"\t" +(float)((float)supp/(float)computeSupport(ax,bx)) +"\t\t" +(float)((float)supp/(float)computeSupport(ax,bx))*100);
    System.out.println(ax +" ^ " +cx +" -> " +bx +"\t\t" +supp +"\t" +(float)((float)supp/(float)computeSupport(ax,cx)) +"\t\t" +(float)((float)supp/(float)computeSupport(ax,cx))*100);
    System.out.println(bx +" ^ " +cx +" -> " +ax +"\t\t" +supp +"\t" +(float)((float)supp/(float)computeSupport(bx,cx)) +"\t\t" +(float)((float)supp/(float)computeSupport(bx,cx))*100);
    System.out.println(ax +" -> " +bx +" ^ " +cx +"\t\t" +supp +"\t" +(float)((float)supp/(float)computeSupport(ax)) +"\t\t" +(float)((float)supp/(float)computeSupport(ax))*100);
    System.out.println(bx +" -> " +ax +" ^ " +cx +"\t\t" +supp +"\t" +(float)((float)supp/(float)computeSupport(bx)) +"\t\t" +(float)((float)supp/(float)computeSupport(bx))*100);
    System.out.println(cx +" -> " +bx +" ^ " +ax +"\t\t" +supp +"\t" +(float)((float)supp/(float)computeSupport(cx)) +"\t\t" +(float)((float)supp/(float)computeSupport(cx))*100);


    System.out.println("Final Association Rules are - ");


   for(Map.Entry<String, Float> en : h.entrySet()) {
     if(en.getValue() >= conf)
         System.out.println(en.getKey()+" with confidence of "+en.getValue());
    }


  
  }
  //----------------
  static int computeSupport(String apparel){
    int support=0;
         for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
       if((entry.getValue()).contains(apparel)){
         support++;
       } 
    }
  return support;
  }
  static int computeSupport(String apparel, String apparel1){
    int support=0;
         for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
       if(((entry.getValue()).contains(apparel)) && ((entry.getValue()).contains(apparel1))) {
         support++;
       } 
    }
  return support;
  }
  static int computeSupport(String apparel, String apparel1, String apparel2){
    int support=0;
         for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
       if(((entry.getValue()).contains(apparel)) && ((entry.getValue()).contains(apparel1)) && ((entry.getValue()).contains(apparel2)) ) {
         support++;
       } 
    }
  return support;
  }
}