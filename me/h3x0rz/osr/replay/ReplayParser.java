package me.h3x0rz.osr.replay;

import me.h3x0rz.util.LZMADeCompressor;

public class ReplayParser {

    private ReplayParser(){}

    public static ReplayElement[] parse(String replay){
        String[] elements = replay.split(",");
        ReplayElement[] elementArray = new ReplayElement[elements.length];
        int counter = 0;
        for(String element : elements){
            String elem = element.replace("|",",");
            String[] splitted = elem.split(",");
            long w = Long.parseLong(splitted[0]);
            float x = Float.parseFloat(splitted[1]);
            float y = Float.parseFloat(splitted[2]);
            int z = Integer.parseInt(splitted[3]);
            elementArray[counter] = new ReplayElement(w,x,y,z);
            counter++;
        }
        return elementArray;
    }

    public static byte[] unparse(ReplayElement[] elements){
        byte[] output;
        String raw = "";
        for(ReplayElement elem : elements){
            raw += elem.toString()+",";
        }
        output = LZMADeCompressor.compress(raw);
        return output;
    }

}
