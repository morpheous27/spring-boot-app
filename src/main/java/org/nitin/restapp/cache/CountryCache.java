package org.nitin.restapp.cache;

import java.util.HashMap;
import java.util.Map;

import org.nitin.restapp.dtos.Country;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@EnableCaching
public class CountryCache {

	Map<String, Country> countryMap = new HashMap<>();

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("users");
	}

	@Bean
	@Lazy
	public Map<String, Country> getCountryMap() {
		return countryMap;
	}
}
