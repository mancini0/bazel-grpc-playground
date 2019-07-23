# bazel-grpc-playground
This repo reproduces (what might be) a bug in io.grpc.testing.GrpcCleanupRule.

Using bazel 0.28.0

clone this repo, cd here
bazel build //...
bazel run //hyphenation:hyphenation-service-test (should work fine)
bazel run //hyphenation:app (should work fine, no output will be produced, ctrl-c to exit)
bazel run //capitalization:app (should work fine, no output will be produced, ctrl-c to exit)

BUT both tests executed by

bazel run //capitalization:capitalization-service-test will fail with the following stack trace:


java.lang.NoSuchMethodError: io.grpc.NameResolver$Factory.newNameResolver(Ljava/net/URI;Lio/grpc/NameResolver$Args;)Lio/grpc/NameResolver;
	at io.grpc.internal.ManagedChannelImpl.getNameResolver(ManagedChannelImpl.java:678)
	at io.grpc.internal.ManagedChannelImpl.<init>(ManagedChannelImpl.java:578)
	at io.grpc.internal.AbstractManagedChannelImplBuilder.build(AbstractManagedChannelImplBuilder.java:512)
	at com.example.capitalization.CapitalizationServiceTest.setup(CapitalizationServiceTest.java:34)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:24)
	at io.grpc.testing.GrpcCleanupRule$1.evaluate(GrpcCleanupRule.java:125)
	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at com.google.testing.junit.runner.internal.junit4.CancellableRequestFactory$CancellableRunner.run(CancellableRequestFactory.java:89)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
	at com.google.testing.junit.runner.junit4.JUnit4Runner.run(JUnit4Runner.java:112)
	at com.google.testing.junit.runner.BazelTestRunner.runTestsInSuite(BazelTestRunner.java:153)
	at com.google.testing.junit.runner.BazelTestRunner.main(BazelTestRunner.java:84)




