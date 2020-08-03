K-Means 1D
import java.util.*;


public class kmeans1


{


        public static void main(String args[])


        {


                Scanner scan=new Scanner(System.in);


                System.out.println("Enter number of elements");


                int n=scan.nextInt();


                System.out.println("Enter the numbers now");


                ArrayList <Double> num=new ArrayList <Double>();


                for(int i=0;i<n;i++)


                {


                        num.add(scan.nextDouble());


                }


                int count=0;


                System.out.println("Choose 2 numbers from the list");


                double avg1=scan.nextDouble(); double avg2=scan.nextDouble();


                ArrayList <Double> old1=new ArrayList<Double>();


                ArrayList <Double> old2=new ArrayList<Double>();


                ArrayList <Double> new1=new ArrayList<Double>();


                ArrayList <Double> new2=new ArrayList<Double>();


                System.out.println(num);


                old1.add(2.0);


                new1.clear();
                while(!old1.equals(new1))
                {
                        if(count==0) old1.clear();


                        //System.out.println("Entered while loop");


                        new1=new ArrayList<Double>(old1);
                        new2=new ArrayList<Double>(old2);
                        //System.out.println("New 1 is "+new1); System.out.println("New 2 is "+new2);


                        old1.clear();


                        old2.clear();


                        for(int i=0;i<n;i++)                


                        {


                                


                                if(Math.abs(num.get(i)-avg1)<Math.abs(num.get(i)-avg2))


                                {


                                        old1.add(num.get(i));


                                }


                                else


                                {


                                        old2.add(num.get(i));


                                }


                        }


                        Collections.sort(old1);


                        Collections.sort(old2);


                        count++;


                        System.out.println();




                        System.out.println("After iteration "+count+" the sets are");


                        System.out.println(old1); System.out.println(old2);


                        double sum1=0.0, sum2=0.0;


                        for(int i=0;i<old1.size();i++) {sum1+=old1.get(i);} avg1=sum1/old1.size();


                        for(int i=0;i<old2.size();i++) {sum2+=old2.get(i);} avg2=sum2/old2.size();


                        //System.out.println(avg1+" "+avg2);


                }


        }


}




  



K-Means 2D
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class Position{
        @Override
        public String toString() {
                return "Position [x=" + x + ", y=" + y + ", d=" + d + "]";
        }
        public int getX() {
                return x;
        }
        public void setX(int x) {
                this.x = x;
        }
        public int getY() {
                return y;
        }
        public void setY(int y) {
                this.y = y;
        }
        public int getD() {
                return d;
        }
        public void setD(int d) {
                this.d = d;
        }
        int x,y,d;
        Position(int x,int y,int d){
                this.x=x;
                this.y=y;
                this.d=d;
        }
}




public class KMeans2 {
        static int n,x,y,d,r1,r2,ps=0,cs=0,f=0;
        static ArrayList<Position> p = new ArrayList<Position>();
        static ArrayList<Position> cc1 = new ArrayList<Position>();
        static ArrayList<Position> cc2 = new ArrayList<Position>();
        static ArrayList<Position> pc1 = new ArrayList<Position>();
        static ArrayList<Position> pc2 = new ArrayList<Position>();




        public static void main(String args[]){                
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter No of Points:");
                n = sc.nextInt();
                for(int i=0;i<n;i++){
                        System.out.println("Enter x and y co-ordinates:");
                        x = sc.nextInt();
                        y = sc.nextInt();
                        Position c = new Position(x,y,0);
                        p.add(c);
                }
                do{
                        pc1.clear();
                        pc2.clear();
                        pc1.addAll(cc1);
                        pc2.addAll(cc2);
                        cc1.clear();
                        cc2.clear();
                        ps=cs;
                        f++;
                        getRandom();
                        calculateMDistances();
                        getSum();
                }while(ps>=cs || f==1);
                System.out.print("\n\nFinal Clusters\nCluster 1:");
                for(int i=0;i<pc1.size();i++) {
                        System.out.print("("+pc1.get(i).getX()+","+pc1.get(i).getY()+")\t");
                }
                System.out.print("\nCluster 2:");
                for(int i=0;i<pc2.size();i++) {
                        System.out.print("("+pc2.get(i).getX()+","+pc2.get(i).getY()+")\t");
                }
                sc.close();
        }
        
        
        public static void getRandom(){
                Random r = new Random();
                r1=r2;
                 while(r1==r2){
                        r1 = r.nextInt(n);
                        r2 = r.nextInt(n);
                }
                System.out.println("\n\nRandom 1:"+"("+p.get(r1).getX()+","+p.get(r1).getY()+")\t");
                System.out.println("Random 2:"+"("+p.get(r2).getX()+","+p.get(r2).getY()+")\t");


        }
        
        public static void calculateMDistances(){
                int x1 = p.get(r1).getX();
                int y1 = p.get(r1).getY();
                int x2 = p.get(r2).getX();
                int y2 = p.get(r2).getY();
                System.out.println("Points\tFrom c1\tFrom c2");
                for(int i=0;i<n;i++){
                        int t1=Math.abs(p.get(i).getX()-x1)+Math.abs(p.get(i).getY()-y1);
                        int t2=Math.abs(p.get(i).getX()-x2)+Math.abs(p.get(i).getY()-y2);
                        System.out.println("("+p.get(i).getX()+","+p.get(i).getY()+")\t"+t1+"\t"+t2);
                        if(t1<=t2){
                                p.get(i).setD(t1);
                                cc1.add(p.get(i));
                        }
                        else{
                                p.get(i).setD(t2);
                                cc2.add(p.get(i));
                        }
                }
                System.out.print("\nCluster 1:");
                for(int i=0;i<cc1.size();i++) {
                        System.out.print("("+cc1.get(i).getX()+","+cc1.get(i).getY()+")\t");
                }
                System.out.print("\nCluster 2:");
                for(int i=0;i<cc2.size();i++) {
                        System.out.print("("+cc2.get(i).getX()+","+cc2.get(i).getY()+")\t");
                }
        }
        
        public static void getSum(){
                cs=0;
                for(int i=0;i<cc1.size();i++){
                        cs=cs+cc1.get(i).getD();
                }
                for(int i=0;i<cc2.size();i++){
                        cs=cs+cc2.get(i).getD();
                }
                System.out.println("\nSum :"+cs);
        }                        
}