import java.util.HashSet;
import java.util.Set;

// Problem: LeetCode 36 - Valid Sudoku
// Pattern: Array Hashing (Constraint Tracking)
// Core idea: For each filled cell, record row/col/box constraints and fail on first duplicate.
// Invariant: Each inserted marker represents a unique (digit, row/col/box) constraint seen so far.
// Complexity: O(1) time and O(1) space because board size is fixed at 9x9.
// Dry run: If '5' appears again in same row marker, set insertion fails -> invalid board.
// Why this works: Sudoku validity is exactly the absence of duplicate digits in each row, column, and 3x3 box.
// Mental Trigger (simple): Build three uniqueness checks per digit: row, column, and box.
// When to use: Need O(1) average lookups for seen/complement/frequency checks.
// Failure mode: Wrong box indexing or forgetting to skip '.' cells.
// Input edge cases: Empty cells only, partially filled board, duplicates in row/col/box.
// Brute -> Optimal jump: Replace repeated scans with one-pass constraint recording.
// Invariant break test: Any duplicate digit in same unit must trigger immediate false.
// Complexity trigger: Single pass over 81 cells with constant-time set checks.
// Common variant: boolean matrices or bitmask arrays for lower constant factors.
// Flow Dry Run (same order as code below):
// A) Create a set for seen constraint markers.
// B) Iterate every cell; skip '.'.
// C) Insert row/col/box markers for current digit.
// D) If any insertion fails, return false; otherwise return true.
public class ValidSudoku
{
    public boolean isValidSudoku(char[][] board)
    {
        // Stores unique markers like "5 in row 0", "5 in col 3", "5 in block 1-0".
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                
                // Empty cell has no constraint to record.
                if (number != '.') {
                    /*
                     Loop Snapshot Example:
                     number='5' at (0,0) -> add row/col/box markers (all true first time)
                     next '5' in same row -> row marker add fails -> invalid
                    */
                    // .add() returns false if marker already exists.
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in col " + j) ||
                        !seen.add(number + " in block " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
         
    }
}





// BitMasking (Arrays)
// Alternative 1:
// Use integer bitmasks for rows/cols/blocks.
// Bit position p (0..8) indicates digit (p+1) already used in that unit.
// public class ValidSudoku {
//     public boolean isValidSudoku(char[][] board) {
//         // We need 9 integers for rows, 9 for columns, and 9 for blocks
//         int[] rows = new int[9];
//         int[] cols = new int[9];
//         int[] blocks = new int[9];

//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 if (board[i][j] == '.') continue;

//                 // Convert char '1'-'9' to int 0-8
//                 int val = board[i][j] - '1';
                
//                 // Create a mask: shift '1' left by 'val' positions
//                 // e.g., if val is 3, mask is 000001000
//                 int mask = 1 << val;
                
//                 // Calculate block index (0 to 8)
//                 int blockIdx = (i / 3) * 3 + (j / 3);

//                 // If already set in row/col/block, digit is duplicated.
//                 if ((rows[i] & mask) != 0 || 
//                     (cols[j] & mask) != 0 || 
//                     (blocks[blockIdx] & mask) != 0) {
//                     return false;
//                 }

//                 // Mark current digit as seen in row, col, and block.
//                 rows[i] |= mask;
//                 cols[j] |= mask;
//                 blocks[blockIdx] |= mask;
//             }
//         }
//         return true;
//     }
// }   






// 2D Boolean Arrays for Row Column and 3 × 3 Box
// Alternative 2:
// rows[r][d], cols[c][d], boxes[b][d] track whether digit d is already used.
// public class ValidSudoku
// {
// public boolean isValidSudokuBoolean(char[][] board)
//   {
//     boolean[][] rows = new boolean[9][9];
//     boolean[][] cols = new boolean[9][9];
//     boolean[][] boxes = new boolean[9][9];

//     for (int r = 0; r < 9; r++) {
//         for (int c = 0; c < 9; c++) {
//             if (board[r][c] == '.') continue;

//             int num = board[r][c] - '1'; // Convert '1'-'9' to 0-8
//             int boxIdx = (r / 3) * 3 + (c / 3);

//             // Duplicate detected in row, column, or 3x3 box.
//             if (rows[r][num] || cols[c][num] || boxes[boxIdx][num]) {
//                 return false;
//             }

//             // Mark digit as seen in all three structures.
//             rows[r][num] = true;
//             cols[c][num] = true;
//             boxes[boxIdx][num] = true;
//         }
//     }
//     return true;
//   }
// }