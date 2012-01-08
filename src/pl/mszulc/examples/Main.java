package pl.mszulc.examples;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.startTest();
    }

    private void startTest() {

        getTestThread("test0").start();
        getTestThread("test1").start();
        getTestThread("test2").start();
        getTestThread("test3").start();
        getTestThread("test4").start();
        getTestThread("test5").start();
        getTestThread("test6").start();
        getTestThread("test7").start();
        getTestThread("test8").start();
        getTestThread("test9").start();
        getTestThread("test10").start();
        getTestThread("test11").start();
        getTestThread("test12").start();
        getTestThread("test13").start();
        getTestThread("test14").start();
        getTestThread("test15").start();
        getTestThread("test16").start();
        getTestThread("test17").start();
        getTestThread("test18").start();


    }

    private Thread getTestThread(final String testString) {
        return new Thread(new Runnable() {
            public void run() {
                FileWriterTest fileTest = new FileWriterTest("WRITERTEST.txt");
                fileTest.doWriteToFile(testString);
            }
        });
    }


}