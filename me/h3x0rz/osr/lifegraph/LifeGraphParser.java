package me.h3x0rz.osr.lifegraph;

public class LifeGraphParser {

    private LifeGraphParser() {}

    public static LifeGraphElement[] parse(String str){
        String[] elements = str.split(",");
        LifeGraphElement[] graphArray = new LifeGraphElement[elements.length];
        int counter = 0;
        for(String element : elements){
            String elem = element.replace("|",",");
            String[] splitted = elem.split(",");
            int u = Integer.parseInt(splitted[0]);
            double v = Double.parseDouble(splitted[1]);
            graphArray[counter] = new LifeGraphElement(u,v);
            counter++;
        }
        return graphArray;
    }

    public static String unparse(LifeGraphElement[] elements){
        String out = "";
        for(LifeGraphElement element : elements){
            out += (element.getU()+"|"+element.getV()+",");
        }
        return out;
    }

}
