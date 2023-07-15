package com.dm.earth.cabricality.config.modmenu;

import com.dm.earth.cabricality.Cabricality;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;

import static com.dm.earth.cabricality.Cabricality.CONFIG;

public class CabfConfigScreen {
	private final ConfigBuilder builder = ConfigBuilder.create()
												  .setTitle(Cabricality.genTranslatableText("screen", "config", "title"))
												  .transparentBackground()
												  .setSavingRunnable(CONFIG::save);
	private final ConfigEntryBuilder entryBuilder = builder.entryBuilder();

	public CabfConfigScreen(Screen parent) {
		builder.setParentScreen(parent);
		initEntries();
	}

	public Screen build() {
		return builder.build();
	}

	/*
	 * CATEGORIES
	 */

	private final ConfigCategory general = builder.getOrCreateCategory(Cabricality.genTranslatableText("config", "category", "general"));
	private final ConfigCategory debug = builder.getOrCreateCategory(Cabricality.genTranslatableText("config", "category", "debug"));

	private void initEntries() {
		// General
		general.addEntry(entryBuilder.startBooleanToggle(Cabricality.genTranslatableText("config", "general", "include_version_in_window_title"), CONFIG.includeVersionInWindowTitle())
								 .setDefaultValue(true)
								 .setTooltip(Cabricality.genTranslatableText("config", "general", "include_version_in_window_title", "tooltip"))
								 .setSaveConsumer(CONFIG::includeVersionInWindowTitle)
								 .build());

		general.addEntry(entryBuilder.startBooleanToggle(Cabricality.genTranslatableText("config", "general", "background_blur"), CONFIG.backgroundBlur())
								 .setDefaultValue(true)
								 .setTooltip(Cabricality.genTranslatableText("config", "general", "background_blur", "tooltip"))
								 .setSaveConsumer(CONFIG::backgroundBlur)
								 .build());

		general.addEntry(entryBuilder.startBooleanToggle(Cabricality.genTranslatableText("config", "general", "background_blur_darken"), CONFIG.backgroundBlurDarken())
								 .setDefaultValue(true)
								 .setTooltip(Cabricality.genTranslatableText("config", "general", "background_blur_darken", "tooltip"))
								 .setSaveConsumer(CONFIG::backgroundBlurDarken)
								 .build());

		general.addEntry(entryBuilder.startIntSlider(Cabricality.genTranslatableText("config", "general", "background_blur_radius"), Math.round(CONFIG.backgroundBlurRadius()), 1, 128)
								 .setDefaultValue(35)
								 .setTooltip(Cabricality.genTranslatableText("config", "general", "background_blur_radius", "tooltip"))
								 .setSaveConsumer(value -> CONFIG.backgroundBlurRadius(value.floatValue()))
								 .build());

		// Debug
		debug.addEntry(entryBuilder.startBooleanToggle(Cabricality.genTranslatableText("config", "debug", "debug_info"), CONFIG.debugInfo())
							   .setDefaultValue(false)
							   .setSaveConsumer(CONFIG::debugInfo)
							   .build());

		debug.addEntry(entryBuilder.startBooleanToggle(Cabricality.genTranslatableText("config", "debug", "cleaner_log"), CONFIG.cleanerLog())
							   .setDefaultValue(true)
							   .setSaveConsumer(CONFIG::cleanerLog)
							   .build());
	}
}
