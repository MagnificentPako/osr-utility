package me.h3x0rz.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteInput {

    private ByteBuffer buffer;

    public ByteInput(byte[] bytes) {
        this(ByteBuffer.wrap(bytes));
    }

    public ByteInput(ByteBuffer buffer){
        this.buffer = buffer;
        this.buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public byte readByte(){
        return buffer.get();
    }

    public int getPosition() {
        return buffer.position();
    }
    public int readInt() {
        return buffer.getInt();
    }
    public short readShort() {
        return buffer.getShort();
    }
    public int readUnsignedShort() {
        return readShort() & 0xffff;
    }
    public long readLong() {return buffer.getLong();}

    public byte[] readByteArray(int length) {
        byte[] result = new byte[length];
        this.buffer.get(result);
        return result;
    }

    public int readULeb128(){
        int parsed = 0;
        try {
            parsed = Leb128.readUnsignedLeb128(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public String readString(){
        byte b = this.readByte();
        if(b == 0x0b) {
            int len = this.readULeb128();
            byte[] bytes = new byte[len];
            this.buffer.get(bytes);
            try {
                return new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }else{
            return "";
        }
    }

}
