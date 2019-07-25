load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

rules_jvm_external_tag = "2.0.1"

rules_jvm_external_sha = "55e8d3951647ae3dffde22b4f7f8dee11b3f70f3f89424713debd7076197eaca"

dagger_version = "2.23.2"

grpc_version = "1.22.1"

http_archive(
    name = "rules_jvm_external",
    sha256 = rules_jvm_external_sha,
    strip_prefix = "rules_jvm_external-%s" % rules_jvm_external_tag,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % rules_jvm_external_tag,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    name = "maven",
    artifacts = [
        "io.grpc:grpc-netty-shaded:%s" % grpc_version,
        "io.grpc:grpc-api:%s" % grpc_version,
        "io.grpc:grpc-testing:%s" % grpc_version,
        "io.grpc:grpc-core:%s" % grpc_version,
        "io.grpc:grpc-stub:%s" % grpc_version,
        "com.google.dagger:dagger:%s" % dagger_version,
        "com.google.dagger:dagger-compiler:%s" % dagger_version,
        "javax.inject:javax.inject:1",
        "junit:junit:4.12",
    ],
    repositories = [
        "https://jcenter.bintray.com/",
        "https://repo1.maven.org/maven2",
    ],
)

http_archive(
     name = "io_grpc_grpc_java",
     sha256 = "ceade229adade0d7b156f6d17fbc1df9298bfc8d3c4eeaba596f7a4a4d3701fc",
     url = "https://github.com/grpc/grpc-java/archive/v%s.zip" % grpc_version,
     strip_prefix="grpc-java-%s" % grpc_version
 )

load("@io_grpc_grpc_java//:repositories.bzl", "grpc_java_repositories")


grpc_java_repositories()
