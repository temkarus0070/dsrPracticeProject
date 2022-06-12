package org.temkarus0070.dsrpracticeproject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.temkarus0070.dsrpracticeproject.projections.MentorStudentsStatsProjection;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguageStatsProjection;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PracticeTicketStats {
    private List<MentorStudentsStatsProjection> mentorStudentsStats;
    private List<ProgrammingLanguageStatsProjection> programmingLanguageStats;
}
