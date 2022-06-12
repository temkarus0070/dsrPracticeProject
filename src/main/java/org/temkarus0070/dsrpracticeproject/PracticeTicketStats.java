package org.temkarus0070.dsrpracticeproject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.temkarus0070.dsrpracticeproject.projections.MentorStudentsStatsView;
import org.temkarus0070.dsrpracticeproject.projections.ProgrammingLanguageStatsView;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PracticeTicketStats {
    private List<MentorStudentsStatsView> mentorStudentsStats;
    private List<ProgrammingLanguageStatsView> programmingLanguageStats;
}
