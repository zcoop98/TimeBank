package com.example.josephstewart.timebank.backend;

/**
 * Created by josephstewart on 5/14/17.
 */

public class Scanner extends Thread {

    public void run() {
        for (int i = 0; i < 120; i ++)
        {
            System.out.println("SCANNER THREAD...");
            try{this.sleep(1000);} catch(Exception e){}
        }
    }

}
