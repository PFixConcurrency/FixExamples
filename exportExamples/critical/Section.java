package critical;

class Section implements Runnable {

static Object objectFix = new Object();    Critical t;
    int threadNumber;

    public Section(Critical t, int threadNumber)
    {
        this.t = t;
        this.threadNumber = threadNumber;
    }

    public void run() {

        if(threadNumber == 0)
        {

synchronized (objectFix){             t.turn = 0;
            System.out.println("In critical section, thread number = " + threadNumber);
            if(t.turn != 0)
                throw new RuntimeException();
}            System.out.println("Out critical section, thread number = " + threadNumber);
            t.turn = 1;
        }
        else
        {
            if(threadNumber == 1)
            {
synchronized (objectFix){                 t.turn = 1;
}                System.out.println("In critical section, thread number = " + threadNumber);
                while(t.turn != 1);
                System.out.println("Out critical section, thread number = " + threadNumber);
                t.turn = 0;          }
            else
            {
                System.err.println("This algorithm only supports two threads");
            }
        }
    }
}
