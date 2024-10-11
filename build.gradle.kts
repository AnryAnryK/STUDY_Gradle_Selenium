

plugins {
    id("java-library")
    id("io.qameta.allure") version "2.11.2" // для allure
//    id("io.freefair.lombok") version "6.0.0-m2" // для lombok
//    id ("org.springframework.boot") version "2.5.3" // для spring
//    id ("io.spring.dependency-management") version "1.0.11.RELEASE" // для spring
}

//group = "org.example"
//version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}


dependencies {
    //testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("com.codeborne:selenide:7.3.1") // selenide

    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2") // позволяет специально не искать Веб-драйвер ХРОМА и в @Test после void написать: WebDriverManager.chromedriver.setup()
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3") // 1 -!!!  JUnit5  - !!! это АГРЕГАТОР (он включает в себя 1-ю и 2-ю минимально необходимые зависимости, т.е. можно ТОЛЬКО ЕГО ИСПОЛЬЗОВАТЬ !!!)

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.3") // 2 - JUnit5 - это его "ядро", т.е. "основная зависимость" (1-я из 2 минимально необходимых зависимостей, чтобы JUnit5 заработал)
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.3") // 3 - JUnit5 - (2-я из 2 минимально необходимых зависимостей, чтобы JUnit5 заработал)  но этот под вопросом (в репозитории такого нет - я взял из Урока по JUNIT5)     -junit-jupiter-engine - это код, который отвечает за запуск тестов, отвечает за интеграцию этого запуска с системами, которые умеют запускать тесты (Gradle, Maven, IntelijIdea - "зелёная кнопочка")

    testImplementation("com.microsoft.playwright:playwright:1.45.1")

    testImplementation("io.qameta.allure:allure-junit5:2.12.1") // 1 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-commandline:2.30.0") // 2 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-assertj:2.12.1") // 3 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-rest-assured:2.12.1") // 4 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-java-commons:2.12.1") // 5 - Аллюр Репорт
    testImplementation("io.qameta.allure:allure-selenide:2.21.0") // для Аллюр-Селенид
    testImplementation("org.aspectj:aspectjweaver:1.9.5") // 6 - Аллюр Репорт

    testImplementation("org.slf4j:slf4j-simple:2.0.13") // Необязательное дополнение // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple

    testImplementation("org.assertj:assertj-core:3.26.3") // для загрузки файлов из интернета

    testImplementation("com.codeborne:pdf-test:1.5.0") // для работы/загрузки PDF-файлов - !!! com.codeborne:pdf-test:1.5.0 - не конфликтует с com.codeborne:xls-test:1.4.3 !!!
    testImplementation("com.codeborne:xls-test:1.4.3") // для работы/загрузки XLS-файлов - !!! com.codeborne:xls-test:1.4.3 - не конфликтует с com.codeborne:pdf-test:1.5.0 !!!
    testImplementation("com.opencsv:opencsv:5.9")  // для работы/загрузки CSV-файлов
    testImplementation("com.google.code.gson:gson:2.11.0")  // для работы/загрузки json-файлов

    testImplementation("com.github.javafaker:javafaker:0.12")  // для урока - 14_Генерация тестовых данных

    testImplementation("io.rest-assured:rest-assured:5.3.0") //для  rest-assured (уроки по REST API)
    testImplementation("rg.assertj:assertj-core:assertJVersion") //в оригинале в "rest-api-16" было так testImplementation("org.assertj:assertj-core:$assertJVersion")  //
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test") // для spring
    testImplementation("org.springframework.boot:spring-boot-starter-web") // для spring
    testImplementation("io.springfox:springfox-boot-starter:3.0.0") // для spring и для swagger
//    implementation(kotlin("script-runtime"))

//    testImplementation ("org.postgresql:postgresql:42.3.5")  // у Бонусному уроку по JAVA (для Docker)
//    testImplementation("org.springframework:spring-jdbc:5.3.20") // у Бонусному уроку по JAVA (для Docker)
}

tasks.test {
    useJUnitPlatform{}

}



