package edu.upc.eetac.dsa.alejandro;

/**
 * Created by Alex on 27/9/15.
 */
public class Buffer {
    private static final int BUFFER_SIZE = 32;
    private char[] buffer;
    private int tail;
    private int head;

    public Buffer(){
        buffer=new char[BUFFER_SIZE];
        this.head=0;
        this.tail=0;
    }

    public synchronized char get(){
        while (isEmpty()){
            try {
                wait();
            }catch (InterruptedException e) {

            }
        }
        char c=buffer[head++];
        if (head==buffer.length){
            head=0;
        }
        notifyAll();
        return c;
    }

    public synchronized void put(char c){
        while (isFull()){
            try {
                wait();
            }catch (InterruptedException e) {

            }
        }
        buffer[tail++]=c;
        if (tail==buffer.length){
            tail=0;
        }
        notifyAll();
    }

    private boolean isEmpty(){
        if (head==tail)
            return true;
        else
            return false;
    }

    private boolean isFull(){
        if (tail+1==head)
            return true;
        else if (tail==(buffer.length-1) && head==0)
            return true;
        else
            return false;

    }


}
