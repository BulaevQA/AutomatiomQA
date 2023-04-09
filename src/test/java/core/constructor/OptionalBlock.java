package core.constructor;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class OptionalBlock {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private void serviceAddOptionalBlock(String block) {
        $x("//button[normalize-space(text())='"+block+"'][@data-change='show-block']")
                .should(visible, enabled).click();
    }

    private void serviceRemoveOptionalBlock(String block) {
        $x("//h2[normalize-space(text())='"+block+"']/../following-sibling::div//button")
                .should(visible, enabled).click();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Добавление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Добавление опционального блока \"{block}\"")
    public OptionalBlock addOptionalBlock(String block) {
        serviceAddOptionalBlock(block);
        return this;
    }

    /**
     * === Удаление опционального блока ===
     * @param block - Наименование(h2 заголовок) блока
     */
    @Step(value = "Удаление опционального блока \"{block}\"")
    public OptionalBlock removeOptionalBlock(String block) {
        serviceRemoveOptionalBlock(block);
        return this;
    }
}
