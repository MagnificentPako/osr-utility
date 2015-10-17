package me.h3x0rz.osr.replay;

public class ReplayElement {

    private long w;
    private float x;
    private float y;
    private int z;

    public ReplayElement(long w, float x, float y, int z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getW() {
        return w;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String toString(){
        return w+"|"+x+"|"+"y"+"|"+z;
    }

}
