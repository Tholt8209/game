import java.awt.*;

public abstract class gameObject { // used to make variables for other classes to use

        protected int x, y;
        protected ID id; //
        protected int velX, velY; //velocity of x and y

        public gameObject(int x, int y, ID id) {

            //setters for constructor
            this.x = x;
            this.y = y;
            this.id = id;

        }

        public abstract void tick();
        public abstract void render(Graphics g);
        //https://www.youtube.com/watch?v=0T1U0kbu1Sk 7:38
}
