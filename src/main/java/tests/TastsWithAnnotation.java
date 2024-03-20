package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TastsWithAnnotation extends TestsBase {

    @ParameterizedTest(name = "PositiveSearchTest")
    @ValueSource(strings = {"Дюна", "Java"})
    void PositiveSearchTest(String SetSeach) {
        open("https://www.chitai-gorod.ru");
        $(".header-search__input").setValue(SetSeach).pressEnter();
        $(".product-title__head").shouldHave(Condition.text(SetSeach));
    }

    @ParameterizedTest(name = "itemSuitInCategoryTest")
    @CsvSource(value = {
            "Книги, Художественная литература",
            "Игры и игрушки, Настольные игры",
            "Творчество и хобби, Рукоделие",
            "Канцтовары,Офисные принадлежности",
            "Товары для художников, Кисти",
            "Подарки и сувениры,Посуда и текстиль"
    })
    void itemSuitInCategory(String category, String item) {
        open("https://www.chitai-gorod.ru");
        $(".header-city__title").click();
        $(".change-city__buttons").$(byText("Да, я здесь")).click();
        $(".catalog__button").click();
        $(".categories-menu__column").$(byText(category)).click();
        $(".modal__content").shouldHave(Condition.text(item));
    }

    @ParameterizedTest(name = "changeCountryTest")
    @EnumSource(Country.class)
    void changeCountry(Enum country) {
        open("https://www.chitai-gorod.ru");
        $(".change-city__buttons").$(byText("Нет, изменить город")).click();
        $(".app-select__view").click();
        $(".app-select__list").$(byText(country.name())).click();

    }


}
