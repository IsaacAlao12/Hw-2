# Hw-2
add(T element)
Amortized Time: O(1)
Worst Case: O(n) (when resizing happens)
Most inserts just place the element -> constant time
Occasionally, array resizes -> copies all elements
Because resizing happens rarely, the average cost per add stays constant

remove(int index)
Time Complexity: O(n)
Elements must shift left after removal
Worst case: removing first element -> shift entire array

ensureCapacity(int minCapacity)
Amortized: O(1)
Worst Case: O(n)
Resizing requires copying all elements
But doubling reduces frequency of resizing
