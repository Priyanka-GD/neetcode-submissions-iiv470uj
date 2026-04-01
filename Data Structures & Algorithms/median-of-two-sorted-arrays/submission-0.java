class Solution {
    private int p1 = 0, p2 = 0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if((len1 + len2 ) % 2 == 0){
            for(int idx = 0; idx < (len1 + len2)/2 - 1; idx++)
                getMin(nums1, nums2);
            return (double)(getMin(nums1, nums2) +  getMin(nums1, nums2))/2;
        }else{
            for(int idx = 0; idx < (len1 + len2)/2; idx++)
                getMin(nums1, nums2);
            return (double)getMin(nums1, nums2);
        }
    }
    private int getMin(int[] nums1, int[] nums2){
        if(p1 < nums1.length && p2 < nums2.length)
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        else if(p1 < nums1.length)
            return nums1[p1++];
        else if(p2 < nums2.length)
            return nums2[p2++];
        return -1;
    }
}
