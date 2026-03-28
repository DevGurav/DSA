# DSA in Java

This is my Java DSA practice repository, structured by pattern and optimized for interview revision.

The goal is not just to solve problems, but to make each solution easy to revisit after weeks or months.

## Quick Navigation

- [Why This Repo](#why-this-repo)
- [Repository Map](#repository-map)
- [How To Run](#how-to-run)
- [My Comment Format](#my-comment-format)
- [Revision Workflow](#revision-workflow)
- [Current Pattern Coverage](#current-pattern-coverage)
- [Workspace Notes](#workspace-notes)

## Why This Repo

I use this repo to:
- practice core interview patterns in Java
- keep optimal and readable solutions in one place
- store reasoning in comments, not only code
- revise quickly with focused notes (invariant + flow)

## Repository Map

- [Math Quest](Math%20Quest): math/number-based problems
- [Pareto-Problem-set](Pareto-Problem-set): pattern-wise grouping
  - ArrayHashing
  - Binary Search
  - Linked List
  - Sliding Window
  - Stack
  - Two Pointers
- [RevisionIndex.md](RevisionIndex.md): one-line revision sheet (file -> pattern -> trick)

<details>
<summary>View Folder Tree</summary>

```text
DSA/
  Math Quest/
  Pareto-Problem-set/
    ArrayHashing/
    Binary Search/
    Linked List/
    Sliding Window/
    Stack/
    Two Pointers/
  RevisionIndex.md
```

</details>

## How To Run

You can run files from VS Code Java extension or terminal.

Terminal flow:

1. Compile

```bash
javac "path/to/File.java"
```

2. Run

```bash
java ClassName
```

Example:

```bash
javac "Math Quest/PermutationSequence.java"
java PermutationSequence
```

## My Comment Format

Each solution follows a fixed recall template near the top:

1. Problem
2. Pattern
3. Core idea
4. Invariant
5. Complexity
6. Dry run
7. Why this works
8. Mental Trigger (simple)
9. Flow Dry Run (same order as code below)

Inside loops and key conditions, I also add:
- line-by-line intent comments
- Loop Snapshot Example blocks

This format makes old code readable without re-deriving the full logic.

## Revision Workflow

For fast revision sessions:

1. Open [RevisionIndex.md](RevisionIndex.md)
2. Pick a file
3. Read only `Invariant` + `Flow Dry Run`
4. Try to reconstruct the logic mentally
5. Use loop snapshots only if needed
6. Run one test input

This keeps revision short and consistent.

## Current Pattern Coverage

Current repository includes problems from:
- Array Hashing
- Binary Search
- Linked List
- Sliding Window
- Stack / Monotonic Stack
- Two Pointers
- Math / Number Theory

## Workspace Notes

- Java source path is configured from workspace root for smoother folder-based practice.
- Build output is directed to `bin`.
- Non-code docs (`.md`, `.pdf`, `.docx`) are excluded from Java import indexing.

## Roadmap

Planned improvements:

1. Add mini test harness per pattern folder
2. Add brute-force vs optimal comparison notes
3. Add difficulty and frequency tags to [RevisionIndex.md](RevisionIndex.md)
4. Add weekly timed revision checklist

---

If you are using this repo for practice too: start with [RevisionIndex.md](RevisionIndex.md), pick one pattern, and solve 2-3 files in one sitting.
