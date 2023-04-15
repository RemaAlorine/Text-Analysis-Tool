import java.util.Scanner;
import java.io.*;
public class WordAnalysisADT{
int numOfNodes;
int numOfDuplicate;
Node occurArray[];
private Node head;
private Node current;





public WordAnalysisADT(){
numOfNodes=0;
numOfDuplicate=0;
head=current=null;
}
//---------------------------------------//
//(1)
public int totalNum(){
return numOfNodes;
}
//---------------------------------------//
//(2)
public int numUnqWords(){
return occurArray.length;
}
//---------------------------------------//
//(3)
public int numOfOccur(String word){
int count=0;
for(int i=0;i<occurArray.length; i++){
if(occurArray[i].data.equals(word)){
count=occurArray[i].appear;
break;}//if
}
return count;
}
//---------------------------------------//
//(4) 
public int wordLen(int l){  
int count=0; 
               
for(int i=0;i<occurArray.length; i++){
if(occurArray[i].data.length()==l)
count+=occurArray[i].appear;
}

return count;
}
//---------------------------------------//
//(5)
public String printOccur(){
String str="";
for(int i=0;i<occurArray.length; i++)
str+="("+occurArray[i].data+","+occurArray[i].appear+")"+",";
return str.substring(0,str.length()-1);
}
//---------------------------------------//
//(6)
public String printLoc(String word){
String str="";
current=head;
while(current!=null){
if(current.data.equals(word))
str+="("+current.y+","+current.x+")"+",";
current=current.next;
}//while

return str.substring(0,str.length()-1);
}
//---------------------------------------//
//(7)
public boolean adj(String w1,String w2){
current=head;
while(current.next!=null){
if( ((current.data.equals(w1)) && (current.next.data.equals(w2))) || ((current.data.equals(w2)) && (current.next.data.equals(w1))))
return true;
current=current.next;
}//while
return false;
}



//insert
public void insertString(String fileName) throws IOException{
Scanner s=new Scanner(new File(fileName));
Node p; 
int col=1;
int row=1;
String newl="\\n";
while(s.hasNext()){
String word=s.next();
if(word.equals(newl)){
row++;
col=1;
}
else{
if(Character.isLetter(word.charAt(0))){
if(!Character.isLetter(word.charAt(word.length()-1)))
word=word.substring(0,word.length()-1);

insert(word);
numOfNodes++;
Node t=current;
p=head;
while(p!=null){        
if(p.data.equals(t.data) && t!=p){     
t.appear++;
p.appear++;              
t.firstOccur=false;
}//if
p=p.next;
}//inner while

t.x=col;
col++;
t.y=row;
}// if
}//big if
}// reading while


p=head;
while(p!=null){
if(p.firstOccur && p.appear>1){
numOfDuplicate+=p.appear;
numOfDuplicate--;
}//if
p=p.next;
}//while

int index=0;
occurArray=new Node[numOfNodes-numOfDuplicate];

p=head;
while(p!=null){
if(p.firstOccur==true){
occurArray[index]=p;
index++;
}//if
p=p.next;
}//while


for(int i=0; i<occurArray.length-1 ;i++){

for(int j=0; j<occurArray.length-1-i; j++){
if(occurArray[j].appear<occurArray[j+1].appear){
Node temp=occurArray[j];
occurArray[j]=occurArray[j+1];
occurArray[j+1]=temp;
}// if


}//small for
}//big for,

}//insert

public void insert(String d){
Node temp=new Node(d);

if(empty())
head=current=temp;
else{
temp.next=current.next;
current.next=temp;
current=temp;

}
}

public boolean empty(){
return head==null;
}




}




