import java.io.*;
import java.util.*;
public class Main
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
String[] purchase = new String[50];
String[] age = new String[50];
String[] income = new String[50];
String[] student = new String[50];
String[] credit = new String[50];
int y=0,n=0,total=0;
int agey=0;
int agen=0;
int incy=0;
int incn=0;
int stuy=0;
int stun=0;
int credy=0;
int credn=0;
int a1=0,a2=0,a3=0,a4=0,a5=0,a6=0,a1_t=0,a2_t=0,a3_t=0;
int i1=0,i2=0,i3=0,i4=0,i5=0,i6=0,i1_t=0,i2_t=0,i3_t=0;
int s1=0,s2=0,s3=0,s4=0,s1_t=0,s2_t=0;
int c1=0,c2=0,c3=0,c4=0,c1_t=0,c2_t=0;




String csvFile = "nbayes.csv";
BufferedReader br = null;
String line = "";
String cvsSplitBy = ",";
try
{
int i=0,j=0,h=0,k=0,l=0;
br = new BufferedReader(new FileReader(csvFile));
while ((line = br.readLine()) != null) {
String a[] = line.split(",");
purchase[i++] = a[4];
age[j++] = a[0];
income[h++] = a[1];
student[k++] = a[2];
credit[l++] = a[3];
}
}
catch (FileNotFoundException e)
{
e.printStackTrace();
}
catch (IOException e)
{
e.printStackTrace();
}
finally
{
if (br != null)
{
try
{
br.close();
}
catch (IOException e)
{
e.printStackTrace();
}
}
}




for(int i=0;i<purchase.length;i++)
{
if(purchase[i].equalsIgnoreCase("Yes"))
{
 if(age[i].equalsIgnoreCase("Youth"))
 {
   a1++;
   a1_t++;
 }
 if(age[i].equalsIgnoreCase("Middle"))
 {
   a2++;
   a2_t++;
 }
 if(age[i].equalsIgnoreCase("Senior"))
 {
   a3++;
   a3_t++;
 }
}
else
{
 if(age[i].equalsIgnoreCase("Youth"))
 {
   a4++;
   a1_t++;
 }
 if(age[i].equalsIgnoreCase("Middle"))
 {
   a5++;
   a2_t++;
 }
 if(age[i].equalsIgnoreCase("Senior"))
 {
   a6++;
   a3_t++;
 }
}
}
for(int i=0;i<purchase.length;i++)
{
if(purchase[i].equalsIgnoreCase("Yes"))
{
 if(income[i].equalsIgnoreCase("Low"))
 {
   i1++;
   i1_t++;
 }
 if(income[i].equalsIgnoreCase("Medium"))
 {
   i2++;
   i2_t++;
 }
 if(income[i].equalsIgnoreCase("High"))
 {
   i3++;
   i3_t++;
 }
}
else
{
 if(income[i].equalsIgnoreCase("Low"))
 {
   i4++;
   i1_t++;
 }
 if(income[i].equalsIgnoreCase("Medium"))
 {
   i5++;
   i2_t++;
 }
 if(income[i].equalsIgnoreCase("High"))
 {
   i6++;
   i3_t++;
 }
}
}
for(int i=0;i<purchase.length;i++)
{
if(purchase[i].equalsIgnoreCase("Yes"))
{
 if(student[i].equalsIgnoreCase("Yes"))
 {
   s1++;
   s1_t++;
 }
 if(student[i].equalsIgnoreCase("No"))
 {
   s2++;
   s2_t++;
 }
 }
else
{
if(student[i].equalsIgnoreCase("Yes"))
 {
   s3++;
   s1_t++;
 }
 if(student[i].equalsIgnoreCase("No"))
 {
   s4++;
   s2_t++;
 }
}
}
for(int i=0;i<purchase.length;i++)
{
if(purchase[i].equalsIgnoreCase("Yes"))
{
 if(credit[i].equalsIgnoreCase("Fair"))
 {
   c1++;
   c1_t++;
 }
 if(credit[i].equalsIgnoreCase("Excelent"))
 {
   c2++;
   c2_t++;   
 }
 }
else
{
if(credit[i].equalsIgnoreCase("Fair"))
 {
   c3++;
   c1_t++;
 }
 if(credit[i].equalsIgnoreCase("Excellent"))
 {
   c4++;
   c2_t++;
 }
}
}
System.out.println("Probability of youth|yes"+ (float)a1/a1_t);
System.out.println("Probability of middle|yes"+(float)a2/a1_t);
System.out.println("Probability of senior|yes"+(float)a3/a1_t);
System.out.println();
System.out.println("Probability of youth|no"+ (float)a4/a2_t);
System.out.println("Probability of middle|no"+(float)a5/a2_t);
System.out.println("Probability of senior|no"+(float)a6/a2_t);
System.out.println();


