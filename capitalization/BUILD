load("@build_stack_rules_proto//java:java_grpc_library.bzl", "java_grpc_library")

java_grpc_library(
    name = "capitalization-grpc",
    deps = ["//proto:capitalization_proto"],
)

java_plugin(
    name = "dagger_plugin",
    processor_class = "dagger.internal.codegen.ComponentProcessor",
    deps = [
        "@maven//:com_google_dagger_dagger_compiler",
    ],
)

java_library(
    name = "dagger_lib",
    exported_plugins = ["dagger_plugin"],
    exports = [
        "@maven//:com_google_dagger_dagger",
        "@maven//:javax_inject_javax_inject",
    ],
)

java_library(
    name = "capitalization-service",
    srcs = [
        "src/main/java/com/example/capitalization/CapitalizationService.java",
        "src/main/java/com/example/capitalization/FooService.java",
    ],
    exports = [":capitalization-grpc"],
    deps = [
        ":capitalization-grpc",
        "@maven//:javax_inject_javax_inject",
    ],
)

java_test(
    name = "capitalization-service-test",
    srcs = [
        "src/main/java/com/example/capitalization/FooServiceImpl.java",
        "src/main/java/com/example/capitalization/di/CapitalizationComponent.java",
        "src/main/java/com/example/capitalization/di/CapitalizationModule.java",
        "src/test/java/com/example/capitalization/CapitalizationServiceTest.java",
    ],
    test_class = "com.example.capitalization.CapitalizationServiceTest",
    deps = [
        ":capitalization-service",
        ":dagger_lib",
        "@maven//:io_grpc_grpc_core",
        "@maven//:io_grpc_grpc_testing",
        "@maven//:junit_junit",
    ],
)

java_binary(
    name = "app",
    srcs = [
        "src/main/java/com/example/capitalization/App.java",
        "src/main/java/com/example/capitalization/FooServiceImpl.java",
        "src/main/java/com/example/capitalization/di/CapitalizationComponent.java",
        "src/main/java/com/example/capitalization/di/CapitalizationModule.java",
    ],
    main_class = "com.example.capitalization.App",
    deps = [
        ":capitalization-service",
        ":dagger_lib",
        "//server:grpc-server",
    ],
)
