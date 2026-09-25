class Solution {
    static void f(int idx,int[] nums,List<Integer>ds,HashSet<List<Integer>>ans,int target){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            
        }
        if(idx==nums.length||target<0){
            
            return ;
        }
        ds.add(nums[idx]);
        f(idx,nums,ds,ans,target-nums[idx]);
        ds.remove(ds.size()-1);
        f(idx+1,nums,ds,ans,target);

        
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        HashSet<List<Integer>>ans=new HashSet<>();
        f(0,nums,new ArrayList<>(),ans,target);
        List<List<Integer>>res=new ArrayList<>(ans);
        return res;
       
    }
}
