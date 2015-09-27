package edu.upc.eetac.dsa.alejandro;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String line=("En un lugar de la Mancha, de cuyo nombre no quiero acordarme, vivia hace no mucho tiempo un hidalgo.\n");
        Buffer buffer = new Buffer();
        Thread consumer=new Thread(new Consumer(buffer),"consumer");
        Thread producer=new Thread(new Producer(buffer, line), "producer");

        consumer.start();
        producer.start();
    }
}
