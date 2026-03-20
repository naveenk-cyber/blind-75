# 🚀 Longest Consecutive Sequence

## 🧩 Problem Overview
**Longest Consecutive Sequence (LeetCode 128)**

Given an **unsorted array of integers**, return the length of the **longest sequence of consecutive elements**.

> ⚡ The algorithm must run in **O(n)** time.

---

## 📥 Input
- Integer array `nums`

## 📤 Output
- Integer → length of the longest consecutive sequence

---

## 🧠 Examples

### Example 1
Input:

nums = [100,4,200,1,3,2]

Output:

4

Explanation:

[1,2,3,4]


---

### Example 2
Input:

nums = [0,3,7,2,5,8,4,6,0,1]

Output:

9


---

### Example 3
Input:

nums = [1,0,1,2]

Output:

3


---

## ⚙️ Approach

### 🔑 Key Idea
Use a **HashSet** for **O(1)** lookups and avoid sorting.

---

### 🚀 Algorithm Steps

1. Insert all elements into a `HashSet`
2. Traverse each number in the set
3. Check if it is the **start of a sequence**:

if (num - 1) is NOT present

4. Expand the sequence forward:

num → num+1 → num+2 → ...

5. Count the sequence length
6. Track the maximum length

---

## 💻 Implementation (Java)

```java
import java.util.HashSet;

class Solution {
 public int longestConsecutive(int[] nums) {
     if(nums.length == 0) return 0;

     HashSet<Integer> set = new HashSet<>();
     
     for(int num : nums) {
         set.add(num);
     }

     int longest = 0;

     for(int num : set) {
         if(!set.contains(num - 1)) {
             int current = num;
             int count = 1;

             while(set.contains(current + 1)) {
                 current++;
                 count++;
             }

             longest = Math.max(longest, count);
         }
     }

     return longest;
 }
}
⏱️ Complexity Analysis
Type	Complexity
Time	O(n)
Space	O(n)
❌ Why Not Sorting?

Sorting takes O(n log n) ❌

Required complexity is O(n) ✅

🧬 Key Insight
Start only when (num - 1) is NOT present

This avoids rechecking sequences and ensures linear time.

💡 Edge Cases

Empty array → return 0

Duplicates → handled automatically by HashSet

Negative numbers → fully supported
