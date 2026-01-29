// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
   
    static class Node{
        int data;
        Node next;
        Node(){
        }
        Node(int val){
            this.data = val;
            this.next = null;
            System.out.println("Node created = "+this.data+this.next);
        }
      }
      static Node insert(int data){
          Node temp = new Node(data);
        //   node.next = temp;
        return temp;
        }
    static void  print(Node head){
          while(head != null){
            System.out.print(head.data+"->");
            head = head.next;
        }
     }
     static void swap(Node node){
         Node head = node;
         Node temp = node;
         while(head.next != null){
             temp = head.next;
             if(head.next.next != null){
                 head.next = head.next.next;
             }
             temp.next = head;
         }
     }
    public static void main(String[] args) {
  
        System.out.println("Gokul sirvi");
        int[] arr = {2,3,4,5,6};
        Node ll = new Node(4);
        Node head = ll;
        for(int i=0;i<arr.length;i++){
            ll.next = insert(arr[i]);
            ll = ll.next;
        }
        // insert(ll);
       print(head);
       
       swap(head);
        print(head);
    }
}
