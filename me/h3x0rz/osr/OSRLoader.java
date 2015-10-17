package me.h3x0rz.osr;

import me.h3x0rz.util.ByteInput;

import java.io.*;

public class OSRLoader {

    private OSRLoader() {}

    public static OSRData load(RandomAccessFile file) throws Exception {

        byte[] b = new byte[(int)file.length()];
        file.read(b);
        ByteInput in = new ByteInput(b);

        byte gamemode = in.readByte();
        int version = in.readInt();
        String mapmd5 = in.readString();
        String playername = in.readString();
        String replaymd5 = in.readString();
        short threehundreds = in.readShort();
        short onehundreds = in.readShort();
        short fifties = in.readShort();
        short gekis = in.readShort();
        short katus = in.readShort();
        short misses = in.readShort();
        int totalscore = in.readInt();
        short bestcombo = in.readShort();
        byte perfect = in.readByte();
        int mods = in.readInt();
        String lifegraph = in.readString();
        long timestamp = in.readLong();
        int datalength = in.readInt();
        byte[] replay = in.readByteArray(datalength);

        OSRData data = new OSRData(gamemode,version,mapmd5,playername,replaymd5,threehundreds,onehundreds,fifties,gekis,katus,misses,totalscore,bestcombo,perfect,mods,lifegraph,timestamp,datalength,replay);
        return data;
    }

}
