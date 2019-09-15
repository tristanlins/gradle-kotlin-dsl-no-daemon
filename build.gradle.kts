plugins {
    id("net.researchgate.release") version "2.8.1"
}

val sourceFile = project.file("hello.go")
val linuxAmd64Binary = File(project.buildDir, "linux-amd64/hello")
val linuxAmd64Archive = File(project.buildDir, "distribution/hello.linux-amd64.tbz2")

val clean by tasks.creating(type=Delete::class) {
    delete(buildDir)
}

val build by tasks.creating(type=Exec::class) {
    inputs.file(sourceFile)
    outputs.file(linuxAmd64Binary)

    doFirst {
        linuxAmd64Binary.parentFile.mkdirs()
    }

    workingDir = linuxAmd64Binary.parentFile
    commandLine = listOf("go", "build", sourceFile)
    environment("GOOS", "linux")
    environment("GOARCH", "amd64")
    environment("GOCACHE", "$buildDir/gocache")
    environment("CGO_ENABLED", "0")
}

