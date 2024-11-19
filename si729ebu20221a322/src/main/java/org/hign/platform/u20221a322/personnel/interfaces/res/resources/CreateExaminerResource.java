package org.hign.platform.u20221a322.personnel.interfaces.res.resources;

public record CreateExaminerResource(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}

