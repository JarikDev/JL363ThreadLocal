package com;

public class Main {
    static ThreadLocal<String > threadLocal=new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("Hello world");
        ThreadOne threadOne=new ThreadOne();
        ThreadTwo threadTwo=new ThreadTwo();
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("Main "+threadLocal.get());

    }
    static class ThreadOne extends Thread{
        @Override
        public void run() {
            threadLocal.set("Thread One ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread One "+threadLocal.get());
        }
    }

    static class ThreadTwo extends Thread{
        @Override
        public void run() {
            threadLocal.set("Thread Two ");

            System.out.println("Thread Two "+threadLocal.get());
        }
    }
}
