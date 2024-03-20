package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWindow;

public class TestsBase {
    @BeforeAll
static void setConfig(){
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://www.chitai-gorod.ru/";
    }
@AfterEach
public void closeWindow(){
        Selenide.closeWindow();

}
}
