package tests.testdata;

import net.datafaker.Faker;

public class TestData {
    private final Faker faker = new Faker();


    public final String currentAddress = faker.address().fullAddress();
    public final String permanentAddress = faker.address().fullAddress();
    public final String userName = faker.name().fullName();
    public final String userEmail = faker.internet().emailAddress();
    public final String negativeUserEmail = faker.options().option("not-an-email", "user@domain");

}