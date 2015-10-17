package me.h3x0rz.util;

import lzma.sdk.lzma.Decoder;
import lzma.sdk.lzma.Encoder;
import lzma.streams.LzmaDecoderWrapper;
import lzma.streams.LzmaEncoderWrapper;

import java.io.*;

public class LZMADeCompressor {

    private LZMADeCompressor() {}

    public static String decompress(byte[] input){
        LzmaDecoderWrapper wrapper = new LzmaDecoderWrapper(new Decoder());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            wrapper.code(inputStream,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] out = outputStream.toByteArray();

        try {
            return new String(out,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static byte[] compress(String input){
        LzmaEncoderWrapper wrapper = new LzmaEncoderWrapper(new Encoder());
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            wrapper.code(inputStream,outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

}
