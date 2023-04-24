package seoultech.startapp.festival.application.port.out;

import seoultech.startapp.festival.domain.Voter;

public interface SaveVoterPort {
void save(Voter voter);
}
