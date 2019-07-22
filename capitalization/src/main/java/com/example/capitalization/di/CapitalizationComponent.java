package com.example.capitalization.di;

import com.example.capitalization.CapitalizationService;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = CapitalizationModule.class)
@Singleton
public interface CapitalizationComponent {

    CapitalizationService capitalizationService();
}
