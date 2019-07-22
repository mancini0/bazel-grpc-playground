package com.example.capitalization.di;

import com.example.capitalization.FooService;
import com.example.capitalization.FooServiceImpl;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;


@Module
public abstract class CapitalizationModule {

    @Binds
    @Singleton
    public abstract FooService provideFooService(FooServiceImpl fooServiceImpl);

}
