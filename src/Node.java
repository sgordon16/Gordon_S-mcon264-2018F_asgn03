
public class Node<T> {
	private T data;
	private Node<T> nextNode;
	private Node<T> prevNode;
	    
    public Node(T data){
        this.data = data;
        nextNode = null;
    }
    
    public T getData(){
        return data;
    }
    
    public void setNext(Node<T> node){
        nextNode = node;
    }
    
    public Node<T> getNext(){
        return nextNode;
    }
    public void setPrev(Node<T> node){
        prevNode = node;
    }
    
    public Node<T> getPrev(){
        return prevNode;
    }
}
