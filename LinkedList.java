public class LinkedList {
   
        public static class Node{
            Node  next;
            int data;
            public  Node(int data){
                this.data=data;
                this.next=null;
            }
        }
         public static Node head;
         public static Node tail;
         public void addfirst(int data){
            Node newNode=new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            newNode.next =head;
            head=newNode;
         }
         public Node getmid(Node head){
        Node slow= head;
        Node fast= head.next;
        while(fast != null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
         }
        public  Node mergesort(Node head){
            if(head == null || head.next ==null){
                return head;
            }
            Node mid= getmid(head);
            Node righthead=mid.next;
            mid.next=null;
            Node leftside= mergesort(head);
            Node rightside= mergesort(righthead);
            return merge(leftside,rightside);
        }
        public Node merge(Node head1,Node head2){
          
            Node mergell= new Node(-1);
            Node tem= mergell;
            while(head1!=null && head2 != null){
                if(head1.data<=head2.data){
                    tem.next=head1;
                    head1=head1.next;
                    tem=tem.next;
                }
                else{
                    tem.next=head2;
                    head2=head2.next;
                    tem=tem.next; 
                }
            }
            while(head1 !=null){
                    tem.next=head1;
                    head1=head1.next;
                    tem=tem.next;
            }
            while(head2!=null){
                tem.next=head2;
                head2=head2.next;
                tem=tem.next;
            }
            return mergell.next;
            }
            public void print(){
                Node tem= head;
                while(tem != null){
                    System.out.print(tem.data+"->");
                    tem=tem.next;
                }
                System.out.println("null");
            }
        public static void main(String args[]){
            LinkedList ll =new LinkedList();
            ll.addfirst(1);
            ll.addfirst(2);
            ll.addfirst(3);
            ll.addfirst(4);
            ll.addfirst(5);
            ll.print();
            ll.head=ll.mergesort(ll.head);
            ll.print();
        }
    
}
