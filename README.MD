# Champion League Detail Page UI Tests

A Java Selenium automation framework for testing the Champion League detail page of the BGB Ticket Marketplace web application, built with Maven/Gradle and TestNG.

---

## 📁 Project Structure

```
web/
  test/
    tests/
      champion_league/
        page_detail/
          UICheck.java      # Main test class for UI checks
    base/                   # Base test class
  main/
    pages/
      champion_league/
        ChampionLeagueDetail.java  # Page Object Model for detail page
    config/                 # Configuration classes (URLs, environment, etc.)
    utils/                  # Utilities and actions
pom.xml or build.gradle     # Dependency management
README.md
```

---

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Maven or Gradle
- Chrome/Firefox browser and driver (or use WebDriverManager)
- TestNG
- Selenium WebDriver

### Install Dependencies

For Maven:
```sh
mvn clean install
```
For Gradle:
```sh
gradle build
```

### Run Tests

You can run tests using your IDE or via command line:

For Maven:
```sh
mvn test -Dbrowser=chrome -Dheadless=true
```
For Gradle:
```sh
gradle test -Dbrowser=chrome -Dheadless=true
```

---

## 🧩 Key Components

- **BaseTest**: Initializes WebDriver and sets up environment URLs.
- **ChampionLeagueDetail**: Page Object for Champion League detail page interactions.
- **UICheck**: TestNG test class for UI validation.
- **Utils**: Common actions and helpers.

---

## 📝 Example Usage

```java
// In UICheck.java
navigateTo("champions-league/champions-league-final-2025");
ChampionLeagueDetail detailPage = new ChampionLeagueDetail(driver);
detailPage.acceptCookies();
String actualTitle = detailPage.getDetailPathTitle();
Assert.assertEquals(actualTitle, "Champions League Final 2025", "Detail page title mismatch");
```

---

## 🛠️ Customizing

- Update selectors and expected values in `ChampionLeagueDetail.java`.
- Add new page objects in `pages/champion_league/`.
- Add new test cases in `web/test/tests/champion_league/page_detail/`.

---

## 📊 Test Reports

After running your tests, a detailed HTML report is generated automatically.

- **Location:**  
  `target/surefire-reports/index.html` (Maven)

Open this file in your browser to view the results.

---

## Notes

- Tests assume the web application is accessible and the driver is properly configured.
- Update expected titles and selectors in page objects as needed for changes in the UI.