# Given a list of numbers of size n, where n is greater than 3, find the maximum and minimum of the list using less than 2 * (n - 1) comparisons.
#global

def find_min_max(nums):
    max = min = nums[0]
    comparisons = 0
    if len(nums) <= 3:
        return []
    else:
        # finalList, comps = merge_sort(nums, comparisons)
        # print(comps)
        # print(finalList)
        
        for i in range(2,len(nums)):
            if max < nums[i]:
                max = nums[i]
            elif min > nums[i]:
                min = nums[i]
            comparisons += 1
        print(max)
        print(min)
        print(comparisons)



def merge_sort(nums, comparisons):
    # this solves the problem with 2*n comparisons
    size = len(nums)
    if size == 1:
        return nums, comparisons
    else:
        left, comparisons = merge_sort(nums[:size//2], comparisons)
        right, comparisons = merge_sort(nums[size//2:], comparisons)
        final = []
        while len(left) > 0 and len(right) > 0:
            if left[0] < right[0]:
                final.append(left.pop(0))
            else:
                final.append(right.pop(0))
            comparisons += 1
        while len(left) != 0 or len(right) != 0:
            if len(left) > 0:
                final.append(left.pop(0))
            else:
                final.append(right.pop(0))
        return final, comparisons


    


find_min_max([3, 5, 1, 2, 4, 8])
# (1, 8)