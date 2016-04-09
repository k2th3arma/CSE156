package com.data;


public class PersonList {
		
		private Node start;
		private Node end;
		private static int size;
		
		public PersonList(){
			size = 0;
		}

	    public void clear() {
	    	Node tl = start;
	    	Node tmp = start;
	    	while(start != null){
	    		tl.setNext(null);
	    		decrimentSize();
	    	}
	    	start = tmp;
	    }

	    public void addToStart(Person t) {
	    	Node tl = new Node(t);
	 
	    	if(start == null){
	    		start = tl;
	    		end = start;
	    	}
	    	else{
	    		tl.setNext(start);
	    		start = tl;
	    	
	    	}
	    	addSize();
	 
	    }

	    public void addToEnd(Person t) {
	    	Node tl = new Node(t);
	    	
	    	if(start == null){
	    		start = tl;
	    		end = start;
	    	}
	    	else{
	    		end.setNext(tl);
	    		end = tl;
	    		
	    	}
	    	addSize();
	    	
	    }

	    public void remove(int position) {
	    	Node tl = start;
	    	for(int i = 1; i < position - 1; ++i){
	    		if(tl.getNext() == null){
	    			break;
	    		}
	    		tl = tl.getNext();
	    	}
	    	Node temp = tl.getNext();
	    	Node tmp = temp.getNext();
	    	tl.setNext(tmp);
	    	end = tmp;
	    	decrimentSize();
	    	
	    }
	    
	    private Node getNode(int position) {
	    	Node tl = start;
	    	for(int i = 1; i < position; ++i){
	    		if(tl.getNext() == null)
	    			return null;
	    		tl = tl.getNext();		 		
	    	}
	    	return tl.getNext();
	    }
	    
	    public Person getPerson(int position) {
	    	Node tl = start;
	    	for(int i = 1; i < position; ++i){
	    		if(tl.getNext() == null)
	    			return null;
	    		tl = tl.getNext();		 		
	    	}
	    	return tl.getPerson(); 	
	    }

	    public int getSize(){
	    	return size;
	    }
	    
	    public static void addSize(){
	    	++size;
	    }
	    public static void decrimentSize(){
	    	--size;
	    }



}
