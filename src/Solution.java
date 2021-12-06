

class Solution {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        
          ListNode odd  = head;
          ListNode even = head.next;
          ListNode ittr = even.next;
          int curr = 3;
          while(ittr!=null){
            
            if(curr%2==0) {
            	ListNode temp = even.next;
            	even = even.next;
            	ittr=temp.next;
            }else{
              ListNode temp = odd.next;
              odd.next = ittr;
              even.next = ittr.next;
              ittr.next = temp;
              odd = odd.next;
              ittr=even.next;
            }
            curr++;
            
          }
      
        return head;
    }

  public static void main(String[] args){
        Solution s = new Solution();
        ListNode head = s.createLinkList();
        s.oddEvenList(head);
        s.displayResult(head);
    //System.out.println("Hello world");
    }
  
  public void displayResult(ListNode head) {
    
   while(head!=null) {
      System.out.print(head.val);
      System.out.print("->");
      head = head.next;
   }
    
  }
  
  public ListNode createLinkList(){
    ListNode example = new ListNode(1);
    ListNode example2 = new ListNode(2);
    ListNode example3 = new ListNode(3);
    ListNode example4 = new ListNode(4);
    ListNode example5 = new ListNode(5);
    ListNode example6 = new ListNode(6);
    ListNode example7 = new ListNode(7);

    example.next = example2;
    example2.next = example3;
    example3.next = example4;
    example4.next = example5;
    example5.next = example6;
    example6.next = example7;
    
    //example.next = new 
    
    return example;
  }
}