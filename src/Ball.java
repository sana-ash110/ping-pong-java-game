public class Ball {

    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public Ball(int x,int y,int xs,int ys){
        this.x = x;
        this.y = y;
        this.xSpeed = xs;
        this.ySpeed = ys;
    }

    public int getx()
    { 
        return x;
    }
    public int gety()
    {
        return y;
    }

    public void setx(int x)
    { 
        this.x = x; 
    }
    public void sety(int y)
    { 
        this.y = y;
    }

    public int getXSpeed()
    { 
        return xSpeed; 
    }
    public int getYSpeed()
    { 
        return ySpeed;
    }

    public void setXSpeed(int s)
    { 
        xSpeed = s; 
    }
    public void setYSpeed(int s)
    { 
        ySpeed = s; 
    }
}