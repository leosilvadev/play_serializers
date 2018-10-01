package com.github.leosilvadev.avro;

import example.avro.User;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AppOnTheFly {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new URL("https://raw.githubusercontent.com/leosilvadev/play_serializers/master/learning_avro/src/main/avro/user.avsc")
                .openStream();
        Schema schema = new Schema.Parser().parse(inputStream);

        GenericData.Record record = new GenericData.Record(schema);
        record.put("name", "Leonardo");
        record.put("favorite_number", 13);
        record.put("favorite_color", "Black");

        System.out.println(record);
    }
}
