import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.sql.SQLOutput;

public class Game extends Canvas implements Runnable{


    public static final int Width = 640, Height = 480;
    private Thread thread; // everything runs through here
    private boolean running = false;
    public Game(){ // parameter from Window.java
        new Window(Width, Height, "monster hunt", this); // Creates Window


    }

    public synchronized void start(){
        thread = new Thread(this); // creates a additional loop while other loop runs
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){ // prints error
            e.printStackTrace();
        }

    }

    public void run(){
        long lasttime = System.nanoTime();
        double amountofticks = 30;
        double ns = 1000000000 / amountofticks;
        double delta = 0;
        long timer  = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lasttime) / ns;
            lasttime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
                frames++;
            }
            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS " + frames);
                frames = 0;

            }
        }
        stop();
    }
    private void tick(){




    }
    private void render(){ //creates a memory
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3); //
            return;

        }
        Graphics G = bs.getDrawGraphics();

        G.setColor(Color.RED);
        G.fillRect(0,0, Width, Height);
        G.dispose();
        bs.show();
    }


    public static void main(String[] args) {
        new Game();
    }


}

