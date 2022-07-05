package org.temkarus0070.dsrpracticeproject.security.projections;

import java.util.List;

public interface UserProjection {
    String getUsername();

    List<String> getRoles();

    boolean isActive();
}
