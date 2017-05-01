`package com.example.TwoPointers;

import java.util.List;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input :
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5
         With 10 from A, 15 from B and 10 from C.
 */
public class Array3Pointer {
    public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int i=0, j=0, k=0;
        int diff = Integer.MAX_VALUE;

        while(i<a.size() && j < b.size() && k <c.size()){
            int min = Math.min(a.get(i), Math.min(b.get(j), c.get(k)));
            int max = Math.max(a.get(i), Math.max(b.get(j), c.get(k)));
            diff = Math.min(diff, max - min);
            if(diff == 0)
                return diff;
            if(min == a.get(i))
                i++;
            else if(min == b.get(j))
                j++;
            else
                k++;
        }
        return diff;
    }
}
