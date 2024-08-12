plugins {
    id("java-library")
    id("io.qameta.allure") version "2.11.2"
}

//group = "org.example"
//version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    //testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("com.codeborne:selenide:7.3.1")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2") // позволяет специально не искать Веб-драйвер ХРОМА
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3") // 1 - JUnit5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.3") // 2 - JUnit5
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.3") // 3 - JUnit5  но этот под вопросом (в репозитории такого нет - я взял из Урока по JUNIT5)
    testImplementation("com.microsoft.playwright:playwright:1.45.1")
    testImplementation("io.qameta.allure:allure-junit5:2.12.1") // 1 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-commandLine:2.12.1") // 2 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-assertj:2.12.1") // 3 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-rest-assured:2.12.1") // 4 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-java-commons:2.12.1") // 5 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-selenide:2.21.0")
    testImplementation("org.aspectj:aspectjweaver:1.9.5") // 6 - Аллюр Репорт
    testImplementation("org.slf4j:slf4j-simple:2.0.13") // Необязательное дополнение // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
}

tasks.test {
    useJUnitPlatform{}

}