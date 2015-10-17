package me.h3x0rz.osr;

public enum Gamemodes {
    Standard,Taiko,CTB,Mania;

    static public Gamemodes get(byte b){
        switch(b){
            case 0: return Standard;
            case 1: return Taiko;
            case 2: return CTB;
            case 3: return Mania;
            default: return null;
        }
    }
}
