package com.github.leosilvadev.protobuf;

import com.github.leosilvadev.protobuf.city.BuildingOuterClass.Building;
import com.github.leosilvadev.protobuf.city.BuildingTypeOuterClass.BuildingType;
import com.github.leosilvadev.protobuf.city.CityOuterClass.City;
import com.github.leosilvadev.protobuf.city.StreetOuterClass.Street;
import com.google.protobuf.Timestamp;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class App {

    public static void main(final String[] args) throws URISyntaxException, IOException {
        final City city = City.newBuilder()
                .setName("Berlin")
                .setCountryName("Germany")
                .setZipCode("10512")
                .build();

        final Street street = Street.newBuilder()
                .setName("Meine LieblingsStrasse")
                .setCity(city)
                .build();

        final Instant now = ZonedDateTime.now().minusYears(2).toInstant();

        final Building building = Building.newBuilder()
                .setName("Meine Wohnung")
                .setStreet(street)
                .setNumber(80)
                .setType(BuildingType.APARTMENT)
                .setLivingSince(Timestamp.newBuilder().setSeconds(now.getEpochSecond()).setNanos(now.getNano()).build())
                .addPeople("Leonardo")
                .addPeople("Nicolas")
                .build();

        final Path path = Paths.get(new URI("file:///tmp/building"));

        Files.write(path, building.toByteArray());

        System.out.println(Building.parseFrom(Files.readAllBytes(path)));
    }

}
