
//here i have not write main function , its taken care by GFG
//Only logic 
//step1:  first find the inorder of the tree
//step2: save it and then sort the inorder. because BST have sorted inorder.
//step3 : then apply logic of {count the no of swap required to sort the array}

class Solution {
    
   public static  ArrayList<Integer> al = new ArrayList<Integer>();
   public static Map<Integer,Integer> hm = new TreeMap<Integer,Integer>();
    
    public static int minSwaps(int n, int[] arr) {
        
        hm.clear();
        al.clear();
        int count = 0;
        function(arr,n-1,0);
        int temp[] = new int[al.size()];
        for(int i=0;i<al.size();i++)
        {
            temp[i] = al.get(i);
        }
       //sort the arrayList because we have inorder in array list 
       //and binary search have sorted inorder.
        Collections.sort(al);
        
        //From here start logic of 
        //--> find the minimum no of swap required to sort the element.
        for(int i=0;i<al.size();i++)
        {
            hm.put(al.get(i),i);
        }
        
        for(int i=0;i<temp.length;)
        {
            if(hm.get(temp[i])!=i)
            {
               int id = hm.get(temp[i]);
               int tt = temp[id];
               temp[id] = temp[i];
               temp[i] = tt;
               count++;
               continue;
            }
            else{
                i++;
            }
        }
        return count;
    }
    
    public static void function(int[]arr,int n,int i)
    {
        if(i>n)
        {
            return;
        }
        
        function(arr,n,2*i+1);
        al.add(arr[i]);
        function(arr,n,2*i+2);
    }
}
        
