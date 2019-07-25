proto_library(
    visibility = ["//visibility:public"],
    name = "hyphenation_proto",
    srcs = ["hyphenation.proto"],
)

proto_library(
    visibility = ["//visibility:public"],
    name = "capitalization_proto",
    srcs = ["capitalization.proto"],
)

java_proto_library(
    visibility = ["//visibility:public"],
    name = "capitalization_java_proto",
    deps = [":capitalization_proto"],
)

java_proto_library(
    visibility = ["//visibility:public"],
    name = "hyphenation_java_proto",
    deps = [":hyphenation_proto"],
)