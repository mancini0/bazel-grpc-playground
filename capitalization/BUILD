load("@build_stack_rules_proto//java:java_grpc_library.bzl", "java_grpc_library")

java_grpc_library(
    name = "capitalization-grpc",
    deps = ["//proto:capitalization_proto"],
)

java_library(
    name = "capitalization-service",
    srcs = ["src/main/java/com/example/capitalization/CapitalizationService.java"],
    deps = [":capitalization-grpc"],
    exports = [":capitalization-grpc"]
)

java_test(
    name = "capitalization-service-test",
    test_class ="com.example.capitalization.CapitalizationServiceTest",
    srcs = ["src/test/java/com/example/capitalization/CapitalizationServiceTest.java"],
    deps = ["@maven//:io_grpc_grpc_testing",
            "@maven//:io_grpc_grpc_core",
            "@maven//:junit_junit",
            ":capitalization-service"]
)

java_binary(
    name = "app",
    srcs = ["src/main/java/com/example/capitalization/App.java"],
    main_class = "com.example.capitalization.App",
    deps = [
        ":capitalization-service",
        "//server:grpc-server",
    ],
)
