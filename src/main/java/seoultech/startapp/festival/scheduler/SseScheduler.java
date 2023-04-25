package seoultech.startapp.festival.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import seoultech.startapp.global.common.SseEmitters;

@EnableScheduling
@Component
@RequiredArgsConstructor
@Slf4j
public class SseScheduler {
  private final SseEmitters sseEmitters;
  @Scheduled(cron = "*/1 * * * * *")
  public void test() {
    sseEmitters.count();
  }

}
