package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A Simple Stack.
 * @param <A>
 * 
 */
public class Stack<A> implements Iterable<A> {
    
    // Generics is done at compile time (static).
    private List<A> elements = new ArrayList<A>();
    
    /**
     * Pushes an element onto the top of the stack.
     * @param element
     */
    public void push(A element) {
        elements.add(element);
    }

    /**
     * Removes the top element of the stack, and returns that element.
     * @precondition The stack is not empty. // design by contract
     */
    public A pop() {
        A last = peek();
        elements.remove(elements.size() - 1);
        return last;
    }

    /**
     * Returns the top element of the stack, without removing it.
     * @precondition The stack is not empty. // design by contract
     */
    public A peek() {
        return elements.get(elements.size() - 1);
    }
    
    /*
    For each generic type used, a different peek method is generated like:
    public String peek() {
        return elements.get(elements.size() - 1);
    }
    
    public int peek() {
        return elements.get(elements.size() - 1);
    }
    
    public double peek() {
        return elements.get(elements.size() - 1);
    }
    */

    /**
     * Returns an iterator to the internal data structure of the stack.
     */
    public Iterator<A> iterator() {
        // Copy list to protect encapsulation.
        // List is copied but references the same objects in the original list (shallow copy).
        // Shallow copy means encapsulation is still broken.
        List<A> copy = new ArrayList<A>();
        Collections.reverse(copy);
        return copy.iterator();
    }

    /**
     * Returns the size of the stack.
     */
    public int size() {
        return elements.size();
    }
    
    /**
     * Returns the stack as an ArrayList
     */
    public List<A> toArrayList() {
        return new ArrayList<A>(elements);
    }
    
    /**
     * Returns the stack as an List
     */
    public List<A> toList() {
        // `ArrayList` is a concrete class of the `List` interface.
        return new ArrayList<A>(elements);
    }

    public static Integer sumStack(Stack<? extends Integer> stack) {
        // ? extends Integer means ? is a subclass of Integer.
        // int, short int, long int are subclasses of Integer.
        // ? super Integer means ? is a superclass of Integer.
        
        int total = 0;
        for (Integer e : stack.elements) {
            total += e;
        }
        // A subclass has more properties than its super class
        return total;
    }

    public static void prettyPrint(Stack<?> stack) {
        // Use ? mean you don't need to know the type.
        
        System.out.print("[");
        if (stack.size() == 0) {
            System.out.print("]");
            return;
        }
        Iterator<?> iter = stack.iterator();
        
        for(int i = 0; i < stack.size() - 1; i++) {
            System.out.print(iter.next() + " ");
        }
        
        System.out.print(iter.next() + "]");
    }
        

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("hello");
        stack.push("how");
        stack.push("are");
        stack.push("you");
        stack.push("today");
        prettyPrint(stack);
    }

}
