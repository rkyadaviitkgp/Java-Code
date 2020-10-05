package programming;

public class DynamicPrograming {
	
	public int numDecodings(String s) {
        
		if(s.length() == 0 || s.isEmpty())
			return 0;
		
		int[] arr = new int[s.length()];
		
		arr[0] = 1;
		
		for(int i=1; i<s.length(); i++) {
			arr[i] = arr[i-1];
			if(Integer.parseInt(s.charAt(i) + "" ) + Integer.parseInt(s.charAt(i-1) + "")*10 <= 26 ) {
				arr[i] = arr[i] + i-2 >= 0 ? arr[i-2] : 0;
			}
		}
		return arr[s.length()-1];
        
    }
	
public boolean checkSubArraySum(int nums[], int ind, int sum, int len, int k, int [] arr){
        
        if(ind >= nums.length)
            return false;
        
        if(arr[ind] != 0)
            return ((arr[ind] == 1) ? true: false);
        
        sum = sum + nums[ind];
        len++;
        
         if(len >= 2 && ( (k!= 0 && sum % k == 0) || k == sum))
             return true;
         
         boolean var1 =  checkSubArraySum(nums, ind+1, sum, len, k, arr); 
         boolean var2  = checkSubArraySum(nums, ind+1, nums[ind], 1, k, arr);
         
         
         
         if(var2 == true)
             arr[ind] = 1;
         else
             arr[ind] = -1;
         
         return var2 || var1;
    }
    
    public boolean checkSubarraySum(int[] nums, int k) {
        
//        int[] arr = new int[nums.length];
//        return checkSubArraySum(nums, 0, 0, 0, k, arr);
    	int sum = nums[0];
    	int start = 0;
    	for(int i=1; i<nums.length; i++) {
    		sum = sum + nums[i];
    		if(sum < k)
    			continue;
    		else {
    			if(i-start+1 >= 2) {
    				if(sum==k || sum%k == 0)
    					return true;
    			}
    			
    		}
    	}
    	return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
