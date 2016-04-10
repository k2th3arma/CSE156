	package com.data;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectList<E> {
		private int size;
		private Object[] item;
		
		public ObjectList(){
			item = new Object[1];
			size = 0;
		}
		private void incSize(){
			++size;
		}
		private void decSize(){
			--size;
		}
		
		public int getSize(){
			return size;
		}
		
		public void add(E o){
			if(size < item.length){
				item[size] = 0;
			}
			else{
				Object[] temp = item;
				item = new Object[size+1];
				for(int i = 0; i < size; ++i){
					item[i] = temp[i];
				}
				temp = null;
				item[size] = 0;
			}
			incSize();
		}
		public void remove(int index){
			if(index < size){
				Object[] temp = item;
				item = new Object[size-1];
				for(int i = 0; i < index; ++i){
					item[i] = temp[i];
				}
				for(int i = index; i < size-1; ++i){
					item[i] = temp[i+1];
				}
				item = null;
				decSize();
			}
		}
		public E get(int index){
			Object temp = null;
			try{
				temp = item[index];
			}
			catch(IndexOutOfBoundsException e){
				System.out.println("\nException:" + e);
			}
			return ((E)temp);
		}
//		@Override
//		public boolean hasNext() {
//			if(size < item.length){
//				return true;
//			}
//			return false;
//		}
//		@Override
//		public Object next() {
//			Object[] temp = item;
//			
//			return null;
//		}


	}