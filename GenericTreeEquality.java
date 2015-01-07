import java.util.Stack;

// Tree implements the binary search tree property

class Tree<T extends Comparable<T>> {
	public Tree(T v) {
		value = v;
		left = null;
		right = null;
	}

	public void insert(T v) {
		if (value.compareTo(v) == 0)
			return;
		if (value.compareTo(v) > 0)
			if (left == null)
				left = new Tree<T>(v);
			else
				left.insert(v);
		else if (value.compareTo(v) < 0)
			if (right == null)
				right = new Tree<T>(v);
			else
				right.insert(v);
	}

	protected T value;
	protected Tree<T> left;
	protected Tree<T> right;
}

class Iter<T extends Comparable<T>> {
	Stack <Tree<T> >stack=new Stack<Tree<T> >();
	Iter(Tree<T> tree){
		
	push(tree);
}
	void push(Tree<T> tree){
		while(tree!=null){
			stack.push(tree);
			tree=tree.left;
		}
	}
	Tree <T> next(){
		if(done()==false)
		{
			Tree <T> node = stack.pop();
			Tree <T> node1=node;
			if(node1.right!=null){
			node1 = node1.right;
			//stack.push(node1);
			push(node1);
			}
		
		return node;
		}
		else
			return null;
		
		
	}
	 boolean done() {
		if(!stack.isEmpty()){
		return false;	
		}
		
		return true;
	}
	
// define here the external iterator operations, done and next

}

public class GenericTreeEquality {

     static <T extends Comparable<T>> boolean equals(Tree<T> tree1, Tree<T> tree2) {
    	 Iter iter1 = new Iter<>(tree1);
    	 Iter iter2 = new Iter<>(tree2);
	// define here the equality test
    	 boolean match = false;
    	 while(!iter1.done() && !iter2.done())
    		 {
    		 if(iter1.next().value.equals(iter2.next().value)){
    			match=true; 
    			 continue;
    		 }
    		 else
    		 { match=false;
    			 break;
    		 }
    		 }
    	 return match;
    	 

	}
	
	public static void main(String[] args) {
		
		Tree<Integer> tree1 = new Tree<Integer>(50);
		tree1.insert(70);
		tree1.insert(80);	
		tree1.insert(90);
		tree1.insert(100);
		
		Tree<Integer> tree2 = new Tree<Integer>(100);
		tree2.insert(90);
		tree2.insert(80);	
		tree2.insert(70);
		tree2.insert(50);
		System.out.println(equals(tree1, tree2 ));
	}
}
    
 