package personal.leetcode.problems.search_a_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        if(matrix[0][0] > target || matrix[m][n] < target) {
            return false;
        }

        int rStart=0,rEnd=m;
        while(true) {
            if(rStart == rEnd) {
                m = rStart;
                break;
            }

            int rToStart;
            if(rEnd - rStart == 1) {
                rToStart = rEnd;
            } else {
                rToStart = ((rEnd - rStart) / 2 + rStart);
            }

            if(matrix[rToStart][0] > target) {
                if(rToStart == rEnd) {
                    rEnd = rStart;
                } else {
                    rEnd = rToStart;
                }
            } else if(matrix[rToStart][0] < target) {
                rStart=rToStart;
            } else {
                return true;
            }
        }

        int cStart=0,cEnd=n;
        while(true) {
            if(cStart == cEnd) {
                return matrix[m][cStart] == target;
            }

            int cToStart;
            if(cEnd - cStart == 1) {
                cToStart = cEnd;
            } else {
                cToStart = ((cEnd - cStart) / 2 + cStart);
            }

            if (matrix[m][cToStart] > target) {
                if(cToStart == cEnd) {
                    cEnd = cStart;
                } else {
                    cEnd = cToStart;
                }
            } else if (matrix[m][cToStart] < target) {
                cStart = cToStart;
            } else {
                return true;
            }
        }
    }
}
