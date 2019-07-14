load("@build_stack_rules_proto//java:java_grpc_library.bzl", "java_grpc_library")

java_grpc_library(
    name = "hyphenation-grpc",
    deps = ["//proto:hyphenation_proto"],
)

java_library(
    name = "hyphenation-service",
    srcs = ["src/main/java/com/example/hyphenation/HyphenationService.java"],
    deps = [":hyphenation-grpc"],
    exports = [":hyphenation-grpc"]
)

java_test(
    name = "hyphenation-service-test",
    test_class ="com.example.hyphenation.HyphenationServiceTest",
    srcs = ["src/test/java/com/example/hyphenation/HyphenationServiceTest.java"],
    deps = ["@maven//:io_grpc_grpc_testing",
            "@maven//:io_grpc_grpc_core",
            "@maven//:junit_junit",
            ":hyphenation-service"]
)

java_binary(
    name = "app",
    srcs = ["src/main/java/com/example/hyphenation/App.java"],
    main_class = "com.example.hyphenation.App",
    deps = [
        ":hyphenation-service",
        "//server:grpc-server",
    ],
)
