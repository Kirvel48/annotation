package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.data.Country;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ChitaiGorodAnnotationTests extends TestsBase {

    @ParameterizedTest(name = "Результат поисковой выдачи для запроса {0}")
    @ValueSource(strings = {"Дюна", "Java"})
    void positiveSearchTest(String setSeach) {
        open("");
        $(".header-search__input").setValue(setSeach).pressEnter();
        $(".product-title__head").shouldHave(Condition.text(setSeach));
    }

    @ParameterizedTest(name = "Список элементов в каталоге соответсвует разделу {0} ")
    @CsvSource(value = {
            "Книги, Художественная литература",
            "Игры и игрушки, Настольные игры",
            "Творчество и хобби, Рукоделие",
            "Канцтовары,Офисные принадлежности",
            "Товары для художников, Кисти",
            "Подарки и сувениры,Посуда и текстиль"
    })
    void itemSuitInCategory(String category, String item) {
        open("");
        $(".change-city__buttons").shouldBe(Condition.visible);
        $(".change-city__buttons").$(byText("Да, я здесь")).click();
        $(".catalog__button").click();
        $(".categories-menu__column").$(byText(category)).click();
        $(".modal__content").shouldHave(Condition.text(item));
    }

    @ParameterizedTest(name = "Список городов для доставки соответствует выбранной стране {0}")
    @EnumSource(Country.class)
    void changeCountry(Country country) {
        open("");
        $(".change-city__buttons").shouldBe(Condition.visible);
        $(".change-city__buttons").$(byText("Нет, изменить город")).click();
        $(".app-select__view").click();
        $(".app-select__list").$(byText(country.countryName)).click();
        $(".city-modal__content").shouldHave(Condition.text(country.countryCapital));


    }


}
