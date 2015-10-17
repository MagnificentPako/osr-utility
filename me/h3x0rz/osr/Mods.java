package me.h3x0rz.osr;

import java.util.ArrayList;
import java.util.List;

public enum Mods {
    None(0),
    NoFail(1),
    Easy(2),
    NoVideo(4),
    Hidden(8),
    HardRock(16),
    SuddenDeath(32),
    DoubleTime(64),
    Relax(128),
    HalfTime(256),
    Nightcore(512),
    Flashlight(1024),
    Autoplay(2048),
    SpunOut(40969),
    Relax2(8192),
    Perfect(16384),
    Key4(32768),
    Key5(65536),
    Key6(131072),
    Key7(262144),
    Key8(524288),
    //keyMod(Key4|Key5|Key6|Key7|Key8),
    FadeIn(1048576),
    Random(2097152),
    LastMod(4194304),
    //FreeModAllowed(NoFail|Easy|Hidden|HardRock|SuddenDeath|Flashlight|FadeIn|Relax|Relax2|SpunOut|keyMod),
    Key9(16777216),
    Key10(33554432),
    Key1(67108864),
    Key3(134217728),
    Key2(268435456);

    private int i;

    Mods(int i){
        this.i = i;
    }

    public int getValue(){
        return this.i;
    }

    public static List<Mods> getUsedMods(int i){
        String str = Integer.toString(i,2);
        List<Mods> mods = new ArrayList();
        int counter = 0;
        for(char s : str.toCharArray()) {
            if(s=='1') {
                mods.add(Mods.values()[counter]);
            }
            counter++;
        }
        return mods;
    }

  public static int reverseMods(List<Mods> mods){
      int i = 0;
      for(Mods mod : mods){
          i += mod.getValue();
      }
      return i;
  }
}
