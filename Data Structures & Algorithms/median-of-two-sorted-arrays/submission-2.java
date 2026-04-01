class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int p1 = 0, p2 = 0, idx = 0;
       int result[] = new int[nums1.length + nums2.length];

       while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                result[idx++] =  nums1[p1++];
                result[idx++] =  nums2[p2++];
            }else if(nums1[p1] < nums2[p2]){
                result[idx++] =  nums1[p1++];
            }else{
               result[idx++] =  nums2[p2++]; 
            }
       }
        while (p1 < nums1.length) {
            result[idx++] = nums1[p1++];
        }
        while (p2 < nums2.length) {
            result[idx++] = nums2[p2++];
        }

        int mid = result.length / 2;
        if(result.length % 2 == 0){
            return (double) (result[mid - 1] + result[mid]) / 2;
        }

       return (double) result[mid];
    }
}
