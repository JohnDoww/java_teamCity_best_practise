package teamCityProject.api.generators;

import teamCityProject.api.models.*;

import java.util.Arrays;

public class TestDataGenerator {

    public static TestData generate(){

        var user = User.builder()
                .username(RandomData.getString())
                .password(RandomData.getString())
                .email(RandomData.getString()+"@gmail.com")
                .roles(Roles.builder()
                        .role(Arrays.asList(Role.builder()
                                        .roleId("SYSTEM_ADMIN")
                                        .scope("g")
                                .build()))
                        .build())
                .build();

        var project =  NewProjectDescription
                .builder()
                .parentProject(Project.builder()
                        .locator("_Root")
                        .build())
                .name(RandomData.getString())
                .id(RandomData.getString())
                .copyAllAssociatedSettings(true)
                .build();
        var buildType = BuildType.builder()
                .id(RandomData.getString())
                .name(RandomData.getString())
                .project(project)
                .build();

        return TestData.builder()
                .user(user)
                .project(project)
                .buildType(buildType)
                .build();
    }

    public static Roles generateRoles(teamCityProject.api.enums.Role role, String scope){
        return Roles.builder()
                .role(Arrays.asList(Role.builder()
                        .roleId(role.getText())
                        .scope(scope)
                        .build()))
                .build();
    }
}
