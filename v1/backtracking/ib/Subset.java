public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
        
        HashSet<Integer> hs=new HashSet<>();
        
        for(int i=0;i<a.size();i++)
        {
            hs.add(a.get(i));
        }
        a.clear();
        
        Iterator<Integer> i=hs.iterator();
        
        while(i.hasNext())
        {
            int n=i.next();
            a.add(n);
        }
        Collections.sort(a);
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> subsets=new ArrayList<>();
        
        int index=0;
        ssutil(a,subsets,ans,0);
        
        return ans;
      
    }
   
    
    public void ssutil(ArrayList<Integer> a,ArrayList<Integer> subsets,
                ArrayList<ArrayList<Integer>> ans,int index)
    {
        
        ArrayList<Integer> temp=new ArrayList<>();
        
        for(int t=0;t<subsets.size();t++)
        {
            int t3=subsets.get(t);
            temp.add(t3);
        }
       ans.add(temp);
       
       for(int i=index;i<a.size();i++)
       {
           subsets.add(a.get(i));
           
           ssutil(a,subsets,ans,i+1);
           
           subsets.remove(subsets.size()-1);
       }
       return;
    }
    
}