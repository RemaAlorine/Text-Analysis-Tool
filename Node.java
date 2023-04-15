public class Node{
public int appear;
public boolean firstOccur;
public int x;
public int y;
public String data;
public Node next;


public Node(){
data=null;
next=null;
appear=1;
firstOccur=true;
}

public Node(String d){
data=d;
next=null;
appear=1;
firstOccur=true;
}




}