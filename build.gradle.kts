plugins {
    id("java")
    id ("org.flywaydb.flyway" )version "10.0.0"
}
buildscript {
    dependencies {
        classpath ("org.flywaydb:flyway-database-postgresql:10.4.1")
    }
}
flyway {
    url = "jdbc:postgresql://localhost:5555/"
    user = "postgres"
    password = "2004"
    cleanDisabled = false
}


group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.postgresql:postgresql:42.7.3")

    compileOnly ("org.projectlombok:lombok:1.18.32")
    annotationProcessor ("org.projectlombok:lombok:1.18.32")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}