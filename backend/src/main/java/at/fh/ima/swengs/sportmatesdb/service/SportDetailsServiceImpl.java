package at.fh.ima.swengs.sportmatesdb.service;

import at.fh.ima.swengs.sportmatesdb.model.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service("sportDetailsService")
public class SportDetailsServiceImpl extends SportService{

    @Autowired
    private SportRepository sportRepository;

    @PostConstruct()
    @Transactional
    public void initSports(){
        //if (sportRepository.count() == 0) {
        at.fh.ima.swengs.sportmatesdb.model.Sport badmintonDouble = new at.fh.ima.swengs.sportmatesdb.model.Sport();
        badmintonDouble.setSportName("Badminton Double");
        badmintonDouble.setSportDescription("Badminton in a team");
        badmintonDouble.setTeam(true);
        badmintonDouble.setTeamSize(2);
        sportRepository.save(badmintonDouble);

        at.fh.ima.swengs.sportmatesdb.model.Sport badminton = new at.fh.ima.swengs.sportmatesdb.model.Sport();
        badminton.setSportName("Badminton");
        badminton.setSportDescription("");
        badminton.setTeam(false);
        sportRepository.save(badminton);

        at.fh.ima.swengs.sportmatesdb.model.Sport tennis = new at.fh.ima.swengs.sportmatesdb.model.Sport();
        tennis.setSportName("Tennis");
        tennis.setSportDescription("");
        tennis.setTeam(false);
        sportRepository.save(tennis);

        at.fh.ima.swengs.sportmatesdb.model.Sport muscleTraining = new at.fh.ima.swengs.sportmatesdb.model.Sport();
        muscleTraining.setSportName("Muscle Training");
        muscleTraining.setSportDescription("");
        muscleTraining.setTeam(false);
        sportRepository.save(muscleTraining);

        at.fh.ima.swengs.sportmatesdb.model.Sport soccer = new at.fh.ima.swengs.sportmatesdb.model.Sport();
        soccer.setSportName("Soccer");
        soccer.setSportDescription("");
        soccer.setTeam(true);
        soccer.setTeamSize(11);
        sportRepository.save(soccer);

        at.fh.ima.swengs.sportmatesdb.model.Sport jogging = new at.fh.ima.swengs.sportmatesdb.model.Sport();
        jogging.setSportName("Jogging");
        jogging.setSportDescription("");
        jogging.setTeam(false);
        sportRepository.save(jogging);

        at.fh.ima.swengs.sportmatesdb.model.Sport tennisDouble = new at.fh.ima.swengs.sportmatesdb.model.Sport();
        tennisDouble.setSportName("Tennis Double");
        tennisDouble.setSportDescription("Tennis in a team");
        tennisDouble.setTeam(true);
        tennisDouble.setTeamSize(2);
        sportRepository.save(tennisDouble);

        at.fh.ima.swengs.sportmatesdb.model.Sport volleyball = new at.fh.ima.swengs.sportmatesdb.model.Sport();
        volleyball.setSportName("Volleyball");
        volleyball.setSportDescription("");
        volleyball.setTeam(true);
        volleyball.setTeamSize(6);
        sportRepository.save(volleyball);
        //}
    }
}
