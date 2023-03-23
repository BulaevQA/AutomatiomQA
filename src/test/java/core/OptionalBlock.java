package core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class OptionalBlock {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceAddOptionalBlock(String block) {
        $x("//button[text()='" + block + "'][@data-change='show-block']").should(Condition.enabled).click();
    }

    private void serviceRemoveOptionalBlock(String block) {
        $x("//h2[text()='" + block + "']/../following-sibling::div//button").should(Condition.enabled).click();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Добавление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Добавление опционального блока {block}")
    public OptionalBlock addOptionalBlock(String block) {
        serviceAddOptionalBlock(block);
        return this;
    }

    /**
     * === Удаление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Удаление опционального блока {block}")
    public OptionalBlock removeOptionalBlock(String block) {
        serviceRemoveOptionalBlock(block);
        return this;
    }
}