System.out.println("Probability of income low|yes"+ (float)i1/i1_t);
System.out.println("Probability of income medium|yes"+(float)i2/i2_t);
System.out.println("Probability of income high|yes"+(float)i3/i3_t);
System.out.println();
System.out.println("Probability of income low|no"+ (float)i4/i1_t);
System.out.println("Probability of income medium|no"+(float)i5/i2_t);
System.out.println("Probability of income high|no"+(float)i6/i3_t);
System.out.println();


System.out.println("Probability of student yes|yes"+ (float)s1/s1_t);
System.out.println("Probability of student no|yes"+(float)s2/s2_t);
System.out.println();
System.out.println("Probability of student yes|no"+ (float)s3/s1_t);
System.out.println("Probability of student yes|no"+(float)s4/s2_t);
System.out.println();


System.out.println("Probability of credit fair|yes"+ (float)c1/c1_t);
System.out.println("Probability of credit excellent|yes"+(float)c2/c2_t);
System.out.println();
System.out.println("Probability of credit fair|no"+ (float)c3/c1_t);
System.out.println("Probability of credit excellent|no"+(float)c4/c2_t);
System.out.println();


System.out.println("--------------------------------------------");
System.out.println("Enter the age(youth/medium/senior)");
String age1=sc.nextLine();
System.out.println("Enter the income(low/medium/high)");
String income1=sc.nextLine();
System.out.println("Enter the student(yes/no)");
String student1=sc.nextLine();
System.out.println("Enter the credit values(fair/excellent)");
String credit1=sc.nextLine();
  for(int i=0;i<purchase.length;i++)
       {
           if(purchase[i].equalsIgnoreCase("Yes"))
           {
               y++;
           }
           else
           {
               n++;
           }
       }
       total=y+n;
for(int i=0;i<purchase.length;i++)
{
if(age1.equalsIgnoreCase(age[i]))
{
 if(purchase[i].equalsIgnoreCase("Yes"))
 {
 agey++;
 }
 else
 {
 agen++;
 }
}
if(income1.equalsIgnoreCase(income[i]))
{
if(purchase[i].equalsIgnoreCase("Yes"))
{
incy++;
}
else
{
incn++;
}
}
if(student1.equalsIgnoreCase(student[i]))
{
if(purchase[i].equalsIgnoreCase("Yes"))
{
stuy++;
}
else
{
stun++;
}
}
if(credit1.equalsIgnoreCase(credit[i]))
{
if(purchase[i].equalsIgnoreCase("Yes"))
{
credy++;
}
else
{
credn++;
}
}


}
float pay,pan,psy,psn,piy,pin,pcy,pcn,pn,py;
py=(float)y/total;
pn=(float)n/total;
pay=(float)agey/y;
pan=(float)agen/n;
piy=(float)incy/y;
pin=(float)incn/n;
psy=(float)stuy/y;
psn=(float)stun/n;
pcy=(float)credy/y;
pcn=(float)credn/n;
float pyes,pno;
pyes=pay*piy*psy*pcy*py;
pno=pan*pin*psn*pcn*pn;




System.out.println("Final probability of yes="+pyes +" "+"and of no="+pno);
if(pyes>=pno)
{
System.out.println("The class is yes");
}
else
{
System.out.println("The class is no");
}
}
}