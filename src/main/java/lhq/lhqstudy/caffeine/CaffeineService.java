package lhq.lhqstudy.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/11/28 17:10
 */
@Service
@Slf4j
public class CaffeineService {
    private static Cache<String, String> APP_CACHE = Caffeine.newBuilder()
            .maximumSize(5000)
            .expireAfterAccess(1, TimeUnit.MINUTES)
            .recordStats()
            .build();

    public String getCache(String key){
        String cache = APP_CACHE.get(key, this::getCacheFromDB);
        log.info("cache :{}", cache);
        return cache;
    }

    public String getCacheFromDB(String key) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return key;
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void monitor(){
        CacheStats cacheStats = APP_CACHE.stats();
        log.info("cache hitRate {} evictionCount {} ", cacheStats.hitRate(), cacheStats.evictionCount());
        log.info("cache static " + cacheStats.toString());
    }
}
