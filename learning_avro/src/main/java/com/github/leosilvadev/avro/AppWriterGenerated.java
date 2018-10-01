package com.github.leosilvadev.avro;

import example.avro.User;
import org.apache.avro.data.Json;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.*;

public class AppWriterGenerated {

    public static void main(String[] args) throws IOException {
        final User user = User.newBuilder()
                .setName("Leonardo")
                .setFavoriteColor("Black")
                .setFavoriteNumber(13)
                .build();

        SpecificDatumWriter<User> writer = new SpecificDatumWriter<>(user.getSchema());

        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        final Encoder encoder = new EncoderFactory().binaryEncoder(os, null);

        writer.write(user, encoder);
        encoder.flush();

        new FileOutputStream(new File("user")).write(os.toByteArray());
    }
}
