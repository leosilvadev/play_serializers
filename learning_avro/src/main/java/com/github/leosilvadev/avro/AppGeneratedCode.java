package com.github.leosilvadev.avro;

import example.avro.User;

public class AppGeneratedCode {

    public static void main(String[] args) {
        final User user = User.newBuilder()
                .setName("Leonardo")
                .setFavoriteColor("Black")
                .setFavoriteNumber(13)
                .build();

        System.out.println(user.getSchema());
    }
}
