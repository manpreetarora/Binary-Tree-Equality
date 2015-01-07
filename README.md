# Binary-Tree-Equality
This program tests the equality of two BSTs using an external iterator for inorder traversal of a generic binary search tree (BST)
The external iterator is generic and  supports two public methods: a boolean function done(), which tests whether the 
iterator has any more values to yield, and a function next(), which returns the next value if the iterator is not yet done.
The equality test repeatedly obtains one value from each tree, in alternating fashion, and compare these values for equality. 
It returns false if the values are not equal (mismatch). If there are no mismatches and the iterators are done at the same time,
the equality test returns true.
A sequence diagram generated through JIVE demonstrates how the code works.
