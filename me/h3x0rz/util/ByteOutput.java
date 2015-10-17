package me.h3x0rz.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class ByteOutput {

    private ByteBuffer buffer;

    public ByteOutput(byte[] bytes) {
        this(ByteBuffer.wrap(bytes));
    }

    public ByteOutput(ByteBuffer buffer){
        this.buffer = buffer;
        this.buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public void writeByte(byte b){
        buffer.put(b);
    }

    public void writeInt(int i) {
        buffer.putInt(i);
    }

    public void writeShort(short s) {
        buffer.putShort(s);
    }

    public void writeLong(long l) {
        buffer.putLong(l);
    }

    public void writeByteArray(byte[] array) {
        buffer.put(array);
    }

    public void writeULeb128(int value){
        Leb128.writeUnsignedLeb128(this,value);
    }

    public void writeString(String str){
        this.writeByte((byte)0x0b);
        int len = str.length();
        byte[] text = str.getBytes(Charset.forName("UTF-8"));
        this.writeULeb128(len);
        this.writeByteArray(text);
    }


}
