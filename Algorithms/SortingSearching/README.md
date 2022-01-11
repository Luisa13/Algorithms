# Sorting & Searching
Some of the concepts studied here

## Sorting

## Searching
**Binary Search** is an algorithm for finding an item from a **sorted** list of items.

The template using recursion:
```
public int binarySearch(final int[] arr, final target, int start, int end){
    if(start > end)
      return -1;
    
    int mid = start + (end-start) / 2;
    if (arr[mid] == target)
      return mid;
    
    if (arr[mid] > target)
      return binarySearch(arr, target, start, mid-1);
      
    else
      return binarySearch(arr, target, mid+1, end);

}
```
This has a downside though, which is that the recursion uses stack (small amount of memory allocated in the processor) and it's possible to get an overflow.


The solution template using two pointers (without recursion)
```
public void binarySearch(int[] arr, int target){
    int start = 0;
    int end = arr.length;

    while(start < end){
        mid = start + (end - start)/2;
        if(arr[mid] == target)
            return mid;
        else if(arr[mid] > target)
            end = mid;
        else
            start = mid;
    }
    
    if(arr[start] == target)
        return start;
        
    if(arr[end] == target)
        return end;
        
    return -1;
}
```
Either one method or the other, it works like this :)
<img src="https://user-images.githubusercontent.com/3811449/136035094-7bfce04e-9ad2-40ac-adea-b1d03f313428.png" alt="relationships" width="700">

