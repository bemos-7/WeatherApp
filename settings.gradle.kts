pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "WeatherApp"
include(":app")
include(":data")
include(":domain")
include(":feature")
include(":feature:home")
include(":feature:details_city")
include(":feature:details_city_future")
include(":feature:shared")
include(":feature:settings")
include(":core")
include(":core:domain")
include(":core:data")
include(":core:data:city")
include(":core:data:weather")
include(":core:feature")
