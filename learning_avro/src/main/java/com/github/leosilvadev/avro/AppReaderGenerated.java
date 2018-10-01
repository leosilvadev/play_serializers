package com.github.leosilvadev.avro;

import example.avro.User;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;

public class AppReaderGenerated {

    public static void main(String[] args) throws IOException {
        byte[] bytes = IOUtils.toByteArray(new FileInputStream("user"));
        SpecificDatumReader<User> reader = new SpecificDatumReader<>(User.getClassSchema());
        Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
        User user = reader.read(null, decoder);
        System.out.println("Message received : " + user);
    }
}
