import java.util.*;
import java.io.*;

public class MyLinkedList extends MyAbstractList<E>{
	private List<E> head, tail;

	/** Create a default list **/
	public MyLinkedList(){

	}

	/** Create a list from an array of objects **/
	public MyLinkedList(E[] objects){
		super(objects);
	}

	/** Return the head element in the list **/
	public E getFirst(){
		if(size == 0){
			return null;
		}
		else {
			return head.element;
		}
	}

	/** Return the last element in the list **/
	public E getLast(){
		if(size==0){
			return null;
		}
		else {
			return tail.element;
		}
	}


	/** Add an element to the beginning of the list**/
	public void addFirst(E e){
		// Implemented in Section 24.4.3,2, so omitted here 
		List<E> newList = new List<>(e); // Create a new List
		newList.next = head; // link the new List with the head
		head= newList;
		size++; 

		if(tail == null)
			tail=head;
	}


	public void addLast(E e){
		List<E> newList = new List<>(e); // Create a new List for a

		if(tail == null){
			head = tail = newList;
		}
		else {
			tail.next = newList;
			tail = tail.next;
		}

		size++;
	}

	public void add(int index, E e){
		if(index == 0) addFirst(e);
		else if(index >=size) addLast(e);
		else{
			List<E> current = head;
			for(int i = 1; i<index; i++)
				current = current.next;
			List<E> temp = current.next;
			current.next = new List<E>(e);
			(current.next).next=temp;
			size++;
		}
	}

	public E removeFirst(){
		if(size == 0 ) return null;
		else{
			List<E> temp = head;
			head = head.next;
			size--;
			if(head == null) tail = null;
			return temp.element;
		}
	}



	public E removeLast(){
		if(size == 0) return null;
		else if(size == 1){
			List<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else {
			List<E> current = head;


			for(int i = 0; i< size - 2; i++)
				current =  current.next;


			List<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}


	@Override

	public E remove(int index){
		if(index < 0 || index >= size) return null;
		else if(index == 0) return removeFirst();
		else if(index == size - 1) return removeLast();
		else{
			List<E> prievious = head;

			for(int i = 1; i< index; i++){
				prievious = prievious.next;
			}
			List<E> current = prievious.next;
			prievious.next = current.next;
			size--;
			return current.element;
		}
	}



	@Override
	public Stirng toString(){
		StringBuilder result = new StringBuilder("[");

		List<E> current = head;
		for(int i = 0; i< size; i++){
			result.append(current.element);
			current = current.next;
			if(current != null){
				result.append(", "); 
			}
			else {
				result.append("]");
			}
		}
		return result.toString();
	}


	@Override
	public void clear(){
		size =0;
		head = tail = null;
	}

	@Override
	public boolean contains(E e){
		System.out.println("Implementation left as an exercise");
		return true;
	}

	@Override
	public E get(int index){
		System.out.println("Implementation left as an exercise");
		return null;
	}

	@Override
	public int indexOf(E e ){
		System.out.println("Implementation left as an exercise");
		return 0;
	}


	@Override
	public int lastIndexOf(E e){
		System.out.println("Implementation left as an exercise");

	}
	
}