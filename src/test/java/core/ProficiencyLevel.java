package core;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProficiencyLevel {

    ///////////////// Генерация XPath \\\\\\\\\\\\\\\\\\\

    private String serviceLvlDefinition(String lvl) {
        switch (lvl) {
            case "Начальный":
                return "BEGINNER";
            case "Средний":
                return "MIDDLE";
            case "Продвинутый":
                return "ADVANCED";
            case "Эксперт":
                return "EXPERT";
        }
        return lvl;
    }

    private void serviceProficiencyLevel(String value) {
        $x("//*[@data-level='" + value + "']").should(Condition.enabled).click();
    }

    private void serviceProficiencyLevel(String value, String index) {
        $x("(//*[@data-level='" + value + "'])[" + index + "]").should(Condition.enabled).click();
    }

    ///////////////// Логика взаимодействия cо страницей \\\\\\\\\\\\\\\\\\\

    /**
     * === Выбор уровня владения навыком ===
     * @param lvl - Уровень владения навыком (Начальный, Средний, Продвинутый, Эксперт)
     */
    @Step("Выбор владения навыком на уровне {lvl}")
    public ProficiencyLevel selectDefinitionLvl(String lvl) {
        serviceProficiencyLevel(serviceLvlDefinition(lvl));
        return this;
    }

    /**
     * === Выбор уровня владения вторым и более навыком ===
     * @param lvl   - Уровень владения навыком (Начальный, Средний, Продвинутый, Эксперт)
     * @param index - Позиция поля в DOM
     */
    @Step("Выбор владения навыком на уровне {lvl}")
    public ProficiencyLevel selectDefinitionLvl(String lvl, String index) {
        serviceProficiencyLevel(serviceLvlDefinition(lvl), index);
        return this;
    }
}
