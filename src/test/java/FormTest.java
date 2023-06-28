import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    @Test
    public void testSuccessfulForm() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Мо");
        $(byText("Москва")).click();
        $("[data-test-id=date]").click();
        $(byText("5")).click();
        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79123456789");
        $("[data-test-id=agreement]").click();
        $(byText("Забронировать")).click();

        $(withText("Успешно")).shouldBe(visible, Duration.ofSeconds(15));
    }
}
