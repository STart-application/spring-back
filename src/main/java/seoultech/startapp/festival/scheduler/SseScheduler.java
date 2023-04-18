package seoultech.startapp.festival.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import seoultech.startapp.global.common.SseEmitters;

@EnableScheduling
@RequiredArgsConstructor
public class SseScheduler {
  private final SseEmitters sseEmitters;
  @Scheduled(cron = "*/1 * * * * *")
  public void test() {
    sseEmitters.count();
  }

}
