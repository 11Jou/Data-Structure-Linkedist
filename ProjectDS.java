package projectds;
import java.util.Scanner;
public class ProjectDS {
    public static void main(String[] args) {
Scanner S=new Scanner (System.in);
        System.out.println("Enter A String ");
        String Words=S.nextLine();
        int Size = Words.length();
        if(Size<=1000){
        ArrayHash Table= new ArrayHash(Size);
        for(int i=0;i<Size;i++)
            Table.AddChar(Words.charAt(i), (int)Words.charAt(i), Table.Array);
        Table.GetMax(Table.Array);   }
        else 
            System.out.println("Size is More than 1000"); }}
class ArrayHash {
   Node Array[];
   int Size;
 public  ArrayHash(int Size){ 
       this.Size=Size;
       Array = new Node[Size];
       for(int i=0;i<Size;i++){
           Array[i]=new Node();
           Array[i]=null;  }  }
 int MyHash(Node X[],int Key){
   int  Index=Key%Size;
   int i=1;
   while (X[Index]!=null&&X[Index].Value!=(char)Key){
       Index=(Index+i*i)%Size;
   i++;
   }
   return Index;
 }
void AddChar(char Value,int Key,Node X[]){
    int Index=MyHash(X,Key);
    Node NewNode= new Node(Value);
    if(Array[Index]==null)
        Array[Index]=NewNode;
    else {
        NewNode.next=Array[Index];
        Array[Index]=NewNode; } }
void GetMax(Node X[]){ 
    int Max=0;
    char Maximum=' ';
     char Ch=' ';
    for(int i=0;i<Size;i++){
        int j=0;
        while(X[i]!=null){
            j++;
        Ch=X[i].Value;
        X[i]=X[i].next;  }
        if(j>Max){
            Max=j;  
            Maximum = Ch; }
          else if(j==Max&&(int)Ch<(int)Maximum){ 
              Max=j;  
            Maximum = Ch;  } }
    if(Max!=0)
       if(Maximum==' ')
        System.out.println(" Space "+ " "+Max);
        else 
            System.out.println(Maximum + " " + Max);}}
 class Node {
    char Value;
    Node next;  
    Node(char Value){
        this.Value=Value;
        next=null;  }
    Node(){
   next=null;}}
    
