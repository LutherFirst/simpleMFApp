package org.nfl.fintech;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.nfl.fintech");

        noClasses()
            .that()
            .resideInAnyPackage("org.nfl.fintech.service..")
            .or()
            .resideInAnyPackage("org.nfl.fintech.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..org.nfl.fintech.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
