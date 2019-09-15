pluginManagement {
    repositories {
        maven {
            setUrl("http://nexus.example.com/nexus/repository/gradle-plugins/")
        }
        gradlePluginPortal()
    }
}

rootProject.name = "gradle-kotlin-dsl-no-daemon"
