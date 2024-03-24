package tests.data;

public enum Country {

    RUSSIA("Россия", "Москва"),
    BELARUS("Беларусь", "Минск"),
    KAZAKHSTAN("Казахстан", "Астана");

    Country(String countryName, String countryCapital) {
        this.countryName = countryName;
        this.countryCapital = countryCapital;

    }

    public final String countryName;
    public final String countryCapital;

}


