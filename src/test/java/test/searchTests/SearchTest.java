package test.searchTests;

import base.BrowserConfig;
import org.junit.jupiter.api.Test;

import static helpers.other.ClassObjects.*;

public class SearchTest extends BrowserConfig {

    @Test
    public void searchTest() {
        openLink.openUrl(url);
        search.searchField("Учитель");
        click.clickButton("Найти", "2");
    }
}
