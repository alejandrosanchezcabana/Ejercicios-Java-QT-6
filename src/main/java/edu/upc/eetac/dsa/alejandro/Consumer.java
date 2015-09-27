package edu.upc.eetac.dsa.alejandro;

/**
 * Created by Alex on 27/9/15.
 */
public class Consumer implements Runnable{
    private Buffer buffer=null;
    public Consumer(Buffer buffer){
        this.buffer=buffer;
    }
    @Override
    public void run(){
        StringBuilder sb =new StringBuilder();
        char c;
        while ((c=buffer.get())!= '\n'){
            System.out.println(Thread.currentThread().getName()+ " reads "+c);
            sb.append(c);
        }
        System.out.println(sb);
    }
}